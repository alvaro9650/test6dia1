package com.example.alvaro.test6dia1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText exam;
    EditText practices;
    EditText attitude;
    Button calculate;
    TextView score;
    Float technicalScore;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        askScores();
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
        spinner = findViewById(R.id.spinner);
        SpinnerAdapter adapter = ArrayAdapter.createFromResource(this, R.array.courses, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
    }

    private void askScores() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.ask_scores);
        builder.setNeutralButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private Float getNota() {
        return (technicalScore = Float.parseFloat(exam.getText().toString()) * 0.7f + Float.parseFloat(practices.getText().toString()) * 0.2f) > 5 ? technicalScore + Float.parseFloat(attitude.getText().toString()) * 0.1f : technicalScore;
    }
}
