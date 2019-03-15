package com.aleengo.wassup.ui.main.dagger;

import com.aleengo.wassup.common.scope.PerActivity;
import com.aleengo.wassup.ui.main.presentation.MainView;
import com.aleengo.wassup.ui.main.views.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by CK_ALEENGO on 15/03/2019.
 * Copyright (c) 2019. All rights reserved.
 */
@Module
public class MainActivityModule {

    private MainActivity activity;

    public MainActivityModule(MainActivity activity) {
        this.activity = activity;
    }

    @PerActivity
    @Provides
    public MainView view() {
        return new MainView(activity);
    }
}
