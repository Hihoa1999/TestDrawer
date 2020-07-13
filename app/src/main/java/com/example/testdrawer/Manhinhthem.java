package com.example.testdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Manhinhthem extends AppCompatActivity {
    DatabaseHelper db;
    EditText ed1,ed2,ed3;
    Button b1,b2;
    RadioButton ra1,ra2;
    CheckBox ck1,ck2,ck3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhthem);
        Anhxa();
    }
    private void Anhxa()
    {
        db=new DatabaseHelper(this);
        ed1=(EditText)findViewById(R.id.editName);
        ed2=(EditText)findViewById(R.id.editBirt);
        ed3=(EditText)findViewById(R.id.editSchool);
        ra1=(RadioButton)findViewById(R.id.radMale);
        ra2=(RadioButton)findViewById(R.id.radFeMale);
        ck1=(CheckBox)findViewById(R.id.cbSport);
        ck2=(CheckBox)findViewById(R.id.cbTravel);
        ck3=(CheckBox)findViewById(R.id.cbReedBook);
        b1=(Button)findViewById(R.id.btReset);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetView();
            }
        });
        b2=(Button)findViewById(R.id.btOK);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveStudent();
            }
        });
    }
    private void resetView()
    {
        ed1.setText("");
        ed2.setText("");
        ed3.setText("");
        ra1.setChecked(true);
        ck1.setChecked(false);
        ck2.setChecked(false);
        ck3.setChecked(false);
    }
    private void saveStudent() {
        String name = ed1.getText().toString();
        String birth = ed2.getText().toString();
        String school = ed3.getText().toString();
        int sex = 0;
        if (ra1.isChecked()) sex = 1;
        String favorite = "";
        if (ck1.isChecked()) {
            favorite += "," + ck1.getText().toString();
        }
        if (ck2.isChecked()) {
            favorite += "," + ck2.getText().toString();
        }
        if (ck3.isChecked()) {
            favorite += "," + ck3.getText().toString();
        }


            Boolean insertsv = db.insertsv(name, birth, school, sex, favorite);
            if (insertsv == true) {
                Toast.makeText(getApplicationContext(), "Addmember Successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Addmember Already exists", Toast.LENGTH_SHORT).show();
            }

    }
}