package com.example.nishant.local_host;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
/**
 * Created by nishant on 9/1/17.
 */
public class connect_host extends AsyncTask<String, String, String> {

    private Context context;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... arg0){

        try{
            String username = (String)arg0[0];
            String link = "http://myphpmysqlweb.hostei.com/login.php?username="+username+"& password=";

            URL url = new URL(link);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(response.getEntity().getContent()));

            StringBuffer stringbuffer = new StringBuffer("");
            String line="";

            while ((line = in.readLine()) != null) {
                stringbuffer.append(line);
                break;
            }

            in.close();
            return stringbuffer.toString();
        } catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }


    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(context,"successfull",Toast.LENGTH_SHORT).show();
        super.onPostExecute(s);
    }

}
