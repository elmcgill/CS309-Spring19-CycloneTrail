package com.example.cyclone_trail;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.example.cyclone_trail.globals.GlobalVars;

import java.util.Locale;

public class GameClockActivity extends AppCompatTextView {

    private Context context;

    public GameClockActivity(Context context) {
        super(context);
        this.context = context;
        GlobalVars.gameClockString = findViewById(R.id.GameClock);
    }

    public GameClockActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        GlobalVars.gameClockString = findViewById(R.id.GameClock);
    }

    public GameClockActivity(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        GlobalVars.gameClockString = findViewById(R.id.GameClock);
    }

    public void startGameClock() {
        GlobalVars.gameClock = new CountDownTimer(GlobalVars.gameClockMilliSeconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                GlobalVars.gameClockMilliSeconds = millisUntilFinished;
                updateScreen();
            }

            @Override
            public void onFinish() {
                Log.d("FINISH - time left: ", String.valueOf(GlobalVars.gameClockMilliSeconds));
                context.startActivity(new Intent(context, EndGameActivity.class));
            }
        }.start();
        GlobalVars.clockRunning = true;
    }

    // pause clock running
    public void stopClock() {
        GlobalVars.gameClock.cancel();
        GlobalVars.clockRunning = false;
    }

    /*// reset to 5 min == START_TIME_5MIN, 1 min == START_TIME_1MIN
    public void resetGameClock() {
        GlobalVars.gameClockMilliSeconds = START_TIME_5MIN;
    }*/

    // add specified time to clock
    public void addTimeGameClock(int seconds) {
        GlobalVars.gameClockMilliSeconds += (seconds * 1000);
    }

    // subtract specified time to clock
    public void subtractTimeGameClock(int seconds) {
        GlobalVars.gameClockMilliSeconds -= (seconds * 1000);
    }

    //change clock to minutes:seconds string format for user
    public void updateScreen() {
        int minutesLeft = (int) GlobalVars.gameClockMilliSeconds / 60000; //get minutes from time left
        int secondsLeft = (int) GlobalVars.gameClockMilliSeconds % 60000 / 1000; //get seconds from time left

        String tempTimeStr = String.format(Locale.getDefault(), "%02d:%02d", minutesLeft, secondsLeft);

        /*tempTimeStr = "" + minutesLeft;
        tempTimeStr += ":";
        if(secondsLeft < 10) {
            tempTimeStr += "0";
        }
        tempTimeStr += secondsLeft;*/

        GlobalVars.gameClockString.setText(tempTimeStr);
        //Log.d("Time Left", tempTimeStr);
    }
}

