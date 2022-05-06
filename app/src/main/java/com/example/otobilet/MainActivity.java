package com.example.otobilet;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int year, month, dayOfMonth;
    DatePickerDialog datePickerDialog;
    Calendar calendar;
    TextView selectDate;
    Button button;
    Spinner spinner1;
    Spinner spinner2;
   // TextView textView23;
    ArrayList<String> iller;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iller = new ArrayList<>();
        iller.add("İl seçiniz");

        changeTitle();
        tanimla();
        adaptorOlusturma();
        spinnerAdaptorEkle();
        sehirEkle();
        tarihSec();
        button();




    }

    public void sehirEkle(){
        SQLiteDatabase database = this.openOrCreateDatabase("ubilet.com", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS sehirler (id INTEGER PRIMARY KEY, name VARCHAR)");
        String executable ="INSERT INTO sehirler (name)" +
                "VALUES\n" +
                "('ADANA'),\n" +
                "('ADIYAMAN'),\n" +
                "('AFYON'),\n" +
                "('AĞRI'),\n" +
                "('AMASYA'),\n" +
                "('ANKARA'),\n" +
                "('ANTALYA'),\n" +
                "('ARTVİN'),\n" +
                "('AYDIN'),\n" +
                "('BALIKESİR'),\n" +
                "('BİLECİK'),\n" +
                "('BİNGÖL'),\n" +
                "('BİTLİS'),\n" +
                "('BOLU'),\n" +
                "('BURDUR'),\n" +
                "('BURSA'),\n" +
                "('ÇANAKKALE'),\n" +
                "('ÇANKIRI'),\n" +
                "('ÇORUM'),\n" +
                "('DENİZLİ'),\n" +
                "('DİYARBAKIR'),\n" +
                "('EDİRNE'),\n" +
                "('ELAZIĞ'),\n" +
                "('ERZİNCAN'),\n" +
                "('ERZURUM'),\n" +
                "('ESKİŞEHİR'),\n" +
                "('GAZİANTEP'),\n" +
                "('GİRESUN'),\n" +
                "('GÜMÜŞHANE'),\n" +
                "('HAKKARİ'),\n" +
                "('HATAY'),\n" +
                "('ISPARTA'),\n" +
                "('İÇEL'),\n" +
                "('İSTANBUL'),\n" +
                "('İZMİR'),\n" +
                "('KARS'),\n" +
                "('KASTAMONU'),\n" +
                "('KAYSERİ'),\n" +
                "('KIRKLARELİ'),\n" +
                "('KIRŞEHİR'),\n" +
                "('KOCAELİ'),\n" +
                "('KONYA'),\n" +
                "('KÜTAHYA'),\n" +
                "('MALATYA'),\n" +
                "('MANİSA'),\n" +
                "('KAHRAMANMARAŞ'),\n" +
                "('MARDİN'),\n" +
                "('MUĞLA'),\n" +
                "('MUŞ'),\n" +
                "('NEVŞEHİR'),\n" +
                "('NİĞDE'),\n" +
                "('ORDU'),\n" +
                "('RİZE'),\n" +
                "('SAKARYA'),\n" +
                "('SAMSUN'),\n" +
                "('SİİRT'),\n" +
                "('SİNOP'),\n" +
                "('SİVAS'),\n" +
                "('TEKİRDAĞ'),\n" +
                "('TOKAT'),\n" +
                "('TRABZON'),\n" +
                "('TUNCELİ'),\n" +
                "('ŞANLIURFA'),\n" +
                "('UŞAK'),\n" +
                "('VAN'),\n" +
                "('YOZGAT'),\n" +
                "('ZONGULDAK'),\n" +
                "('AKSARAY'),\n" +
                "('BAYBURT'),\n" +
                "('KARAMAN'),\n" +
                "('KIRIKKALE'),\n" +
                "('BATMAN'),\n" +
                "('ŞIRNAK'),\n" +
                "('BARTIN'),\n" +
                "('ARDAHAN'),\n" +
                "('IĞDIR'),\n" +
                "('YALOVA'),\n" +
                "('KARABÜK'),\n" +
                "('KİLİS'),\n" +
                "('OSMANİYE'),\n" +
                "('DÜZCE')";

        database.execSQL(executable);
        Cursor cursor = database.rawQuery("SELECT * FROM sehirler", null);
        int nameIx = cursor.getColumnIndex("name");
        while(cursor.moveToNext()){
            iller.add(cursor.getString(nameIx));
        }
        database.close();
    }

    public void tanimla(){
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        selectDate = (TextView) findViewById(R.id.selectDate);
        button = (Button) findViewById(R.id.button1);
      //  textView23 = (TextView) findViewById(R.id.textView23);

    }
    public void adaptorOlusturma(){
        arrayAdapter = new ArrayAdapter(this, android.support.constraint.R.layout.support_simple_spinner_dropdown_item, iller);
    }
    public void spinnerAdaptorEkle(){
        spinner1.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter);

    }
    public void tarihSec(){
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                selectDate.setText(day + "/" + (month+1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
    }
    public void button(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nereden = spinner1.getSelectedItem().toString();
                String nereye = spinner2.getSelectedItem().toString();
                Intent i = new Intent(MainActivity.this, OtobusListele.class);
                i.putExtra("tarih", selectDate.getText());
                i.putExtra("nereden", nereden);
                i.putExtra("nereye ", nereye);
                startActivity(i);
            }
        });
    }

    public void changeTitle() {
        MainActivity.this.setTitle("ubilet.com");
        ActionBar aBar;
        aBar = getSupportActionBar();
        ColorDrawable cd = new ColorDrawable(Color.RED);
        aBar.setBackgroundDrawable(cd);
    }


}