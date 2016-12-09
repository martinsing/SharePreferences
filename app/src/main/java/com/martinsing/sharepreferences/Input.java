package com.martinsing.sharepreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class Input extends AppCompatActivity implements View.OnClickListener {

    EditText first_name;
    EditText last_name;
    Spinner sex;
    EditText dob;
    EditText height;
    EditText weight;
    SharedPreferences sharedPreferences;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        first_name = (EditText) findViewById(R.id.lbl_edit_firstname);
        last_name = (EditText) findViewById(R.id.lbl_edit_lastname);
        sex = (Spinner) findViewById(R.id.lbl_edit_sex);
        dob = (EditText) findViewById(R.id.lbl_edit_dob);
        height = (EditText) findViewById(R.id.lbl_edit_height);
        weight = (EditText) findViewById(R.id.lbl_edit_weight);
        sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(this);

        SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
        String Firstname = sharedPreferences.getString("ufirst_name", null);
        String Lastname = sharedPreferences.getString("ulast_name", null);
        String Dob = sharedPreferences.getString("udob", null);
        String Height = sharedPreferences.getString("uheight", null);
        String Weight = sharedPreferences.getString("uweight", null);

        first_name.setText(Firstname);
        last_name.setText(Lastname);
        dob.setText(Dob);
        height.setText(Height);
        weight.setText(Weight);

//For the Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//Add back arrow to toolbar
        if (getSupportActionBar() != null) {
//Specifies whether or not the Home button is shown.
            getSupportActionBar().setDisplayShowHomeEnabled(true);
//Specifies whether or not the Home button has the arrow used for Up Navigation next to it.
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ufirst_name", first_name.getText().toString());
        editor.putString("ulast_name", last_name.getText().toString());
        editor.putString("usex", sex.getSelectedItem().toString());
        editor.putString("udob", dob.getText().toString());
        editor.putString("uheight", height.getText().toString());
        editor.putString("uweight", weight.getText().toString());
        editor.commit();
        startActivity(intent);
    }
}