package com.example.td01;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

@TargetApi(Build.VERSION_CODES.M)
public class Achat extends AppCompatActivity {

    public  String finalRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.achat);
        TextView tvRequest = (TextView) findViewById(R.id.tvRequest);
        //get login name from intent
        Bundle b = getIntent().getExtras();
        String request = null;
        if(b != null){
            request = b.getString("request");
        }

        finalRequest = "Voulez-vous acheter du " + request + " ?";
        tvRequest.setText(finalRequest);

    }
}