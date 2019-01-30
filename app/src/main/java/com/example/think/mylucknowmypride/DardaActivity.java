package com.example.think.mylucknowmypride ;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DardaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darda);
        Button iay=(Button)findViewById(R.id.iay);
        Button lgay=(Button)findViewById(R.id.lgay);
        Button snidhi=(Button)findViewById(R.id.snidhi);
        Button rdsrf=(Button)findViewById(R.id.rdsrf);
        Button sagy=(Button)findViewById(R.id.sagy);
        Button nrlm=(Button)findViewById(R.id.nrlm);
        Button mahatma=(Button)findViewById(R.id.mahatma);
        iay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://iay.nic.in/netiay/home.aspx"));
                startActivity(intent);
            }
        });
        lgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://nrega.nic.in/netnrega/home.aspx"));
                startActivity(intent);
            }
        });/*
        nrlm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://lgay.up.nic.in/NotForBrowser.htm"));
                startActivity(intent);
            }
        });*/
        snidhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://mplads.nic.in/"));
                startActivity(intent);
            }
        });
        rdsrf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://ruralsoftnet.up.nic.in/"));
                startActivity(intent);
            }
        });
        sagy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://saanjhi.gov.in/"));
                startActivity(intent);
            }
        });
        mahatma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://nrega.nic.in/netnrega/home.aspx"));
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_darda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
