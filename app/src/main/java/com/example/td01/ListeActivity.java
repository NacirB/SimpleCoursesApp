package com.example.td01;

import android.annotation.TargetApi;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

@TargetApi(Build.VERSION_CODES.M)
public class ListeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_liste);

        TextView tvLogin = (TextView) findViewById(R.id.tvLogin);
        //get login name from intent
        Bundle b = getIntent().getExtras();
        String login = null;
        if(b != null){
            login = b.getString("login");

        }
        //System.out.println(login);
        tvLogin.setText(login);
        FetchData process = new FetchData();
        process.execute(this);


        //list view
        ListView lvCourses = (ListView) findViewById(R.id.lvCourses);
        /*
        List<String> courses = new ArrayList<String>();

        courses.add("Du fromage");
        courses.add("Du pain");
        courses.add("Du coca");
        courses.add("Du beurre");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                courses );

        lvCourses.setAdapter(arrayAdapter);
        */
        // make the items of the list view clickable
        lvCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent intent = new Intent(ListeActivity.this, Achat.class);

                String request = (String) arg0.getItemAtPosition(position);
                Bundle b = new Bundle();
                b.putString("request",request);
                intent.putExtras(b);
                startActivity(intent);

            }
        });


    }


}