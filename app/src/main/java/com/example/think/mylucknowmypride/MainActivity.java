package com.example.think.mylucknowmypride ;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView contact=(ImageView)findViewById(R.id.contact);
        ImageView aboutlko=(ImageView)findViewById(R.id.aboutlko);
        ImageView publicgrrivance=(ImageView)findViewById(R.id.publicgrrivance);
        ImageView medicalservice=(ImageView)findViewById(R.id.medicalservice);
        ImageView municipalcorporation=(ImageView)findViewById(R.id.municipalcorporation);
        ImageView tourism=(ImageView)findViewById(R.id.tourism);
        ImageView govtscheem=(ImageView)findViewById(R.id.govtscheem);
        ImageView publicservices=(ImageView)findViewById(R.id.publicservices);
        ImageView map=(ImageView)findViewById(R.id.map);
        ImageView gallery=(ImageView)findViewById(R.id.gallery);
        ImageView contactdm=(ImageView)findViewById(R.id.contactdm);
        ImageView ganjinghome=(ImageView)findViewById(R.id.ganjinghome);
        ImageView lkomahotsavhome=(ImageView)findViewById(R.id.lkomahotsavhome);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,ContactActivity.class);
                startActivity(i);

            }
        });
        aboutlko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,AboutLkoActivity.class);
                startActivity(i);

            }
        });
        publicgrrivance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i=new Intent(MainActivity.this,PublicGrivance.class);
//                startActivity(i);
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jsklucknow.com"));
                startActivity(intent);

            }
        });
        medicalservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MedicalServices.class);
                startActivity(i);

            }
        });
        tourism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,TourismActivity.class);
                startActivity(i);
            }
        });
        municipalcorporation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MunicipalActivity.class);
                startActivity(i);
            }
        });
        govtscheem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i=new Intent(MainActivity.this,GovtScheem.class);
               startActivity(i);

            }
        });
        publicservices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,PublicServices.class);
                startActivity(i);
            }
        });
       /* map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MapActivity.class);
                startActivity(intent);
            }
        });*/
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Gallery.class);
                startActivity(i);

            }
        });
        contactdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,DmContactActivity.class);
                startActivity(i);

            }
        });
        ganjinghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,HomeGanjingCarnival.class);
                startActivity(i);

            }
        });
        lkomahotsavhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,HomeLucknowMahotsav.class);
                startActivity(i);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        Intent startMain=new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
}
