package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = (TextView) findViewById(R.id.text);
        registerForContextMenu(t);
    }
    public void showPopUp(View v){
        PopupMenu p=new PopupMenu(this,v);
        p.setOnMenuItemClickListener(this);
        p.inflate(R.menu.text_context_menu);
        p.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem m) {
        int id = m.getItemId();
        TextView t = (TextView) findViewById(R.id.text);
        if (id == R.id.increase) {
            t.setTextSize(TypedValue.COMPLEX_UNIT_PX, t.getTextSize() + 10);
        } else if (id == R.id.decrease) {
            t.setTextSize(TypedValue.COMPLEX_UNIT_PX, t.getTextSize() - 10);
        }
        return false;
    }

    public void onCreateContextMenu(ContextMenu m, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(m, v, menuInfo);
        getMenuInflater().inflate(R.menu.text_context_menu, m);
    }

    public boolean onContextItemSelected(MenuItem m) {
        int id = m.getItemId();
        TextView t = (TextView) findViewById(R.id.text);
        if (id == R.id.increase) {
            t.setTextSize(TypedValue.COMPLEX_UNIT_PX, t.getTextSize() + 10);
        } else if (id == R.id.decrease) {
            t.setTextSize(TypedValue.COMPLEX_UNIT_PX, t.getTextSize() - 10);
        }
        return super.onContextItemSelected(m);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem m) {
        int id = m.getItemId();
        if (id == R.id.new_canvas) {
            Toast.makeText(this, "Canvas", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.settings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(m);
    }
}