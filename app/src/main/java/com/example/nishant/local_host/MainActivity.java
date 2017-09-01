package com.example.nishant.local_host;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    connect_host con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button connect =(Button)findViewById(R.id.connect);
        EditText username=(EditText)findViewById(R.id.username);
        connect.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){

        EditText username=(EditText)findViewById(R.id.username);

       if(v.getId()==R.id.connect){
           String credential_username=username.getText().toString();
            con.execute(credential_username);

           Toast.makeText(this,"unsuccessfull",Toast.LENGTH_SHORT).show();
       }
    }

}
