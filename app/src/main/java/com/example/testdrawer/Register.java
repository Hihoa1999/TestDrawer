package com.example.testdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Toolbar toolbar;
    DatabaseHelper db;
    EditText e1,e2,e3;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Anh xa
        db=new DatabaseHelper(this);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.pass);
        e3=(EditText)findViewById(R.id.cpass);
        b2=(Button)findViewById(R.id.login);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Register.this,MainActivity.class);
                startActivity(i);
            }
        });
        //Lay du lieu tu o textbox
        b1=(Button)findViewById(R.id.register);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                //Truy van o text box co trong khong
                if(s1.equals("") ||s2.equals("") || s3.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else
                //Kiem tra co trong database khong
                {
                    if(s2.equals(s3))
                    {
                        Boolean chkemail=db.chkemail(s1);
                        if(chkemail==true)
                        {
                            Boolean insert=db.insert(s1,s2);
                            if(insert==true)
                            {
                                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Email Already exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.add,menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.them)
        {
            Toast.makeText(this, "Ban da nhan vao thoat", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.thoat)
        {
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Thong bao");
            alert.setMessage("Ban thuc su muon thoat");
            alert.setIcon(R.mipmap.ic_launcher);
            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    onBackPressed();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }
}