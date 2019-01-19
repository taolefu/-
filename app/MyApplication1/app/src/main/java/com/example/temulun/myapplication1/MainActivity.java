package com.example.temulun.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1=null;
    private EditText et1=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.tv1);
        et1=(EditText)findViewById(R.id.et1);
        Log.d("MainActivity", "onCreate: execute");
    }

        public void click (View view){
        for (int i=0;i<4;i++) {
            String wenben = tv1.getText().toString();
            String yanzheng = et1.getText().toString();
            if (wenben.equals("输入正确，请进行下一步")) {
                break;
            } else {
                if (yanzheng.equals("abcd")) {
                    tv1.setText("输入正确，请进行下一步");
                }
                else {
                    tv1.setText("输入错误，请重新输入");
                }
            }
        }
    }
}
