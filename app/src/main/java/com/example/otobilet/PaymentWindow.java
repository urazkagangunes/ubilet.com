package com.example.otobilet;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PaymentWindow extends AppCompatActivity {

    private TextView bilgiAl, iletisimBilgileri, yolcuBilgileri, kartBilgileri, kartNumarasi, cartSdk, cvcInfo;
    private EditText emailAddress, personName, kimlikNumarasi,inputCardInfo, editTextDate, cvc, editTextPhone;
    private Button button3;
    private String tarih;
    private String nereden;
    private String nereye;
    private String otobus;

    private String name;
    private String kimlikno;
    private String bilet;
    private String koltukNo;
    private List<String> koltuklar = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_window);
        changeTitle();
        tanimla();
        onClickBtn();
        Bundle extras = getIntent().getExtras();
        tarih = extras.getString("tarih");
        nereden = extras.getString("nereden");
        nereye = extras.getString("nereye");
        otobus = extras.getString("otobus");
        koltuklar = extras.getStringArrayList("koltuklar");
        bilgiAl.setText(otobus + "\n" + tarih);
    }
    public void tanimla(){
        bilgiAl = (TextView) findViewById(R.id.bilgiAl);
        iletisimBilgileri = (TextView) findViewById(R.id.IletisimBilgileri);
        yolcuBilgileri = (TextView) findViewById(R.id.yolcuBilgileri);
        kartBilgileri = (TextView) findViewById(R.id.kartBilgileri);
        kartNumarasi = (TextView) findViewById(R.id.kartNumarasi);
        cartSdk = (TextView) findViewById(R.id.cardSkt);
        cvcInfo = (TextView) findViewById(R.id.cvcInfo);
        emailAddress = (EditText) findViewById(R.id.emailAddress);
        personName =(EditText) findViewById(R.id.personName);
        kimlikNumarasi = (EditText) findViewById(R.id.kimlikNumarasi);
        inputCardInfo = (EditText) findViewById(R.id.inputCardInfo);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        cvc = (EditText) findViewById(R.id.cvc);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        button3 = (Button) findViewById(R.id.button3);
    }
    public void onClickBtn(){
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PaymentWindow.this,paymentAndTicketInfo.class);
                veriTabaninaEkle();
                i.putExtra("tarih", tarih);
                i.putExtra("nereden", nereden);
                i.putExtra("nereye", nereye);
                i.putExtra("otobus", otobus);
                i.putExtra("name", name);
                startActivity(i);
            }
        });
    }

    public void veriTabaninaEkle() {
        name = personName.getText().toString();
        kimlikno = kimlikNumarasi.getText().toString();
        bilet = otobus;
        koltukNo = koltuklar.get(0);



        Customer customer = new Customer(name, kimlikno, bilet, koltukNo);
        DatabaseOperations db = new DatabaseOperations(getApplicationContext());
        db.add(customer);
    }

    public void changeTitle() {
        this.setTitle("ubilet.com");
        ActionBar aBar;
        aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.RED);
        aBar.setBackgroundDrawable(cd);
    }

    /*
    public void tcyial() {

        try {
            kimlikno = kimlikNumarasi.getText().toString();
            name = personName.getText().toString();
            SQLiteDatabase database = this.openOrCreateDatabase("ubilet.com", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS persons (id INTEGER PRIMARY KEY, name VARCHAR, tc VARCHAR)");

            String executable = "INSERT INTO persons (name, tc) VALUES ('" + name + "', '" + kimlikno + "')";
            System.out.println(executable);
            database.execSQL(executable);

            Cursor cursor = database.rawQuery("SELECT * FROM persons", null);
            int nameIx = cursor.getColumnIndex("name");
            int idIx = cursor.getColumnIndex("id");
            while(cursor.moveToNext()){
                System.out.println(cursor.getString(nameIx));
                System.out.println(cursor.getString(idIx));
            }
        } catch (Exception e) {

            System.out.println(e);
        }
    }*/



}