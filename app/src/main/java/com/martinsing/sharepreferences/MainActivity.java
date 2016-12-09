package com.martinsing.sharepreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;
import static com.martinsing.sharepreferences.R.mipmap.ic_launcher;

public class MainActivity extends AppCompatActivity {

    TextView user_name;
    TextView user_sex;
    TextView user_dob;
    TextView user_height;
    TextView user_weight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_name = (TextView) findViewById(R.id.lbl_user_name);
        user_sex = (TextView) findViewById(R.id.lbl_user_sex);
        user_dob = (TextView) findViewById(R.id.lbl_user_dob);
        user_height = (TextView) findViewById(R.id.lbl_user_height);
        user_weight = (TextView) findViewById(R.id.lbl_user_weight);

        SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);

        String Firstname = sharedPreferences.getString("ufirst_name", null);
        String Lastname = sharedPreferences.getString("ulast_name", null);
        String sex = sharedPreferences.getString("usex", null);
        String dob = sharedPreferences.getString("udob", null);
        String height = sharedPreferences.getString("uheight", null);
        String weight = sharedPreferences.getString("uweight", null);

        user_name.setText(Lastname + ", " + Firstname);
        user_sex.setText(sex);
        user_dob.setText(dob);
        user_height.setText(height);
        user_weight.setText(weight);


//For the Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//Sets launcher icon as home
        toolbar.setNavigationIcon(ic_launcher);
    }

    //Launch the Input Activity
    public void gotoInput(View view) {
        Intent intent = new Intent(this, Input.class);
        startActivity(intent);
    }
}