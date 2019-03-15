package com.aleengo.wassup.ui.main.dagger;

import com.aleengo.wassup.common.scope.PerActivity;
import com.aleengo.wassup.ui.main.views.MainActivity;

import dagger.Subcomponent;

/**
 * Created by CK_ALEENGO on 15/03/2019.
 * Copyright (c) 2019. All rights reserved.
 */
@PerActivity
@Subcomponent(modules = {MainActivityModule.class})
public interface MainActivityComponent {

    void inject(MainActivity activity);

    @Subcomponent.Builder
    interface Builder {
        MainActivityComponent build();
        Builder mainActivityModule(MainActivityModule module);
    }
}
