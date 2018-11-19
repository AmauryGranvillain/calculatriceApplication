package com.example.formation3.firstappandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button buttonDigit9,buttonDigit8,buttonDigit7,
            buttonDigit6,buttonDigit5,buttonDigit4,buttonDigit3,
            buttonDigit2,buttonDigit1,buttonDigit0,buttonDigitAdd,
            buttonDigitEqual,buttonDigitDot,buttonDigitSub,buttonDigitMult,buttonDigitDivision, buttonDigitInfo;
    private TextView textView;
    private String operator;
    private Float previousValue;
    private final String result_key = "keybundle";

    private View.OnClickListener digitListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addDigitValue(v);
        }
    };
    private View.OnClickListener goActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,InfoActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener operatorListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chooseOperator(v);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView = findViewById(R.id.text_shownumber);

        if(savedInstanceState != null){
            String bundle = savedInstanceState.getString(result_key);
            textView.setText(bundle);
        }


        this.buttonDigit0 = findViewById(R.id.button_digit0);
        this.buttonDigit1 = findViewById(R.id.button_digit1);
        this.buttonDigit2 = findViewById(R.id.button_digit2);
        this.buttonDigit3 = findViewById(R.id.button_digit3);
        this.buttonDigit4 = findViewById(R.id.button_digit4);
        this.buttonDigit5 = findViewById(R.id.button_digit5);
        this.buttonDigit6 = findViewById(R.id.button_digit6);
        this.buttonDigit7 = findViewById(R.id.button_digit7);
        this.buttonDigit8 = findViewById(R.id.button_digit8);
        this.buttonDigit9 = findViewById(R.id.button_digit9);
        this.buttonDigitDot = findViewById(R.id.button_digitdot);
        this.buttonDigitAdd = findViewById(R.id.button_digitadd);
        this.buttonDigitSub = findViewById(R.id.button_digitsub);
        this.buttonDigitDivision = findViewById(R.id.button_digitdivision);
        this.buttonDigitMult = findViewById(R.id.button_digitmult);
        this.buttonDigitEqual = findViewById(R.id.button_digitequal);
        this.buttonDigitInfo = findViewById(R.id.button_digitinfo);

        buttonDigit0.setOnClickListener(digitListener);
        buttonDigit1.setOnClickListener(digitListener);
        buttonDigit2.setOnClickListener(digitListener);
        buttonDigit3.setOnClickListener(digitListener);
        buttonDigit4.setOnClickListener(digitListener);
        buttonDigit5.setOnClickListener(digitListener);
        buttonDigit6.setOnClickListener(digitListener);
        buttonDigit7.setOnClickListener(digitListener);
        buttonDigit8.setOnClickListener(digitListener);
        buttonDigit9.setOnClickListener(digitListener);
        buttonDigitAdd.setOnClickListener(operatorListener);
        buttonDigitSub.setOnClickListener(operatorListener);
        buttonDigitDivision.setOnClickListener(operatorListener);
        buttonDigitMult.setOnClickListener(operatorListener);

        buttonDigitInfo.setOnClickListener(goActivity);

    }

    /**
     * method when the user click on button with a number
     */

    public void addDigitValue (View v){

        Button tappedButton = (Button) v;

        if (textView.getText().equals("0")) {

            textView.setText(tappedButton.getText().toString());

        } else {

            textView.setText(textView.getText() + tappedButton.getText().toString());

        }

    }

    /**
     * method when the user choices an operator
     */

    public void chooseOperator (View v){

        Button storageNumber = (Button) v;

        if (operator != null) {
            calculate();
        }

        operator = storageNumber.getText().toString();
        previousValue = Float.parseFloat(textView.getText().toString());

        textView.setText("0");
        Log.d("Storage", previousValue.toString());
    }

    /**
     * method when user click on equal
     */

    public void calculResult (View v){
        if(previousValue != null){
            calculate();
        } else {
            textView.setText("0");
        }
    }

    /**
     * method for calculate the result and screen it on textView
     */

    private void calculate() {
        Float result;

        switch (operator) {
            case "+":
                result = previousValue + Float.parseFloat(textView.getText().toString());
                break;
            case "-":
                result = previousValue - Float.parseFloat(textView.getText().toString());
                break;
            case "*":
                result = previousValue * Float.parseFloat(textView.getText().toString());
                break;
            case "/":
                result = previousValue / Float.parseFloat(textView.getText().toString());
                break;
            default :
                result = previousValue;
        }

        textView.setText(result.toString());
        operator = null;
        previousValue = null;
    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(result_key,textView.getText().toString());
    }

}
