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

    TextView tvOutput, tvOutput2, tvOutput3, tvOutput4, tvOutput5, tvOutput9;

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
        tvOutput9 = findViewById(R.id.tvOutput9);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double value, discount,result,rebate;
                double rate1 = 0.0,rate2 = 0.0,rate3 = 0.0,rate4 = 0.0,total;


                try {
                    value = Double.parseDouble(etValue1.getText().toString());
                    discount = Double.parseDouble(etValue2.getText().toString());
                   if(value <= 200){
                       rate1 = value * 0.218;

                       total = rate1;

                       tvOutput2.setText("");
                       tvOutput3.setText("");
                       tvOutput4.setText("");
                   }
                   else if(value <= 300){
                       rate1 = 200 * 0.218;
                       rate2 = (value - 200) * 0.334;

                       total = rate1 + rate2;

                       tvOutput2.setText("") ;
                       tvOutput3.setText("");
                       tvOutput4.setText("");
                   }
                   else if(value <= 600) {
                       rate1 = 200 * 0.218;
                       rate2 = 100 * 0.334;
                       rate3 = (value - 300) * 0.516;

                       tvOutput2.setText("") ;
                       tvOutput3.setText("");
                       tvOutput4.setText("");

                   }
                   else if (value >= 600) {
                       rate1 = 200 * 0.218;
                       rate2 = 100 * 0.334;
                       rate3 = 300 * 0.516;
                       rate4 = (value - 600) * 0.546;

                       tvOutput2.setText("");
                       tvOutput3.setText("");
                       tvOutput4.setText("");


                    total = rate1 + rate2 + rate3+rate4;



                   }

                    total = rate1 +rate2 +rate3+rate4;

                    rebate = (discount/100) * total;
                    result = total - rebate;

                    tvOutput5.setText("Current Bill RM:" + total );
                    tvOutput9.setText("Rebate RM:" + rebate);
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

                etValue1.setText("");
                etValue2.setText("");
                tvOutput2.setText("First 200kWh for RM0.218/kWh");
                tvOutput3.setText("Next 100kWh for RM0.334/kWh");
                tvOutput4.setText("Next 300kWh for RM0.516/kWh");
                tvOutput9.setText("");
                tvOutput5.setText("After 600kWh, RM0.546/kWh");
                tvOutput.setText("");
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}