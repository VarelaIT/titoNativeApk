package com.varelait.titonativeapk;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.varelait.titonativeapk.logic.Measures;

public class MainActivity extends AppCompatActivity {

    public Measures measures;
    public float panel;
    public float height;
    public float base;
    public Button calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        calcBtn = (Button)findViewById(R.id.calculateBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    void calculate () {
        getBaseInput();
        getHeightInput();
        getPanelInput();
        TextView baseOutput = (TextView)findViewById(R.id.baseOutput);

        if (base > 10 && height > 10 && panel > 1) {
           measures = new Measures(base, height, panel);
           baseOutput.setText((CharSequence)measures.getGlassBase().toString());
        } else
            notifyError();
    }

    void notifyError () {
    }

    void getPanelInput () {
        EditText inputView = (EditText) findViewById(R.id.baseInput);
        this.panel = parseInt(inputView.getText().toString());
    }

    void getHeightInput () {
        EditText inputView = (EditText) findViewById(R.id.baseInput);
        this.height = parseFloat(inputView.getText().toString());
    }

    void getBaseInput () {
        EditText inputView = (EditText) findViewById(R.id.baseInput);
        this.base = parseFloat(inputView.getText().toString());
    }

}