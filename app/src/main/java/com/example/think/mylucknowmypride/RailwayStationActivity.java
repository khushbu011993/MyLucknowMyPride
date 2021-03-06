package com.example.think.mylucknowmypride ;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

public class RailwayStationActivity extends AppCompatActivity {
    private final String NAMESPACE = "http://tempuri.org/";
    private final String URL = "http://mycitymypride.skskup.com/Gallery.asmx";//?op=Railway_Details";//?op=getDisposedReportsImages"; //?op=insert_data
    private final String SOAP_ACTION = "http://tempuri.org/Railway_Details";
    private final String METHOD_NAME = "Railway_Details";
    ListView tv_result;
    private ProgressDialog dialog ;
    private static final String TAG_TYPES = "Types";
    private static final String TAG_NAME = "Name";
    private static final String TAG_CODE = "Code";
    private static final String TAG_DISTANCE = "Distance";
    private String TAG = "PGGURU";
    ArrayList<String> xx=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_railway_station);
        tv_result=(ListView)findViewById(R.id.tv_result);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        dialog=new ProgressDialog(RailwayStationActivity.this);
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
                String code = c.getString(TAG_CODE);
                String distance = c.getString(TAG_DISTANCE);

                c.put(TAG_NAME, name);
                c.put(TAG_CODE, code);
                c.put(TAG_DISTANCE, distance);


                xx.add(name);
                xx.add(code);
                xx.add(distance);


              /*  tv_result.setAdapter(adapter);
                adapter = new ArrayAdapter<String>(RailwayStationActivity.this, android.R.layout.simple_list_item_1, xx);
                tv_result.setAdapter(adapter);*/
            }  } catch (Exception e) {
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
            //tv.setText("Sending...");

        }
        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
            tv_result.setAdapter(adapter);
            adapter = new ArrayAdapter<String>(RailwayStationActivity.this, android.R.layout.simple_list_item_1, xx);
            tv_result.setAdapter(adapter);
            dialog.dismiss();
            dialog.setProgress(View.GONE);

        }



        @Override
        protected void onProgressUpdate(Void... values) {
            Log.i(TAG, "onProgressUpdate");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_railway_station, menu);
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
