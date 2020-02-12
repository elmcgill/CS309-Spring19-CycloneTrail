package com.example.cyclone_trail;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.cyclone_trail.Objects.Backpack;
import com.example.cyclone_trail.app.AppController;
import com.example.cyclone_trail.globals.GlobalVars;
import com.example.cyclone_trail.net_utils.Const;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ViewBackpackActivity extends Activity implements View.OnClickListener  {

    private String TAG = ViewBackpackActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private Button btn_backToGame;
    private TextView moneyLeft, textView1, textView2, textView3;
    //private EditText editText;
    private String[] items = {"food", "water", "supplies"};
    private String tag_json_req = "json_req";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_backpack);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        //TextViews
        moneyLeft = findViewById(R.id.moneyLeft);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        //Placeholder while text updates
        String temp = "" + getString(R.string.money_left, 0);
        moneyLeft.setText(temp);
        String temp2 = "" + getString(R.string.room_left, 0);
        textView1.setText(temp2);
        textView2.setText("Do or Do Not");
        textView3.setText("There is No Try");

        //Button
        btn_backToGame = findViewById(R.id.btn_backToGame);
        btn_backToGame.setOnClickListener(this);

        //set find by id for all backpack items
        for(int i = 0; i < items.length; i++) {
            for (int j = 0; j < GlobalVars.userBackpack.allItemViews(i).length; j++) {
                String itemID = items[i] + (j);
                int resID = getResources().getIdentifier(itemID, "id", getPackageName());
                GlobalVars.userBackpack.allItemViews(i)[j] = findViewById(resID);
            }
        }

        Log.d("SETUP","START");
        setUpBackpack();
        waitTime(0);
        GlobalVars.userBackpack.setupVis();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_backToGame:
                finish();
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

    public void setUpBackpack() {
        Log.d("SETUP","START REQUEST");
        // Create URL using Username
        final String URL = Const.URL_SERVER_GET_GAME_INSTANCE + GlobalVars.username;

        JsonObjectRequest jsonObjReq = new JsonObjectRequest
                (Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse (JSONObject response){
                        try {
                            Log.d("SETUP","CALL UPDATE BAG");
                            compareAndUpdate(response);
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
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_req);

        //Cancelling request
        //ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj2);
    }

    public void compareAndUpdate(JSONObject jsonObject) throws JSONException {
        Log.d("SETUP","UPDATE BAG STUFF");
        JSONObject backpackObject = jsonObject.getJSONObject("backpack");
        JSONArray tempArray = backpackObject.getJSONArray("itemCounts");
        String[] itemNames = {"Food", "Water", "School Supplies"};
        int[] oldItemAmts = GlobalVars.userBackpack.allItemAmounts();

        //Set money to updated value
        int moneyAmt = jsonObject.getInt("money");
        GlobalVars.userBackpack.setMoneyAmt(moneyAmt);

        //Update backpack to match server backpack
        for(int i = 0; i < itemNames.length; i++) {
            int itemAmt = tempArray.getInt(i);
            String temp;
            itemAmt = itemAmt - oldItemAmts[i];
            if (itemAmt == 0) {
                continue;
            } else if (itemAmt < 0) {
                temp = "add";
            } else {
                temp = "sub";
            }
            itemAmt = Math.abs(itemAmt);
            GlobalVars.userBackpack.updateBag(temp, itemNames[i], itemAmt);
        }
    }

    public void updateText() {
        Log.d("SETUP","SET TEXT INSIDE");
        String temp = "" + getString(R.string.money_left, GlobalVars.userBackpack.getMoneyAmt());
        moneyLeft.setText(temp);
        String temp2 = "" + getString(R.string.room_left, GlobalVars.userBackpack.getSpaceLeft());
        textView1.setText(temp2);
    }

    private void waitTime(int n) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                //wait 1 second for text set up
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("SETUP","SET TEXT");
                        updateText();
                    }
                });
            }
        }, 100 + (n * 100));
    }
}
