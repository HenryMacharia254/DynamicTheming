package com.timac.dynamicthemesetting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
// import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settingTheme();
        setContentView(R.layout.activity_main);
    }

    public void settingTheme() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String themeName = pref.getString("prefTheme", "Default");
        switch (themeName) {
            case "Default":
                setTheme(R.style.Theme_DynamicThemeSetting);
                break;
            case "Red":
                setTheme(R.style.RedTheme);
                break;
            case "Green":
                setTheme(R.style.GreenTheme);
                break;
            case "Yellow":
                setTheme(R.style.YellowTheme);
                break;
        }
    }

    public void setPreference(View view) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        if (view.getId() == R.id.buttonOriginal){
            editor.putString("prefTheme","Default");
        } else if (view.getId() == R.id.buttonGreen){
            editor.putString("prefTheme","Green");
            editor.apply();
        }else if (view.getId() == R.id.buttonYellow){
            editor.putString("prefTheme","Yellow");
        }
        else if (view.getId() == R.id.buttonRed){
            editor.putString("prefTheme","Red");
        }
        editor.apply();
        settingTheme();
        MainActivity.this.finish();
        MainActivity.this.startActivity(getIntent());
    }
}