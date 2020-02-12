package com.example.cyclone_trail;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.cyclone_trail.app.AppController;
import com.example.cyclone_trail.globals.GlobalVars;
import com.example.cyclone_trail.net_utils.Const;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.cyclone_trail.globals.GlobalVars.shouldAllowBack;

public class MainMenuActivity extends Activity implements OnClickListener {

    private Button btnStartGame, btnLeaderboard, btnSettings;
    private ProgressDialog pDialog;

    // These tags will be used to cancel the requests
    private String tag_json_obj = "jobj_req";
    private String TAG = MainMenuActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        btnLeaderboard = findViewById(R.id.btnLeaderboard);
        btnStartGame = findViewById(R.id.btnStartGame);
        btnSettings = findViewById(R.id.btnSettings);

        btnLeaderboard.setOnClickListener(this);
        btnStartGame.setOnClickListener(this);
        btnSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLeaderboard:
                startActivity(new Intent(MainMenuActivity.this, LeaderboardActivity.class));
                break;
            case R.id.btnStartGame:
                createNewGame();
                startActivity(new Intent(MainMenuActivity.this, FillBackpackActivity.class));
                break;
            case R.id.btnSettings:
                //startActivity(new Intent(MainMenuActivity.this, EndGameActivity.class));
                break;
            default:
                break;
        }
    }

    private void showProgressDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideProgressDialog() {
        if (pDialog.isShowing())
            pDialog.hide();
    }

    public void createNewGame() {
        showProgressDialog();

        // Optional Parameters to pass as POST request
        JSONObject js = new JSONObject();
        try {
            js.put("username", GlobalVars.username);
            js.put("money", 10.0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest
                (Request.Method.POST, Const.URL_SERVER_ADD_GAME_INSTANCE, js, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse (JSONObject response){
                        hideProgressDialog();
                        GlobalVars.userJSONObj = response;
                        //Toast toast = Toast.makeText(getApplicationContext(), GlobalVars.userJSONObj.toString(), Toast.LENGTH_LONG);
                        //toast.show();
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
                params.put("username", GlobalVars.username);
                params.put("backpack", "");
                params.put("amount", "10");

                return params;
            }

        };

        //Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

        //Cancelling request
        //ApplicationController.getInstance().getRequestQueue().cancelAll(tag_string_req);
    }
    
    @Override
    public void onBackPressed() {
        if (!shouldAllowBack) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Please Logout",
                    Toast.LENGTH_SHORT);

            toast.show();
        } else {
            super.onBackPressed();
        }
    }

}
