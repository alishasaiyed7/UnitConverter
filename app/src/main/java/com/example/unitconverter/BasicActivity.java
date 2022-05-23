package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BasicActivity extends AppCompatActivity {
    CardView cardarea, cardlength, cardtime, cardmass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        setUpViews();
        setUpListener();
    }

    private void setUpViews() {
        cardarea=findViewById(R.id.cardArea);
        cardlength=findViewById(R.id.cardLength);
        cardmass=findViewById(R.id.cardMass);
        cardtime=findViewById(R.id.cardTime);
    }

    private void setUpListener() {
        cardarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(BasicActivity.this, AreaActivity.class);
                startActivity(it);

            }
        });
        cardlength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        cardtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        cardmass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}