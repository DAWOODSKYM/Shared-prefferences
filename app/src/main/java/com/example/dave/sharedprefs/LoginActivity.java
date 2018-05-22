package com.example.dave.sharedprefs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText inputPin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputPin=findViewById(R.id.inputPin);
    }

    public void submit(View view) {
        String userPin=inputPin.getText().toString().trim();
        SharedPreferences pref=getSharedPreferences("pin",MODE_PRIVATE);
        String dbpin=pref.getString("pin","");
        if (userPin.equals(dbpin)){
            //login
            Intent x=new Intent(this,MainActivity.class);
            startActivity(x);
            finish();

        }else{
            Toast.makeText(this,"Wrong PIN",Toast.LENGTH_SHORT).show();
        }
    }
}
