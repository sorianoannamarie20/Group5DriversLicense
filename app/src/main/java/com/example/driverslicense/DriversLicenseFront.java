package com.example.driverslicense;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DriversLicenseFront extends AppCompatActivity {
    private TextView LT;
    private TextView FN;
    private TextView LN;
    private TextView MN;
    private TextView SN;
    private TextView B;
    private TextView M;
    private TextView P;
    private TextView Ht;
    private TextView Wt;
    private TextView N;
    private TextView S;
    private TextView Bday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers_license_front);

        LT = findViewById(R.id.LT);
        FN = findViewById(R.id.FName);
        LN = findViewById(R.id.LName);
        MN = findViewById(R.id.MName);
        SN = findViewById(R.id.street);
        B = findViewById(R.id.barangay);
        M = findViewById(R.id.mun);
        P = findViewById(R.id.pro);
        Ht = findViewById(R.id.ht);
        Wt = findViewById(R.id.wt);
        N = findViewById(R.id.nat);
        S = findViewById(R.id.seks);
        Bday = findViewById(R.id.bday);


        Intent front = getIntent();
        String LType = front.getStringExtra("License");
        String FirstName = front.getStringExtra("FirstName");
        String LastName = front.getStringExtra("LastName");
        String MiddleName = front.getStringExtra("MiddleName");
        String StreetNumber = front.getStringExtra("StreetNumber");
        String Barangay = front.getStringExtra("Barangay");
        String Municipality = front.getStringExtra("Municipality");
        String Province = front.getStringExtra("Province");
        String Height = front.getStringExtra("Height");
        String Weight = front.getStringExtra("Weight");
        String Nationality = front.getStringExtra("Nationality");
        String Sex = front.getStringExtra("Sex");
        String Birthday = front.getStringExtra("Birthday");


        LT.setText(LType);
        FN.setText(FirstName);
        LN.setText(LastName);
        MN.setText(MiddleName);
        SN.setText(StreetNumber);
        B.setText(Barangay);
        M.setText(Municipality);
        P.setText(Province);
        Ht.setText(Height);
        Wt.setText(Weight);
        N.setText(Nationality);
        S.setText(Sex);
        Bday.setText(Birthday);

    }
}