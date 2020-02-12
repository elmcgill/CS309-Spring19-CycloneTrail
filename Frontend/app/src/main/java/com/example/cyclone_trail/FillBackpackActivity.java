package com.example.cyclone_trail;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cyclone_trail.Objects.Backpack;
import com.example.cyclone_trail.globals.GlobalVars;

import static com.example.cyclone_trail.globals.GlobalVars.shouldAllowBack;
import static com.example.cyclone_trail.globals.GlobalVars.userBackpack;

public class FillBackpackActivity extends Activity implements View.OnClickListener {

    private String TAG = FillBackpackActivity.class.getSimpleName();
    private Button btn_next;
    private TextView moneyLeft, itemDes, roomLeft;
    public EditText amtOfItem;
    //public Backpack userBackpack;
    private String[] items = {"food", "water", "supplies"};
    private int itr;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_backpack);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
        shouldAllowBack = false;

        GlobalVars.userBackpack = new Backpack(pDialog, TAG);
        GlobalVars.userBackpack.resetBagItemsList();

        //TextViews
        moneyLeft = findViewById(R.id.moneyLeft);
        itemDes = findViewById(R.id.itemDes);
        roomLeft = findViewById(R.id.roomLeft);

        //EditView
        amtOfItem = findViewById(R.id.amtOfItem);

        //Button
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);

        //set find by id for all backpack items
        for(int i = 0; i < items.length; i++) {
            for (int j = 0; j < GlobalVars.userBackpack.allItemViews(i).length; j++) {
                String itemID = items[i] + (j);
                int resID = getResources().getIdentifier(itemID, "id", getPackageName());
                GlobalVars.userBackpack.allItemViews(i)[j] = findViewById(resID);
            }
        }

        setupFood();
    }

    @Override
    public void onBackPressed() {
        if (!shouldAllowBack) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Fill your bag and continue to the Cyclone Trail!",
                    Toast.LENGTH_SHORT);

            toast.show();
        } else {
            super.onBackPressed();
        }
    }

    //Setup initial screen
    public void setupFood() {
        String temp = "" + getString(R.string.money_left, GlobalVars.userBackpack.getMoneyAmt());
        moneyLeft.setText(temp);
        itemDes.setText("Food: $2.00 each");
        String temp2 = "" + getString(R.string.room_left, GlobalVars.userBackpack.getSpaceLeft());
        roomLeft.setText(temp2);
        amtOfItem.setHint("Enter Amount of Food");
    }

    //Get food info
    public int getFood() {
        int temp = GlobalVars.userBackpack.getUserEnteredAmt(amtOfItem);
        int itemAmt = GlobalVars.userBackpack.calcSingleItemAmt(temp, 2);
        GlobalVars.userBackpack.updateMoneyAmt("sub", itemAmt * 2);
        GlobalVars.userBackpack.updateBag( "sub", "Food", itemAmt);
        return itemAmt;
    }

    public void setupWater() {
        String temp = "" + getString(R.string.money_left, GlobalVars.userBackpack.getMoneyAmt());
        moneyLeft.setText(temp);
        itemDes.setText("Water: $1.00 each");
        String temp2 = "" + getString(R.string.room_left, GlobalVars.userBackpack.getSpaceLeft());
        roomLeft.setText(temp2);
        amtOfItem.setText("");
        amtOfItem.setHint("Enter Amount of Water");
    }

    public int getWater() {
        int temp = GlobalVars.userBackpack.getUserEnteredAmt(amtOfItem);
        int itemAmt = GlobalVars.userBackpack.calcSingleItemAmt(temp, 1);
        GlobalVars.userBackpack.updateMoneyAmt("sub", itemAmt);
        GlobalVars.userBackpack.updateBag( "sub", "Water", itemAmt);
        return itemAmt;
    }

    public void setupSupplies() {
        String temp = "" + getString(R.string.money_left, GlobalVars.userBackpack.getMoneyAmt());
        moneyLeft.setText(temp);
        itemDes.setText("School Supplies: $2.00 each");
        String temp2 = "" + getString(R.string.room_left, GlobalVars.userBackpack.getSpaceLeft());
        roomLeft.setText(temp2);
        amtOfItem.setText("");
        amtOfItem.setHint("Enter Amount of Supplies");
    }

    public int getSupplies() {
        int temp = GlobalVars.userBackpack.getUserEnteredAmt(amtOfItem);
        int itemAmt = GlobalVars.userBackpack.calcSingleItemAmt(temp, 2);
        GlobalVars.userBackpack.updateMoneyAmt("sub", itemAmt * 2);
        GlobalVars.userBackpack.updateBag("sub", "School Supplies", itemAmt);
        return itemAmt;
    }

    public void setupReview() {
        String temp = "" + getString(R.string.money_left, GlobalVars.userBackpack.getMoneyAmt());
        moneyLeft.setText(temp);
        itemDes.setText("Here is your");
        roomLeft.setText("Filled Backpack");
        amtOfItem.setText("");
        amtOfItem.setHint(GlobalVars.username);
        amtOfItem.setFocusable(false);
        btn_next.setText("Start Game");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.btn_next:
            switch (itr) {
            case 0: //get food info/to water
                getFood();
                setupWater();
                itr++;
                break;
            case 1: //get water info/to supplies
                getWater();
                setupSupplies();
                itr++;
                break;
            case 2: //get supplies info/to review
                getSupplies();
                setupReview();
                itr++;
                break;
            case 3: //review info/to game
                fillBackpack();
                startActivity(new Intent(FillBackpackActivity.this, GameBoardActivity.class));
                break;
            }
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

    //JSON Request to send backpack info
    public void fillBackpack() {
        showProgressDialog();

        GlobalVars.userBackpack.sendBackpackRequest();
    }
}
