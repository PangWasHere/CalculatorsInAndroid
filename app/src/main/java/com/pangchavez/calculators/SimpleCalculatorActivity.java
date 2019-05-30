package com.pangchavez.calculators;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SimpleCalculatorActivity extends AppCompatActivity {

    Button AddBtn, SubBtn, MulBtn, DivBtn;
    TextView NumOne, NumTwo, Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);

        AddBtn = findViewById(R.id.AddBtn);
        SubBtn = findViewById(R.id.SubtractBtn);
        MulBtn = findViewById(R.id.MultiplyBtn);
        DivBtn = findViewById(R.id.DivideBtn);

        NumOne = findViewById(R.id.NumberOne);
        NumTwo = findViewById(R.id.NumberTwo);
        Result = findViewById(R.id.TVResult);

        AddBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Result.setText(String.valueOf(Calculate("Add")));
            }
        });
        SubBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Result.setText(String.valueOf(Calculate("Subtract")));
            }
        });
        MulBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Result.setText(String.valueOf(Calculate("Multiply")));
            }
        });
        DivBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Result.setText(String.valueOf(Calculate("Divide")));
            }
        });
    }

    private int Calculate(String operation)
    {
        int result = 0;
        int numOne = Integer.parseInt(NumOne.getText().toString());
        int numTwo = Integer.parseInt(NumTwo.getText().toString());

        switch (operation)
        {
            case "Add":
                result = numOne + numTwo;
                break;
            case "Subtract":
                result = numOne - numTwo;
                break;
            case "Multiply":
                result = numOne * numTwo;
                break;
            case "Divide":
                result = numOne / numTwo;
                break;
        }

        return result;
    }
}
