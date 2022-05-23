package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

enum AreaUnit {
    square_meter, square_Km, meter, centimeter
}

public class AreaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner fromspinner, ToSpinner;
    EditText UserInput;
    Button AreaConnvert;
    TextView TextViewoutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        setupviews();
        setupadapters();

    }

    private void setupadapters() {
    }

    private void setupviews() {

        fromspinner = findViewById(R.id.FromSpinner);
        ToSpinner = findViewById(R.id.ToSpinner);

        UserInput = findViewById(R.id.AreaHintnumber);
        TextViewoutput = findViewById(R.id.AreaOutput);

        List<String> areaList = new ArrayList<>();
        areaList.add("square Meter");
        areaList.add("square KiloMeter");
        areaList.add(" Meter");
        areaList.add("CentiMeter");
        ArrayAdapter<String> adp = new ArrayAdapter<>(AreaActivity.this, android.R.layout.simple_list_item_1, areaList);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromspinner.setAdapter(adp);

        fromspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fromspinner.setSelection(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<CharSequence> aradp = ArrayAdapter.createFromResource(this, R.array.AreaList, android.R.layout.simple_list_item_1);
        aradp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ToSpinner.setAdapter(aradp);

        ToSpinner.setOnItemSelectedListener(this);

        AreaConnvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fromString = (String) fromspinner.getSelectedItem();
                String Tostring = (String) ToSpinner.getSelectedItem();

                double Input = Double.parseDouble(UserInput.getText().toString());

                AreaUnit Fromunit = getUnit(fromString);
                AreaUnit ToUnit = getUnit(Tostring);

                double result = setvaluesforconversion(Input, Fromunit, ToUnit);
                TextViewoutput.setText(String.valueOf(result));
            }
        });
    }


    public static Double setvaluesforconversion(double Input, AreaUnit From, AreaUnit To) {

        switch (From) {
            case square_Km:
                if (To == AreaUnit.square_meter) {
                    return Input * (2.20);
                } else if (To == AreaUnit.square_Km) {
                    return Input / (2.20);
                }
                break;

            case square_meter:
                if (To == AreaUnit.square_Km) {
                    return Input * (3.20);
                } else if (To == AreaUnit.square_meter) {
                    return Input / (3.20);
                }
                break;
            default:
                throw new IllegalStateException("Unknow Value " + From);
        }
        return 0.0;

    }

    public  static AreaUnit getUnit(String Text){
            if (Text!=null){
                for (AreaUnit areaUnit: AreaUnit.values()){
                    if (Text.equalsIgnoreCase(areaUnit.toString())){
                        return  areaUnit;
                    }
                }

            }
            throw new IllegalArgumentException("Value Unknown" +Text);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice =adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}