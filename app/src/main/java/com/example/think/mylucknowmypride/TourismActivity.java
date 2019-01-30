package com.example.think.mylucknowmypride ;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TourismActivity extends AppCompatActivity {
ImageView chatar,sahnazafimambara,tombbaigum,tombsadatali,residency,jamamasjid,
        chotaimambara,satkhanda,clocktower,rumidarwaja,asifimasjid,shahibawali,baraimambara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourism);
        Button information=(Button)findViewById(R.id.information);
        TextView website=(TextView)findViewById(R.id.website);
        baraimambara=(ImageView)findViewById(R.id.baraimambara);
        shahibawali=(ImageView)findViewById(R.id.shahibawali);
        asifimasjid=(ImageView)findViewById(R.id.asifimasjid);
        rumidarwaja=(ImageView)findViewById(R.id.rumidarwaja);
        clocktower=(ImageView)findViewById(R.id.clocktower);
        satkhanda=(ImageView)findViewById(R.id.satkhanda);
        chotaimambara=(ImageView)findViewById(R.id.chotaimambara);
        jamamasjid=(ImageView)findViewById(R.id.jamamasjid);
        residency=(ImageView)findViewById(R.id.residency);
        tombsadatali=(ImageView)findViewById(R.id.tombsadatali);
        tombbaigum=(ImageView)findViewById(R.id.tombbaigum);
        sahnazafimambara=(ImageView)findViewById(R.id.sahnazafimambara);
        chatar=(ImageView)findViewById(R.id.chatar);
        shahibawali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lucknowonline.in/city-guide/shahi-bawli"));
                startActivity(intent);
            }
        });
        residency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lucknow.org.uk/tourist-attractions/british-residency.html"));
                startActivity(intent);
            }
        });
        rumidarwaja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lucknow.org.uk/tourist-attractions/rumi-darwaza.html"));
                startActivity(intent);
            }
        });
        baraimambara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lucknow.org.uk/tourist-attractions/bara-imambara.html"));
                startActivity(intent);
            }
        });
        chatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lucknow.org.uk/tourist-attractions/chattar-manzil.html"));
                startActivity(intent);
            }
        });
        jamamasjid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lucknow.org.uk/tourist-attractions/jama-masjid.html"));
                startActivity(intent);
            }
        });
        asifimasjid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.journeyfix.com/indian-temples/asafi-masjid-lucknow/overview-13-766.html"));
                startActivity(intent);
            }
        });
        clocktower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.discoverhongkong.com/in/see-do/culture-heritage/historical-sites/colonial/clock-tower.jsp"));
                startActivity(intent);
            }
        });
        satkhanda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/site/lucknowtravelguide/satkhanda-lucknow"));
                startActivity(intent);
            }
        });
        chotaimambara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/site/lucknowtravelguide/chhota-imambara"));
                startActivity(intent);
            }
        });
        tombsadatali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://saveourheritage.in/maqbara-sadat-ali-khan/"));
                startActivity(intent);
            }
        });
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TourismActivity.this,TourismInformation.class);
                startActivity(i);
            }
        });
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://uptourism.gov.in/"));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tourism, menu);
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
