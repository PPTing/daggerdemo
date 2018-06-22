package me.ppting.draggerdemo.util;

import android.support.test.espresso.AmbiguousViewMatcherException;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.core.internal.deps.guava.base.Predicate;
import android.support.test.espresso.core.internal.deps.guava.collect.Iterables;
import android.support.test.espresso.core.internal.deps.guava.collect.Iterators;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Matcher;

import java.util.Iterator;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.util.TreeIterables.breadthFirstViewTraversal;
import static org.hamcrest.Matchers.is;

/**
 * Created by PPTing on 2018/6/22.
 * Description: 用来校验 margin 值的类
 */
public class MarginAssertions {

    /**
     * 计算该 view 和 anotherView 的 marginTop 是否正确
     * @param viewMatcher
     * @param margin px
     * @return
     */
    public static ViewAssertion isMarginTopRight(final Matcher<View> viewMatcher, final int margin){
        return new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {


                View anotherView = findView(viewMatcher, getTopViewGroup(view));

                int firstViewTop = getTop(view);

                int secondViewTop = getTop(anotherView);


                assertThat(
                        "两个 view 的 marginTop 值不正确，请检查",
                        Math.abs(firstViewTop - secondViewTop) == margin + view.getMeasuredHeight(),
                        is(true));
            }
        };
    }

    /**
     * 计算两个 view 的 marginLeft 是否正确
     * @param viewMatcher
     * @param margin px
     * @return
     */
    public static ViewAssertion isMarginLeftRight(final Matcher<View> viewMatcher, final int margin){
        return new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                View anotherView = findView(viewMatcher, getTopViewGroup(view));

                int firstViewLeft = getLeft(view);

                int secondViewLeft = getLeft(anotherView);

                int width = view.getMeasuredWidth();

                assertThat(
                        "两个 view 的 marginLeft 值不正确，请检查",
                        Math.abs(firstViewLeft - secondViewLeft) == (margin + width),
                        is(true)
                );
            }
        };
    }

    /**
     * 获取距离屏幕顶部的距离
     * @param view
     * @return
     */
    static int getTop(View view){
        int[] outLocation = new int[2];
        view.getLocationOnScreen(outLocation);
        return outLocation[1];
    }

    /**
     * 获取距离屏幕左边的距离
     * @param view
     * @return
     */
    static int getLeft(View view){
        int[] outLocation = new int[2];
        view.getLocationOnScreen(outLocation);
        return outLocation[0];
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
}
