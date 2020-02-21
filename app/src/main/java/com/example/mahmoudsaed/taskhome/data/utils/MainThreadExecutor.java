package com.example.mahmoudsaed.taskhome.data.utils;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

/**
 * Created by Mahmoud Saed on 2/13/2020.
 */

public  class MainThreadExecutor implements Executor {
    private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(@NonNull Runnable command) {
        mainThreadHandler.post(command);
    }
}

