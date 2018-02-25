package calculator.charan.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private String displayValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
    }

    //Any Button with the number on it will listen to this method then clicked
    public void buttonNumberOperation(View view) {
        TextView textView1 = findViewById(R.id.textView1);
        switch(view.getId()){
            case R.id.button1:
                //The Length of the display value is restricted to 10 Characters as per requirement
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
    //This Listener will listen to Clear and All Clear button
    public void buttonClearOperation(View view) {
        TextView textView1 = findViewById(R.id.textView1);
        switch (view.getId()) {
            case R.id.buttonC:
                //Clear button clears the last character
                if (displayValue.length() <= 10 && displayValue.length()>=1) {
                    displayValue = displayValue.substring(0,displayValue.length()-1);
                    textView1.setText(displayValue);
                }
                break;
            //All Clear button resets the values entered before
            case R.id.buttonAC:
                displayValue = "";
                textView1.setText(R.string.Zero);
                break;
        }
    }

    //The Division,Multiplication,Addition and Subtractions operaation listens to this listener
    public void buttonOperandOperation(View view){
        TextView textView1 = findViewById(R.id.textView1);
        switch (view.getId()) {
            case R.id.buttonDiv:
                //The Validations are done in such a way that no two operands can repeat consequently
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
                //Validation for Dot Characters which should not follow the Operation Symbols
                if (displayValue.length() < 10 && !displayValue.endsWith("/") && !displayValue.endsWith("x") &&
                        !displayValue.endsWith("+") && !displayValue.endsWith("-") && !displayValue.endsWith(".") &&
                        displayValue.length()>0) {
                    displayValue = displayValue + ".";
                    textView1.setText(displayValue);
                }
                break;
        }
    }

    //Square root operations
    public void buttonRootOperation(View view){
        TextView textView1 = findViewById(R.id.textView1);
        if(view.getId() == R.id.buttonRoot){
            if(displayValue.indexOf('+') >= 0 || displayValue.indexOf('-') >= 0 || displayValue.indexOf('x') >= 0
                    || displayValue.indexOf('/')>=0) {
                Toast.makeText(getApplicationContext(), "Invalid Operation", Toast.LENGTH_SHORT).show();
            }
            else{
                Double value = Double.parseDouble(displayValue);
                Double sqrt = Math.sqrt(value);
                displayValue = sqrt.toString();

                if(displayValue.contains("."))
                {
                    if(displayValue.matches("(.)*.0"))
                    {
                        displayValue = displayValue.substring(0,displayValue.indexOf('.'));
                    }
                }
                textView1.setText(displayValue);
            }
        }
    }

    //This Listener is invoked when the Equal button is clicked
    //This is where the calculation happens according to precedence
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
            else {
                //Shunting-Yard algorithm is the concept used here for the calculation to be done with the precedence operators
                StringBuilder numbersBuilder = new StringBuilder();
                StringBuilder symbolsBuilder = new StringBuilder();

                Stack stack = new Stack();
                Queue<Object> queue = new LinkedList<Object>();

                ArrayList arrayList = new ArrayList();

                for (int i = 0; i < displayValue.length(); i++) {
                    char ch = displayValue.charAt(i);
                    if (Character.isDigit(ch) || ch == '.') {
                        numbersBuilder.append(ch);

                    } else {
                        //Operators are moved to the stack
                        if (stack.isEmpty()) {
                            symbolsBuilder.append(ch);
                            stack.push(ch);
                            //Operands are moved to the Queue
                            queue.add(Double.parseDouble(numbersBuilder.toString()));
                            numbersBuilder.setLength(0);
                        } else {
                            symbolsBuilder.append(ch);
                            char Operand_In_Stack = (char) stack.pop();
                            //Operators leaves the stack to the queue by comparing with the last in operator in the stack
                            if (precedenceOf(Operand_In_Stack, ch)) {
                                queue.add(Double.parseDouble(numbersBuilder.toString()));
                                numbersBuilder.setLength(0);
                                queue.add(Operand_In_Stack);
                            } else {
                                queue.add(Double.parseDouble(numbersBuilder.toString()));
                                numbersBuilder.setLength(0);
                                stack.push(Operand_In_Stack);
                            }
                            stack.push(ch);
                        }

                        symbolsBuilder.setLength(0);
                    }
                }
                queue.add(Double.parseDouble(numbersBuilder.toString()));
                while (!stack.isEmpty()) {
                    queue.add(stack.pop());
                }
                System.out.println(stack);
                System.out.println(queue);

                //Shunting-Yard Algorithm Final Step
                for (Object value : queue) {
                    arrayList.add(value.toString());
                }

                //Iterate ArrayList and perform final Calculations
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i).toString().charAt(0) == '/') {
                        Double input1 = Double.parseDouble(arrayList.get(i - 2).toString());
                        Double input2 = Double.parseDouble(arrayList.get(i - 1).toString());
                        Double output = input1 / input2;
                        arrayList.set(i, output);
                    } else if (arrayList.get(i).toString().charAt(0) == 'x') {
                        Double input1 = Double.parseDouble(arrayList.get(i - 2).toString());
                        Double input2 = Double.parseDouble(arrayList.get(i - 1).toString());
                        Double output = input1 * input2;
                        arrayList.set(i, output);
                    } else if (arrayList.get(i).toString().charAt(0) == '+') {
                        Double input1 = Double.parseDouble(arrayList.get(i - 2).toString());
                        Double input2 = Double.parseDouble(arrayList.get(i - 1).toString());
                        Double output = input1 + input2;
                        arrayList.set(i, output);
                    } else if (arrayList.get(i).toString().charAt(0) == '-') {
                        Double input1 = Double.parseDouble(arrayList.get(i - 2).toString());
                        Double input2 = Double.parseDouble(arrayList.get(i - 1).toString());
                        Double output = input1 - input2;
                        arrayList.set(i, output);
                    }
                }
                displayValue = arrayList.get(arrayList.size() - 1).toString();
                if(displayValue.contains("."))
                {
                    if(displayValue.matches("(.)*.0"))
                    {
                        displayValue = displayValue.substring(0,displayValue.indexOf('.'));
                    }
                }
                textView1.setText(displayValue);
            }
        }
    }

    //This is the precedence Operation used by the Algorithm in the previous steps
    public static boolean precedenceOf(char Operator1,char Operator2){
        int Operator1_value = (Operator1=='+'||Operator1=='-')?1:2;
        int Operator2_value = (Operator2=='+'||Operator2=='-')?1:2;
        if(Operator1_value>=Operator2_value)
            return true;
        else
            return false;
    }


}

