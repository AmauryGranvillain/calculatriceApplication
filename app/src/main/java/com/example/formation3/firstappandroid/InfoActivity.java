package com.example.formation3.firstappandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class InfoActivity extends AppCompatActivity {
    private Button buttonExitActivity,buttonCallNumber, buttonSendToMail;

    private View.OnClickListener exitActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            InfoActivity.this.finish();
        }
    };
    private View.OnClickListener numberActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:0606060606"));
            startActivity(intent);
        }
    };

    private View.OnClickListener mailActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:toto@mail.com"));
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_activity);

        this.buttonExitActivity = findViewById(R.id.button_digitexitactivity);
        buttonExitActivity.setOnClickListener(exitActivity);

        this.buttonCallNumber = findViewById(R.id.button_telnumber);
        buttonCallNumber.setOnClickListener(numberActivity);

        this.buttonSendToMail = findViewById(R.id.button_sendtomail);
        buttonSendToMail.setOnClickListener(mailActivity);
    }

}
