package com.example.cyclone_trail;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.cyclone_trail.app.AppController;
import com.example.cyclone_trail.net_utils.Const;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LeaderboardActivity extends Activity {


    private String TAG = LeaderboardActivity.class.getSimpleName();
    private TextView msgResponse, scoreResponse, idResponse;
    private ProgressDialog pDialog;

    private String tag_json_obj = "jobj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard);

        msgResponse = (TextView) findViewById(R.id.msgResponse);
        /*scoreResponse = (TextView) findViewById(R.id.scoreResponse);
        idResponse = (TextView) findViewById(R.id.idResponse);*/

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        getScores();

    }

    private void showProgressDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideProgressDialog() {
        if (pDialog.isShowing())
            pDialog.hide();
    }

    private void printArray(JSONArray response)
    {
        JSONObject temp;
        String output = "";
        try {
            for(int i = 0; i < response.length(); i++) {
                temp = response.getJSONObject(i);
                output += String.format(Locale.getDefault(), "%2d.  %s: %d\n", i+1, temp.getString("username"), temp.getInt("score"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        msgResponse.setText(output);
    }

    private void getScores() {
        showProgressDialog();
        JsonArrayRequest jsonAryReq = new JsonArrayRequest(Const.URL_SERVER_SORTED_SCORES,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        printArray(response);
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

            /*@Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", "Do");
                params.put("score" , "Not");
                params.put("userID", "Compute");

                return params;
            }*/

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonAryReq,
                tag_json_obj);

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }

}
