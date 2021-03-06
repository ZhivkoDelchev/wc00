package com.wc00;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.wc00.media.PlayerIntentStarter;
import com.wc00.media.PlayerService;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button playButton;
    private Button stopButton;
    private PlayerIntentStarter playerIntentStarter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerIntentStarter = new PlayerIntentStarter(this);

        playButton = (Button) findViewById(R.id.PlayButton);
        playButton.setOnClickListener(this);

        stopButton = (Button) findViewById(R.id.stopButton);
        stopButton.setOnClickListener(this);
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
    public void onClick(View v) {
        if (v == playButton) {
            String songFilePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Music/journey.mp3";
            playerIntentStarter.firePlayIntent(songFilePath);
        } else if (v == stopButton) {
            playerIntentStarter.fireStopIntent();
        }
    }
}
