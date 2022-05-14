package com.example.otobilet;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class BiletListele extends AppCompatActivity {
    String kimlikNo;
    ArrayList<Customer> customers = new ArrayList<Customer>();
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilet_listele);
        lv = findViewById(R.id.goruntele);
        changeTitle();
        Bundle extras = getIntent().getExtras();
        kimlikNo = extras.getString("kimlikNo");
        control();
    }

    public void control(){
        DatabaseOperations db = new DatabaseOperations(getApplicationContext());
        Customer customer;
        customers = (ArrayList<Customer>) db.getCustomer(kimlikNo);
        CustomerAdapter ca = new CustomerAdapter(this, customers);
        lv.setAdapter(ca);

        lv.setLongClickable(true);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), String.valueOf((int) l), Toast.LENGTH_LONG).show();

                AlertDialog.Builder ab = new AlertDialog.Builder(BiletListele.this);
                ab.setTitle("Seçim Yapınız");
                ab.setPositiveButton("Güncelle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DatabaseOperations db = new DatabaseOperations(getApplicationContext());
                        Intent intent = new Intent(BiletListele.this, MainActivity.class);
                        db.delete((int) l);
                        startActivity(intent);
                    }
                });
                ab.setNegativeButton("Sil", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.delete((int) l);
                        for (int j = 0; j<customers.size(); j++) {
                            if (customers.get(j).getId() == (int) l) {
                                customers.remove(j);
                                break;
                            }
                        }
                        startActivity(getIntent());
                    }
                });
                ab.setNeutralButton("İptal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                ab.show();
                return false;
            }
        });
    }
    public void changeTitle() {
        BiletListele.this.setTitle("ubilet.com");
        ActionBar aBar;
        aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.RED);
        aBar.setBackgroundDrawable(cd);
    }
}