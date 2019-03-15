package com.aleengo.wassup.ui.main.presentation;

import com.aleengo.wassup.common.AbstractPresenter;

import javax.inject.Inject;

/**
 * Created by CK_ALEENGO on 15/03/2019.
 * Copyright (c) 2019. All rights reserved.
 */
public class MainPresenter extends AbstractPresenter<MainView>
        implements MainContract.Presenter {

    @Inject
    public MainPresenter() {
    }

    @Override
    public void clear() {
        detach();
    }
}
