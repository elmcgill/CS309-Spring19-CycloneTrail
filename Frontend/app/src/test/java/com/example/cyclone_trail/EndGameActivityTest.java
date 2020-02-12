package com.example.cyclone_trail;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.EditText;

import com.example.cyclone_trail.Objects.Backpack;
import com.example.cyclone_trail.globals.GlobalVars;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the (@link EndGameActivity)
 */

@RunWith(MockitoJUnitRunner.class)
public class EndGameActivityTest {
    //Place private static finals here

    private ProgressDialog pDialog;
    private String tag = "TEST";
    EndGameActivity testEndGameActivity;

    @Before
    public void setUp() throws Exception {
        testEndGameActivity = new EndGameActivity();

    }

    @Test
    public void test_calculateScore() {
        GlobalVars.gameClockMilliSeconds = 60000*4; // set time left
        testEndGameActivity.itemAmts[0] = 0;        // set food amount
        testEndGameActivity.itemAmts[1] = 0;        // set water amount
        testEndGameActivity.itemAmts[2] = 0;        // set supplies amount
        GlobalVars.scoreMod = 0;                    // set special modifier
        int score = testEndGameActivity.calculateScore();

        assertThat("Time left: 4 min, Food: 0, Water: 0, Supplies: 0, Special Mod: 0",
                score, is(48000));
    }
}
