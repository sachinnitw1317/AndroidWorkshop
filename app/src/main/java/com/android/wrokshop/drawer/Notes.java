package com.android.wrokshop.drawer;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.wrokshop.drawer.R;

public class Notes extends ActionBarActivity {
    EditText notes;
    Button save,clear;
    SharedPreferences sharedpreferences;
    public static final String notes_pref = "notes" ;
    public  static  final String notes_text="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        notes= (EditText) findViewById(R.id.notes);
        save= (Button) findViewById(R.id.save);
        clear= (Button) findViewById(R.id.clear);
        sharedpreferences = getSharedPreferences(notes_pref,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(notes_text)) {
            notes.setText(sharedpreferences.getString(notes_text, ""));
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = notes.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(notes_text, n);
                editor.commit();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes.setText("");

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
