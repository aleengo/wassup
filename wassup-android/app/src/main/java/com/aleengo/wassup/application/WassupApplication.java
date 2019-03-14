package com.aleengo.wassup.application;

import android.app.Application;
import android.content.Context;

import com.aleengo.peach.toolbox.commons.common.PeachConfig;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by CK_ALEENGO on 14/03/2019.
 * Copyright (c) 2019. All rights reserved.
 */
public class WassupApplication extends Application {

    private RefWatcher refWatcher;

    public static WassupApplication getApplication(Context context) {
        return (WassupApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // enabled logging
        PeachConfig.setDebug(true);

        // config LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }

        this.refWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getWatcher(Context context) {
        return getApplication(context).refWatcher;
    }

}
