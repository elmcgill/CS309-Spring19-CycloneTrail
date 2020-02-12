package com.example.cyclone_trail.Objects;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.cyclone_trail.CreateUserActivity;
import com.example.cyclone_trail.LoginActivity;
import com.example.cyclone_trail.app.AppController;
import com.example.cyclone_trail.globals.GlobalVars;
import com.example.cyclone_trail.net_utils.Const;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Backpack {

    private String TAG;
    private ImageView[] food = new ImageView[9];
    private ImageView[] water = new ImageView[9];
    private ImageView[] supplies = new ImageView[9];
    private ImageView[][] itemViews = {food, water, supplies};
    private int moneyAmt, spaceLeft;
    private ArrayList<String> bagItemsList;
    private ProgressDialog pDialog;

    // These tags will be used to cancel the requests
    private String tag_json_obj = "jobj_req";

    public Backpack(ProgressDialog pDialog, String tag) {
        this.pDialog = pDialog;

        TAG = tag;

        bagItemsList = new ArrayList<>();

        moneyAmt = 10; // start game with $10
        spaceLeft = 9; // max space is 9
    }

    //additional constructors for having a pre-filled backpack or sized pack
    public Backpack(ProgressDialog pDialog, String tag, ArrayList<String> baglist) {
        this.pDialog = pDialog;

        TAG = tag;

        bagItemsList = baglist;

        moneyAmt = 10; // start game with $10
        spaceLeft = 9; // max space is 9
    }

    public ImageView[] allItemViews(int itemIdx) {
        return itemViews[itemIdx];
    }

    public int getMoneyAmt() {
        return moneyAmt;
    }

    public void setMoneyAmt(int money) {
        moneyAmt = money;
    }

    public void updateMoneyAmt(String addSub, int mod) {
        int temp = moneyAmt;
        if(addSub.compareTo("add") == 0) {
            temp += mod;
        } else {
            temp -= mod;
        }
        if(temp < 0) {
            temp = 0;
        }
        moneyAmt = temp;
    }

    public int getSpaceLeft() {
        return spaceLeft;
    }

    public void setSpaceLeft(String addSub, int mod) {
        if(addSub.compareTo("add") == 0) {
            spaceLeft += mod;
        } else {
            spaceLeft -= mod;
        }
    }

    public void addToBag(String item, int amt) {
        for(int i = 0; i < amt; i++) {
            if(bagItemsList.size() < 9) { // add items while the bag is not full
                bagItemsList.add(item);
            } else {
                break; // bag full, exit
            }
        }
    }

    public void removeFromBag(String item, int amt) {
        for(int i = 0; i < amt; i++) {
            if(bagItemsList.size() > 1) { // remove items while the bag is not empty
                bagItemsList.remove(item);
            } else {
                break; // bag full, exit
            }
        }
    }

    public String getBagItemsListString() {
        return bagItemsList.toString();
    }

    public void resetBagItemsList() {
        bagItemsList.clear();
    }

    public int getUserEnteredAmt(EditText amtOfItem) {
        int temp = 0;
        if(!amtOfItem.getText().toString().isEmpty()) {
            temp = Integer.parseInt(amtOfItem.getText().toString());
        }
        return temp;
    }

    public int calcSingleItemAmt(int userVal, int price) {
        int cost = userVal * price;
        int itemAmt = 0;
        if(cost >= getMoneyAmt()) {
            itemAmt = getMoneyAmt() / price; //set to max amount
        } else if (cost < 0) {
            itemAmt = 0;
        } else {
            itemAmt = userVal;
        }
        if(itemAmt > 9) {   // max number of items purchasable is 9
            itemAmt = 9;
        }
        return itemAmt;
    }

    public int getItemAmount(items selection) {
        int[] itemAmts = {0, 0, 0};
        for(int i = 0; i < bagItemsList.size(); i++) {
            if(bagItemsList.get(i).compareTo("Food") == 0) {
                itemAmts[0]++;
            } else if (bagItemsList.get(i).compareTo("Water") == 0) {
                itemAmts[1]++;
            } else if (bagItemsList.get(i).compareTo("School Supplies") == 0) {
                itemAmts[2]++;
            } else {
                break;
            }
        }
        switch(selection) {
            case Food:
                return itemAmts[0];
            case Water:
                return itemAmts[1];
            case Supplies:
                return itemAmts[2];
            default:
                return 0;
        }
    }

    public int[] allItemAmounts() {
        int[] all = {getItemAmount(items.Food), getItemAmount(items.Water), getItemAmount(items.Supplies)};
        return all;
    }

    public void resetVis() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j++) {
                itemViews[i][j].setVisibility(View.INVISIBLE);
            }
        }
    }

    public void setupVis() {
        resetVis();
        int idx = 0;
        int[] itemAmts = allItemAmounts();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < itemAmts[i]; j++) {
                itemViews[i][idx].setVisibility(View.VISIBLE);
                idx++;
            }
        }
    }

    /**
     * @param addSubSpace
     *  Adding or Subtracting items?
     * @param item
     *  item to add/remove
     * @param itemAmt
     *  how many of the item to fill the bag with
     * @return
     *  updated bagItemsList
     */
    public ArrayList<String> updateBag(String addSubSpace, String item, int itemAmt) {
        //updateMoneyAmt(addSubSetMoney, costOrMoney); //increase/decrease money
        setSpaceLeft(addSubSpace, itemAmt); //increase/decrease space
        if(addSubSpace.compareTo("add") == 0) {
            removeFromBag(item, itemAmt);
        } else {
            addToBag(item, itemAmt);
        }
        setupVis();
        return bagItemsList;
    }

    private void showProgressDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideProgressDialog() {
        if (pDialog.isShowing())
            pDialog.hide();
    }

    public void sendBackpackRequest() {
        Log.d("Backpack contents", bagItemsList.toString());
        for(int i = 0; i < bagItemsList.size(); i++) {

            // Create URL using Username and Password
            final String URL = Const.URL_SERVER_ADD_TO_BAG;

            JSONObject js = new JSONObject();
            try {
                js.put("username", GlobalVars.username);
                js.put("object", bagItemsList.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            final int finalI = i;
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
                    params.put("username", GlobalVars.username);
                    params.put("object", bagItemsList.get(finalI));

                    return params;
                }

            };

            //Adding request to request queue
            AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

            //Cancelling request
            //ApplicationController.getInstance().getRequestQueue().cancelAll(tag_string_req);

        }
    }

    public enum items {
        Food, Water, Supplies;
    }
}
