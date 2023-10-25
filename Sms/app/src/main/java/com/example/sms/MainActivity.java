package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String mobile, msg;
        EditText e1, e2;
        Button b;
        b = (Button) findViewById(R.id.btnSend);
        e1 = (EditText) findViewById(R.id.mblTxt);
        e2 = (EditText) findViewById(R.id.msgTxt);
        mobile = e1.getText().toString();
        msg = e2.getText().toString();


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
//                    SmsManager s = SmsManager.getDefault();
//                    s.sendTextMessage(mobile, null, msg, null);


                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("smsto:"));
                    i.setType("vnd.android-dir/mms-sms");
                    i.putExtra("address", mobile);
                    i.putExtra("sms_body", msg);
                    startActivity(Intent.createChooser(i, "Send Sms via:"));
//                    SmsManager smsManager = SmsManager.getDefault();
//                    smsManager.sendTextMessage(mobile, null, msg, null, null);
                    Toast.makeText(MainActivity.this, "Sent Successfully", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}