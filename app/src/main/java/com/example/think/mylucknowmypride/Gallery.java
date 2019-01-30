package com.example.think.mylucknowmypride ;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Gallery extends AppCompatActivity {
    Button monuments,ganjingcarnival,lkomahotsav,megaprojects;
    ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        megaprojects=(Button)findViewById(R.id.megaprojects);
        lkomahotsav=(Button)findViewById(R.id.lkomahotsav);
        ganjingcarnival=(Button)findViewById(R.id.ganjingcarnival);
        monuments=(Button)findViewById(R.id.monuments);
        monuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Gallery.this,MonumentsActivity.class);
                startActivity(i);
            }
        });
        ganjingcarnival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress=new ProgressDialog(Gallery.this);
                progress.setMessage("Loading");
                progress.setIndeterminate(false);
                progress.show();
                Intent i=new Intent(Gallery.this,GanjingcarnivalActivity.class);
                startActivity(i);
            }
        });
        lkomahotsav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://lucknowmahotsav.in/gallary.aspx"));
                startActivity(intent);
            }
        });
        megaprojects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Gallery.this,MegaProjectsActivity.class);
                startActivity(i);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gallery, menu);
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
