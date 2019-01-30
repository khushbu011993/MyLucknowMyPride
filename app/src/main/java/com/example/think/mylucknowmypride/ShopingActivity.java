package com.example.think.mylucknowmypride ;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class ShopingActivity extends AppCompatActivity {
    private final String NAMESPACE = "http://tempuri.org/";
    private final String URL = "http://mycitymypride.skskup.com/Gallery.asmx";//?op=Railway_Details";//?op=getDisposedReportsImages"; //?op=insert_data
    private final String SOAP_ACTION = "http://tempuri.org/getshoppingmalldetail";
    private final String METHOD_NAME = "getshoppingmalldetail";
    ListView tv_result2;
    private static final String TAG_TYPES = "Types";
    private static final String TAG_NAME = "Name";
    private static final String TAG_ADDRESS = "Owner_Mobile1";
    private static final String TAG_PIN = "Mobile No1";
    private static final String TAG_OWNER = "Owner_Mobile2";
    private static final String TAG_MOBILE = "Mobile No2";
    private String TAG = "PGGURU";
    private static String mobilestoreinput = "Shopping Malls";
    ArrayList<String> xx = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    private ProgressDialog dialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping);
        tv_result2 = (ListView) findViewById(R.id.tv_result1);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        dialog=new ProgressDialog(ShopingActivity.this);
        dialog.setMessage("Loading...");
        dialog.setIndeterminate(false);
        dialog.show();

        AsyncCallWS task = new AsyncCallWS();
        //Call execute
        task.execute();
   /* }*/

     /*    public void getpostofficedetail(String mobilestoreinput) {*/

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        request.addProperty("type",  mobilestoreinput);
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
            JSONObject jsonRootObject = new JSONObject(String.valueOf(response));
            JSONArray Types = jsonRootObject.getJSONArray(TAG_TYPES);
            for (int i = 0; i < Types.length(); i++) {


                JSONObject c = Types.getJSONObject(i);
                String name = c.getString(TAG_NAME);
                String address = c.getString(TAG_ADDRESS);
                String pin = c.getString(TAG_PIN);
                String owner = c.getString(TAG_OWNER);
                String mobile = c.getString(TAG_MOBILE);

                c.put(TAG_NAME, name);
                c.put(TAG_ADDRESS, address);
                c.put(TAG_PIN, pin);
                c.put(TAG_OWNER, owner);
                c.put(TAG_MOBILE, mobile);


                xx.add(name);
                xx.add(address);
                xx.add(pin);
                xx.add(owner);
                xx.add(mobile);

/*
                tv_result2.setAdapter(adapter);
                adapter = new ArrayAdapter<String>(ShopingActivity.this, android.R.layout.simple_list_item_1, xx);
                tv_result2.setAdapter(adapter);*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tv_result2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==2)
                {

                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:8009094201"));
                    startActivity(callIntent1);

                }
                else if(position==4)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:8009094205"));
                    startActivity(callIntent1);
                }
                else if(position==7)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9670000045"));
                    startActivity(callIntent1);
                }
                else if(position==9)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9873258850"));
                    startActivity(callIntent1);
                }
                else if(position==12)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9335230963"));
                    startActivity(callIntent1);
                }
                else if(position==14)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9415635877"));
                    startActivity(callIntent1);
                }
                else if(position==17)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9918801594"));
                    startActivity(callIntent1);
                }
                else if(position==19)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9918002305"));
                    startActivity(callIntent1);
                }
                else if(position==22)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9336922174"));
                    startActivity(callIntent1);
                }
                else if(position==24)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:8756542588"));
                    startActivity(callIntent1);
                }
                else if(position==27)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9936575500"));
                    startActivity(callIntent1);
                }
                else if(position==29)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9919888111"));
                    startActivity(callIntent1);
                }
            }
        });
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
            //tv.setText("Sending...");

        }

        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
            tv_result2.setAdapter(adapter);
            adapter = new ArrayAdapter<String>(ShopingActivity.this, android.R.layout.simple_list_item_1, xx);
            tv_result2.setAdapter(adapter);
            dialog.dismiss();
            dialog.setProgress(View.GONE);

        }


        @Override
        protected void onProgressUpdate(Void... values) {
            Log.i(TAG, "onProgressUpdate");
        }

    }}
