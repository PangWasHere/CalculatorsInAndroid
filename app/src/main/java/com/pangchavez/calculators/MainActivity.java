package com.pangchavez.calculators;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnCalculatorClick(View view)
    {
        Button btn = (Button)view;
        Intent calculatorIntent;
        Class calculatorClass = null;

        switch (btn.getText().toString())
        {
            case "Simple Calculator":
                calculatorClass = SimpleCalculatorActivity.class;
                break;
            case "Standard Calculator":
                calculatorClass = StandardCalculatorActivity.class;
                break;
            case "Tip Calculator":
                calculatorClass = TipCalculatorActivity.class;
                break;
        }

        calculatorIntent = new Intent(this, calculatorClass);
        startActivity(calculatorIntent);
    }
}
