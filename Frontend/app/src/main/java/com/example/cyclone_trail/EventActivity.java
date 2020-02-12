package com.example.cyclone_trail;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.cyclone_trail.ChatActivities.ChatActivity;
import com.example.cyclone_trail.app.AppController;
import com.example.cyclone_trail.globals.GlobalVars;
import com.example.cyclone_trail.net_utils.Const;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.cyclone_trail.globals.GlobalVars.shouldAllowBack;

public class EventActivity extends Activity implements OnClickListener {

    private String TAG = EventActivity.class.getSimpleName();
    private int choice = 0;
    private Button btn_one, btn_two, btn_three, btn_four, btnToChat, btnViewPack;
    private Button[] buttons = new Button[6];
    private TextView title;
    private boolean allowBack;
    //These tags will be used to cancel the requests
    private String tag_json_obj = "jobj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);

        allowBack = false;

        title = findViewById(R.id.eventTitle);

        findButtons();
        fillButtonsArray();
        setButtonVisibility();
        setButtonListeners();
        //setPhoto();
    }

    @Override
    public void onBackPressed() {
        if (!allowBack) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "You cannot go back once you've found an event",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
        else
            super.onBackPressed();
    }

    /*
    public void setPhoto()
    {
        String temp;
        try
        {
            temp = GlobalVars.userJSONObj.getString("eventName");
            if(temp.equals("Lancelot & Elaine"))
                findViewById(R.id.lande).setVisibility(View.VISIBLE);
            else if(temp.equals("The ISU Book Store"))
                findViewById(R.id.bookstore).setVisibility(View.VISIBLE);
            else if(temp.equals("The Knoll"))
                findViewById(R.id.knoll).setVisibility(View.VISIBLE);
            else if(temp.equals("Construction"))
                findViewById(R.id.construction).setVisibility(View.VISIBLE);
            else if(temp.equals("Riddle Me This: What is a taco?"))
                findViewById(R.id.taco).setVisibility(View.VISIBLE);
            else if(temp.equals("Free School Supplies"))
                findViewById(R.id.free_sign).setVisibility(View.VISIBLE);
            else if(temp.equals("The Campanile"))
                findViewById(R.id.campanile).setVisibility(View.VISIBLE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    */

    public void setButtonVisibility()
    {
        try
        {
            title.setText(GlobalVars.userJSONObj.getString("eventName"));
            Log.d("EVENT JSON Object", GlobalVars.userJSONObj.toString());
            //Log.d("Before crash:", GlobalVars.userJSONObj.getString("dialogFour"));
            if(GlobalVars.userJSONObj.getString("dialogFour").equals(""))
                btn_four.setVisibility(View.GONE);
            else
                btn_four.setText(GlobalVars.userJSONObj.getString("dialogFour"));

            //Button 3
            if(GlobalVars.userJSONObj.getString("dialogThree").equals(""))
                btn_three.setVisibility(View.GONE);
            else
                btn_three.setText(GlobalVars.userJSONObj.getString("dialogThree"));

            //Button 2
            if(GlobalVars.userJSONObj.getString("dialogTwo").equals(""))
                btn_two.setVisibility(View.GONE);
            else
                btn_two.setText(GlobalVars.userJSONObj.getString("dialogTwo"));

            //Button 1
            if(GlobalVars.userJSONObj.getString("dialogOne").equals(""))
                btn_one.setVisibility(View.GONE);
            else
                btn_one.setText(GlobalVars.userJSONObj.getString("dialogOne"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setButtonListeners()
    {
        for(Button b: this.buttons)
            b.setOnClickListener(this);
    }

    public void findButtons()
    {
        btn_one = findViewById(R.id.choice_1);
        btn_two = findViewById(R.id.choice_2);
        btn_three = findViewById(R.id.choice_3);
        btn_four = findViewById(R.id.choice_4);
        btnViewPack = findViewById(R.id.btnViewPack);
        btnToChat = findViewById(R.id.btnToChat);
    }

    public void fillButtonsArray()
    {
        buttons[0] = btn_one;
        buttons[1] = btn_two;
        buttons[2] = btn_three;
        buttons[3] = btn_four;
        buttons[4] = btnViewPack;
        buttons[5] = btnToChat;
    }

    /**
     * Making json object request
     * */
    private void makeJsonObjReq() {

        JSONObject js = fillEventReq(choice);
        JsonObjectRequest jsonObjReq = new JsonObjectRequest
                (Request.Method.POST, Const.URL_SERVER_GET_EVENT_RESULTS,
                        js, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                            parseEventResults(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        error.printStackTrace();
                    }
                }) {
            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", GlobalVars.username);
                params.put("eventChoice", Integer.toString(choice));
                return params;
            }
        };
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }

    public JSONObject fillEventReq(int n)
    {
        JSONObject temp = new JSONObject();
        try
        {
            temp.put("username", GlobalVars.username);
            temp.put("eventChoice", n);
        } catch (JSONException e) {
            e.printStackTrace();
    }
        return temp;
    }

    public void parseEventResults(JSONObject response)
    {
        try
        {
            String[] values = response.getString("eventResult").split(",");
        /*
        values[0] is Success or Failed
        values[1] is the item that the user added or lost
        values[2] is the amount of items gained or lost
        values[3] is the amount of money gained or lost
        values[4] is the amount of time gained or lost
         */
            if(values[0].equals("S"))
                allowBack = true;

            String time = values[4].substring(1);
            String gainOrLoss = values[4].substring(0, 1);

            if(gainOrLoss.equals("*")) //If you gained time
                GlobalVars.gameClockString.addTimeGameClock(Integer.parseInt(time));
            else if(gainOrLoss.equals("-")) //If you lost time
                GlobalVars.gameClockString.subtractTimeGameClock(Integer.parseInt(time));
            if(allowBack)
                finish();
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.choice_1:
                this.choice = 1;
                makeJsonObjReq();
                break;
            case R.id.choice_2:
                this.choice = 2;
                makeJsonObjReq();
                break;
            case R.id.choice_3:
                this.choice = 3;
                makeJsonObjReq();
                break;
            case R.id.choice_4:
                this.choice = 4;
                makeJsonObjReq();
                break;
            case R.id.btnToChat:
                startActivity(new Intent(EventActivity.this,
                                        ChatActivity.class));
                break;
            case R.id.btnViewPack:
                startActivity(new Intent(EventActivity.this,
                                        ViewBackpackActivity.class));
                break;
            default:
                break;
        }
    }

}
