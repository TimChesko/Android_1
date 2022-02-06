package com.example.android1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

//CTRL + ALT + O - удаление лишних import
//CTRL + ALT + L - форматировать
public class MainActivity extends AppCompatActivity {

    //numbers
    Button oneB = findViewById(R.id.one);
    Button twoB = findViewById(R.id.two);
    Button threeB = findViewById(R.id.three);
    Button fourB = findViewById(R.id.four);
    Button fiveB = findViewById(R.id.five);
    Button sixB = findViewById(R.id.six);
    Button sevenB = findViewById(R.id.seven);
    Button eightB = findViewById(R.id.eight);
    Button nineB = findViewById(R.id.nine);
    Button zeroB = findViewById(R.id.zero);
    //do
    Button procentB = findViewById(R.id.procent);
    Button divideB = findViewById(R.id.divide);
    Button multiplyB = findViewById(R.id.multiply);
    Button minusB = findViewById(R.id.minus);
    Button sumB = findViewById(R.id.sum);
    //del
    Button deleteB = findViewById(R.id.delete);
    Button celB = findViewById(R.id.cel);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListner();
    }

    public void initListner(){
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
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.one:
                    break;
                case R.id.two:
                    break;
                case R.id.three:
                    break;
                case R.id.four:
                    break;
                case R.id.five:
                    break;
                case R.id.six:
                    break;
                case R.id.seven:
                    break;
                case R.id.eight:
                    break;
                case R.id.nine:
                    break;
                case R.id.zero:
                    break;
                case R.id.procent:
                    break;
                case R.id.divide:
                    break;
                case R.id.multiply:
                    break;
                case R.id.minus:
                    break;
                case R.id.sum:
                    break;
                case R.id.cel:
                    break;
                case R.id.delete:
                    break;
            }
        }
    };
}