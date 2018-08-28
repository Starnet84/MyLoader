package com.itsteps.altair.myloader;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.*;

public class MainActivity extends AppCompatActivity {

    ImageView imgClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgClick = (ImageView)findViewById(R.id.imageView1);

        imgClick.setOnClickListener(view->
                new LongTask().execute());
    }

    class LongTask extends AsyncTask<Void, Void, String>
    {
        // do in another stream (Метод выполняюийся в отдельном (рабочем) потоке)
        @Override
        protected String doInBackground(Void... voids)  {
            //return null;
            try {
                Thread.sleep(300);
                Intent intent = new Intent(MainActivity.this, TimerActivity.class);
                startActivity(intent);



            } catch (InterruptedException e) {
                Log.d(MainActivity.class.getSimpleName(), e.getMessage());
            }
            return "Some answer";
        }
    }
}
