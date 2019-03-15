package com.aleengo.wassup.application.dagger;

import android.content.Context;

import com.aleengo.wassup.common.scope.Application;
import com.aleengo.wassup.ui.main.dagger.MainActivityComponent;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CK_ALEENGO on 15/03/2019.
 * Copyright (c) 2019. All rights reserved.
 */
@Module(subcomponents = {MainActivityComponent.class})
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Application
    public Context context() {
        return context;
    }
}
