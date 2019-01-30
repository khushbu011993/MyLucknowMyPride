package com.example.think.mylucknowmypride ;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {
  /*  private final String NAMESPACE = "http://tempuri.org/";
    private final String URL = "http://mycity.skskup.com/WebService3.asmx"; //?op=insert_data
    private final String SOAP_ACTION = "http://tempuri.org/inset";
    private final String METHOD_NAME = "inset";
    EditText txt_name, txt_email, txt_phone, txt_msg;
    Button btn_contact;
    TextView tv;
    private static String user_name;
    private static String user_mail;
    private static String user_phone;
    private static String user_message;
    private static String mobileresponse;
    private String TAG = "PGGURU";
    private static int i;

  */  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
      Button btn_contact=(Button)findViewById(R.id.btn_contact);
        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText txt_name = (EditText) findViewById(R.id.txt_name);

                EditText txt_email = (EditText) findViewById(R.id.txt_email);

                EditText txt_phone = (EditText) findViewById(R.id.txt_phone);

                EditText txt_msg = (EditText) findViewById(R.id.txt_msg);

                if(txt_name.length()==0 & txt_email.length()==0 & txt_phone.length()==0 & txt_msg.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"Some Fields are required",Toast.LENGTH_SHORT).show();
                }
                else if (txt_name.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter your Name",
                            Toast.LENGTH_LONG).show();
                }
//                else if (txt_email.length() == 0) {
//                    Toast.makeText(getApplicationContext(), "Please enter your Email",
//                            Toast.LENGTH_LONG).show();
//                }
                else if (txt_phone.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter your Phone Number",
                            Toast.LENGTH_LONG).show();
                }
                else if (txt_msg.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter your Message",
                            Toast.LENGTH_LONG).show();
                }

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"smc@aapkaawadh.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Suggestion from My Lucknow My Pride" + " " + "from" + " " + txt_name.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT,"Name" + ":"+txt_name.getText().toString() + "\n" + "Email Id" + ":" + txt_email.getText().toString() + "\n" + "Phone" + ":" + txt_phone.getText().toString() + "\n" + "Enquiry" + ":" + txt_msg.getText().toString());

                try {
                    startActivity(Intent.createChooser(i, "Thanks for your valueable suggestion.It has been send for concerned department for neccessary action...."));
//                    txt_name.setText("");
//                    txt_email.setText("");
//                    txt_phone.setText("");
//                    txt_msg.setText("");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "No Email Client installed", Toast.LENGTH_LONG).show();
                }

            }
        });
       /* txt_name=(EditText)findViewById(R.id.txt_name);
        txt_email=(EditText)findViewById(R.id.txt_email);
        txt_phone=(EditText)findViewById(R.id.txt_phone);
        txt_msg=(EditText)findViewById(R.id.txt_msg);
        tv=(TextView)findViewById(R.id.tv);
        btn_contact=(Button)findViewById(R.id.btn_contact);
        btn_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_name=txt_name.getText().toString();
                txt_name.setText("");
                user_mail=txt_email.getText().toString();
                txt_email.setText("");
                user_phone=txt_phone.getText().toString();
                txt_phone.setText("");
                user_message=txt_msg.getText().toString();
                txt_msg.setText("");
                AsyncCallWS task = new AsyncCallWS();
                //Call execute
                task.execute();
if(user_name.length()==0 & user_mail.length()==0 & user_phone.length()==0 & user_message.length()==0)
{
    Toast.makeText(getApplicationContext(),"All Fields are required",Toast.LENGTH_SHORT).show();
}
else if (user_name.length() == 0) {
    Toast.makeText(getApplicationContext(), "Please enter your Name",
            Toast.LENGTH_LONG).show();
}
else if (user_mail.length() == 0) {
    Toast.makeText(getApplicationContext(), "Please enter your Email",
            Toast.LENGTH_LONG).show();
}
else if (user_phone.length() == 0) {
    Toast.makeText(getApplicationContext(), "Please enter your Phone Number",
            Toast.LENGTH_LONG).show();
}
else if (user_message.length() == 0) {
    Toast.makeText(getApplicationContext(), "Please enter your Message",
            Toast.LENGTH_LONG).show();
}

                *//*AsyncCallWS task = new AsyncCallWS();
                //Call execute
                task.execute();*//*

            }
        });

    }
    public void insert_data(String user_name,String user_mail,String user_phone,String user_message) {
        //Create request
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
        //Property which holds input parameters
     *//*   PropertyInfo celsiusPI = new PropertyInfo();
        //Set Name
        celsiusPI.setName("name");
        celsiusPI.setName("email");
        celsiusPI.setName("phoneNo");
        celsiusPI.setName("message");
        //Set Value
        celsiusPI.setValue(user_name);
        celsiusPI.setValue(user_mail);
        celsiusPI.setValue(user_phone);
        celsiusPI.setValue(user_message);//
        // Set dataType
        celsiusPI.setType(String .class);
        //  Add the property to request object
        request.addProperty(celsiusPI);*//*

         request.addProperty("name", user_name);
        request.addProperty("email", user_mail);
        request.addProperty("phoneNo", user_phone);
        request.addProperty("message", user_message);

        //Create envelope
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
            //Assign it to fahren static variable
            mobileresponse = response.toString();
            i=Integer.parseInt(response.toString());
            // i=Integer.parseInt(mobileresponse.toString());
            if(i>0)
            {
               Toast.makeText(getBaseContext(), "User Suggestion Submitted Successfully", Toast.LENGTH_LONG).show();
              *//*  Intent userPage=new Intent(ContactActivity.this,MainActivity.class);
                startActivity(userPage);*//*
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class AsyncCallWS extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            Log.i(TAG, "doInBackground");
            insert_data(user_name,user_mail,user_phone,user_message);

            return null;
        }

       *//* private void getvalue(String username, String useremail) {
        }*//*

        @Override
        protected void onPostExecute(Void result) {
            Log.i(TAG, "onPostExecute");
            tv.setText(mobileresponse + "Submitted");
          Toast.makeText(getBaseContext(), "Thanks for your valueable suggestion.It has been send for concerned department for neccessary action",
                 Toast.LENGTH_LONG).show();
        //  Intent userPage=new Intent(ContactActivity.this,OTPActivity.class);
//            startActivity(userPage);
        }

        @Override
        protected void onPreExecute() {
            Log.i(TAG, "onPreExecute");
            tv.setText("Sending...");
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            Log.i(TAG, "onProgressUpdate");
        }

    }*/
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact, menu);
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
    }*/
    }
}