package com.example.cyclone_trail;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.cyclone_trail.globals.GlobalVars.shouldAllowBack;

public class EndGameActivity extends Activity implements View.OnClickListener {

    private String TAG = EndGameActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private TextView winOrLoose, showScore;
    private Button btn_playAgain, btn_toLeadBoard, btn_toMain;
    private int userScore = 0;
    public int[] itemAmts = new int[3];

    private String tag_json_req0 = "json_req0";
    private String tag_json_req1 = "json_req1";
    private String tag_json_req2 = "json_req2";
    private String tag_json_req3 = "json_req3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        shouldAllowBack = false;

        //set win or loose and calculate score
        winOrLoose = findViewById(R.id.winORloose);
        if(GlobalVars.gameClockMilliSeconds <= 1000) {
            winOrLoose.setText("YOU LOST!");
        } else if(GlobalVars.gameClockMilliSeconds > 1000) {
            //userScore = GlobalVars.gameClockMilliSeconds / 48;
            updateBag();
            userScore = calculateScore();
            winOrLoose.setText("YOU WON!");
        }

        showScore = findViewById(R.id.scoreNum);
        showScore.setText("Score: " + userScore);

        //btn_playAgain = findViewById(R.id.btn_playAgain);
        btn_toLeadBoard = findViewById(R.id.btn_toLeadBoard);
        btn_toMain = findViewById(R.id.btn_toMain);

        //btn_playAgain.setOnClickListener(this);
        btn_toLeadBoard.setOnClickListener(this);
        btn_toMain.setOnClickListener(this);

        getUserInfo();
        postScore();
        removeGameInstance();
    }

    private void showProgressDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideProgressDialog() {
        if (pDialog.isShowing())
            pDialog.hide();
    }

    // Get user from server using username. Get back JSONObject user
    // Also put user id into global variable for easy use
    public void getUserInfo() {
        showProgressDialog();

        // Create URL using Username and Password
        final String URL = Const.URL_SERVER_GET_USER;

        JSONObject js = new JSONObject();
        try {
            js.put("username", GlobalVars.username); //get username from global username
            js.put("password", "fake"); // password doesn't matter
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest
                (Method.POST, URL, js, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse (JSONObject response){
                        try {
                            GlobalVars.userJSONObj = response;
                            GlobalVars.userID = Integer.valueOf(response.get("id").toString());
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
                params.put("userID", "id");
                params.put("username", "username");
                params.put("score", "score");
                return params;
            }

        };

        //Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_req0);

        //Cancelling request
        //ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj0);
    }

    public void postScore() {
        showProgressDialog();

        // Create URL using Username and Password
        final String URL = Const.URL_SERVER_SCORE_NEW;

        JSONObject js = new JSONObject();
        try {
            js.put("userID", GlobalVars.userID); //get userID from global userID
            js.put("username", GlobalVars.username); //get username from global username
            js.put("score", (int) userScore);  // get from calculated score above
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest
                (Request.Method.POST, URL, js, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse (JSONObject response){

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
                params.put("userID", "id");
                params.put("username", "username");
                params.put("score", "score");
                return params;
            }

        };

        //Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_req1);

        //Cancelling request
        //ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj1);
    }

    public void removeGameInstance() {
        showProgressDialog();

        // Create URL using Username and Password
        final String URL = Const.URL_SERVER_REMOVE_GAME_INSTANCE;

        JSONObject js = new JSONObject();
        try {
            js.put("username", GlobalVars.username); //get username from global username
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest
                (Request.Method.POST, URL, js, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse (JSONObject response){

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
                params.put("username", "username");
                return params;
            }

        };

        //Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_req2);

        //Cancelling request
        //ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj2);
    }

    public void updateBag() {
        // Create URL using Username
        final String URL = Const.URL_SERVER_GET_GAME_INSTANCE + GlobalVars.username;

        JsonObjectRequest jsonObjReq = new JsonObjectRequest
                (Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse (JSONObject response){
                        try {
                            getBackpackInfo(response);
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
                params.put("username", "username");
                return params;
            }

        };

        //Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_req3);

        //Cancelling request
        //ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj2);
    }

    public void getBackpackInfo(JSONObject jsonObject) throws JSONException {
        JSONObject backpackObject = jsonObject.getJSONObject("backpack");
        JSONArray tempArray = backpackObject.getJSONArray("itemCounts");

        //Get item amounts from server backpack
        for(int i = 0; i < 3; i++) {
            itemAmts[i] = tempArray.getInt(i);
        }

        //Set money to updated value
        int moneyAmt = jsonObject.getInt("money");
        GlobalVars.userBackpack.setMoneyAmt(moneyAmt);
    }

    public int calculateScore() {
        //food, water, school supplies
        //Max Score = 100000
        double timeMod = 60000.0 * (GlobalVars.gameClockMilliSeconds / 300000.0);
        double foodMod = (itemAmts[0] * 1500) > 10000 ? 10000 : (itemAmts[0] * 1500);
        double waterMod = (itemAmts[1] * 750) > 5000 ? 5000 : (itemAmts[1] * 1500);
        double suppliesMod = (itemAmts[2] * 1500) > 10000 ? 10000 : (itemAmts[2] * 1500);
        double scoreModFin = GlobalVars.scoreMod > 0 ? GlobalVars.scoreMod : 0;
        int finalScore = (int) Math.round(timeMod + foodMod + waterMod + suppliesMod + scoreModFin);
        return finalScore;
    }

    @Override
    public void onBackPressed() {
        if (!shouldAllowBack) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "You cannot go back from whence you came, traveler",
                    Toast.LENGTH_SHORT);

            toast.show();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.btn_playAgain:
                //GlobalVars.gameClockMilliSeconds = 300000;  //reset clock to play again
                startActivity(new Intent(EndGameActivity.this, FillBackpackActivity.class));
                break;*/
            case R.id.btn_toLeadBoard:
                startActivity(new Intent(EndGameActivity.this, LeaderboardActivity.class));
                break;
            case R.id.btn_toMain:
                startActivity(new Intent(EndGameActivity.this, MainMenuActivity.class));
                break;
            default:
                break;
        }
    }

}
