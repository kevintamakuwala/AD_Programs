package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    TextView result;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        result = (TextView) findViewById(R.id.displayResult);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute(editText.getText().toString());
            }
        });
    }

    private class MyAsyncTask extends AsyncTask<String, String, String> {
        String response;
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

        @Override
        public void onPreExecute() {
            progressDialog.setMessage("Waiting for " + editText.getText().toString() + " Seconds");
            progressDialog.show();
        }

        @Override
        public String doInBackground(String... params) {
            publishProgress("Sleeping...");
            try {
                int timeInSeconds = Integer.parseInt(params[0]);
                int timeInMillis = 1000 * timeInSeconds;
                for (int i = 0; i < timeInSeconds; i++) {
                    Thread.sleep(1000);
                    publishProgress(response = "Slept for " + (i + 1) + " Seconds");
                }
            } catch (Exception e) {
                response = e.getMessage();
            }
            return response;
        }

        @Override
        public void onProgressUpdate(String... s) {
            result.setText(s[0]);
        }

        @Override
        public void onPostExecute(String s) {
            progressDialog.dismiss();
            result.setText(s);
        }
    }

}
