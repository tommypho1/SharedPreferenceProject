package com.example.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {
    private SharedPreferences prefs;
    private String prefName = "MyPref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences(prefName, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        EditText e = (EditText) findViewById(R.id.editText);
        e.setText(prefs.getString("TextValue", "Default Value"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        EditText e = (EditText) findViewById(R.id.editText);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("TextValue", e.getText().toString());
        editor.commit();
    }
}
