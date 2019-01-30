package com.example.think.mylucknowmypride ;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class AirportActivity extends AppCompatActivity {
    private final String NAMESPACE = "http://tempuri.org/";
    private final String URL = "http://mycitymypride.skskup.com/Gallery.asmx";//?op=getDisposedReportsImages"; //?op=insert_data
    private final String SOAP_ACTION = "http://tempuri.org/getimageairport";
    private final String METHOD_NAME = "getimageairport";/*
    private final String NAMESPACE1 = "http://tempuri.org/";
    private final String URL1 = "http://demo2.jsklucknow.com/webservice.asmx";*///?op=getDisposedReportsImages"; //?op=insert_data
    private final String SOAP_ACTION1 = "http://tempuri.org/AirPort ";
    private final String METHOD_NAME1 = "AirPort ";
    ListView tv_result;
    private static final String TAG_TYPES = "Types";

    // private static final String TAG_ADDRESS = "Address";
    //  private static final String TAG_MOBILENO1 = "MobileNo1";
    private static final String TAG_ADDRESS = "Address";
    private static final String TAG_MOBILENO1 = "MobileNo1";
    private static final String TAG_MOBILENO2 = "Mobile2";
    private static final String TAG_WEBSITE = "Website";
    private ProgressDialog progress;
    private String TAG = "PGGURU";
    private ProgressDialog dialog ;

    //  ArrayList<Bitmap> xx = new ArrayList<Bitmap>();
    // ArrayAdapter<Bitmap> adapter;

    /*  private static final String TAG_MOHALLA = "Mohalla";
      private static final String TAG_mohalla = "mohalla";*/
    private Bitmap bmp;
    ImageView image;
    LinearLayout layout1;
    ArrayList<String> xx = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport);
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        image = (ImageView) findViewById(R.id.image);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        dialog=new ProgressDialog(AirportActivity.this);
        dialog.setMessage("Loading...");
        dialog.setIndeterminate(false);
        dialog.show();

        AsyncCallWS task = new AsyncCallWS();
        //Call execute
        task.execute();
        SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
        // request.addProperty("fillGrievanceResult");
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        //Set output SOAP object
        envelope.setOutputSoapObject(request);
        //Create HTTP call object
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

        try {
            //Invole web service
            androidHttpTransport.call(SOAP_ACTION, envelope);
            //Get the response
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();

            String jsonRootObject1 = response.toString();
            String[] items = jsonRootObject1.split(",");
            for (int i = 0; i < items.length; i++) {
                String Types = items[i];
                if (Types != "") {
                    byte[] bloc = Base64.decode(Types, Base64.DEFAULT);

                    bmp = BitmapFactory.decodeByteArray(bloc, 0, bloc.length);
                    ImageView tv=new ImageView(this);
                    // xx.add(bmp);
                    tv.setImageBitmap(bmp);

                    layout1.addView(tv);
                    tv.setPadding(10,10, 10, 10);
                    //image.setImageBitmap(bmp);

                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        // }

        SoapObject request1 = new SoapObject(NAMESPACE, METHOD_NAME1);
        // request.addProperty("fillGrievanceResult");
        SoapSerializationEnvelope envelope1 = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope1.dotNet = true;
        //Set output SOAP object
        envelope1.setOutputSoapObject(request1);
        //Create HTTP call object
        HttpTransportSE androidHttpTransport1 = new HttpTransportSE(URL);

        try {
            //Invole web service
            androidHttpTransport1.call(SOAP_ACTION1, envelope1);
            //Get the response
            SoapPrimitive response1 = (SoapPrimitive) envelope1.getResponse();
            JSONObject jsonRootObject = new JSONObject(String.valueOf(response1));
            JSONArray Types = jsonRootObject.getJSONArray(TAG_TYPES);
            for(int i=0; i < Types.length(); i++) {


                JSONObject c = Types.getJSONObject(i);
                String mohalla = c.getString(TAG_ADDRESS);
                String mohalla1 = c.getString(TAG_MOBILENO1);
                c.put(TAG_ADDRESS, mohalla);
                c.put(TAG_ADDRESS, mohalla1);
                TextView tv = new TextView(getApplicationContext());
                TextView tv1 = new TextView(getApplicationContext());

//            *//*    xx.add(mohalla);
//                tv_result.setAdapter(adapter);*//*

                tv.setText(mohalla);
                tv.setTextColor(Color.BLUE);
                layout1.addView(tv);
                tv1.setText(mohalla1);
                tv1.setTextColor(Color.RED);
                tv1.setPadding(10, 10, 10, 10);
                layout1.addView(tv1);
                // adapter = new ArrayAdapter<String>(PhpWebservice.this, android.R.layout.simple_list_item_1, xx);
                // tv.setAdapter(adapter);
                tv1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                        callIntent1.setData(Uri.parse("tel:05222435404"));
                        startActivity(callIntent1);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class AsyncCallWS extends AsyncTask<Integer, Void, Void> {
        int progressStatus = 0;

        @Override
        protected Void doInBackground(Integer... params) {

            while (progressStatus <100 ) {
                progressStatus++;
                publishProgress(progressStatus);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        private void publishProgress(int progressStatus) {
        }     @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
            dialog.dismiss();
            dialog.setProgress(View.GONE);
            // tv_result.setAdapter(adapter);

           /* SoapObject request1 = new SoapObject(NAMESPACE1, METHOD_NAME1);
            // request.addProperty("fillGrievanceResult");
            SoapSerializationEnvelope envelope1 = new SoapSerializationEnvelope(
                    SoapEnvelope.VER11);
            envelope1.dotNet = true;
            //Set output SOAP object
            envelope1.setOutputSoapObject(request1);
            //Create HTTP call object
            HttpTransportSE androidHttpTransport1 = new HttpTransportSE(URL);

            try {
                //Invole web service
                androidHttpTransport1.call(SOAP_ACTION1, envelope1);
                //Get the response
                SoapPrimitive response1 = (SoapPrimitive) envelope1.getResponse();
                JSONObject jsonRootObject = new JSONObject(String.valueOf(response1));
                JSONArray Mohalla = jsonRootObject.getJSONArray(TAG_MOHALLA);
                for (int i = 0; i < Mohalla.length(); i++) {
                    JSONObject c = Mohalla.getJSONObject(i);
                    String mohalla = c.getString(TAG_mohalla);
                    c.put(TAG_mohalla, mohalla);
                    TextView tv = new TextView(getApplicationContext());

                    //    xx.add(mohalla);
                    //tv_result.setAdapter(adapter);*//**//*

                    tv.setText(mohalla);
                    layout1.addView(tv);
                    // adapter = new ArrayAdapter<String>(PhpWebservice.this, android.R.layout.simple_list_item_1, xx);
                    // tv.setAdapter(adapter);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }


        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
            //tv.setText("Sending...");

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            Log.i(TAG, "onProgressUpdate");
        }

    }
}