package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    public Button calc;
    public TextView total_res;
    public TextView res;
    public EditText cent;
    public EditText kilo;
    public RadioGroup rg;
    public RadioButton rcent;
    public RadioButton rmet;
    public TextView tvheight;

    String cent_str;
    String kilo_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rmet = findViewById(R.id.meters);
        rcent = findViewById(R.id.centimeters);
        tvheight = findViewById(R.id.tvheight);
        rg =findViewById(R.id.rg);
        calc = findViewById(R.id.calc);
        total_res = findViewById(R.id.total_res);
        res = findViewById(R.id.res);
        cent = findViewById(R.id.cent);
        kilo = findViewById(R.id.kilo);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.centimeters:
                        cent.setHint("centimeters");
                        tvheight.setText("Height (cm)");
                        break;

                    case R.id.meters:
                        cent.setHint("meters");
                        tvheight.setText("Height (m)");
                        break;
                }
            }
        });


        calc.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                cent_str = cent.getText().toString();
                kilo_str = kilo.getText().toString();
                double c = Double.parseDouble(cent_str);
                double k = Double.parseDouble(kilo_str);
                if (rcent.isChecked()) {
                    double resul = (k / c / c) * 10000;
                    DecimalFormat df = new DecimalFormat("#.#");
                    String resu = df.format(resul);
                    total_res.setText(resu);
                    if (resul < 18.5) {
                        res.setText("Underweight");
                    } else if ((resul >= 18.5) && (resul < 25)) {
                        res.setText("Normal Weight");
                    } else if ((resul >= 25) && (resul < 30)) {
                        res.setText("Overweight");
                    } else {
                        res.setText("Obesity");
                    }
                }else if(rmet.isChecked()){
                    double resul = k/(c*c);
                    DecimalFormat df = new DecimalFormat("#.#");
                    String resu = df.format(resul);
                    total_res.setText(resu);
                    if (resul < 18.5) {
                        res.setText("Underweight");
                    } else if ((resul >= 18.5) && (resul < 25)) {
                        res.setText("Normal Weight");
                    } else if ((resul >= 25) && (resul < 30)) {
                        res.setText("Overweight");
                    } else {
                        res.setText("Obesity");
                    }
                }


            }

        });



    }
}

// [weight (kg) / height (cm) / height (cm)] x 10,000
//double myNum = 34.393893 DecimalFormat df = new DecimalFormat("#.##"); String twoDigitNum = df.format(myNum);