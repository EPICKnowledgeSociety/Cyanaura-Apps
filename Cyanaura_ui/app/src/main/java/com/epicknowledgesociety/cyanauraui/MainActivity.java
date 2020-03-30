package com.epicknowledgesociety.cyanauraui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CheckBox isInfected;
    Spinner spinner1;
    Button symptomdate,confirmdate,statusdate,submit1;
    String symptomdatestr,confirmdatestr,statusdatestr,infsourcestr,inforiginstr,unamestr,udistrictstr,umuncipalitystr,uagestr,unationalitystr,uresidentstr,ucaddressstr,upaddressstr,ugenderstr;

    EditText uname,udistrict,umuncipality,uage,unationality,uresident,ucaddress,upaddress,infsource,inforigin;
    androidx.constraintlayout.widget.ConstraintLayout l1;
    int y=2020;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isInfected=(CheckBox)findViewById(R.id.isinfected);

        infsource=(EditText)findViewById(R.id.uinfectionsource);
        inforigin=(EditText)findViewById(R.id.uinfectionorigin);
        uname=(EditText)findViewById(R.id.uname);
        udistrict=(EditText)findViewById(R.id.udistrict);
        umuncipality=(EditText)findViewById(R.id.umuncipality);
        uage=(EditText)findViewById(R.id.uage);
        unationality=(EditText)findViewById(R.id.unationality);
        uresident=(EditText)findViewById(R.id.uresidentstate);
        ucaddress=(EditText)findViewById(R.id.ucurrentaddress);
        upaddress=(EditText)findViewById(R.id.upermanentaddress);


        unamestr=uname.getText().toString();
        udistrictstr=udistrict.getText().toString();
        umuncipalitystr=umuncipality.getText().toString();
        uagestr=uage.getText().toString();
        unationalitystr=unationality.getText().toString();
        uresidentstr=uresident.getText().toString();
        ucaddressstr=ucaddress.getText().toString();
        upaddressstr=upaddress.getText().toString();
        infsourcestr=infsource.getText().toString();
        inforiginstr=inforigin.getText().toString();

        symptomdate=(Button)findViewById(R.id.usymptomdate);
        confirmdate=(Button)findViewById(R.id.uconfirmdate);
        statusdate=(Button)findViewById(R.id.ustatusdate);

        submit1=(Button)findViewById(R.id.submit1);
        l1=( androidx.constraintlayout.widget.ConstraintLayout)findViewById(R.id.cl1);

        spinner1=(Spinner)findViewById(R.id.ugender);


        isInfected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(l1.getVisibility()==View.GONE) {
                    l1.setVisibility(View.VISIBLE);
                }
                else{
                   l1.setVisibility(View.GONE);
                }

   // infsourcestr=infsource.getText().toString();
    //inforiginstr=inforigin.getText().toString();


            }


        });

        symptomdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog d1=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        symptomdatestr=dayOfMonth+"/"+month+"/"+year;



                    }
                },y,0,0);
                d1.show();

            }
        });
        confirmdate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog d2=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        confirmdatestr=dayOfMonth+"/"+month+"/"+year;

                    }
                },y,0,0);
                d2.show();

            }
        });
        statusdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog d3=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        statusdatestr=dayOfMonth+"/"+month+"/"+year;
                    }
                },y,0,0);
                d3.show();

            }
        });




        List<String> categories = new ArrayList<String>();
        categories.add("Male");
        categories.add("Female");
        categories.add("Other");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner1.setAdapter(dataAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ugenderstr=String.valueOf(spinner1.getSelectedItem());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

}
