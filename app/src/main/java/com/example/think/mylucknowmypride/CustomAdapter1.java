package com.example.think.mylucknowmypride ;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

/**
 * Created by THINK on 2/24/2016.
 */
public class CustomAdapter1 extends PagerAdapter {
    private final String NAMESPACE = "http://tempuri.org/";
    private final String URL = "http://mycitymypride.skskup.com/Gallery.asmx";//?op=getDisposedReportsImages"; //?op=insert_data
    private final String SOAP_ACTION = "http://tempuri.org/getImage";
    private final String METHOD_NAME = "getImage";
    private ProgressDialog progress;
    private String TAG = "PGGURU";
    ArrayList<Bitmap> xx=new ArrayList<Bitmap>();
    ArrayAdapter<Bitmap> adapter;
    Context context;
    private Bitmap  bmp;
    int[] imageId = { };

    public CustomAdapter1(Context context){
        this.context = context;
        progress=new ProgressDialog(context);
      /*  progress.setMessage("Loading...");*/

        // progress.setMax(10);
        // progress.show();

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

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

            String jsonRootObject1=response.toString();
            String[] items = jsonRootObject1.split(",");
            for(int i=0;i<items.length;i++)
            {
                String   Types =items[i];
                if (Types != "") {
                    byte[] bloc = Base64.decode(Types, Base64.DEFAULT);

                    bmp = BitmapFactory.decodeByteArray(bloc, 0, bloc.length);
                    xx.add(bmp);


                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private class AsyncCallWS extends AsyncTask<Integer, Void, Void> {

        int progressStatus = 0;
        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
            progress.setMessage("Loading...");
            progress.setIndeterminate(false);
            progress.show();

        }
        @Override
        protected Void doInBackground(Integer... params) {


            while (progressStatus <200 ) {
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
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");

            progress.dismiss();
            progress.setProgress(View.GONE);





        }



        @Override
        protected void onProgressUpdate(Void... values) {
            Log.i(TAG, "onProgressUpdate");
        }


    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = ((Activity)context).getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.gridlayout, container, false);
        ImageView imageView = (ImageView) viewItem.findViewById(R.id.imageView1);
        imageView.setImageBitmap(xx.get(position));

        ((ViewPager)container).addView(viewItem);

        return viewItem;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return xx.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // TODO Auto-generated method stub

        return view == ((View)object);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }


}
