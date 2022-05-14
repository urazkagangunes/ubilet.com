package com.example.otobilet;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.database.sqlite.SQLiteDatabase;

public class Create {
    public static void main(String[] args) {
        SQLiteDatabase mydatabase = openOrCreateDatabase("ubilet.com", null);
    }
}
