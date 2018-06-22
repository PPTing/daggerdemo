package me.ppting.draggerdemo;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.PositionAssertions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.ppting.draggerdemo.activity.MainActivity;
import me.ppting.draggerdemo.util.MarginAssertions;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static org.hamcrest.Matchers.is;

//import com.google.common.base.Preconditions;
//import com.google.common.base.Predicate;
//import com.google.common.collect.Iterables;
//import com.google.common.collect.Iterators;

/**
 * Created by PPTing on 2018/6/20.
 * Description:
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAddResult(){
        //输入一个 34
        Espresso.onView(ViewMatchers.withId(R.id.et_no_one))
                .perform(ViewActions.typeText("34"),ViewActions.closeSoftKeyboard());

        Espresso.onView(ViewMatchers.withId(R.id.et_no_two))
                .perform(ViewActions.typeText("14"),ViewActions.closeSoftKeyboard());

        //点击相加
        Espresso.onView(ViewMatchers.withId(R.id.bt_add))
                .perform(ViewActions.click());


        //点击跳转
        Espresso.onView(ViewMatchers.withId(R.id.bt_jump))
                .perform(ViewActions.click());
//
        Espresso.onView(ViewMatchers.withId(R.id.tv_result_in_second))
                .check(ViewAssertions.matches(ViewMatchers.withText("48")));


    }


    /**
     * 测试两个按钮的 marginTop 值是否正确
     */
    @Test
    public void testIsMarginTopRight(){
        Espresso.onView(ViewMatchers.withId(R.id.bt_add))
                .check(MarginAssertions.isMarginTopRight(ViewMatchers.withId(R.id.bt_jump),30));
    }

    @Test
    public void testIsMarginLeftRight(){
        Espresso.onView(ViewMatchers.withId(R.id.bt_left))
                .check(MarginAssertions.isMarginLeftRight(ViewMatchers.withId(R.id.bt_right),90));
    }






}
