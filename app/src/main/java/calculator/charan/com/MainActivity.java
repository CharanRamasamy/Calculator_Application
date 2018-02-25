package calculator.charan.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private String displayValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button AC = findViewById(R.id.buttonAC);
        Button Button0 = findViewById(R.id.button0);
        Button Button1 = findViewById(R.id.button1);
        Button Button2 = findViewById(R.id.button2);
        Button Button3 = findViewById(R.id.button3);

        Button Button4 = findViewById(R.id.button4);
        Button Button5 = findViewById(R.id.button5);
        Button Button6 = findViewById(R.id.button6);
        Button Button7 = findViewById(R.id.button7);
        Button Button8 = findViewById(R.id.button8);

        Button Button9 = findViewById(R.id.button9);
        Button ButtonC = findViewById(R.id.buttonC);
        Button ButtonRoot = findViewById(R.id.buttonRoot);
        Button ButtonPlus = findViewById(R.id.buttonPlus);
        Button ButtonMul = findViewById(R.id.buttonMul);

        Button ButtonPlusOrMinus = findViewById(R.id.buttonPlusOrMinus);
        Button ButtonMin = findViewById(R.id.buttonMin);
        Button ButtonEquals = findViewById(R.id.buttonEquals);
        Button ButtonDot = findViewById(R.id.buttonDot);
        Button ButtonDiv = findViewById(R.id.buttonDiv);

        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
}

    public void buttonNumberOperation(View view) {
        TextView textView1 = findViewById(R.id.textView1);
        switch(view.getId()){
            case R.id.button1:
                if(displayValue.length()<10) {
                    displayValue = displayValue + "1";
                    textView1.setText(displayValue);
                }
                break;

            case R.id.button2:
                if(displayValue.length()<10) {
                    displayValue = displayValue + "2";
                    textView1.setText(displayValue);
                }
                break;

            case R.id.button3:
                if(displayValue.length()<10) {
                    displayValue = displayValue + "3";
                    textView1.setText(displayValue);
                }
                    break;

            case R.id.button4:
                if(displayValue.length()<10) {
                    displayValue = displayValue + "4";
                    textView1.setText(displayValue);
                }
                break;

            case R.id.button5:
                if(displayValue.length()<10) {
                    displayValue = displayValue + "5";
                    textView1.setText(displayValue);
                }
                break;

            case R.id.button6:
                if(displayValue.length()<10) {
                    displayValue = displayValue + "6";
                    textView1.setText(displayValue);
                }
                break;

            case R.id.button7:
                if(displayValue.length()<10) {
                    displayValue = displayValue + "7";
                    textView1.setText(displayValue);
                }
                break;

            case R.id.button8:
                if(displayValue.length()<10) {
                    displayValue = displayValue + "8";
                    textView1.setText(displayValue);
                }
                break;

            case R.id.button9:
                if(displayValue.length()<10) {
                    displayValue = displayValue + "9";
                    textView1.setText(displayValue);
                }
                break;

            case R.id.button0:
                if(displayValue.length()<10 && !displayValue.equals("")) {
                    displayValue = displayValue + "0";
                    textView1.setText(displayValue);
                }
                break;


        }
    }


    public void buttonClearOperation(View view) {
        TextView textView1 = findViewById(R.id.textView1);
        switch (view.getId()) {
            case R.id.buttonC:
                if (displayValue.length() <= 10 && displayValue.length()>=1) {
                    displayValue = displayValue.substring(0,displayValue.length()-1);
                    textView1.setText(displayValue);
                }
                break;

            case R.id.buttonAC:
                displayValue = "";
                textView1.setText(R.string.Zero);
                break;
        }
    }

    public void buttonOperandOperation(View view){
        TextView textView1 = findViewById(R.id.textView1);
        switch (view.getId()) {
            case R.id.buttonDiv:
                if (displayValue.length() < 10 && !displayValue.endsWith("/") && !displayValue.endsWith("x") &&
                        !displayValue.endsWith("+") && !displayValue.endsWith("-") && !displayValue.endsWith(".") &&
                        displayValue.length()>0) {
                    displayValue = displayValue + "/";
                    textView1.setText(displayValue);
                }
                break;

            case R.id.buttonMul:
                if (displayValue.length() < 10 && !displayValue.endsWith("/") && !displayValue.endsWith("x") &&
                        !displayValue.endsWith("+") && !displayValue.endsWith("-") && !displayValue.endsWith(".") &&
                        displayValue.length()>0) {
                    displayValue = displayValue + "x";
                    textView1.setText(displayValue);
            }
            break;

            case R.id.buttonMin:
                if (displayValue.length() < 10 && !displayValue.endsWith("/") && !displayValue.endsWith("x") &&
                        !displayValue.endsWith("+") && !displayValue.endsWith("-") && !displayValue.endsWith(".") &&
                        displayValue.length()>0) {
                    displayValue = displayValue + "-";
                    textView1.setText(displayValue);
                }
                break;

            case R.id.buttonPlus:
                if (displayValue.length() < 10 && !displayValue.endsWith("/") && !displayValue.endsWith("x") &&
                        !displayValue.endsWith("+") && !displayValue.endsWith("-") && !displayValue.endsWith(".") &&
                        displayValue.length()>0) {
                    displayValue = displayValue + "+";
                    textView1.setText(displayValue);
                }
                break;

            case R.id.buttonDot:
                if (displayValue.length() < 10 && !displayValue.endsWith("/") && !displayValue.endsWith("x") &&
                        !displayValue.endsWith("+") && !displayValue.endsWith("-") && !displayValue.endsWith(".") &&
                        displayValue.length()>0) {
                    displayValue = displayValue + ".";
                    textView1.setText(displayValue);
                }
                break;
        }
    }

    public void buttonEqualsOperation(View view) {
        TextView textView1 = findViewById(R.id.textView1);
        double calculatedValue;
        if (view.getId() == R.id.buttonEquals) {

            if ( displayValue.equals("") || displayValue.charAt(displayValue.length() - 1) == 'x'
                    || displayValue.charAt(displayValue.length() - 1) == '/'
                    || displayValue.charAt(displayValue.length() - 1) == '-'
                    || displayValue.charAt(displayValue.length() - 1) == '+'
                    || displayValue.charAt(displayValue.length() - 1) == '.') {
                Toast.makeText(getApplicationContext(), "Invalid Operation", Toast.LENGTH_SHORT).show();
            }


            }
        }

    public static boolean precedenceOf(char Operator1,char Operator2){
        int Operator1_value = (Operator1=='+'||Operator1=='-')?1:2;
        int Operator2_value = (Operator2=='+'||Operator2=='-')?1:2;
        if(Operator1_value>=Operator2_value)
            return true;
        else
            return false;
    }


}
