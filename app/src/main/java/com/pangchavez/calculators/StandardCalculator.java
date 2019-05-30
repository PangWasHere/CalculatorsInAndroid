package com.pangchavez.calculators;

// TODO: Fix continuous operation when equal is pressed

public class StandardCalculator {

    double result;
    double currentNumber;
    String strCurrentNumber;
    String strOperation;
    boolean operatorClicked;
    boolean decimalClicked;
    String recentOperator;
    String currentOperator;

    public StandardCalculator()
    {
        // TODO: Make a reset function
        strOperation = "";
        result = 0;
        currentNumber = 0;
        strCurrentNumber = "0";
        recentOperator = "=";
        currentOperator = "=";
        decimalClicked = false; // Prevents the number to contain multiple decimal points
        operatorClicked = false; // Prevents the operation to be repeated;
    }

    public String getResult()
    {
        String resultString;

        // Check if result has no decimal point
        // If it has return the result as double
        // Else return its integer value
        if ((result == Math.floor(result)) && !Double.isInfinite(result)) {
            // Is an integer
            int integerResult = (int)Math.floor(result);
            resultString = String.valueOf(integerResult);
        } else {
            resultString = String.valueOf(result);
        }

        return resultString;
    }

    public String getCurrentNumber()
    {
        return strCurrentNumber;
    }

    public String getOperationSequence()
    {
        return strOperation;
    }

    public void deleteLastDigit()
    {
        if(strCurrentNumber != null && strCurrentNumber.length() > 0 && !strCurrentNumber.equals("0"))
        {
            strCurrentNumber = strCurrentNumber.substring(0, strCurrentNumber.length() - 1);
        }

        if(strCurrentNumber.isEmpty())
        {
            strCurrentNumber = "0";
        }
    }

    public void clearOperation()
    {
        strOperation = "";
        result = 0;
        currentNumber = 0;
        strCurrentNumber = "0";
        recentOperator = "=";
        currentOperator = "=";
        decimalClicked = false; // Prevents the number to contain multiple decimal points
        operatorClicked = false; // Prevents the operation to be repeated
    }

    public void clearCurrentNumber()
    {
        strCurrentNumber = "0";
        currentNumber = 0;
        decimalClicked = false; // Prevents the number to contain multiple decimal points
        operatorClicked = false; // Prevents the operation to be repeated
    }

    // When a number is clicked
    void setCurrentNumber(String newNumber)
    {
        if(operatorClicked)
        {
            strCurrentNumber = "";
            operatorClicked = false;
        }

        if(strCurrentNumber == "0")
        {
            strCurrentNumber = "";
        }

        strCurrentNumber += newNumber;

    }

    void addDecimalPoint()
    {
        if(decimalClicked)
        {
            // Do nothing
        } else
        {
            strCurrentNumber += ".";
        }

        decimalClicked = true;
    }

    void addSign()
    {
        currentNumber = Double.parseDouble(strCurrentNumber);
        currentNumber = -currentNumber;

        if ((currentNumber == Math.floor(currentNumber)) && !Double.isInfinite(currentNumber)) {
            // Is an integer
            int integerResult = (int)Math.floor(currentNumber);
            strCurrentNumber = String.valueOf(integerResult);
        } else {
            strCurrentNumber = String.valueOf(currentNumber);
        }

    }

    // When a operator is clicked
    void calculate(String operator)
    {
        currentNumber = Double.parseDouble(strCurrentNumber);
        // For hanging decimal points to be formatted properly.
        if(decimalClicked)
            strCurrentNumber = String.valueOf(currentNumber);

        if(operatorClicked)
        {
            // Operator has been clicked. Do nothing.
        } else {
            operatorClicked = true;
            decimalClicked = false;
            recentOperator = currentOperator;
            currentOperator = operator;

            evaluateOperation(operator);

            strCurrentNumber = getResult();
        }
    }

    void evaluateOperation(String operator)
    {
        if(operator.contains("="))
        {
            evaluateOperation(recentOperator);
            strOperation = "";
        } else {
            switch(recentOperator)
            {
                case "+":
                    result += currentNumber;
                    break;
                case "-":
                    result -= currentNumber;
                    break;
                case "x":
                    result *= currentNumber;
                    break;
                case "/":
                    if(currentNumber != 0)
                        result /= currentNumber;
                    else
                        strCurrentNumber = "Cannot divide by zero";
                    break;
                case "=":
                    result = currentNumber;
                    break;
            }
            strOperation += strCurrentNumber + " " + operator + " ";
        }
    }

}
