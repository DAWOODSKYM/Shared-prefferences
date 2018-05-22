package com.example.dave.sharedprefs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText inputpin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref=getSharedPreferences("pin",MODE_PRIVATE);
        boolean set= pref.getBoolean("set",false);
        if (set){
            Intent x=new Intent(this,LoginActivity.class);
            startActivity(x);
            finish();//this prevents going back to the login page when the back button is pressed(kills the page)
        }
        setContentView(R.layout.activity_register);
        inputpin=findViewById(R.id.inputPin);
    }


    public void setPin(View view) {
        String pin =inputpin.getText().toString().trim();
        if(pin.length()==4)
        {
            //save the pin that was set
            SharedPreferences.Editor editor=getSharedPreferences("pin",MODE_PRIVATE).edit();
            editor.putString("pin",pin);
            editor.putString("pin",pin);
            editor.putBoolean("set",true);
            editor.commit();
            //go to login page
            Intent x=new Intent(this, LoginActivity.class);
            startActivity(x);
            finish();//kill page
        }
        else
        {
            Toast.makeText(this,"Invalid PIN", Toast.LENGTH_SHORT).show();
        }
    }
}
