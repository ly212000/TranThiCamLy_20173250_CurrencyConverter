package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, OnClickListener {

    TextView txt1, txt2, txt3;
    TextView textInput, textOutput;
    Spinner spinner1, spinner2;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, dot, ce, bs;
    Double rate = 1.0, rate1 = 23435.0, rate2 = 23435.0;
    String unit1 = "Vietnam - Dong", unit2 = "Vietnam - Dong";

    String[] denomination = {"US - Dollar", "Vietnam - Dong", "Japan - Yen", "Thailand - Baht",
            "UK - Pound", "Brazil - Real", "China - Yuan"};
    Double[] value = {1.0, 23435.0, 108.46, 32.68, 0.8028, 5.1063, 7.032};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        textInput = txt1;
        textOutput = txt2;
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        b1 = findViewById(R.id.one);
        b2 = findViewById(R.id.two);
        b3 = findViewById(R.id.three);
        b4 = findViewById(R.id.four);
        b5 = findViewById(R.id.five);
        b6 = findViewById(R.id.six);
        b7 = findViewById(R.id.seven);
        b8 = findViewById(R.id.eight);
        b9 = findViewById(R.id.nine);
        b0 = findViewById(R.id.zero);
        dot = findViewById(R.id.dot);
        ce = findViewById(R.id.ce);
        bs = findViewById(R.id.bs);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        ce.setOnClickListener(this);
        bs.setOnClickListener(this);
        dot.setOnClickListener(this);
        txt1.setOnClickListener(this);
        txt2.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                denomination);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick (View view) {
        if (view.getId() == txt1.getId()) {
            textInput = txt1;
            textOutput = txt2;
        }
        if (view.getId() == txt2.getId()) {
            textInput = txt2;
            textOutput = txt1;
        }

        if (view.getId() == b1.getId()) textInput.setText(textInput.getText()+"1");
        if (view.getId() == b2.getId()) textInput.setText(textInput.getText()+"2");
        if (view.getId() == b3.getId()) textInput.setText(textInput.getText()+"3");
        if (view.getId() == b4.getId()) textInput.setText(textInput.getText()+"4");
        if (view.getId() == b5.getId()) textInput.setText(textInput.getText()+"5");
        if (view.getId() == b6.getId()) textInput.setText(textInput.getText()+"6");
        if (view.getId() == b7.getId()) textInput.setText(textInput.getText()+"7");
        if (view.getId() == b8.getId()) textInput.setText(textInput.getText()+"8");
        if (view.getId() == b9.getId()) textInput.setText(textInput.getText()+"9");
        if (view.getId() == b0.getId()) textInput.setText(textInput.getText()+"0");
        if (view.getId() == dot.getId()) textInput.setText(textInput.getText()+".");

        if(view.getId() == ce.getId()) {
            textInput.setText("0");
            textOutput.setText("0");
        }
        if (view.getId() == bs.getId())
            textInput.setText(textInput.getText().toString().substring(0,textInput.getText().toString().length()-1));

        if(textInput == txt1) rate = rate2/rate1;
        if (textInput == txt2) rate = rate1/rate2;
        String rateString = Double.toString(rate);
        txt3.setText("1 " + unit1 + " = " + rateString + " " + unit2);

        Double output = Double.parseDouble(textInput.getText().toString()) * rate;
        textOutput.setText(output.toString());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        if (parent.getId() == R.id.spinner1) {
               rate1 = value[position];
               unit1 = denomination[position];
            }

        if (parent.getId() == R.id.spinner2) {
                rate2 = value[position];
                unit2 = denomination[position];
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}
