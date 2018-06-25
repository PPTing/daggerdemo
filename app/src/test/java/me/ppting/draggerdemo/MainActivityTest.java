package me.ppting.draggerdemo;

import android.app.Activity;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import me.ppting.draggerdemo.activity.MainActivity;

/**
 * Created by PPTing on 2018/6/23.
 * Description:
 */

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {


    private Activity main;

    @Before
    public void setUp(){
        main = Robolectric.setupActivity(MainActivity.class);
    }
    @Test
    public void testAddResult(){

        EditText firstEt = main.findViewById(R.id.et_no_one);
        firstEt.setText("34");

        EditText secondEt = main.findViewById(R.id.et_no_two);
        secondEt.setText("14");

        Button addBt = main.findViewById(R.id.bt_add);
        addBt.performClick();

        TextView textView = main.findViewById(R.id.tv_result);


        Assert.assertEquals("48",textView.getText().toString());

    }

    @Test
    public void testText(){
        Espresso.onView(ViewMatchers.withId(R.id.bt_left))
                .check(ViewAssertions.matches(ViewMatchers.withText("左边")));
    }
}
