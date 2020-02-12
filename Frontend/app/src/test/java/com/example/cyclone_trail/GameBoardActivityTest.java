package com.example.cyclone_trail;

import com.google.android.gms.maps.model.LatLng;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit tests for the (@link GameBoardActivity)
 */

@RunWith(MockitoJUnitRunner.class)
public class GameBoardActivityTest {
    //Place private static finals here

    private GameBoardActivity mMockGameBoardActivity;

    @Mock
    JSONObject mMockJsonObject;

    @Before
    public void setUp() throws Exception {
        mMockGameBoardActivity = new GameBoardActivity();
        mMockGameBoardActivity.setStart();

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_setStart() {
        assertThat("Checking that GameBoardActivity.locationName is set correctly when the game starts",
                mMockGameBoardActivity.getLocationName(),
                is(equalTo("Friley Residence Hall")));
        assertThat("Checking that GameBoardActivity.locationLat is set correctly when the game starts",
                mMockGameBoardActivity.getLocationLatitude(),
                is(equalTo(42.023975)));
        assertThat("Checking that GameBoardActivity.locationLon is set correctly when the game starts",
                mMockGameBoardActivity.getLocationLongitude(),
                is(equalTo(-93.650423)));

    }

    @Test
    public void test_fillObjectLocation() throws JSONException {
        when(mMockJsonObject.getString("title")).thenReturn("Friley Residence Hall");
        when(mMockJsonObject.getDouble("latitude")).thenReturn(42.023975);
        when(mMockJsonObject.getDouble("longitude")).thenReturn(-93.650423);

        assertThat("Checking that GameBoardActivity.locationName is placed inside JSONObject correctly",
                mMockGameBoardActivity.fillObjectLocation().getString("title"),
                is(equalTo(mMockJsonObject.getString("title"))));
        assertThat("Checking that GameBoardActivity.locationLat is placed inside JSONObject correctly",
                mMockGameBoardActivity.fillObjectLocation().getDouble("latitude"),
                is(equalTo(mMockJsonObject.getDouble("latitude"))));
        assertThat("Checking that GameBoardActivity.locationLon is placed inside JSONObject correctly",
                mMockGameBoardActivity.fillObjectLocation().getDouble("longitude"),
                is(equalTo(mMockJsonObject.getDouble("longitude"))));
    }

    @Test
    public void test_updateLocation() throws JSONException {
        when(mMockJsonObject.getString("title")).thenReturn("East Hall");
        when(mMockJsonObject.getDouble("latitude")).thenReturn(42.026002);
        when(mMockJsonObject.getDouble("longitude")).thenReturn(-93.643408);
        when(mMockJsonObject.getInt("status")).thenReturn(0);

        mMockGameBoardActivity.updateLocation(mMockJsonObject);

        assertThat("Checking that GameBoardActivity.locationName updates correctly",
                mMockGameBoardActivity.getLocationName(),
                is(equalTo(mMockJsonObject.getString("title"))));
        assertThat("Checking that GameBoardActivity.locationLat updates correctly",
                mMockGameBoardActivity.getLocationLatitude(),
                is(equalTo(mMockJsonObject.getDouble("latitude"))));
        assertThat("Checking that GameBoard.locationLon updates correctly",
                mMockGameBoardActivity.getLocationLongitude(),
                is(equalTo(mMockJsonObject.getDouble("longitude"))));
    }

}
