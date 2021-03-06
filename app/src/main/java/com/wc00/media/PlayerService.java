package com.wc00.media;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

public class PlayerService extends Service {

    public static final String EXTRA_FILE_PATH = "EXTRA_FILE_PATH";
    private Player player;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        this.player = new Player(new MediaPlayer());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getAction();
        switch (action) {
            case PlayerActions.ACTION_PLAY:
                try {
                    player.play(intent.getStringExtra(EXTRA_FILE_PATH));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case PlayerActions.ACTION_STOP:
                player.stop();
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        player.release();
        super.onDestroy();
    }
}
