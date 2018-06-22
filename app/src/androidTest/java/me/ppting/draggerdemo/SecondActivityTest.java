package me.ppting.draggerdemo;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.ppting.draggerdemo.activity.SecondActivity;

/**
 * Created by PPTing on 2018/6/21.
 * Description:
 */

@RunWith(AndroidJUnit4.class)
public class SecondActivityTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(SecondActivity.class);

    @Test
    public void testShowResult(){
        Espresso.onView(ViewMatchers.withId(R.id.tv_result_in_second))
                .perform(ViewActions.click());
    }
}
