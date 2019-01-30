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

public class IcseActivity extends AppCompatActivity {
    private final String NAMESPACE = "http://tempuri.org/";
    private final String URL = "http://mycitymypride.skskup.com/Gallery.asmx";//?op=Railway_Details";//?op=getDisposedReportsImages"; //?op=insert_data
    private final String SOAP_ACTION = "http://tempuri.org/ICSCBOARDSCHOOL";
    private final String METHOD_NAME = "ICSCBOARDSCHOOL";
    ListView tv_result;
    private static final String TAG_TYPES = "Types";
    private static final String TAG_NAME = "Name";
    private static final String TAG_ADDRESS = "Address";
    private static final String TAG_MOBILENO1 = "Mobile1";
    private static final String TAG_MOBILENO2 = "Mobile2";
    private static final String TAG_WEBSITE = "Website";
    // private static final String TAG_COMPLAINT_MOBILE_NO = "COMPLAINT_MOBILE_NO";
    private String TAG = "PGGURU";
    ArrayList<String> xx=new ArrayList<String>();
    ArrayAdapter<String> adapter;
    private ProgressDialog dialog ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icse);

        tv_result=(ListView)findViewById(R.id.tv_result);
        // pg = (ProgressBar) findViewById(R.id.progressBar1);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //  dialog = ProgressDialog.show(RailwayGettingInfo.this, "", "loading..");
        dialog=new ProgressDialog(IcseActivity.this);
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
                String address = c.getString(TAG_ADDRESS);
                String mobile1 = c.getString(TAG_MOBILENO1);
                String mobile2 = c.getString(TAG_MOBILENO2);
                String website = c.getString(TAG_WEBSITE);
                //String mobile2 = c.getString(TAG_MOBILENO2);

                c.put(TAG_NAME, name);
                c.put(TAG_ADDRESS, address);
                c.put(TAG_MOBILENO1, mobile1);
                c.put(TAG_MOBILENO1, mobile2);
                c.put(TAG_WEBSITE, website);


                xx.add(name);
                xx.add(address);
                xx.add(mobile1);
                xx.add(mobile2);
                xx.add(website);


            }  } catch (Exception e) {
            e.printStackTrace();
        }
        // }
        tv_result.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 2) {

                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222326882 "));
                    startActivity(callIntent1);

                } else if (position == 3) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222763585"));
                    startActivity(callIntent1);
                } else if (position == 4) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cmseducation.org/branches/aliganj1/"));
                    startActivity(intent);

                } else if (position ==7) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222301301  "));
                    startActivity(callIntent1);
                } else if (position ==8) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:00000"));
                    startActivity(callIntent1);
                } else if (position ==9) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jaipuria.com/index.aspx"));
                    startActivity(intent);
                }  else if (position ==12) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222235415  "));
                    startActivity(callIntent1);
                } else if (position ==13) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222235416 "));
                    startActivity(callIntent1);
                } else if (position ==14) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lamartinierelucknow.org "));
                    startActivity(intent);
                }else if (position ==17) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05223265626"));
                    startActivity(callIntent1);
                } else if (position ==18) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05223265625"));
                    startActivity(callIntent1);
                } else if (position ==19) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lamartinieregirlscolleegelko.com/"));
                    startActivity(intent);
                }else if (position ==22) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222262013 "));
                    startActivity(callIntent1);
                } else if (position ==23) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:0000"));
                    startActivity(callIntent1);
                } else if (position ==24) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cmseducation.orgibranches/asharfabadi"));
                    startActivity(intent);
                }else if (position ==27) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222623712"));
                    startActivity(callIntent1);
                } else if (position ==28) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:00000 "));
                    startActivity(callIntent1);
                } else if (position ==29) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(" http://www.stfrancislucknow.org/"));
                    startActivity(intent);
                }else if (position ==32) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9839818765"));
                    startActivity(callIntent1);
                } else if (position ==33) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:0000 "));
                    startActivity(callIntent1);
                } else if (position ==34) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(" http://www.stfrancislko.org/ "));
                    startActivity(intent);
                }else if (position ==37) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222990607 "));
                    startActivity(callIntent1);
                } else if (position ==38) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222990608"));
                    startActivity(callIntent1);
                } else if (position ==39) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cmseducation.org/branches/gomtinagar2/"));
                    startActivity(intent);
                }else if (position ==42) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222321078"));
                    startActivity(callIntent1);
                } else if (position ==43) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:0000"));
                    startActivity(callIntent1);
                } else if (position ==44) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://stfidelislok.webs.com/"));
                    startActivity(intent);
                }else if (position ==47) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222435690 "));
                    startActivity(callIntent1);
                } else if (position ==48) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222435342 "));
                    startActivity(callIntent1);
                } else if (position ==49) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cmseducation.org/branches/kanpurrd/"));
                    startActivity(intent);
                }else if (position ==52) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222337396"));
                    startActivity(callIntent1);
                } else if (position ==53) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222337394"));
                    startActivity(callIntent1);
                } else if (position ==54) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cmseducation.org/branches/mahanagarl/"));
                    startActivity(intent);
                }else if (position ==57) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:0522236651"));
                    startActivity(callIntent1);
                } else if (position ==58) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222332787"));
                    startActivity(callIntent1);
                } else if (position ==59) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(" http://www.cmseducation.org/branches/mahanagar2/"));
                    startActivity(intent);
                }else if (position ==62) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222330012 "));
                    startActivity(callIntent1);
                } else if (position ==63) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222330013 "));
                    startActivity(callIntent1);
                } else if (position ==64) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cmseducation.orgibranchesimahanagar3/  "));
                    startActivity(intent);
                }else if (position ==67) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222414737"));
                    startActivity(callIntent1);
                } else if (position ==68) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222415690"));
                    startActivity(callIntent1);
                } else if (position ==69) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cmseducation.org/branches/rajajipuraml/"));
                    startActivity(intent);
                }else if (position ==72) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:522-2418425 "));
                    startActivity(callIntent1);
                } else if (position ==73) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:0000"));
                    startActivity(callIntent1);
                } else if (position ==74) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(" http://www.cmseducation.org/branches/rajajipuram2/"));
                    startActivity(intent);
                }else if (position ==77) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222692830 "));
                    startActivity(callIntent1);
                } else if (position ==78) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222690328 "));
                    startActivity(callIntent1);
                } else if (position ==79) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cmseducation.org/branches/ rajendranagar1/"));
                    startActivity(intent);
                }else if (position ==82) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222691895 "));
                    startActivity(callIntent1);
                } else if (position ==83) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222693571"));
                    startActivity(callIntent1);
                } else if (position ==84) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cmseducation.org/branches/ rajendranagar2/"));
                    startActivity(intent);
                }else if (position ==87) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222691752 "));
                    startActivity(callIntent1);
                } else if (position ==88) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:0000"));
                    startActivity(callIntent1);
                } else if (position ==89) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(""));
                    startActivity(intent);
                }else if (position ==92) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222453546"));
                    startActivity(callIntent1);
                } else if (position ==93) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:0000"));
                    startActivity(callIntent1);
                } else if (position ==94) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cmseducation.orgibranchesirdsoi"));
                    startActivity(intent);
                }else if (position ==97) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222636607 "));
                    startActivity(callIntent1);
                } else if (position ==98) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:0000"));
                    startActivity(callIntent1);
                } else if (position ==99) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cmseducation.org/branches/stationrd/ "));
                    startActivity(intent);
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
            adapter = new ArrayAdapter<String>(IcseActivity.this, android.R.layout.simple_list_item_1, xx);
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
        getMenuInflater().inflate(R.menu.menu_icse, menu);
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
