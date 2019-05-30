package com.pangchavez.calculators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StandardCalculatorActivity extends AppCompatActivity {

    StandardCalculator calculator;
    TextView TxtCurrentNumber, TxtOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_calculator);
        calculator = new StandardCalculator();

        TxtCurrentNumber = findViewById(R.id.TxtCurrent);
        TxtOperation = findViewById(R.id.TxtOperation);

    }

    public void BtnNumberClick(View view)
    {
        Button btn = (Button)view;

        calculator.setCurrentNumber(btn.getText().toString());
        TxtCurrentNumber.setText(calculator.getCurrentNumber());
    }

    public void BtnOperatorClick(View view)
    {
        Button btn = (Button)view;

        calculator.calculate(btn.getText().toString());
        TxtOperation.setText(calculator.getOperationSequence());
        TxtCurrentNumber.setText(calculator.getCurrentNumber());
    }

    public void BtnSpecialOperatorClick(View view) {
        Button btn = (Button)view;
        String specialOperator = btn.getText().toString();

        switch (specialOperator)
        {
            case "+/-":
                calculator.addSign();
                TxtCurrentNumber.setText(calculator.getCurrentNumber());
                break;
            case "C":
                calculator.clearOperation();
                calculator.clearCurrentNumber();
                TxtOperation.setText(calculator.getOperationSequence());
                TxtCurrentNumber.setText(calculator.getCurrentNumber());
                break;
            case "CE":
                calculator.clearCurrentNumber();
                TxtOperation.setText(calculator.getOperationSequence());
                TxtCurrentNumber.setText(calculator.getCurrentNumber());
                break;
            case ".":
                calculator.addDecimalPoint();
                TxtCurrentNumber.setText(calculator.getCurrentNumber());
                break;
            case "DEL":
                calculator.deleteLastDigit();
                TxtCurrentNumber.setText(calculator.getCurrentNumber());
                break;
        }
    }
}
