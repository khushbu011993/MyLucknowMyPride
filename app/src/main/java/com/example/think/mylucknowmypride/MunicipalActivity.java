package com.example.think.mylucknowmypride ;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MunicipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipal);
        Button about_municipal=(Button)findViewById(R.id.about_municipal);
        Button zone1=(Button)findViewById(R.id.zone1);
        Button zone2=(Button)findViewById(R.id.zone2);
        Button zone3=(Button)findViewById(R.id.zone3);
        Button zone4=(Button)findViewById(R.id.zone4);
        Button zone5=(Button)findViewById(R.id.zone5);
        Button zone6=(Button)findViewById(R.id.zone6);
        Button zone7=(Button)findViewById(R.id.zone7);
        Button zone8=(Button)findViewById(R.id.zone8);
        about_municipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MunicipalActivity.this,About_Municipal.class);
                startActivity(i);
             /*   Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://lmc.up.nic.in/"));
                startActivity(intent);*/
            }
        });
        zone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MunicipalActivity.this,ZoneFirst.class);
                startActivity(i);
            }
        });
        zone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MunicipalActivity.this,ZoneSecond.class);
                startActivity(i);
            }
        });
        zone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MunicipalActivity.this,ZoneThird.class);
                startActivity(i);
            }
        });
        zone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MunicipalActivity.this,ZoneFourth.class);
                startActivity(i);
            }
        });
        zone5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MunicipalActivity.this,ZoneFifth.class);
                startActivity(i);
            }
        });
        zone6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MunicipalActivity.this,ZoneSixth.class);
                startActivity(i);
            }
        });
        zone7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MunicipalActivity.this,ZoneSeventh.class);
                startActivity(i);
            }
        });
        zone8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MunicipalActivity.this,ZoneEight.class);

                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_municipal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id ==R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
