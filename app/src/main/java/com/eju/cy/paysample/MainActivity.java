package com.eju.cy.paysample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.eju.cy.paylibrary.dialog.PayDialog;
import com.eju.cy.paylibrary.net.RetrofitManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RetrofitManager.getDefault().init("17","10410254a133eb0d74afc1b5141321c07d274d9d","JDM");
        findViewById(R.id.tv_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PayDialog payDialog = new PayDialog(true);
                payDialog.show(getSupportFragmentManager(), "");

            }
        });
    }
}
