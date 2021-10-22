package com.example.midterm_catalina;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    double costToCatalina = 34.00;
    double costToLongBeach = 40.00;
    int numberOfTickets;
    double totalCost;
    String destination;


//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        outState.putString("numberOfTickets", numberOfTickets);
////        outState.putString("resultString", resultString);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//
//        if (savedInstanceState != null) {
//            numberOfTickets = savedInstanceState.getString("numberOfTickets","");
//
//            numberOfTickets.setText(numberOfTickets);
//            onCreate();
//        }
//    }



//    package com.example.tipcalculator;
//
//import android.os.Bundle;
//import android.view.KeyEvent;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.text.NumberFormat;
//
//    public class MainActivity extends AppCompatActivity
//            implements TextView.OnEditorActionListener, View.OnClickListener {
//
//        private String billAmountString = "";
//        private float tipPercent = .15f;
//
//        private EditText billAmountEditText;
//        private TextView percentTextView;
//        private Button percentUpButton;
//        private Button percentDownButton;
//        private TextView tipTextView;
//        private TextView totalTextView;
//
//
//
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//
//            billAmountEditText = findViewById(R.id.billAmountEditText);
//            percentTextView = findViewById(R.id.percentTextView);
//            percentUpButton = findViewById(R.id.percentUpButton);
//            percentDownButton = findViewById(R.id.percentDownButton);
//            tipTextView = findViewById(R.id.tipTextView);
//            totalTextView = findViewById(R.id.totalTextView);
//
//            billAmountEditText.setOnEditorActionListener(this);
//            percentDownButton.setOnClickListener(this);
//            percentUpButton.setOnClickListener(this);
//        }
//
//        @Override
//        protected void onSaveInstanceState(@NonNull Bundle outState) {
//            super.onSaveInstanceState(outState);
//
//            outState.putString("billAmountString", billAmountString);
//            outState.putFloat("tipPercent", tipPercent);
//        }
//
//        @Override
//        protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//            super.onRestoreInstanceState(savedInstanceState);
//
//            if (savedInstanceState != null) {
//                billAmountString = savedInstanceState.getString("billMountString","");
//                tipPercent = savedInstanceState.getFloat("tipPercent", 0.15f);
//
//                billAmountEditText.setText(billAmountString);
//                calculateAndDisplay();
//            }
//        }
//
//
//
//        public void calculateAndDisplay() {
//            //get the bill amount
//            billAmountString = billAmountEditText.getText().toString();
//            float billAmount;
//            if (billAmountString.equals("")){
//                billAmount = 0;
//            }
//            else {
//                billAmount = Float.parseFloat(billAmountString);
//            }
//
//            //calculate tip and total
//            float tipAmount = billAmount * tipPercent;
//            float totalAmount = billAmount + tipAmount;
//
//            NumberFormat currency = NumberFormat.getCurrencyInstance();
//            tipTextView.setText(currency.format(tipAmount));
//            totalTextView.setText(currency.format(totalAmount));
//
//            NumberFormat percent = NumberFormat.getPercentInstance();
//            percentTextView.setText(percent.format(tipPercent));
//        }
//
//
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.percentDownButton:
//                    tipPercent = tipPercent - 0.01f;
//                    calculateAndDisplay();
//                    break;
//                case R.id.percentUpButton:
//                    tipPercent = tipPercent + 0.01f;
//                    calculateAndDisplay();
//                    break;
//            }
//        }
//
//        @Override
//        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//            calculateAndDisplay();
//            return false;
//        }
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText tickets = findViewById(R.id.txtTickets);
        final Spinner group = findViewById(R.id.txtGroup);
        Button cost = findViewById(R.id.btnCalculate);


        cost.setOnClickListener(new View.OnClickListener() {

            final TextView result = (findViewById(R.id.txtResults));

            @Override
            public void onClick(View v) {
                numberOfTickets = Integer.parseInt(tickets.getText().toString());
                destination = group.getSelectedItem().toString();
                switch (destination) {
                    case "To Catalina Island":
                        totalCost = costToCatalina * numberOfTickets;
                        break;
                    case "To Long Beach":
                        totalCost = costToLongBeach * numberOfTickets;
                        break;

                }
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                result.setText("One Way Trip " + destination + "\n" + "for " + numberOfTickets + " passengers: " + currency.format(totalCost));

            }
        });
    }
}