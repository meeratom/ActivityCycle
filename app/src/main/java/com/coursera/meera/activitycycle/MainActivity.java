package com.coursera.meera.activitycycle;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private final static String TAG = "MainActivity";
    private int mCreate = 0;
    private int mStart = 0;
    private int mRestart = 0;
    private int mResume = 0;

    private TextView mTvCreate, mTvStart, mTvRestart, mTvResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvCreate = (TextView) findViewById(R.id.create);
        mTvStart = (TextView) findViewById(R.id.start);
        mTvRestart = (TextView) findViewById(R.id.restart);
        mTvResume = (TextView) findViewById(R.id.resume);

        Button nextActivityButton = (Button) findViewById(R.id.button);
        nextActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NextActivity.class);
                startActivity(i);
            }
        });

        if (savedInstanceState != null)
        {
            mCreate = savedInstanceState.getInt("mcreate",0);
            mStart = savedInstanceState.getInt("mstart",0);
            mRestart = savedInstanceState.getInt("mrestart",0);
            mResume = savedInstanceState.getInt("mresume",0);
        }

        Log.i(TAG, "Entered the onCreate() method");
        mCreate++;
        displayCounts();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "Entered the onDestroy() method");
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.i(TAG, "Entered the onStart() method");
        mStart++;
        displayCounts();
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.i(TAG, "Entered the onStop() method");
    }

    @Override
    public void onRestart() {
        super.onRestart();

        Log.i(TAG, "Entered the onRestart() method");
        mRestart++;
        displayCounts();
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i(TAG, "Entered the onResume() method");
        mResume++;
        displayCounts();
    }

    @Override
    public void onPause() {
        super.onResume();

        Log.i(TAG, "Entered the onPause() method");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("mcreate",mCreate);
        savedInstanceState.putInt("mstart",mStart);
        savedInstanceState.putInt("mrestart",mRestart);
        savedInstanceState.putInt("mresume",mResume);
    }

    public void displayCounts() {

        mTvCreate.setText("onCreate() calls : " +mCreate);
        mTvStart.setText("onStart() calls: " + mStart);
        mTvResume.setText("onResume() calls: " + mResume);
        mTvRestart.setText("onRestart() calls: " + mRestart);
    }
}
