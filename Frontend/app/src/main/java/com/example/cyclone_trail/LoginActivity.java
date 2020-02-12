package com.example.cyclone_trail;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.cyclone_trail.app.AppController;
import com.example.cyclone_trail.globals.GlobalVars;
import com.example.cyclone_trail.net_utils.Const;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity implements OnClickListener {

    private String TAG = LoginActivity.class.getSimpleName();
    private Button btn_logIn, btnToCreateUser;
    private EditText userName, passWord;
    private ProgressDialog pDialog;

    // These tags will be used to cancel the requests
    private String tag_str_req = "str_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btn_logIn = findViewById(R.id.btn_login);
        btnToCreateUser = findViewById(R.id.btnToCreateUser);
        userName = findViewById(R.id.userName);
        passWord = findViewById(R.id.passWord);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        btn_logIn.setOnClickListener(this);
        btnToCreateUser.setOnClickListener(this);
    }

    private void showProgressDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideProgressDialog() {
        if (pDialog.isShowing())
            pDialog.hide();
    }

    public void login() {
        JSONObject js = new JSONObject();
        try
        {
            js.put("username", userName.getText().toString());
            js.put("password", passWord.getText().toString());
        }
        catch (JSONException e) {
            e.printStackTrace();
            Toast toast = Toast.makeText(getApplicationContext(),
                    "error", Toast.LENGTH_SHORT);
            toast.show();
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest
                (Request.Method.POST, Const.URL_SERVER_ATTEMPT_LOGIN,
                        js, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        //Toast toast = Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG);
                        //toast.show();
                        try
                        {
                            if(response.getInt("status") == 0) {
                                startActivity(new Intent(LoginActivity.this, MainMenuActivity.class));
                                // Save current user (username) to global variable
                                GlobalVars.username = userName.getText().toString();
                            } else if (response.getInt("status") == 2) {
                                Toast.makeText(getApplicationContext(), "Wrong username!", Toast.LENGTH_SHORT).show();
                            }  else if (response.getInt("status") == 1) {
                                Toast.makeText(getApplicationContext(), "Wrong password!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Wrong username or password", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        error.printStackTrace();
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", userName.getText().toString());
                params.put("password", passWord.getText().toString());
                return params;
            }
        };

        //Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_str_req);

        //Cancelling request
        //ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.btnToCreateUser:
                startActivity(new Intent(LoginActivity.this, CreateUserActivity.class));
                break;
            default:
                break;
        }
    }

}
