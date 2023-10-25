package com.example.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.datetimepicker.fragments.DatePickerFragment;
import com.example.datetimepicker.fragments.TimePickerFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.btn_time);
        EditText e1=(EditText) findViewById(R.id.text_time);

        Button btn2 = (Button) findViewById(R.id.btn_date);
        EditText e2=(EditText) findViewById(R.id.text_date);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerFragment t=new TimePickerFragment(e1);
                t.show(getSupportFragmentManager(),"");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment t=new DatePickerFragment(e2);
                t.show(getSupportFragmentManager(),"");
            }
        });
    }
}