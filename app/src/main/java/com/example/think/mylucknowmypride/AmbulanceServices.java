package com.example.think.mylucknowmypride ;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

public class AmbulanceServices extends AppCompatActivity {
    private final String NAMESPACE = "http://tempuri.org/";
    private final String URL = "http://mycitymypride.skskup.com/Gallery.asmx";//?op=Railway_Details";//?op=getDisposedReportsImages"; //?op=insert_data
    private final String SOAP_ACTION = "http://tempuri.org/Ambulance_Services";
    private final String METHOD_NAME = "Ambulance_Services";
    ListView tv_result;
    private static final String TAG_TYPES = "Types";
    private static final String TAG_NAME = "Name";
    private static final String TAG_MOBILENO1 = "Mobile1";
    private static final String TAG_MOBILENO2 = "Mobile2";
    private String TAG = "PGGURU";
    ArrayList<String> xx=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    private ProgressDialog dialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance_services);
        tv_result=(ListView)findViewById(R.id.tv_result);
        // pg = (ProgressBar) findViewById(R.id.progressBar1);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //  dialog = ProgressDialog.show(RailwayGettingInfo.this, "", "loading..");
        dialog=new ProgressDialog(AmbulanceServices.this);
        dialog.setMessage("Loading...");
        dialog.setIndeterminate(false);
        dialog.show();
        AsyncCallWS task = new AsyncCallWS();
        //Call execute

        task.execute();

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

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
            JSONObject jsonRootObject = new JSONObject(String.valueOf(response));
            JSONArray Types = jsonRootObject.getJSONArray(TAG_TYPES);
            for(int i=0; i < Types.length(); i++) {


                JSONObject c = Types.getJSONObject(i);
                String name = c.getString(TAG_NAME);
                //  String address = c.getString(TAG_ADDRESS);
                String mobile1 = c.getString(TAG_MOBILENO1);
                String mobile2 = c.getString(TAG_MOBILENO2);

                c.put(TAG_NAME, name);
                //  c.put(TAG_ADDRESS, address);
                c.put(TAG_MOBILENO1, mobile1);
                c.put(TAG_MOBILENO1, mobile2);


                xx.add(name);
                // xx.add(address);
                xx.add(mobile1);
                xx.add(mobile2);


              /*  tv_result.setAdapter(adapter);
                adapter = new ArrayAdapter<String>(RailwayGettingInfo.this, android.R.layout.simple_list_item_1, xx);
                tv_result.setAdapter(adapter);*/
            }  } catch (Exception e) {
            e.printStackTrace();
        }
        tv_result.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==1)
                {

                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:108"));
                    startActivity(callIntent1);

                }
                else if(position==4)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:8604428471"));
                    startActivity(callIntent1);
                }
                else if(position==7)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05223040102"));
                    startActivity(callIntent1);
                }
                else if(position==8)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:7052150201"));
                    startActivity(callIntent1);
                }
                else if(position==10)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:8400108108"));
                    startActivity(callIntent1);
                }
                else if(position==11)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9984088777"));
                    startActivity(callIntent1);
                }
                else if(position==13)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9454000999"));
                    startActivity(callIntent1);
                }
                else if(position==14)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:7275400999"));
                    startActivity(callIntent1);
                }
                else if(position==16)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9792452160"));
                    startActivity(callIntent1);
                }
                else if(position==17)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:8545043472"));
                    startActivity(callIntent1);
                }
                else if(position==19)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9415513900"));
                    startActivity(callIntent1);
                }
                else if(position==20)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:7408767000"));
                    startActivity(callIntent1);
                }
                else if(position==22)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222463301"));
                    startActivity(callIntent1);
                }
                else if(position==23)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222457656"));
                    startActivity(callIntent1);
                }
                else if(position==25)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9335603127"));
                    startActivity(callIntent1);
                }
                else if(position==26)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:8960806023"));
                    startActivity(callIntent1);
                }
                else if(position==28)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222450152"));
                    startActivity(callIntent1);
                }
                else if(position==29)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222451377"));
                    startActivity(callIntent1);
                }
                else if(position==31)
                {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222283584"));
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

        }
//        @Override
//        protected Void doInBackground(String... params) {
//            Log.i(TAG, "doInBackground");
//
//            return null;
//        }

        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");


            // tv_result.setAdapter(adapter);
            adapter = new ArrayAdapter<String>(AmbulanceServices.this, android.R.layout.simple_list_item_1, xx);
            tv_result.setAdapter(adapter);
            dialog.dismiss();
            dialog.setProgress(View.GONE);
            // tv_result.setAdapter(adapter);

        }



        @Override
        protected void onProgressUpdate(Void... values) {
            Log.i(TAG, "onProgressUpdate");
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ambulance_services, menu);
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
