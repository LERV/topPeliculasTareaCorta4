package com.luis.edward.toppeliculastareacorta4;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by estadm on 22/3/2018.
 */

public class DownloadFilesTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... urls)
    {
        String paginaHtml="NADADA----";
        try
        {
            // Build and set timeout values for the request.
            URLConnection connection = (new URL("https://www.botanical-online.com/tiposdetuberculos.htm")).openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();

            // Read and store the result line by line then return the entire string.
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder html = new StringBuilder();
            for (String line; (line = reader.readLine()) != null; ) {
                html.append(line);
            }
            in.close();

            paginaHtml=html.toString();

        }

        catch (MalformedURLException ex) {
            Log.e("httptest",Log.getStackTraceString(ex));
        }
        catch (IOException ex) {
            Log.e("httptest",Log.getStackTraceString(ex));
        }
        return paginaHtml;
    }
}

