package com.saad.asaad.lesson3assignment;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    LinearLayout layout;
    EditText cupsInput;
    Button calculateButton;
    TextView tablespoonsOutput;
    TextView teaspoonsOutput;
    TextView bannerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        layout = new LinearLayout(this);
        cupsInput = new EditText(this);
        calculateButton = new Button(this);
        tablespoonsOutput = new TextView(this);
        teaspoonsOutput = new TextView(this);
        bannerText = new TextView(this);


        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER_HORIZONTAL);
        layout.setBackgroundColor(Color.WHITE);

        bannerText.setWidth(300);
        bannerText.setGravity(Gravity.CENTER_HORIZONTAL);
        bannerText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        bannerText.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        bannerText.setText("Cups Converter");
        bannerText.setTextColor(Color.RED);
        bannerText.setPadding(0, 0, 0, 10);

        cupsInput.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL | InputType.TYPE_NUMBER_FLAG_SIGNED);
        cupsInput.setHint("Cups");
        calculateButton.setText("Convert");
        calculateButton.setOnClickListener(convertCups);

        tablespoonsOutput.setText("0 TeaSpoon");
        teaspoonsOutput.setText("0 TableSpoon");
        tablespoonsOutput.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        teaspoonsOutput.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

        layout.addView(bannerText);
        layout.addView(cupsInput);
        layout.addView(calculateButton);
        layout.addView(tablespoonsOutput);
        layout.addView(teaspoonsOutput);

        setContentView(layout);

    }

    private View.OnClickListener convertCups = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            double cups = Double.parseDouble(cupsInput.getText().toString());
            // 1 cup = 16 Tablespoon
            // 1 cup = 48 Teaspoon
            double tbsp = cups *48;
            double tsp = cups *16;
            tablespoonsOutput.setText(String.valueOf(tbsp) + " Tablespoons");
            teaspoonsOutput.setText(String.valueOf(tsp) + " Teaspoons");
        }
    };


}
