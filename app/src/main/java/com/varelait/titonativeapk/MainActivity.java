package com.varelait.titonativeapk;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
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
                calculate(v);
            }
        });
    }

    void calculate (View view) {
        Button button = (Button)view;
        getBaseInput();
        getHeightInput();
        getPanelInput();
        TextView baseOutput = (TextView)findViewById(R.id.baseOutput);

        //Log.d("Tacker", "base: " + base + " height: " + height + " panels: " + panel );
        if (base > 10 && height > 10 && panel > 1) {
           measures = new Measures(base, height, panel);
           baseOutput.setText((CharSequence)measures.getGlassBase().toString());
        } else
            button.setText((CharSequence) "Error");
    }

    void notifyError () {
    }

    void getPanelInput () {
        EditText inputView = (EditText) findViewById(R.id.panelInput);
        Editable value = inputView.getText();
        if (value != null)
            this.panel = parseInt(inputView.getText().toString());
        else
            this.panel = 2;
    }

    void getHeightInput () {
        EditText inputView = (EditText) findViewById(R.id.baseInput);
        Editable value = inputView.getText();
        if (value != null)
            this.height = parseFloat(value.toString());
        else
            this.height = 0;
    }

    void getBaseInput () {
        EditText inputView = (EditText) findViewById(R.id.baseInput);
        Editable value = inputView.getText();
        if (value != null)
            this.base = parseFloat(value.toString());
        else
            this.base = 0;
    }

}