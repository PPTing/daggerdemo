package me.ppting.draggerdemo;

import android.support.test.espresso.AmbiguousViewMatcherException;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.PositionAssertions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.core.internal.deps.guava.base.Predicate;
import android.support.test.espresso.core.internal.deps.guava.collect.Iterables;
import android.support.test.espresso.core.internal.deps.guava.collect.Iterators;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ViewAsserts;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Iterator;

import me.ppting.draggerdemo.activity.MainActivity;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.util.TreeIterables.breadthFirstViewTraversal;
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
     * 测试两个按钮的 margin 值是否正确
     */
    @Test
    public void testIsMarginRight(){
        Espresso.onView(ViewMatchers.withId(R.id.bt_add))
                .check(isMarginRight(ViewMatchers.withId(R.id.bt_jump),30));
    }




    public static ViewAssertion isMarginRight(final Matcher<View> anotherView,final int margin){
        return new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {


                View anotherVieww = findView(anotherView, getTopViewGroup(view));

                int[] firstOutLocation = new int[2];
                view.getLocationOnScreen(firstOutLocation);

                int[] secondOutLocation = new int[2];
                anotherVieww.getLocationOnScreen(secondOutLocation);

                Log.d("MainActivityTest","first top "+firstOutLocation[1]);
                Log.d("MainActivityTest","second top "+secondOutLocation[1]);
                Log.d("MainActivityTest","view height "+view.getMeasuredHeight());

                assertThat(
                        "描述",
                        Math.abs(firstOutLocation[1] - secondOutLocation[1]) == margin + view.getMeasuredHeight(),
                        is(true));
            }
        };
    }

    // Helper methods
    static View findView(final Matcher<View> toView, View root) {

        final Predicate<View> viewPredicate =
                new Predicate<View>() {
                    @Override
                    public boolean apply(View input) {
                        return toView.matches(input);
                    }
                };
        Iterator<View> matchedViewIterator =
                Iterables.filter(breadthFirstViewTraversal(root), viewPredicate).iterator();
        View matchedView = null;
        while (matchedViewIterator.hasNext()) {
            if (matchedView != null) {
                // Ambiguous!
                throw new AmbiguousViewMatcherException.Builder()
                        .withRootView(root)
                        .withViewMatcher(toView)
                        .withView1(matchedView)
                        .withView2(matchedViewIterator.next())
                        .withOtherAmbiguousViews(Iterators.toArray(matchedViewIterator, View.class))
                        .build();
            } else {
                matchedView = matchedViewIterator.next();
            }
        }
        if (matchedView == null) {
            throw new NoMatchingViewException.Builder()
                    .withViewMatcher(toView)
                    .withRootView(root)
                    .build();
        }
        return matchedView;
    }

    private static ViewGroup getTopViewGroup(View view) {
        ViewParent currentParent = view.getParent();
        ViewGroup topView = null;
        while (currentParent != null) {
            if (currentParent instanceof ViewGroup) {
                topView = (ViewGroup) currentParent;
            }
            currentParent = currentParent.getParent();
        }
        return topView;
    }

//    public static Matcher<View> isMarginRight( final Matcher<View> anotherView,final int margin) {
//        return new TypeSafeMatcher<View>() {
//
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("with margin : ");
//                description.appendValue(margin);
//                anotherView.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//
//                int[] firstOutLocation = new int[2];
//                view.getLocationOnScreen(firstOutLocation);
//
//
//
//                return false;
//
//            }
//        };
//    }
}
