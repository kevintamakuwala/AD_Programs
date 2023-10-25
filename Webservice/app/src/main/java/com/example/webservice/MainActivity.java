package com.example.webservice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.jetbrains.annotations.Contract;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String jsonStr = getListData();
        try {
            ArrayList<HashMap<String, String>> userList = new ArrayList<>();
            ListView lv = (ListView) findViewById(R.id.user_list);
            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONArray jsonArray = jsonObject.getJSONArray("users");
            for (int i = 0; i < jsonArray.length(); ++i) {
                HashMap<String, String> user = new HashMap<>();
                JSONObject obj = jsonArray.getJSONObject(i);
                user.put("name", obj.getString("name"));
                user.put("location", obj.getString("location"));
                user.put("designation", obj.getString("designation"));
                userList.add(user);
            }
            ListAdapter listAdapter = new SimpleAdapter(MainActivity.this, userList, R.layout.list_row, new String[]{"name", "location", "designation"}, new int[]{R.id.name, R.id.location, R.id.designation});
            lv.setAdapter(listAdapter);
        } catch (Exception e) {

        }
    }

    private String getListData() {
        String jsonStr = "{ \"users\" :[" +
                "{\"name\":\"Kevin\",\"designation\":\"Top Order Batsman\",\"location\":\"Surat\"}" +
                ",{\"name\":\"Virat Kohli\",\"designation\":\"Top Order Batsman\",\"location\":\"Delhi\"}" +
                ",{\"name\":\"Dhoni\",\"designation\":\"Captain\",\"location\":\"Ranchi\"}" +
                ",{\"name\":\"Rohit Sharma\",\"designation\":\"Opener\",\"location\":\"Mumbai\"}] }";
        return jsonStr;
    }
}