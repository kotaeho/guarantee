package com.grandra.guarantee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button guarantee_btn;
    private Button guarantee_recommend;
    private Button interest_rate;
    private Button warranty_details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.Init();
        this.guarantee_check();
        this.guarantee_recom();
        this.setInterest_rate();
        this.setWarranty_details();
    }

    private void Init(){
        guarantee_btn = findViewById(R.id.guarantee_btn);
        guarantee_recommend = findViewById(R.id.guarantee_recommend);
        interest_rate = findViewById(R.id.interest_rate);
        warranty_details = findViewById(R.id.warranty_details);
    }

    private void guarantee_check(){
        guarantee_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,guarantee_check.class);
                startActivity(intent);
            }
        });
    }

    private void guarantee_recom(){
        guarantee_recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,guarantee_recommend.class);
                startActivity(intent);
            }
        });
    }

    private void setInterest_rate(){
        interest_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,guarantee_inerest_rate.class);
                startActivity(intent);
            }
        });
    }

    private void setWarranty_details(){
        warranty_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,guarantee_warranty_details.class);
                startActivity(intent);
            }
        });
    }
}