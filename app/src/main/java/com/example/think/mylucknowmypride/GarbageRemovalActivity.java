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

public class GarbageRemovalActivity extends AppCompatActivity {
    private final String NAMESPACE = "http://tempuri.org/";
    private final String URL = "http://mycitymypride.skskup.com/Gallery.asmx";
    private final String SOAP_ACTION = "http://tempuri.org/getimagezone1 ";
    private final String METHOD_NAME = "getimagezone1 ";
    private final String SOAP_ACTION1 = "http://tempuri.org/Road_repairing_maintainance";
    private final String METHOD_NAME1 = "Road_repairing_maintainance";
    ListView tv_result;
    private static final String TAG_TYPES = "Types";
    private static final String TAG_NAME = "Name";
    private static final String TAG_ADDRESS = "Address";
    private static final String TAG_MOBILENO1 = "Mobile1";
    private static final String TAG_MOBILENO2 = "Mobile2";

    private ProgressDialog dialog;
    private String TAG = "PGGURU";
    private static String mobilestoreinput = "Garbage";
    private static String mobilestoreinput1 = "Garbage1";
    private Bitmap bmp;
    ImageView image;
    LinearLayout layout1;
    ArrayList<String> xx = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garbage_removal);
        layout1 = (LinearLayout) findViewById(R.id.layout1);
        image = (ImageView) findViewById(R.id.image);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        dialog=new ProgressDialog(GarbageRemovalActivity.this);
        dialog.setMessage("Loading...");
        dialog.setIndeterminate(false);
        dialog.show();


        AsyncCallWS task = new AsyncCallWS();
        //Call execute
        task.execute();
        SoapObject request = new SoapObject(NAMESPACE,METHOD_NAME);
        request.addProperty("id",  mobilestoreinput);

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


                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        // }

        SoapObject request1 = new SoapObject(NAMESPACE, METHOD_NAME1);
        request1.addProperty("id",  mobilestoreinput1);
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
                String name=c.getString(TAG_NAME);
                String address = c.getString(TAG_ADDRESS);
                String mobile = c.getString(TAG_MOBILENO1);
                String mobile1 = c.getString(TAG_MOBILENO2);
                //String mobileother = c.get(TAG_MOBILENO2);

                c.put(TAG_NAME, name);
                c.put(TAG_ADDRESS, address);
                c.put(TAG_MOBILENO1,mobile);
                c.put(TAG_MOBILENO2,mobile1);
                TextView tv = new TextView(getApplicationContext());
                TextView tv1 = new TextView(getApplicationContext());
                TextView tv2 = new TextView(getApplicationContext());
                TextView tv3 = new TextView(getApplicationContext());


                tv.setText(name);
                tv.setTextColor(Color.BLACK);
                tv.setPadding(150, 10, 10, 10);
                layout1.addView(tv);
                tv1.setText(address);
                tv1.setTextColor(Color.BLACK);
                tv1.setPadding(150, 10, 10, 10);
                layout1.addView(tv1);
                tv2.setText(mobile);
                tv2.setTextColor(Color.BLUE);
                tv2.setPadding(150, 10, 10, 10);
                layout1.addView(tv2);
                tv3.setText(mobile1);
                tv3.setTextColor(Color.BLUE);
                tv3.setPadding(150, 10, 10, 10);
                layout1.addView(tv3);

                tv2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                        callIntent1.setData(Uri.parse("tel:9415609552"));
                        startActivity(callIntent1);
                    }
                });
                tv3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                        callIntent1.setData(Uri.parse("tel:9415004576"));
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
        }
        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");


        }

        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
            dialog.dismiss();
            dialog.setProgress(View.GONE);

        }




        @Override
        protected void onProgressUpdate(Void... values) {
            Log.i(TAG, "onProgressUpdate");
        }

    }
}