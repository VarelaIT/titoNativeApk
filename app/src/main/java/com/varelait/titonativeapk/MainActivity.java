package com.varelait.titonativeapk;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.varelait.titonativeapk.logic.IMeasures;
import com.varelait.titonativeapk.logic.Measures;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public Measures measures;
    public float panel;
    public float height;
    public float base;
    public Button calcBtn;
    public TextView railsOut;
    public TextView lateralOut;
    public TextView alfaOut;
    public TextView jambasOut;
    public TextView glassBaseOut;
    public TextView glassHeightOut;

    @SuppressLint("MissingInflatedId")
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

        railsOut = (TextView) findViewById(R.id.railsOutput);
        lateralOut = (TextView) findViewById(R.id.lateralOutput);
        alfaOut = (TextView) findViewById(R.id.alfaisalOutput);
        jambasOut = (TextView) findViewById(R.id.jambasOutput);
        glassBaseOut = (TextView) findViewById(R.id.glassBaseOutput);
        glassHeightOut = (TextView) findViewById(R.id.glassHeightOutput);
    }

    void renderResult (IMeasures result) {
        DecimalFormat decimal = new DecimalFormat("#.##");
        railsOut.setText((CharSequence) decimal.format(result.getRails()));
        lateralOut.setText((CharSequence) decimal.format(result.getLaterals()));
        alfaOut.setText((CharSequence) decimal.format(result.getAlfaisal()));
        jambasOut.setText((CharSequence) decimal.format(result.getJambas()));
        glassBaseOut.setText((CharSequence) decimal.format(result.getGlassBase()));
        glassHeightOut.setText((CharSequence) decimal.format(result.getGlassHeigth()));
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    void calculate (View view) {
        Button button = (Button)view;
        getBaseInput();
        getHeightInput();
        getPanelInput();

        //Log.d("Tacker", "base: " + base + " height: " + height + " panels: " + panel );
        if (base > 10 && height > 10 && panel > 1) {
           measures = new Measures(base, height, panel);
           renderResult(measures);
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