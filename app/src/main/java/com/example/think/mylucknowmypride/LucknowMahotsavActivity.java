package com.example.think.mylucknowmypride ;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class LucknowMahotsavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layou);
        GridView gridView = (GridView) findViewById(R.id.grid_view);


        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //  @Override
	          /*  public void onItemClick(AdapterView<?> parent, View v,
	                    int position, long id) {

	                // Sending image id to FullScreenActivity
	                Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
	                // passing array index
	                i.putExtra("id", position);
	                startActivity(i);
	            }*/

            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), LkoFullImage.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lucknow_mahotsav, menu);
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

