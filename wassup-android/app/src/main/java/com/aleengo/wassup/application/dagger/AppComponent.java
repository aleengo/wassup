package com.aleengo.wassup.application.dagger;

import com.aleengo.wassup.common.scope.Application;
import com.aleengo.wassup.ui.main.dagger.MainActivityComponent;

import dagger.Component;

/**
 * Created by CK_ALEENGO on 15/03/2019.
 * Copyright (c) 2019. All rights reserved.
 */
@Application
@Component(modules = {AppModule.class})
public interface AppComponent {

    MainActivityComponent.Builder MainActivityComponentBuilder();

    @Component.Builder
    interface Builder {
        AppComponent build();
        Builder appModule(AppModule module);
    }
}
