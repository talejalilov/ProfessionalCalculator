package com.example.proffesionalcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity {


    Button btnClear, btnBracketOpen, btnBracketClose, btnDivision, btnMultiply, btnMinus, btnPlus, btnEqual, btnPoint, btn0, btn1, btn2, btn3, btn4, btn5, btn6,
            btn7, btn8, btn9;
    TextView previousCalculation;
    EditText display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClear = findViewById(R.id.clear_text);
        btnBracketOpen = findViewById(R.id.btnBracketOpen);
        btnBracketClose = findViewById(R.id.btnBracketClose);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnEqual = findViewById(R.id.btnEqual);
        btnPoint = findViewById(R.id.btnPoint);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        display = findViewById(R.id.display);

        //Bu kod edit textdə basanda klaviaturanın gəlib - gəlməməsinin sorqusudur
        display.setShowSoftInputOnFocus(false);

    }

    public void updateText(String strToAdd) {

        String oldStr = display.getText().toString();

        int cursorPos = display.getSelectionStart();

        //Kursoru idarə etmək üçün yazılmış kod
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());

    }

    public void zeroBtn(View view) {
        updateText(getResources().getString(R.string.btn_zero));
    }

    public void oneBtn(View view) {
        updateText(getResources().getString(R.string.btn_one));
    }

    public void twoBtn(View view) {
        updateText(getResources().getString(R.string.btn_two));
    }

    public void threeBtn(View view) {
        updateText(getResources().getString(R.string.btn_three));
    }

    public void fourBtn(View view) {
        updateText(getResources().getString(R.string.btn_four));
    }

    public void fiveBtn(View view) {
        updateText(getResources().getString(R.string.btn_five));
    }

    public void sixBtn(View view) {
        updateText(getResources().getString(R.string.btn_six));
    }

    public void sevenBtn(View view) {
        updateText(getResources().getString(R.string.btn_seven));
    }

    public void eightBtn(View view) {
        updateText(getResources().getString(R.string.btn_eight));
    }

    public void nineBtn(View view) {
        updateText(getResources().getString(R.string.btn_nine));
    }

    public void bracketOpenBtn(View view) {
        updateText(getResources().getString(R.string.bracket_open));
    }

    public void bracketClose(View view) {
        updateText(getResources().getString(R.string.bracket_close));
    }

    public void divisionBtn(View view) {
        updateText(getResources().getString(R.string.btn_division));
    }

    public void addBtn(View view) {
        updateText(getResources().getString(R.string.btn_add));
    }

    public void minusBtn(View view) {
        updateText(getResources().getString(R.string.btn_subtract));
    }

    public void multiplyBtn(View view) {
        updateText(getResources().getString(R.string.btn_multiply));
    }

    public void pointBtn(View view) {
        updateText(getResources().getString(R.string.btn_point));
    }

    public void clearBtn(View view) {
        display.setText("");

    }

    public void btnEqual(View view) {


        String userExp = display.getText().toString();

        userExp = userExp.replaceAll(getResources().getString(R.string.btn_multiply), "*");
        userExp = userExp.replaceAll(getResources().getString(R.string.btn_division), "/");


        Expression expression = new Expression(userExp);
        String result = String.valueOf(expression.calculate());

        display.setText(result);
        display.setSelection(result.length());


    }

    public void backspace(View view) {

        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {

            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            //Burada tb- yazılan yerə nə yazılsa ondan əvvəlki yeri orada yazılan şeylə əvəz edir
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }

    }

}
