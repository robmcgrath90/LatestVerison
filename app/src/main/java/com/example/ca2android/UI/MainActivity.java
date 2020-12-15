package com.example.ca2android.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.ca2android.Model.ClientModel;
import com.example.ca2android.DB.DatabaseHandler;
import com.example.ca2android.R;
import com.example.ca2android.Adapaters.RecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //reference to all buttons and controls of layout
    Button btn_add, btn_View;
    EditText et_name, et_weight;
    Switch sw_ActiveClient;


    ArrayAdapter clientArrayAdapter;
    DatabaseHandler databaseHandler;

    //41.06 OF VIDEO REFERENCE https://www.youtube.com/watch?v=FFCpjZkqfb0&list=PLDWXkSNB175IgeYcOWH0TC2LmtqUfAiuD&index=3
    //Initialising Recycler View classes
    RecyclerView rvClients;
    RecyclerView.Adapter Adapter;
    RecyclerView.LayoutManager layoutManager;
    List<ClientModel> clientList = new ArrayList<ClientModel>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning values
        btn_add = findViewById(R.id.btnAdd);
        btn_View = findViewById(R.id.btnView);
        et_name = findViewById(R.id.et_name);
        et_weight = findViewById(R.id.etEnterWeight);
        sw_ActiveClient = findViewById(R.id.sw_ActiveClient);
        rvClients = findViewById(R.id.rvClients);



        databaseHandler = new DatabaseHandler(MainActivity.this);
        clientList = databaseHandler.getEveryone();

        //Code to display recycler view, adapted from https://www.youtube.com/watch?v=FFCpjZkqfb0
        //video time 42.10
        rvClients.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvClients.setLayoutManager(layoutManager);
        Adapter = new RecyclerAdapter(clientList,this);
        rvClients.setAdapter(Adapter);


        //reference 1.14 of video  https://www.youtube.com/watch?v=hDSVInZ2JCs&fbclid=IwAR2YB6VBte9Peo-XCJhihZV575MH8U5w2NfEOjRVx9I12Ktj90HhFLQC_h4
        //ShowClientsOnListView(databaseHandler);

        //button listeners for the add and view buttons
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //try catch, try line 43 code and if it works show the toast
                //before adding the try catch the app would crash if the weight was left blank
                ClientModel clientModel;

                try {
                    clientModel = new ClientModel(-1, et_name.getText().toString(),Integer.parseInt(et_weight.getText().toString()),sw_ActiveClient.isChecked());
                   // Toast.makeText(MainActivity.this, clientModel.toString(), Toast.LENGTH_SHORT).show();

                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error creating client", Toast.LENGTH_SHORT).show();
                    clientModel = new ClientModel(-1, "error", 0, false);
                }

                //reference https://www.youtube.com/watch?v=hDSVInZ2JCs&fbclid=IwAR2YB6VBte9Peo-XCJhihZV575MH8U5w2NfEOjRVx9I12Ktj90HhFLQC_h4
                boolean success = databaseHandler.addOne(clientModel);
                Toast.makeText(MainActivity.this, "Client Added" + success, Toast.LENGTH_SHORT).show();

                //reference video 46.47 https://www.youtube.com/watch?v=hDSVInZ2JCs&fbclid=IwAR2YB6VBte9Peo-XCJhihZV575MH8U5w2NfEOjRVx9I12Ktj90HhFLQC_h4
                //makes a reference to the database
                DatabaseHandler databaseHandler = new DatabaseHandler(MainActivity.this);

                //Code to display recycler view, adapted from https://www.youtube.com/watch?v=FFCpjZkqfb0
                //reuse of same code to update the recyclerview after a client is entered
                clientList = databaseHandler.getEveryone();
                rvClients.setHasFixedSize(true);
                layoutManager = new LinearLayoutManager(MainActivity.this);
                rvClients.setLayoutManager(layoutManager);
                Adapter = new RecyclerAdapter(clientList, MainActivity.this);
                rvClients.setAdapter(Adapter);









            }
        });

      //  btn_View.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View v) {
                //REFERENCE TO db
              //  DatabaseHandler databaseHandler = new DatabaseHandler(MainActivity.this);

                //call on method to update clientList
               // ShowClientsOnListView(databaseHandler);

              //  Toast.makeText(MainActivity.this, everyone.toString(), Toast.LENGTH_SHORT).show();



          //  }
       // });

        //item click listener will give you a number on which one was clicked (not the same as on click listener)
        //reference 1:22:57 in video https://www.youtube.com/watch?v=hDSVInZ2JCs&fbclid=IwAR2YB6VBte9Peo-XCJhihZV575MH8U5w2NfEOjRVx9I12Ktj90HhFLQC_h4
       // lv_ClientList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          //  @Override
           // public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           //     ClientModel clickedClient = (ClientModel) parent.getItemAtPosition(position);
            //    databaseHandler.deleteOne(clickedClient);
             //   ShowClientsOnListView(databaseHandler);
              //  Toast.makeText(MainActivity.this, "Deleted" + clickedClient.toString(), Toast.LENGTH_SHORT).show();

          //  }
     //   });

 //   }



   // private void ShowClientsOnListView(DatabaseHandler databaseHandler2) {
      //  clientArrayAdapter = new ArrayAdapter<ClientModel>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHandler2.getEveryone());
      //  lv_ClientList.setAdapter(clientArrayAdapter);
   // }


}}