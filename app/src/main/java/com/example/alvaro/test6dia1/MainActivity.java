package com.example.alvaro.test6dia1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText exam;
    EditText practices;
    EditText attitude;
    Button calculate;
    TextView score;
    Float technicalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exam = findViewById(R.id.editText);
        practices = findViewById(R.id.editText2);
        attitude = findViewById(R.id.editText3);
        calculate = findViewById(R.id.button);
        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                score.setText(String.valueOf(getNota()));
            }
        });
        score = findViewById(R.id.textView);
    }

    private Float getNota() {
        return (technicalScore = Float.parseFloat(exam.getText().toString()) * 0.7f + Float.parseFloat(practices.getText().toString()) * 0.2f) > 5 ? technicalScore + Float.parseFloat(attitude.getText().toString()) * 0.1f : technicalScore;
    }
}
