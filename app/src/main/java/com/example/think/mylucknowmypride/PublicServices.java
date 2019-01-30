package com.example.think.mylucknowmypride ;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class PublicServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_services);
        ImageView hospital=(ImageView)findViewById(R.id.hospital);
        ImageView railwaystation=(ImageView)findViewById(R.id.railwaystation);
        ImageView busstation=(ImageView)findViewById(R.id.busstation);
        ImageView schools=(ImageView)findViewById(R.id.schools);
        ImageView firestation=(ImageView)findViewById(R.id.firestation);
        ImageView policestation=(ImageView)findViewById(R.id.policestation);
        ImageView airport=(ImageView)findViewById(R.id.airport);
        ImageView postoffice=(ImageView)findViewById(R.id.postoffice);
        ImageView shopingmalls=(ImageView)findViewById(R.id.shopingmalls);
        ImageView importantservices=(ImageView)findViewById(R.id.importantservices);
       // TextView google=(TextView)findViewById(R.id.google);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PublicServices.this,HospitalActivity.class);
                startActivity(i);
            }
        });
        airport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PublicServices.this,AirportActivity.class);
                startActivity(i);

            }
        });
        postoffice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PublicServices.this,PostOfiiceActivity.class);
                startActivity(i);
            }
        });
        railwaystation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PublicServices.this,RailwayStationActivity.class);
                startActivity(i);
            }
        });
        busstation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PublicServices.this,BusStationActivity.class);
                startActivity(i);
            }
        });
        schools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PublicServices.this,SchoolsActivity.class);
                startActivity(i);
            }
        });
        firestation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PublicServices.this,FireStationActivity.class);
                startActivity(i);
            }
        });
        policestation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PublicServices.this,PoliceStationActivity.class);
                startActivity(i);
            }
        });
        importantservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PublicServices.this,Important_Service_Activity.class);
                startActivity(i);
            }
        });
        shopingmalls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PublicServices.this,ShopingActivity.class);
                startActivity(i);
            }
        });
      /*  google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/?gfe_rd=cr&ei=uMJnVo7JN6vv8wfF9avYCg&gws_rd=ssl"));
                startActivity(intent);
            }
        });*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_public_services, menu);
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
