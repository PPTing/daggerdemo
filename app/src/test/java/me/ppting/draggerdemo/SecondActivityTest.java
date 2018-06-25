package me.ppting.draggerdemo;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import java.util.ArrayList;
import java.util.List;
import me.ppting.draggerdemo.activity.SecondActivity;
import me.ppting.draggerdemo.adapter.Items;
import me.ppting.draggerdemo.adapter.ListAdapter;

/**
 * Created by PPTing on 2018/6/23.
 * Description:
 */

@RunWith(RobolectricTestRunner.class)
public class SecondActivityTest {

    private Activity secondActivity;

    @Before
    public void set(){
        secondActivity = Robolectric.setupActivity(SecondActivity.class);
    }


    @Mock
    ListAdapter listAdapter;

    @Test
    public void testList(){


        listAdapter = Mockito.spy(ListAdapter.class);

        List<Items> items = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            Items item = new Items("mock name "+i);
            items.add(item);
        }

        RecyclerView recyclerView = secondActivity.findViewById(R.id.rv_list);
        recyclerView.setAdapter(listAdapter);
        listAdapter.setItems(items);

        //进行验证
        ConstraintLayout layout = (ConstraintLayout) recyclerView.getChildAt(0);
        TextView textView = (TextView) layout.getChildAt(0);
        Assert.assertEquals("mock name 0",textView.getText().toString());
    }
}
