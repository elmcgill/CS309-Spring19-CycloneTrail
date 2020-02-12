package com.example.cyclone_trail;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.cyclone_trail.ChatActivities.ChatActivity;
import com.example.cyclone_trail.app.AppController;
import com.example.cyclone_trail.globals.GlobalVars;
import com.example.cyclone_trail.net_utils.Const;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import java.util.Timer;
import java.util.TimerTask;

import static com.example.cyclone_trail.globals.GlobalVars.shouldAllowBack;

public class GameBoardActivity extends FragmentActivity implements OnMapReadyCallback, OnClickListener {

    private static final long START_TIME_5MIN = 300000;
    private static final long START_TIME_1MIN = 60000;

    private String TAG = GameBoardActivity.class.getSimpleName();
    private GoogleMap mMap;
    private Button btn_move_Left, btn_move_Right, btnToChat, btnViewPack;
    private String locationName;
    private double locationLat, locationLon;
    private float maxZoom;
    private int locationStat, test;
    private ArrayList<Marker> markers = new ArrayList<Marker>();

    //These tags will be used to cancel the requests
    private String tag_json_obj = "jobj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        btn_move_Left = findViewById(R.id.btnMoveLeft);
        btn_move_Right = findViewById(R.id.btnMoveRight);
        btnToChat = findViewById(R.id.btnToChat);
        btnViewPack = findViewById(R.id.btnViewPack);

        GlobalVars.gameClockMilliSeconds = START_TIME_5MIN;

        shouldAllowBack = false;
        maxZoom = 17.0f;

        setStart();

        btn_move_Left.setOnClickListener(this);
        btn_move_Right.setOnClickListener(this);
        btnToChat.setOnClickListener(this);
        btnViewPack.setOnClickListener(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void setStart() {
        locationName = "Friley Residence Hall";
        locationLat = 42.023975;
        locationLon = -93.650423;
        locationStat = 0;
    }

    @Override
    protected void onStop() {
        super.onStop();

        GlobalVars.gameClockString.stopClock();
    }

    @Override
    protected void onResume() {
        super.onResume();

        GlobalVars.gameClockString.startGameClock();
    }

    /**
     * Making json object request
     */
    private void makeJsonObjReq(String urlTag) {

        JSONObject js = fillObjectLocation();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest
                (Request.Method.POST, Const.URL_SERVER_LOCATIONS + urlTag + "?username=" + GlobalVars.username,
                        js, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        try {
                            responseHandler(response.getInt("status"), response);
                        } catch (JSONException e) {
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
                params.put("title", locationName);
                params.put("latitude", Double.toString(locationLat));
                params.put("longitude", Double.toString(locationLon));
                params.put("status", Integer.toString(0));

                return params;
            }
        };
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }

    private void makeJsonArrayRequest() {

        JSONObject js = fillAryLocation();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest
                (Request.Method.POST, Const.URL_SERVER_LOCATIONS,
                        js, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        printArray(response);
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
                params.put("title", locationName);
                params.put("latitude", Double.toString(locationLat));
                params.put("longitude", Double.toString(locationLon));
                params.put("status", Integer.toString(0));

                return params;
            }
        };
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }

