package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_one;
    private Button btn_two;
    private Button btn_add;
    private EditText ed_cal;
    private boolean opflag = false;
    private Stack<Integer> stack = new Stack<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_one = findViewById(R.id.btn_1);
        btn_two = findViewById(R.id.btn_2);
        btn_add = findViewById(R.id.btn_add);
        ed_cal = findViewById(R.id.edittext_calculate);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_add.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                if (opflag){
                    opflag = false;
                    ed_cal.setText("1");
                }else{
                    ed_cal.append("1");
                }
                /*if (ed_cal.getText() == null){
                    ed_cal.setText("1");
                }else {
                    ed_cal.setText(ed_cal.getText().toString() + "1");
                    ed_cal.append("1");
                }*/
                //Toast.makeText(MainActivity.this, "点击了数字1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_2:
                if (opflag){
                    opflag = false;
                    ed_cal.setText("2");
                }else{
                    ed_cal.append("2");
                }
                //Toast.makeText(MainActivity.this, "点击了数字2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_add:
                opflag = true;
                if (stack.empty()){
                    int a = Integer.valueOf(ed_cal.getText().toString());
                    stack.push(a);
                } else {
                    int rs = stack.pop() + Integer.valueOf(ed_cal.getText().toString());
                    stack.push(rs);
                    ed_cal.setText(String.valueOf(rs));
                }
                break;
            default:
                Toast.makeText(MainActivity.this, "点击了其他按钮", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
