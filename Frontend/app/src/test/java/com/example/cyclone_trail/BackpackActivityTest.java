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
 * Unit tests for the (@link FillBackpackActivity)
 */

@RunWith(MockitoJUnitRunner.class)
public class BackpackActivityTest {
    //Place private static finals here

    private ProgressDialog pDialog;
    private String tag = "TEST";
    private Backpack mMockedBackpack;
    private Context context;
    private FillBackpackActivity mMockFillBackpackActivity;

    @Mock
    Backpack mMockBackpackObject;

    @Before
    public void setUp() throws Exception {
        mMockFillBackpackActivity = new FillBackpackActivity();
        //mMockedBackpack = new Backpack(context, pDialog, tag);

        //mMockFillBackpackActivity.userBackpack = mMockBackpackObject;
        GlobalVars.userBackpack = mMockBackpackObject;
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_getFood0() {
        when(GlobalVars.userBackpack.getUserEnteredAmt(mMockFillBackpackActivity.amtOfItem)).thenReturn((int) 2);
        when(GlobalVars.userBackpack.calcSingleItemAmt(2,2)).thenReturn((int) 2);
        int foodAmt = mMockFillBackpackActivity.getFood();

        assertThat("Test if user enters in 2 then foodAmt will be 2",
                foodAmt, is(2));
    }

    @Test
    public void test_getFood1() {
        when(GlobalVars.userBackpack.getUserEnteredAmt(mMockFillBackpackActivity.amtOfItem)).thenReturn((int) 9);
        when(GlobalVars.userBackpack.calcSingleItemAmt(9,2)).thenReturn((int) 5);
        int foodAmt = mMockFillBackpackActivity.getFood();

        assertThat("Test if user enters in 9 then foodAmt will be 5",
                foodAmt, is(5));
    }

    @Test
    public void test_getFood2() {
        when(GlobalVars.userBackpack.getUserEnteredAmt(mMockFillBackpackActivity.amtOfItem)).thenReturn((int) 0);
        when(GlobalVars.userBackpack.calcSingleItemAmt(0,2)).thenReturn((int) 0);
        int foodAmt = mMockFillBackpackActivity.getFood();

        assertThat("Test if user enters in 0 then foodAmt will be 0",
                foodAmt, is(0));
    }

    /*@Test
    public void test_addToBag() {
        pack.resetBagItemsList();
        pack.addToBag("Food", 5);
        assertThat("Test adding 5 Food to the backpack arraylist",
                pack.getBagItemsList(),
                is(equalTo("[Food, Food, Food, Food, Food]")));

        pack.resetBagItemsList();
        pack.addToBag("Water", 9);
        assertThat("Test adding 9 Water to the backpack arraylist",
                pack.getBagItemsList(),
                is(equalTo("[Water, Water, Water, Water, Water, Water, Water, Water, Water]")));

        pack.resetBagItemsList();
        pack.addToBag("School Supplies", 10);
        assertThat("Test adding 10 School Supplies to the backpack arraylist, try to overfill",
                pack.getBagItemsList(),
                is(equalTo("[School Supplies, School Supplies, School Supplies, School Supplies, School Supplies, School Supplies, School Supplies, School Supplies, School Supplies]")));

        pack.resetBagItemsList();
        pack.addToBag("Food", 2);
        pack.addToBag("Water", 3);
        pack.addToBag("School Supplies", 5);
        assertThat("Test adding different items to the backpack arraylist",
                pack.getBagItemsList(),
                is(equalTo("[Food, Food, Water, Water, Water, School Supplies, School Supplies, School Supplies, School Supplies]")));

    }

    @Test
    public void test_removeFromBag() {
        // From test above this works:
        pack.addToBag("Food", 2);
        pack.addToBag("Water", 3);
        pack.addToBag("School Supplies", 5);

        pack.removeFromBag("Food", 1);
        assertThat("Test removing 1 food from the backpack arraylist",
                pack.getBagItemsList(),
                is(equalTo("[Food, Water, Water, Water, School Supplies, School Supplies, School Supplies, School Supplies]")));

        pack.removeFromBag("Water", 2);
        assertThat("Test removing 2 water from the backpack arraylist",
                pack.getBagItemsList(),
                is(equalTo("[Food, Water, School Supplies, School Supplies, School Supplies, School Supplies]")));

        pack.removeFromBag("School Supplies", 3);
        assertThat("Test removing 3 School Supplies from the backpack arraylist",
                pack.getBagItemsList(),
                is(equalTo("[Food, Water, School Supplies]")));

        pack.resetBagItemsList();
        assertThat("Test resetting the backpack arraylist",
                pack.getBagItemsList(),
                is(equalTo("[]")));
    }

    @Test
    public void test_itemAmounts() {
        // From test above this works:
        pack.addToBag("Food", 2);
        pack.addToBag("Water", 3);
        pack.addToBag("School Supplies", 5);

        assertThat("Test getting item amounts",
                pack.itemAmounts()[0],
                is(equalTo( 2 )));
        assertThat("Test getting item amounts",
                pack.itemAmounts()[1],
                is(equalTo( 3 )));
        assertThat("Test getting item amounts",
                pack.itemAmounts()[2],
                is(equalTo( 4 )));

        pack.resetBagItemsList();
        pack.addToBag("Water", 15);
        assertThat("Test getting item amounts",
                pack.itemAmounts()[1],
                is(equalTo( 9 )));
    }*/
}
