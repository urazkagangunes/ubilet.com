package com.example.otobilet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BiletlerimGiris extends AppCompatActivity {

    EditText kimlikno;
    EditText adSoyad;
    Button btnListele;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biletlerim_giris);
        changeTitle();
        tanimla();
        btn();


    }
    public void tanimla(){
        kimlikno = (EditText) findViewById(R.id.kimliknoEditText);
        adSoyad = (EditText) findViewById(R.id.adSoyadEditText);
        btnListele = (Button) findViewById(R.id.btnListeleme);
    }

    public void btn(){
        btnListele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kimlikNo = kimlikno.getText().toString();
                Intent i = new Intent(BiletlerimGiris.this, BiletListele.class);
                i.putExtra("kimlikNo", kimlikNo);
                startActivity(i);
            }
        });
    }
    /*
    public void control(){
        DatabaseOperations db = new DatabaseOperations(getApplicationContext());
        Customer customer;
        customers = (ArrayList<Customer>) db.getCustomer(kimlikNo);
        for (int i = 0; i < customers.size(); i++) {
            String adSoyad = customers.get(i).getAdSoyad();
            System.out.println(adSoyad);
        }
    }

     */



    public void changeTitle() {
        BiletlerimGiris.this.setTitle("ubilet.com");
        ActionBar aBar;
        aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.RED);
        aBar.setBackgroundDrawable(cd);
    }
}