package com.example.android1;

import static com.example.android1.SettingsActivity.KEY_CURRENT_THEME;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

//CTRL + ALT + O - удаление лишних import
//CTRL + ALT + L - форматировать
public class MainActivity extends AppCompatActivity {

    //numbers
    Button oneB;
    Button twoB;
    Button threeB;
    Button fourB;
    Button fiveB;
    Button sixB;
    Button sevenB;
    Button eightB;
    Button nineB;
    Button zeroB;
    //do
    Button procentB;
    Button divideB;
    Button multiplyB;
    Button minusB;
    Button sumB;
    Button equal;
    Button dote;
    //delete
    Button deleteB;
    Button celB;
    //editText - окно ввода
    EditText editText;
    String saveText = "";
    Double num1 = 0.0;
    String make = "";
    Button settings;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        i = new Intent(MainActivity.this, SettingsActivity.class);
        int value = i.getIntExtra("KEY_THEME",0);
        Log.d("myLogs",value + " - значение getIntExtra");
        setContentView(R.layout.activity_main);
        initView();
        typeFace();
        initListner();
        setContent();
    }


    private void typeFace() {
        Typeface tf = Typeface.createFromAsset(getAssets(), "Source_Sans_Pro/SourceSansPro-Black.ttf");
        editText.setTypeface(tf);
    }

    private void initListner() {
        oneB.setOnClickListener(listener);
        twoB.setOnClickListener(listener);
        threeB.setOnClickListener(listener);
        fourB.setOnClickListener(listener);
        fiveB.setOnClickListener(listener);
        sixB.setOnClickListener(listener);
        sevenB.setOnClickListener(listener);
        eightB.setOnClickListener(listener);
        nineB.setOnClickListener(listener);
        zeroB.setOnClickListener(listener);
        procentB.setOnClickListener(listener);
        divideB.setOnClickListener(listener);
        multiplyB.setOnClickListener(listener);
        minusB.setOnClickListener(listener);
        sumB.setOnClickListener(listener);
        deleteB.setOnClickListener(listener);
        celB.setOnClickListener(listener);
        equal.setOnClickListener(listener);
        dote.setOnClickListener(listener);
        settings.setOnClickListener(listener);
    }

    private void initView() {
        oneB = findViewById(R.id.one);
        twoB = findViewById(R.id.two);
        threeB = findViewById(R.id.three);
        fourB = findViewById(R.id.four);
        fiveB = findViewById(R.id.five);
        sixB = findViewById(R.id.six);
        sevenB = findViewById(R.id.seven);
        eightB = findViewById(R.id.eight);
        nineB = findViewById(R.id.nine);
        zeroB = findViewById(R.id.zero);
        procentB = findViewById(R.id.procent);
        divideB = findViewById(R.id.divide);
        multiplyB = findViewById(R.id.multiply);
        minusB = findViewById(R.id.minus);
        sumB = findViewById(R.id.sum);
        deleteB = findViewById(R.id.delete);
        celB = findViewById(R.id.cel);
        editText = findViewById(R.id.editText);
        equal = findViewById(R.id.equal);
        dote = findViewById(R.id.dote);
        settings = findViewById(R.id.settingsButton);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.one:
                    saveText = saveText + "1";
                    editText.setText(saveText);
                    break;
                case R.id.two:
                    saveText = saveText + "2";
                    editText.setText(saveText);
                    break;
                case R.id.three:
                    saveText = saveText + "3";
                    editText.setText(saveText);
                    break;
                case R.id.four:
                    saveText = saveText + "4";
                    editText.setText(saveText);
                    break;
                case R.id.five:
                    saveText = saveText + "5";
                    editText.setText(saveText);
                    break;
                case R.id.six:
                    saveText = saveText + "6";
                    editText.setText(saveText);
                    break;
                case R.id.seven:
                    saveText = saveText + "7";
                    editText.setText(saveText);
                    break;
                case R.id.eight:
                    saveText = saveText + "8";
                    editText.setText(saveText);
                    break;
                case R.id.nine:
                    saveText = saveText + "9";
                    editText.setText(saveText);
                    break;
                case R.id.zero:
                    saveText = saveText + "0";
                    editText.setText(saveText);
                    break;
                case R.id.procent:
                    num1 = Double.valueOf(saveText);
                    make = "%";
                    editText.setText(compile(Double.valueOf(saveText), num1, make));
                    break;
                case R.id.divide:
                    num1 = Double.valueOf(saveText);
                    make = "/";
                    saveText = "";
                    editText.setText("");
                    editText.setHint(R.string.divideText);
                    break;
                case R.id.multiply:
                    num1 = Double.valueOf(saveText);
                    make = "*";
                    saveText = "";
                    editText.setText("");
                    editText.setHint(R.string.multiplyText);
                    break;
                case R.id.minus:
                    num1 = Double.valueOf(saveText);
                    make = "-";
                    saveText = "";
                    editText.setText("");
                    editText.setHint(R.string.minusText);
                    break;
                case R.id.sum:
                    num1 = Double.valueOf(saveText);
                    make = "+";
                    saveText = "";
                    editText.setText("");
                    editText.setHint(R.string.plusText);
                    break;
                case R.id.cel:
                    make = "";
                    saveText = "";
                    editText.setText(R.string.setFirstNum);
                    break;
                case R.id.equal:
                    String res = compile(Double.valueOf(saveText), num1, make);
                    saveText = res;
                    editText.setText(res);
                    break;
                case R.id.delete:
                    saveText = editText.getText().toString();
                    try {
                        saveText = saveText.substring(0, saveText.length() - 1);
                        editText.setText(saveText);
                    } catch (Exception ex) {
                    }
                    break;
                case R.id.dote:
                    saveText = saveText + ".";
                    editText.setText(saveText);
                    break;
                case R.id.settingsButton:
                    startActivity(i);
                    break;
            }
        }

        private String compile(Double valueOf, Double num1, String make) {
            double res = 0;
            switch (make) {
                case "+":
                    res = valueOf + num1;
                    break;
                case "-":
                    res = num1 - valueOf;
                    break;
                case "*":
                    res = num1 * valueOf;
                    break;
                case "/":
                    res = num1 / valueOf;
                    break;
                case "%":
                    res = num1 / 100;
            }
            return String.valueOf(res);
        }
    };

    @Override
    //запомнили
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("saveText", saveText);
        outState.putString("make", make);
        outState.putDouble("num1", num1);
    }

    @Override
    //восстановили
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        saveText = savedInstanceState.getString("saveText");
        make = savedInstanceState.getString("make");
        num1 = savedInstanceState.getDouble("num1");
        setContent();
    }

    private void setContent() {
        editText.setText(saveText);
    }
}