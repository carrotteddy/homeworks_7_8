package com.example.homework_7;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer first, second, result;
    private boolean isOperationClick;

    private String operation;
    private MaterialButton openActivityBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        openActivityBtn  = findViewById(R.id.new_activity_btn);
    }

    public void OnNumberClick(View view) {
        openActivityBtn.setVisibility(View.GONE);
        if (view.getId() == R.id.btn_1) {
            numberClickerLogic(1);
        } else if (view.getId() == R.id.btn_3) {
            numberClickerLogic(3);
        } else if (view.getId() == R.id.btn_4) {
            numberClickerLogic(4);
        } else if (view.getId() == R.id.btn_5) {
            numberClickerLogic(5);
        } else if (view.getId() == R.id.btn_6) {
            numberClickerLogic(6);
        } else if (view.getId() == R.id.btn_7) {
            numberClickerLogic(7);
        } else if (view.getId() == R.id.btn_8) {
            numberClickerLogic(8);
        } else if (view.getId() == R.id.btn_9) {
            numberClickerLogic(9);
        } else if (view.getId() == R.id.btn_0) {
            numberClickerLogic(0);
        } else if (view.getId() == R.id.equal_btn) {
            second = Integer.valueOf(textView.getText().toString());
            performOperation();
            operation = null;
            openActivityBtn.setVisibility(View.VISIBLE);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        if (view.getId() == R.id.plus_btn) {
            operation = "+";
        } else if (view.getId() == R.id.minus_btn) {
            operation = "-";
        } else if (view.getId() == R.id.multiply_btn) {
            operation = "*";
        } else if (view.getId() == R.id.division_btn) {
            operation = "/";
        }
        first = Integer.valueOf(textView.getText().toString());
        isOperationClick = true;
        openActivityBtn.setVisibility(View.GONE);
    }

    public void numberClickerLogic(int value) {
        if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(String.valueOf(value));
        } else {
            textView.append(String.valueOf(value));
        }
    }

    private void performOperation() {
        if (first != null || second != null) {
            switch (operation) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
                case "/":
                    if (second != 0) {
                        result = first / second;
                    } else {
                        Toast.makeText(this, "Ошибка: Деление на ноль недопустимо.", Toast.LENGTH_SHORT).show();
                        textView.setText("0");
                        first = null;
                        second = null;
                        result = null;
                        return;
                    }
                    break;
                case "*":
                    result = first * second;
                    break;
            }
        }
        textView.setText(String.valueOf(result));
        first = null;
        second = null;
        result = null;
    }

    public void onClearClick(View view) {
        textView.setText("0");
        first = null;
        second = null;
        result = null;
        operation = null;
        isOperationClick = false;
    }

    public void openNewActivityCLick(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);

    }
}




