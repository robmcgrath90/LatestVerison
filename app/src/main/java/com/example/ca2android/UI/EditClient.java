package com.example.ca2android.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.ca2android.DB.DatabaseHandler;
import com.example.ca2android.Model.ClientModel;
import com.example.ca2android.R;

import java.util.ArrayList;
import java.util.List;

public class EditClient extends AppCompatActivity {


    List<ClientModel> clientModelList = new ArrayList<ClientModel>();
    Button btnUpdate;
    Button btnGoback;
    Button btnDelete;
    Switch sw_isclientactive;
    EditText et_ClientWeight;
    EditText et_ClientName;
    TextView tv_ClientIdNumber;
    ClientModel client;
    DatabaseHandler dbhandler;

    //id number of the person getting sent over
    int id;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_client);

        //video reference time 1:10:05 https://www.youtube.com/watch?v=FFCpjZkqfb0&list=PLDWXkSNB175IgeYcOWH0TC2LmtqUfAiuD&index=2&t=2685s
        btnDelete = findViewById(R.id.btnUpdate);
        btnGoback = findViewById(R.id.btn_Goback);
        btnUpdate = findViewById(R.id.btnUpdate);
        sw_isclientactive = findViewById(R.id.sw_ActiveClient);
        tv_ClientIdNumber = findViewById(R.id.tv_ClientIdNumber);
        et_ClientName = findViewById(R.id.et_ClientName);
        et_ClientWeight = findViewById(R.id.et_ClientWeight);

        //connet to database, populatelsit
        dbhandler = new DatabaseHandler(EditClient.this);
        clientModelList = dbhandler.getEveryone();



        //reference video time 1:19:33 https://www.youtube.com/watch?v=FFCpjZkqfb0&list=PLDWXkSNB175IgeYcOWH0TC2LmtqUfAiuD&index=2&t=2685s
        //getting the item that has been sent
        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);

        //reference 1:20:40 of video https://www.youtube.com/watch?v=FFCpjZkqfb0&list=PLDWXkSNB175IgeYcOWH0TC2LmtqUfAiuD&index=2&t=2685s
        if (id >= 0) {
            for(ClientModel C: clientModelList)
            {if (C.getId() == id){
                client = C;
            }

        }
            //reference 1:21:56 of video https://www.youtube.com/watch?v=FFCpjZkqfb0&list=PLDWXkSNB175IgeYcOWH0TC2LmtqUfAiuD&index=2&t=2685s
            et_ClientName.setText(client.getName());
            et_ClientWeight.setText(String.valueOf(client.getWeight()));
            sw_isclientactive.setChecked(client.isActive());
            tv_ClientIdNumber.setText(String.valueOf(client.getId()));



        //adding clicklisteners video time 24.24 https://www.youtube.com/watch?v=FFCpjZkqfb0&list=PLDWXkSNB175IgeYcOWH0TC2LmtqUfAiuD&index=2&t=2685s
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //brings the user back to the MainActivity
                Intent intent = new Intent( EditClient.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btnGoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //brings the user back to the MainActivity
                Intent intent = new Intent( EditClient.this, MainActivity.class);
                startActivity(intent);

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //brings the user back to the MainActivity
                Intent intent = new Intent( EditClient.this, MainActivity.class);
                startActivity(intent);

            }
        });




    }}}
