package com.example.think.mylucknowmypride ;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class PublicGrivance extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 1888;
    ImageView get_pic;
    Button submit;
    EditText txt_Name,txt_ContactNo,txt_ProbDesc;
    private static String user_name;
    private static String user_ContactNo;
    private static String user_Prodlem;
    private static String user_image;
    private static String mobileresponse;
    private String TAG = "PGGURU";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_grivance);
        txt_Name=(EditText)findViewById(R.id.txt_Name);
        txt_ContactNo=(EditText)findViewById(R.id.txt_ContactNo);
        txt_ProbDesc=(EditText)findViewById(R.id.txt_ProbDesc);
        get_pic = (ImageView) this.findViewById(R.id.get_pic);
        Button button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name=txt_Name.getText().toString();
                user_ContactNo=txt_ContactNo.getText().toString();
                user_Prodlem=txt_ProbDesc.getText().toString();
              //  user_Prodlem=get_pic.getImageAlpha();

            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            get_pic.setImageBitmap(photo);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_public_grivance, menu);
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
