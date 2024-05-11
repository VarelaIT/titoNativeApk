package com.varelait.titonativeapk;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.view.View;
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
    public TextView baseOutput = (TextView) findViewById(R.id.baseOutput);

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
    }

    void calculate (View button) {
        getBaseInput();
        getHeightInput();
        getPanelInput();

        if (base > 10 && height > 10 && panel > 1) {
           measures = new Measures(base, height, panel);
           baseOutput.setText((CharSequence) measures.getGlassBase().toString());
        } else
            notifyError();
    }

    void notifyError () {
    }

    void getPanelInput () {
        View inputView = (EditText) findViewById(R.id.baseInput);
        this.panel = parseInt((String) inputView.getTooltipText());
    }

    void getHeightInput () {
        View inputView = (EditText) findViewById(R.id.baseInput);
        this.height = parseFloat((String) inputView.getTooltipText());
    }

    void getBaseInput () {
        View inputView = (EditText) findViewById(R.id.baseInput);
        this.base = parseFloat((String) inputView.getTooltipText());
    }

}