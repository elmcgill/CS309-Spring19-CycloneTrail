package com.example.cyclone_trail.globals;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.example.cyclone_trail.GameClockActivity;
import com.example.cyclone_trail.Objects.Backpack;

import org.json.JSONObject;

public class GlobalVars {
    /*private static final long START_TIME_5MIN = 300000;
    private static final long START_TIME_1MIN = 60000;*/

    // Game Clock global variables:
    public static GameClockActivity gameClockString;
    public static long gameClockMilliSeconds;
    public static CountDownTimer gameClock;
    public static boolean clockRunning;
    // End Game Clock global variables

    // User global variables:
    public static String username;
    public static int userID;
    public static JSONObject userJSONObj;
    public static Backpack userBackpack;
    //End User global variables

    // Game functionality global variables:
    public static boolean shouldAllowBack;
    // End Game functionality global variables

    // Score modifier global variable(s):
    public static double scoreMod;
    // End Score modifier global variable(s)
}