    private void printArray(JSONObject response) {
        JSONArray tempAry;
        JSONObject tempObj;
        String mName;
        Double mLon, mLat, curLon, curLat;
        ArrayList<LatLng> locations = new ArrayList<>();

        Iterator<String> keys = response.keys();

        while (keys.hasNext()) {
            try {
                String key = keys.next();

                tempAry = response.getJSONArray(key);

                //Get LatLon of current location
                tempObj = tempAry.getJSONObject(2);
                curLat = tempObj.getDouble("latitude");
                curLon = tempObj.getDouble("longitude");
                LatLng curPos = new LatLng(curLat, curLon);

                for(int i = 0; i < 2; i++)
                {
                    if(!tempAry.get(i).equals(null)) {
                        tempObj = tempAry.getJSONObject(i);

                        mName = tempObj.getString("title");
                        mLat = tempObj.getDouble("latitude");
                        mLon = tempObj.getDouble("longitude");

                        LatLng newPos = new LatLng(mLat, mLon);
                        //if(!locations.contains(newPos)) {
                        locations.add(curPos);
                        locations.add(newPos);
                        //}
                        markers.add(mMap.addMarker(new MarkerOptions().position(newPos).title(mName)));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        Log.d("LOCATION LIST", locations.toString());
        for(int j = 0; j < locations.size() - 1; j += 2) {
            PolylineOptions polyOption = new PolylineOptions().add(locations.get(j)).add(locations.get(j+1)).add(locations.get(j)).width(5).color(Color.RED).geodesic(true);
            mMap.addPolyline(polyOption);
        }
    }

    private JSONObject fillAryLocation() {
        JSONObject js = new JSONObject();
        try {
            js.put("title", "East Hall");
            js.put("latitude", 42.026002);
            js.put("longitude", -93.643408);
            js.put("status", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return js;
    }

    public JSONObject fillObjectLocation() {
        JSONObject js = new JSONObject();
        try {
            js.put("title", locationName);
            js.put("latitude", locationLat);
            js.put("longitude", locationLon);
            js.put("status", locationStat);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return js;
    }

    public String getLocationName() {
        return locationName;
    }

    public Double getLocationLatitude() {
        return locationLat;
    }

    public Double getLocationLongitude() {
        return locationLon;
    }

    private void responseHandler(int rn, JSONObject response) {
        if (rn == 0)
            move(response);
        else if (rn == 1)
            turnAround(response);
        else if (rn == 2)
            endGame(response);
    }

    public void updateLocation(JSONObject response) {
        try {
            locationName = response.getString("title");
            locationLat = response.getDouble("latitude");
            locationLon = response.getDouble("longitude");
            locationStat = response.getInt("status");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void move(JSONObject response) {
        updateLocation(response);
        moveCameraNew();
    }

    private void turnAround(JSONObject response) {
        try {
            LatLng newPos = new LatLng(response.getDouble("latitude"), response.getDouble("longitude"));
            mMap.addMarker(new MarkerOptions().position(newPos).title(response.getString("title")));
            CameraUpdate locationNew = CameraUpdateFactory.newLatLngZoom(newPos, maxZoom);
            mMap.animateCamera(locationNew, 5000, new GoogleMap.CancelableCallback() {
                @Override
                public void onFinish() {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Dead end! Turning Around...", Toast.LENGTH_SHORT);
                    toast.show();

                    LatLng oldPos = new LatLng(locationLat, locationLon);
                    mMap.addMarker(new MarkerOptions().position(oldPos).title(locationName));
                    CameraUpdate locationOld = CameraUpdateFactory.newLatLngZoom(oldPos, maxZoom);
                    mMap.animateCamera(locationOld, 5000, null);
                    btn_move_Left.setEnabled(false);
                    btn_move_Right.setEnabled(false);

                    waitTime(0);
                }

                @Override
                public void onCancel() {

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void endGame(JSONObject response) {
        updateLocation(response);
        LatLng newPos = new LatLng(locationLat, locationLon);
        mMap.addMarker(new MarkerOptions().position(newPos).title(locationName));
        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(newPos, maxZoom);
        mMap.animateCamera(location, 5000, new GoogleMap.CancelableCallback() {
            @Override
            public void onFinish() {
                GlobalVars.gameClockString.stopClock();
                startActivity(new Intent(GameBoardActivity.this, EndGameActivity.class));
            }

            @Override
            public void onCancel() {
                //This disables cancelling
            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        shouldAllowBack = false;
        mMap.getUiSettings().setScrollGesturesEnabled(false);
        mMap.getUiSettings().setZoomGesturesEnabled(false);

        locationName = "Friley Residence Hall";
        locationLat = 42.023975;
        locationLon = -93.650423;
        locationStat = 0;

        /*
         * We are going to display every node in /location and disable their onClickListener()
         */
        makeJsonArrayRequest();

        // Add a marker at Friley Residence Hall and move and zoom the camera
        moveCameraStart("Friley Residence Hall");

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                marker.showInfoWindow();
                return true;
            }
        });
    }

    private void moveCameraNew() {
        LatLng newPos = new LatLng(locationLat, locationLon);
        markers.add(mMap.addMarker(new MarkerOptions().position(newPos).title(locationName)));
        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(newPos, maxZoom);
        mMap.animateCamera(location, 5000, null);
    }

    private void moveCameraStart(String name) {
        LatLng currentPos = new LatLng(locationLat, locationLon);
        markers.add(mMap.addMarker(new MarkerOptions().position(currentPos).title(name)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentPos, maxZoom));
    }

    @Override
    public void onBackPressed() {
        if (!shouldAllowBack) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "You cannot go back once you've embarked on the trail",
                    Toast.LENGTH_SHORT);
            toast.show();
        } else
            super.onBackPressed();
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnMoveLeft:
                makeJsonObjReq("/left");
                waitTime(0);
                break;
            case R.id.btnMoveRight:
                makeJsonObjReq("/right");
                waitTime(0);
                break;
            case R.id.btnToChat: //Go to Chat activity
                startActivity(new Intent(GameBoardActivity.this, ChatActivity.class));
                break;
            case R.id.btnViewPack: //Go to ViewBackpack activity
                startActivity(new Intent(GameBoardActivity.this, ViewBackpackActivity.class));
                break;
            default:
                break;
        }

    }

    private void waitTime(int n) {
        btn_move_Left.setEnabled(false);
        btn_move_Right.setEnabled(false);
        btnToChat.setEnabled(false);
        btnViewPack.setEnabled(false);

        Timer buttonTimer = new Timer();
        buttonTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        //After we've waited, we've arrived at a new new node and want to see if there's an event here
                        updateLoc();
                        Timer timertimer = new Timer();
                        timertimer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(locationStat != 2)
                                        {
                                            checkForEvent();
                                        }
                                        Timer timert = new Timer();
                                        timert.schedule(new TimerTask() {
                                            @Override
                                            public void run() {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        btn_move_Left.setEnabled(true);
                                                        btn_move_Right.setEnabled(true);
                                                        btnToChat.setEnabled(true);
                                                        btnViewPack.setEnabled(true);
                                                        if(locationStat != 2) {
                                                            startActivity(new Intent(GameBoardActivity.this,
                                                                    EventActivity.class));
                                                        }
                                                    }
                                                });
                                            }
                                        }, 1000);
                                    }
                                });
                            }
                        }, 1000);

                    }
                });
            }
        }, 3000 + (n * 500));
    }

    private void checkForEvent() {

        JSONObject js = new JSONObject();
        try {
            js.put("username", GlobalVars.username);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest
                (Request.Method.POST, Const.URL_SERVER_GET_EVENT,
                        js, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                            GlobalVars.userJSONObj = response;
                            Log.d("checkForEventResponse", GlobalVars.userJSONObj.toString());
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
             */
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

                return params;
            }
        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }

    private void updateLoc() {
        JSONObject js = fillObjectLocation();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest
                (Request.Method.POST, Const.URL_SERVER_AT_LOCATION + "?username=" + GlobalVars.username,
                        js, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        //GlobalVars.userJSONObj = response;
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
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("title", locationName);
                params.put("latitude", Double.toString(locationLat));
                params.put("longitude", Double.toString(locationLon));
                params.put("status", Integer.toString(0));

                return params;
            }
        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }
}