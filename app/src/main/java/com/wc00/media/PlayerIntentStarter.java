package com.wc00.media;

import android.content.Context;
import android.content.Intent;

public class PlayerIntentStarter {

    private final Context context;

    public PlayerIntentStarter(Context context) {
        this.context = context;
    }

    public void firePlayIntent(String filePath) {
        Intent intent = new Intent(context, PlayerService.class);
        intent.setAction(PlayerActions.ACTION_PLAY);
        intent.putExtra(PlayerService.EXTRA_FILE_PATH, filePath);
        context.startService(intent);
    }

    public void fireStopIntent() {
        Intent intent = new Intent(context, PlayerService.class);
        intent.setAction(PlayerActions.ACTION_STOP);
        context.startService(intent);
    }
}
