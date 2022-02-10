package com.example.employeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EmployeeActivity extends AppCompatActivity {
  EditText ed1,ed2,ed3,ed4;
  AppCompatButton b1;
  String getempcode,getname,getdeignation,getmobno;
  DbHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        ed1=(EditText)findViewById(R.id.empcode);
        ed2=(EditText)findViewById(R.id.name);
        ed3=(EditText)findViewById(R.id.design);
        ed4=(EditText)findViewById(R.id.mob);
        b1=(AppCompatButton)findViewById(R.id.subbtn);
        mydb=new DbHelper(this);
        mydb.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getempcode= ed1.getText().toString();
                getname=ed2.getText().toString();
                getdeignation=ed3.getText().toString();
                getmobno=ed4.getText().toString();
                boolean  status=mydb.insertEmployee(getempcode,getname,getdeignation,getmobno);
                if(status==true)
                {
                    Toast.makeText(getApplicationContext(), "successfully inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }




            }
        });




    }
}