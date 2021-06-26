//Group 5 BSIT 2 - Block 1 (C072/C073)
// Leader : Soriano, Anna Marie D.
// Members : Pascual, Richmind
//           Beato, Maverick
//           Yares, Dennise

package com.example.driverslicense;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "Main Activity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private EditText FirstName;
    private EditText LastName;
    private EditText MiddleName;
    private EditText StreetNumber;
    private EditText Brgy;
    private EditText Municipality;
    private EditText Province;
    private EditText Height;
    private EditText Weight;
    private EditText Nationality;
    private Button Submit;

    static String LiType, BirthDate, Radiobutton;

    android.widget.RadioGroup RadioGroup;
    android.widget.RadioButton RadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar b = getSupportActionBar();
        b.hide();

        FirstName = findViewById(R.id.FirstName);
        LastName= findViewById(R.id.LastName);
        MiddleName = findViewById(R.id.MiddleName);
        StreetNumber = findViewById(R.id.StreetNumber);
        Brgy = findViewById(R.id.Brgy);
        Municipality = findViewById(R.id.Municipality);
        Province = findViewById(R.id.Province);
        Height = findViewById(R.id.Height);
        Weight = findViewById(R.id.Weight);
        Nationality = findViewById(R.id.Nationality);
        Submit = findViewById(R.id.FormSubmit);


        RadioGroup = findViewById(R.id.RadioGroup);
        RadioGroup.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.RadioGroup group, int checkedId) {

                RadioButton = (android.widget.RadioButton) findViewById(checkedId);
                Radiobutton = RadioButton.getText().toString();
            }
        });

        Spinner LicenseType = findViewById(R.id.Spinner);
        ArrayAdapter<CharSequence> Adapter = ArrayAdapter.createFromResource(this, R.array.LicenseType, android.R.layout.simple_spinner_item);
        Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LicenseType.setAdapter(Adapter);
        LicenseType.setOnItemSelectedListener(this);

        mDisplayDate = (TextView) findViewById(R.id.Date);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar len = Calendar.getInstance();
                int year = len.get(Calendar.YEAR);
                int month = len.get(Calendar.MONTH);
                int day = len.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {

                month = month + 1;

                Log.d(TAG, "onDateSet, mm/dd/yyy: "+month+"/"+day+"/"+year);
                String date = month + "/" + day + "/"+year;
                mDisplayDate.setText(date);
                BirthDate = date;


            }
        };

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Lype = LiType.toString();
                String FName = FirstName.getText().toString();
                String MName = MiddleName.getText().toString();
                String LNames = LastName.getText().toString();
                String SNumber = StreetNumber.getText().toString();
                String Bry = Brgy.getText().toString();
                String Mun = Municipality.getText().toString();
                String Prov = Province.getText().toString();
                String Ht = Height.getText().toString();
                String Wt = Weight.getText().toString();
                String Nation = Nationality.getText().toString();
                String Sks = Radiobutton;
                String Bday = BirthDate;


                if (Lype.isEmpty() || FName.isEmpty() || MName.isEmpty() || LNames.isEmpty() ||
                        SNumber.isEmpty() || Bry.isEmpty() || Mun.isEmpty() || Prov.isEmpty() || Ht.isEmpty() ||
                        Wt.isEmpty() || Nation.isEmpty() || Sks.isEmpty() || Bday.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Kindly Fill up the Form", Toast.LENGTH_LONG).show();
                } else {
                    Intent LicenseIntent = new Intent(MainActivity.this, DriversLicenseFront.class);
                    LicenseIntent.putExtra("License", LiType);
                    LicenseIntent.putExtra("FirstName", FName);
                    LicenseIntent.putExtra("LastName", LNames);
                    LicenseIntent.putExtra("MiddleName", MName);
                    LicenseIntent.putExtra("StreetNumber", SNumber);
                    LicenseIntent.putExtra("Barangay", Bry);
                    LicenseIntent.putExtra("Municipality", Mun);
                    LicenseIntent.putExtra("Province", Prov);
                    LicenseIntent.putExtra("Height", Ht);
                    LicenseIntent.putExtra("Weight", Wt);
                    LicenseIntent.putExtra("Nationality", Nation);
                    LicenseIntent.putExtra("Sex", Sks);
                    LicenseIntent.putExtra("Birthday", Bday);



                } if (FName.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter First Name", Toast.LENGTH_SHORT).show();
                    FirstName.setError("Field Can't be Empty");
                    View get = findViewById(R.id.FirstName);
                    get.getParent().requestChildFocus(get, get);

                } else if (LNames.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please Enter Last Name", Toast.LENGTH_SHORT).show();
                    LastName.setError("Field Can't be Empty");
                    View get1 = findViewById(R.id.LastName);
                    get1.getParent().requestChildFocus(get1, get1);

                } else if (MName.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter Middle Name", Toast.LENGTH_SHORT).show();
                    MiddleName.setError("Field Can't be Empty");
                    View get2 = findViewById(R.id.MiddleName);
                    get2.getParent().requestChildFocus(get2, get2);

                } else if (SNumber.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Street Number & Name", Toast.LENGTH_SHORT).show();
                    View get3 = findViewById(R.id.StreetNumber);
                    get3.getParent().requestChildFocus(get3, get3);
                    StreetNumber.setError("Field Can't be Empty");

                } else if (Bry.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please Enter Barangay", Toast.LENGTH_SHORT).show();
                    View get4 = findViewById(R.id.Brgy);
                    get4.getParent().requestChildFocus(get4, get4);
                    Brgy.setError("Field Can't be Empty");

                } else if (Mun.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please Enter Municipality", Toast.LENGTH_SHORT).show();
                    View get5 = findViewById(R.id.Municipality);
                    get5.getParent().requestChildFocus(get5, get5);
                    Municipality.setError("Field Can't be Empty");

                } else if (Prov.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please Enter Province", Toast.LENGTH_SHORT).show();
                    View get6 = findViewById(R.id.Province);
                    get6.getParent().requestChildFocus(get6, get6);
                    Province.setError("Field Can't be Empty");

                } else if (Ht.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please Enter your Height", Toast.LENGTH_SHORT).show();
                    View get7 = findViewById(R.id.Height);
                    get7.getParent().requestChildFocus(get7, get7);
                    Height.setError("Field Can't be Empty");

                } else if (Wt.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please Enter your Weight", Toast.LENGTH_SHORT).show();
                    View get8 = findViewById(R.id.Weight);
                    get8.getParent().requestChildFocus(get8, get8);
                    Weight.setError("Field Can't be Empty");

                } else if (Nation.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please Enter your Nationality", Toast.LENGTH_SHORT).show();
                    View get9 = findViewById(R.id.Nationality);
                    get9.getParent().requestChildFocus(get9, get9);
                    Nationality.setError("Field Can't be Empty");



                } else if (Bday.isEmpty()) {

                    Toast.makeText(getApplicationContext(), "Please Enter your Birth Date", Toast.LENGTH_SHORT).show();
                    View get10 = findViewById(R.id.Date);
                    get10.getParent().requestChildFocus(get10, get10);


                } else if (RadioGroup.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Please Choose what Sex you are", Toast.LENGTH_SHORT).show();
                    View get11 = findViewById(R.id.RadioGroup);
                    get11.getParent().requestChildFocus(get11, get11);

                } else {


                    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(MainActivity.this);

                    builder.setTitle("Form Submission");
                    builder.setMessage("Do you want to see or display your Driver's License?");

                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (LiType.equals("Please Select Type. . .")) {


                                Toast.makeText(getApplicationContext(), "Please Select License Type", Toast.LENGTH_LONG).show();
                                View targetview = findViewById(R.id.LicenseType);
                                targetview.getParent().requestChildFocus(targetview, targetview);


                            } else {
                                Intent LicenseIntent = new Intent(MainActivity.this, DriversLicenseFront.class);
                                LicenseIntent.putExtra("License", LiType);
                                LicenseIntent.putExtra("FirstName", FName);
                                LicenseIntent.putExtra("LastName", LNames);
                                LicenseIntent.putExtra("MiddleName", MName);
                                LicenseIntent.putExtra("StreetNumber", SNumber);
                                LicenseIntent.putExtra("Barangay", Bry);
                                LicenseIntent.putExtra("Municipality", Mun);
                                LicenseIntent.putExtra("Province", Prov);
                                LicenseIntent.putExtra("Height", Ht);
                                LicenseIntent.putExtra("Weight", Wt);
                                LicenseIntent.putExtra("Nationality", Nation);
                                LicenseIntent.putExtra("Sex", Sks);
                                LicenseIntent.putExtra("Birthday", Bday);
                                startActivity(LicenseIntent);
                                finish();
                            }

                        }

                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                        }
                    });

                    builder.show();
                }
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        LiType = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
