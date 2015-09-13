package com.wc00.media;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.File;
import java.io.IOException;

/**
 * Created by Jako on 13.9.2015.
 */
public class Player {

    private final MediaPlayer mediaPlayer;

    public Player(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }


    public void play(Context context, String filePath) throws IOException {
        mediaPlayer.stop();
        Uri uri = Uri.fromFile(new File(filePath));
        mediaPlayer.setDataSource(context, uri);
        mediaPlayer.prepare();
        mediaPlayer.start();
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public void release() {
        mediaPlayer.release();
    }
}
