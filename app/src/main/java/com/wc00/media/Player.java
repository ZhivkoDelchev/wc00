package com.wc00.media;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;

public class Player {

    private final MediaPlayer mediaPlayer;

    public Player(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public void play(String filePath) throws IOException {
        stop();
        setDataSource(filePath);
        mediaPlayer.start();
    }

    private void setDataSource(String filePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(filePath);
        FileDescriptor descriptor = inputStream.getFD();
        mediaPlayer.setDataSource(descriptor);
        mediaPlayer.prepare();
    }

    public void stop() {
        mediaPlayer.stop();
        mediaPlayer.reset();
    }

    public void release() {
        mediaPlayer.release();
    }
}
