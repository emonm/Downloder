package com.example.emon.downloder;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    Button downloadButton;
    DownloadManager downloadManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadButton = (Button) findViewById(R.id.downloadbutton);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
               Uri url=Uri.parse("http://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3");
                DownloadManager.Request request=new DownloadManager.Request(url);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference=downloadManager.enqueue(request);
            }
        });

    }
}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//////    class DownloadFile extends AsyncTask<String, Integer, String> {
//////        @Override
//////        protected String doInBackground(String... url) {
//////            int count;
//////            try {
//////                URL add = new URL("http://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3");
//////                URLConnection conexion = add.openConnection();
//////                conexion.connect();
//////                // this will be useful so that you can show a tipical 0-100% progress bar
//////                int lenghtOfFile = conexion.getContentLength();
//////
//////                // downlod the file
//////                InputStream input = new BufferedInputStream(add.openStream());
//////                OutputStream output = new FileOutputStream("/sdcard/Download/name.mp3");
//////
//////                byte data[] = new byte[1024];
//////
//////                long total = 0;
//////
//////                while ((count = input.read(data)) != -1) {
//////                    total += count;
//////                    // publishing the progress....
//////                    publishProgress((int) (total * 100 / lenghtOfFile));
//////                    output.write(data, 0, count);
//////                }
//////
//////                output.flush();
//////                output.close();
//////                input.close();
//////            } catch (Exception e) {
//////            }
//////            return null;
//////        }
////
////    }
//}
