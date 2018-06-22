package me.ppting.draggerdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import me.ppting.draggerdemo.ITest;
import me.ppting.draggerdemo.R;
import me.ppting.draggerdemo.component.DaggerSaladComponent;
import me.ppting.draggerdemo.component.SaladComponent;
import me.ppting.draggerdemo.model.SaladModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Inject
    SaladModel saladModel;
    private EditText etNoOne;
    private EditText etNoTwo;
    private TextView tvResult;
    private Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SaladComponent saladComponent = DaggerSaladComponent.create();
        ITest iTest = saladComponent.getTest();
        iTest.test();

        initView();
    }

    private void initView() {
        etNoOne = findViewById(R.id.et_no_one);
        etNoTwo = findViewById(R.id.et_no_two);
        tvResult = findViewById(R.id.tv_result);
        btAdd = findViewById(R.id.bt_add);
        btAdd.setOnClickListener(this);

        int[] a = new int[2];
        btAdd.getLocationOnScreen(a);
        Log.d("getMarginTop a","outLocation 0"+a[0]);
        Log.d("getMarginTop a","outLocation 1"+a[1]);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_add:
                calculateResult();
                break;
        }
    }

    private void calculateResult(){
        String a = etNoOne.getText().toString();
        String b = etNoTwo.getText().toString();
        Integer numA = Integer.valueOf(a);
        Integer numB = Integer.valueOf(b);

        if (TextUtils.isEmpty(a)){
            Toast.makeText(this,"请输入第一行数字",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(b)){
            Toast.makeText(this,"请输入第二行数字",Toast.LENGTH_SHORT).show();
            return;
        }

        tvResult.setText(String.valueOf(numB + numA));



    }

    public void jump2Second(View view) {
        SecondActivity.start(this,tvResult.getText().toString());
    }
}
