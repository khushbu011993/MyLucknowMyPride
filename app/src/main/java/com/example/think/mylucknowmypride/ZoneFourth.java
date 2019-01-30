package com.example.think.mylucknowmypride ;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ZoneFourth extends AppCompatActivity {
    Button road,streetlight,garbage,incroachment,drinkingwater,others;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone_fourth);
        road=(Button)findViewById(R.id.road);
        streetlight=(Button)findViewById(R.id.streetlight);
        garbage=(Button)findViewById(R.id.garbage);
        incroachment=(Button)findViewById(R.id.incroachment);
        drinkingwater=(Button)findViewById(R.id.drinkingwater);
        others=(Button)findViewById(R.id.others4);
        road.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ZoneFourth.this,RoadZone4Activity.class);
                startActivity(i);
            }
        });
        streetlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ZoneFourth.this,StreetLightZone4Activity.class);
                startActivity(i);
            }
        });
        garbage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ZoneFourth.this,GarbageRemovalZone4Activity.class);
                startActivity(i);
            }
        });
        incroachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ZoneFourth.this, EncraochmentZone4Activity.class);
                startActivity(i);

            }
        });
        drinkingwater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ZoneFourth.this, DrinkigWaterZone4Activity.class);
                startActivity(i);

            }
        });
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ZoneFourth.this, Other4Activity.class);
                startActivity(i);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_zone_fourth, menu);
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
