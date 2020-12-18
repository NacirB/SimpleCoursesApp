package com.example.td01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

@TargetApi(Build.VERSION_CODES.M)
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        TimePicker picker = (TimePicker) findViewById(R.id.timePicker1);
        picker.setIs24HourView(true);

        //button action

        Button btn1 = (Button) findViewById(R.id.btnAction);
        //get Login
        TextView tvLogin = (TextView) findViewById(R.id.txtLogin);


        btn1.setOnClickListener((v) ->{

            // get Time
            String hour = Integer.toString(picker.getHour());
            String minutes = Integer.toString(picker.getMinute());
            //Print results in text view
            TextView result = (TextView)findViewById(R.id.tvResult);
            String login = tvLogin.getText().toString();
            String res = login + " doit faire les courses à " + hour + ":" + minutes;
            result.setText(res);

        });

        //quit button
        Button btnQt = (Button) findViewById(R.id.btnQuitter);

        btnQt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                System.exit(0);
            }

        });

        // Courses Button
        Button btnCourses = (Button) findViewById(R.id.btnCourse);

        btnCourses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListeActivity.class);
                String login = tvLogin.getText().toString();
                Bundle b = new Bundle();
                b.putString("login",login);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }


}