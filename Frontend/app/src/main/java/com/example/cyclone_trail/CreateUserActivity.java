package com.example.cyclone_trail;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.cyclone_trail.app.AppController;
import com.example.cyclone_trail.net_utils.Const;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class CreateUserActivity extends Activity implements OnClickListener {

    private String TAG = CreateUserActivity.class.getSimpleName();
    private Button btn_finish;
    private EditText createUserName, createPassWord;
    private ProgressDialog pDialog;

    // These tags will be used to cancel the requests
    private String tag_json_obj = "jobj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        btn_finish = findViewById(R.id.btn_finish);
        createUserName = findViewById(R.id.createUserName);
        if(createUserName.getText().toString().length() == 0) {
            createUserName.setError("Username required!");
        }
        createPassWord = findViewById(R.id.createPassWord);
        if(createPassWord.getText().toString().length() == 0) {
            createPassWord.setError("Password required!");
        }

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        btn_finish.setOnClickListener(this);
    }

    private void showProgressDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideProgressDialog() {
        if (pDialog.isShowing())
            pDialog.hide();
    }

    public void createUser() {
        showProgressDialog();

        // Optional Parameters to pass as POST request
        JSONObject js = new JSONObject();
        try {
            js.put("id", "");
            js.put("username", createUserName.getText().toString());
            js.put("password", createPassWord.getText().toString());
            js.put("userType", "Regular");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest
            (Request.Method.POST, Const.URL_SERVER_CREATE_USER, js, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse (JSONObject response){
                    try {
                        if (response.isNull("username")) { // User exists send error message
                            Toast.makeText(getApplicationContext(), "User already exists, Please try again!", Toast.LENGTH_SHORT).show();
                        } else if (response.get("username").toString().compareTo(createUserName.getText().toString()) == 0) { // New user go to login
                            startActivity(new Intent(CreateUserActivity.this, LoginActivity.class));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    hideProgressDialog();
                }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                    error.printStackTrace();
                    hideProgressDialog();
                }
            }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id", "");
                params.put("username", createUserName.getText().toString());
                params.put("password", createPassWord.getText().toString());
                params.put("userType", "Regular");

                return params;
            }

        };

        //Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

        //Cancelling request
        //ApplicationController.getInstance().getRequestQueue().cancelAll(tag_string_req);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_finish:
                createUser();
                //startActivity(new Intent(CreateUserActivity.this, MainMenuActivity.class));
                break;
            default:
                break;
        }
    }

}
