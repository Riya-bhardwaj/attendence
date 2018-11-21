package com.example.home.attendance_app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
    }

    public void send(View view) {
        EditText text = (EditText) findViewById(R.id.for_name);
        String valueN = text.getText().toString();
        EditText text1 = (EditText) findViewById(R.id.for_feedback);

        String valueF = text1.getText().toString();
        int len=valueF.length();
        String message= createsummary(valueN,valueF);

        Intent intentf=new Intent(Intent.ACTION_SENDTO);
        intentf.setData(Uri.parse("mailto:cloudcomputingcell.helpdesk@gmail.com"));
        intentf.putExtra(Intent.EXTRA_SUBJECT,"Feedback and Suggestions");
        intentf.putExtra(Intent.EXTRA_TEXT,message);
        if (intentf.resolveActivity(getPackageManager())!=null)
        {  if(len==0)
            Toast.makeText(this, "Please enter your feedback", Toast.LENGTH_SHORT).show();
            if(len>0&&len<600)
            startActivity(intentf);
        }

    }

    private String createsummary(String valueN,String valueF)
    { String message =" Feedback : "+valueF;
        message=message+"\n\n\nFrom : "+valueN;
        return message;
    }

}
