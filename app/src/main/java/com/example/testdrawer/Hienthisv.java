package com.example.testdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Hienthisv extends AppCompatActivity {
    DatabaseHelper db;
    Button bt1;
    Toolbar toolbar;
    ListView listView;
    ArrayList<itemsv> arrayList;
    addsv adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hienthisv);
        Anhxa();
        acctionsv();
        actionBar();

    }
    private void Anhxa()
    {

        listView=(ListView) findViewById(R.id.listview);
        bt1=(Button)findViewById(R.id.quaylai);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Hienthisv.this,MainActivity.class);
                startActivity(i);
                Toast.makeText(Hienthisv.this, "Quay lai", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void acctionsv()
    {
        arrayList=new ArrayList<>();
        arrayList.add(new itemsv("Hoa","20","Phan Boi Chau","Nam","The thao"));
        arrayList.add(new itemsv("Ngoc","20","Phan Boi Chau","Nam","The thao"));
        arrayList.add(new itemsv("Chi","20","Phan Boi Chau","Nam","The thao"));
        arrayList.add(new itemsv("Chi","20","Phan Boi Chau","Nam","The thao"));
        arrayList.add(new itemsv("Chi","20","Phan Boi Chau","Nam","The thao"));
        adapter= new addsv(this,R.layout.dong_sv,arrayList);
        listView.setAdapter(adapter);
    }
    private void actionBar()
    {
        setSupportActionBar(toolbar);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.add,menu);
        return true;
    }


}