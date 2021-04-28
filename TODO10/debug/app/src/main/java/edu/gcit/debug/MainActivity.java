package edu.gcit.debug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText mOperandOne;
    private EditText mOperandTwo;

    private TextView mResult;
    private calculator mCalculator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOperandOne=findViewById(R.id.O1);
        mOperandTwo=findViewById(R.id.O2);
        mResult=findViewById(R.id.final_view);
        mCalculator=new calculator();
    }

    public void add(View view){
        compute(calculator.Operators.ADD);

    }
    public void sub(View view){
        compute(calculator.Operators.SUB);

    }

    public void mul(View view){
        compute(calculator.Operators.MUL);

    }
    public void div(View view){
        compute(calculator.Operators.DIV);

    }
    private void compute(calculator.Operators operator) {
        Double operandOne;
        Double operandTwo;

        operandOne = Double.valueOf(mOperandOne.getText().toString());
        operandTwo = Double.valueOf(mOperandTwo.getText().toString());

//        mResult.setText(String.valueOf(mCalculator.add(operandOne,operandTwo)));
//        mResult.setText(String.valueOf(mCalculator.sub(operandOne,operandTwo)));
//        mResult.setText(String.valueOf(mCalculator.div(operandOne,operandTwo)));
//        mResult.setText(String.valueOf(mCalculator.mul(operandOne,operandTwo)));

        String result;
        switch (operator) {
            case ADD:
                result=String.valueOf(mCalculator.add(operandOne,operandTwo));
                break;
            case SUB:
                result=String.valueOf(mCalculator.sub(operandOne,operandTwo));
                break;
            case DIV:
                result=String.valueOf(mCalculator.div(operandOne,operandTwo));
                break;
            case MUL:
                result=String.valueOf(mCalculator.mul(operandOne,operandTwo));
                break;
            default:
                result = getString(R.string.computationError);
                break;
        }
        mResult.setText(result);


    }

}