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

public class CentralBoard extends AppCompatActivity {
    private final String NAMESPACE = "http://tempuri.org/";
    private final String URL = "http://mycitymypride.skskup.com/Gallery.asmx";//?op=Railway_Details";//?op=getDisposedReportsImages"; //?op=insert_data
    private final String SOAP_ACTION = "http://tempuri.org/CBSEBOARDSCHOOL";
    private final String METHOD_NAME = "CBSEBOARDSCHOOL";
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
        setContentView(R.layout.activity_central_board);
        tv_result=(ListView)findViewById(R.id.tv_result);
        // pg = (ProgressBar) findViewById(R.id.progressBar1);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //  dialog = ProgressDialog.show(RailwayGettingInfo.this, "", "loading..");
        dialog=new ProgressDialog(CentralBoard.this);
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
                    callIntent1.setData(Uri.parse("tel:05222691413"));
                    startActivity(callIntent1);

                } else if (position == 3) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9450111219"));
                    startActivity(callIntent1);
                } else if (position == 4) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://navayugaradiance.org/"));
                    startActivity(intent);

                } else if (position ==7) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05223200340"));
                    startActivity(callIntent1);
                } else if (position ==8) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05223200341"));
                    startActivity(callIntent1);
                } else if (position ==9) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://manipalpublicschoollucknow.com/"));
                    startActivity(intent);
                }  else if (position ==12) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222626897"));
                    startActivity(callIntent1);
                } else if (position ==13) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9335913263"));
                    startActivity(callIntent1);
                } else if (position ==14) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cathedralschoollucknow.com/Index.html"));
                    startActivity(intent);
                }else if (position ==17) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222359868"));
                    startActivity(callIntent1);
                } else if (position ==18) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222359059 "));
                    startActivity(callIntent1);
                } else if (position ==19) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://rlbschools.org/"));
                    startActivity(intent);
                }else if (position ==22) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222995520"));
                    startActivity(callIntent1);
                } else if (position ==23) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05224082383"));
                    startActivity(callIntent1);
                } else if (position ==24) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://balvidyamandirlucknow.com/"));
                    startActivity(intent);
                }else if (position ==27) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222746003"));
                    startActivity(callIntent1);
                } else if (position ==28) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222746005"));
                    startActivity(callIntent1);
                } else if (position ==29) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kvaliganj.org.in/EN/index.php"));
                    startActivity(intent);
                }else if (position ==32) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222817630 "));
                    startActivity(callIntent1);
                } else if (position ==33) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222817777"));
                    startActivity(callIntent1);
                } else if (position ==34) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kvcrpflucknow.org.in/"));
                    startActivity(intent);
                }else if (position ==37) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222296929  "));
                    startActivity(callIntent1);
                } else if (position ==38) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222482996"));
                    startActivity(callIntent1);
                } else if (position ==39) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.apsnrlucknow.org/"));
                    startActivity(intent);
                }else if (position ==42) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05224104031"));
                    startActivity(callIntent1);
                } else if (position ==43) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9369294972"));
                    startActivity(callIntent1);
                } else if (position ==44) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.radcliffe.in/Lucknow/index.aspx"));
                    startActivity(intent);
                }else if (position ==47) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05224113400"));
                    startActivity(callIntent1);
                } else if (position ==48) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:7376172930"));
                    startActivity(callIntent1);
                } else if (position ==49) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vibgyorhigh.com/"));
                    startActivity(intent);
                }else if (position ==52) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9984444022 "));
                    startActivity(callIntent1);
                } else if (position ==53) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:8090809080 "));
                    startActivity(callIntent1);
                } else if (position ==54) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gdgoenkalko.com/index.php"));
                    startActivity(intent);
                }else if (position ==57) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222418912 "));
                    startActivity(callIntent1);
                } else if (position ==58) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222418457 "));
                    startActivity(callIntent1);
                } else if (position ==59) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.stanjanischool.com/index.html"));
                    startActivity(intent);
                }else if (position ==62) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05223278735 "));
                    startActivity(callIntent1);
                } else if (position ==63) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9839609008"));
                    startActivity(callIntent1);
                } else if (position ==64) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.srmps.ac.in/"));
                    startActivity(intent);
                }else if (position ==67) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9838073010"));
                    startActivity(callIntent1);
                } else if (position ==68) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9838079161"));
                    startActivity(callIntent1);
                } else if (position ==69) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.stmalvsintercolleae.com/index.html"));
                    startActivity(intent);
                }else if (position ==72) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05226451476"));
                    startActivity(callIntent1);
                } else if (position ==73) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:9235556666"));
                    startActivity(callIntent1);
                } else if (position ==74) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.themillenniumschools.com/ tmslucknow/MillenniumLucknowSchool/index.aspx"));
                    startActivity(intent);
                }else if (position ==77) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222393105 "));
                    startActivity(callIntent1);
                } else if (position ==78) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222300591"));
                    startActivity(callIntent1);
                } else if (position ==79) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bhavans.info/index.asp"));
                    startActivity(intent);
                }else if (position ==82) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05223200340"));
                    startActivity(callIntent1);
                } else if (position ==83) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05223200341"));
                    startActivity(callIntent1);
                } else if (position ==84) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://manipalpublicschoollucknow.com/"));
                    startActivity(intent);
                }else if (position ==87) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:5222442423"));
                    startActivity(callIntent1);
                } else if (position ==88) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:0000"));
                    startActivity(callIntent1);
                } else if (position ==89) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dpseldeco.com/index.htm"));
                    startActivity(intent);
                }else if (position ==92) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05212298656 "));
                    startActivity(callIntent1);
                } else if (position ==93) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:0000"));
                    startActivity(callIntent1);
                } else if (position ==94) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.kvbkt.orgi"));
                    startActivity(intent);
                }else if (position ==97) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222480641 "));
                    startActivity(callIntent1);
                } else if (position ==98) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222480595"));
                    startActivity(callIntent1);
                } else if (position ==99) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://kvamclko.in/"));
                    startActivity(intent);
                }else if (position ==102) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222300005"));
                    startActivity(callIntent1);
                } else if (position ==103) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05222300006"));
                    startActivity(callIntent1);
                } else if (position ==104) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://theavadhschool.com/index.html"));
                    startActivity(intent);
                }else if (position ==107) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05226534411"));
                    startActivity(callIntent1);
                } else if (position ==108) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:0000"));
                    startActivity(callIntent1);
                } else if (position ==109) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://gmt.lucknowpublicschoolsandcolleges.com/ Home.aspx"));
                    startActivity(intent);
                }else if (position ==112) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:05226062700"));
                    startActivity(callIntent1);
                } else if (position ==113) {
                    Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                    callIntent1.setData(Uri.parse("tel:0000"));
                    startActivity(callIntent1);
                } else if (position ==114) {
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.studyhallfoundation.org/"));
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
            adapter = new ArrayAdapter<String>(CentralBoard.this, android.R.layout.simple_list_item_1, xx);
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
        getMenuInflater().inflate(R.menu.menu_central_board, menu);
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
