package com.example.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText eTo;
    private EditText eSubject;
    private EditText eMsg;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTo = (EditText) findViewById(R.id.txtTo);
        eSubject = (EditText) findViewById(R.id.txtSub);
        eMsg = (EditText) findViewById(R.id.txtMsg);
        btn = (Button) findViewById(R.id.btnSend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{eTo.getText().toString()});
                i.putExtra(Intent.EXTRA_SUBJECT, eSubject.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT, eMsg.getText().toString());
                i.setType("message/rfc822");
                startActivity(Intent.createChooser(i,"Choose mail app"));
            }
        });
    }
}