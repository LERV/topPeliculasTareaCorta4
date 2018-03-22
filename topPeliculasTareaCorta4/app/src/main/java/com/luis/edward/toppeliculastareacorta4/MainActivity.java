package com.luis.edward.toppeliculastareacorta4;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    String htmles;
    TextView prueba;
    public void prueba(View view)
    {
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("https://www.botanical-online.com/tiposdetuberculos.htm");

            urlConnection = (HttpURLConnection) url
                    .openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader isw = new InputStreamReader(in);

            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                //System.out.print(current);
                Log.d("HTML ESS----------",String.valueOf(current));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        htmles="dad";


        prueba.setText("fadsfsd");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prueba=findViewById(R.id.Textprueba);

        //String htmles=new DownloadFilesTask().doInBackground();
         htmles="dad";
        prueba.setText(htmles);

    }

}

