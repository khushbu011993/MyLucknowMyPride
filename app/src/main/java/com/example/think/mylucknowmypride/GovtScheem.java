package com.example.think.mylucknowmypride ;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GovtScheem extends AppCompatActivity {
    ImageView govtscheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt_scheem);
        Button animal=(Button)findViewById(R.id.animal);
        Button panchayatiraj=(Button)findViewById(R.id.panchayatiraj);
        Button duda=(Button)findViewById(R.id.duda);
        Button women_welfare=(Button)findViewById(R.id.women_welfare);
        Button youth_welfare=(Button)findViewById(R.id.youth_welfare);
        Button gramvikash=(Button)findViewById(R.id.gramvikash);
        Button revenu=(Button)findViewById(R.id.revenu);
        Button education=(Button)findViewById(R.id.education);
        Button social=(Button)findViewById(R.id.social);
        Button nrlm=(Button)findViewById(R.id.nrlm);
        Button drda=(Button)findViewById(R.id.drda);
        Button scholarship=(Button)findViewById(R.id.scholarship);
        Button nfbs=(Button)findViewById(R.id.nfbs);
        Button beneficiary=(Button)findViewById(R.id.beneficiary);
        beneficiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://mylucknowmypride.com/Dhanusaand.aspx"));
                startActivity(intent);

            }
        });
        drda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GovtScheem.this,DardaActivity.class);
                startActivity(i);

            }
        });
        nfbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://swd.up.nic.in/"));
                startActivity(intent);

            }
        });
        scholarship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://scholarship.up.nic.in/"));
                startActivity(intent);

            }
        });
        nrlm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://srlm.up.nic.in"));
                startActivity(intent);

            }
        });
        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://swd.up.nic.in/"));
                startActivity(intent);

            }
        });
        animal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://animalhusb.up.nic.in/Schemes.htm"));
                startActivity(intent);

            }
        });
        panchayatiraj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://panchayatiraj.up.nic.in/scheme1.aspx"));
                startActivity(intent);

            }
        });
        duda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://urbandevelopment.up.nic.in/yojnaa.htm"));
                startActivity(intent);

            }
        });
        women_welfare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://mahilakalyan.up.nic.in/ourprograms.htm"));
                startActivity(intent);

            }
        });
        youth_welfare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://prdandyouthwelfare.up.nic.in/schemes.htm"));
                startActivity(intent);

            }
        });
        gramvikash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://sgvv.up.nic.in/scheme%20at%20a%20glalnce.htm"));
                startActivity(intent);

            }
        });
        revenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://bor.up.nic.in/AABY/index.html"));
                startActivity(intent);

            }
        });
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://basiceducationlucknow.org/"));
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_govt_scheem, menu);
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
