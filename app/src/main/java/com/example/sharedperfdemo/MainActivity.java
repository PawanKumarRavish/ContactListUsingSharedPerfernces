package com.example.sharedperfdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    private SharedPreferences sharedPreferences;
    EditText name,email,phone;
    Button btn;
    TextView tvResult;
    private static final String CONTACT ="contact";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.extName);
        phone=findViewById(R.id.extPhoneNo);
        email=findViewById(R.id.extEmail);
        btn=findViewById(R.id.btnSave);
        tvResult=findViewById(R.id.tvResult);


        // 1st step -construct
//        sharedPreferences=getSharedPreferences("cName",MODE_PRIVATE);
//        sharedPreferences=getSharedPreferences("cEmail",MODE_PRIVATE);
//        sharedPreferences=getSharedPreferences("cPhoneNo",MODE_PRIVATE);
        sharedPreferences=getSharedPreferences(CONTACT,MODE_PRIVATE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contacts contact =new Contacts(name.getText().toString(),email.getText().toString(),phone.getText().toString());


                try {
                    sharedPreferences.edit().putString(CONTACT,ObjectSerializer.serialize(contact)).apply();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                getSavedData();
            }
        });

        // 2nd step tp write in my shared perferences
     //   sharedPreferences.edit().putString("key_user_name","Pawan Kumar")
       //         .apply();




        // 3rd step is to read from shared perfernces
       // String name=sharedPreferences.getString("key_user_name","N.A");
        //Log.d(TAG,"onCreate"+name);
      //  ArrayList names =new ArrayList(Arrays.asList("Ammrit","daniel","Deepan","pawan","deva","febin"));
       // sharedPreferences.edit().putStringSet("user_name",new HashSet<>(names)).apply();
        //read
       // Set<String>nameList=sharedPreferences.getStringSet("user_name",new HashSet<>());
        //Log.d(TAG,"onCrewate"+nameList.toString());
//        sharedPreferences.edit().putString("cName","Pawan Kumar")
//               .apply();
//        sharedPreferences.edit().putString("cEmail","ravishpk76@gmail.com")
//                .apply();
//        sharedPreferences.edit().putString("cPhoneNo","1234567890")
//                .apply();
//
//        String cName=sharedPreferences.getString("cName","N/A");








    }

    private void getSavedData() {
        String cInfo=sharedPreferences.getString(CONTACT,"N/A");
        try {
            Contacts contact=(Contacts)ObjectSerializer.deserialize(cInfo);
            tvResult.setText(contact.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

}