package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Calculator extends AppCompatActivity {

    TextView tvOutput, tvOutput2, tvOutput3, tvOutput4, tvOutput5;

    EditText etValue1, etValue2;
    Button btnCalculate, btnClear, btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        etValue1 = findViewById(R.id.etValue1);
        etValue2 = findViewById(R.id.etValue2);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);
        tvOutput = findViewById(R.id.tvOutput);
        tvOutput2 = findViewById(R.id.tvOutput2);
        tvOutput3 = findViewById(R.id.tvOutput3);
        tvOutput4 = findViewById(R.id.tvOutput4);
        tvOutput5 = findViewById(R.id.tvOutput5);
        btnHome = findViewById(R.id.btnHome);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value, discount,result,rebate;
                double rate1 = 0.0,rate2 = 0.0,rate3 = 0.0,total;


                try {
                    value = Double.parseDouble(etValue1.getText().toString());
                    discount = Double.parseDouble(etValue2.getText().toString());
                   if(value <= 100){
                       rate1 = value * 1.20;

                       total = rate1;

                       tvOutput2.setText("first block rate (1.20/kWh) RM " + rate1);
                   }
                   else if(value <= 300){
                       rate1 = 100 * 1.20;
                       rate2 = (value - 100) * 1.50;

                       total = rate1 + rate2;

                       tvOutput2.setText("first block rate (1.20/kWh) RM " + rate1);
                       tvOutput3.setText("second block rate (1.50/kWh) RM " + rate2);
                   }
                   else if(value >= 300){
                       rate1 = 100 * 1.20;
                       rate2 = 200 * 1.50;
                       rate3 = (value - 300) * 2.00;

                       total = rate1 + rate2 + rate3;

                       tvOutput2.setText("first block rate (1.20/kWh) RM " + rate1);
                       tvOutput3.setText("Unit Price second block rate (1.50/kWh) RM " + rate2);
                       tvOutput4.setText("Unit Price third block rate (2.00/kWh) RM " + rate3);

                   }

                    total = rate1 +rate2 +rate3;

                    rebate = (discount/100) * total;
                    result = total - (total * discount / 100);

                    tvOutput5.setText("Total Rebate RM: " + rebate);
                    tvOutput.setText("Final Price RM " + result);


                }catch(NumberFormatException nfe){

                    Toast.makeText(getApplicationContext(),"Please enter value",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calculator.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text = btnClear.getText().toString();

                etValue1.setText("Used Unit (kWh)");
                etValue2.setText("Rebate (%)");
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}