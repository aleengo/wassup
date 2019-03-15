package com.aleengo.wassup.ui.main.presentation;

import android.view.Menu;
import android.view.MenuItem;

import com.aleengo.wassup.common.BasePresenter;
import com.aleengo.wassup.common.BaseView;

/**
 * Created by CK_ALEENGO on 15/03/2019.
 * Copyright (c) 2019. All rights reserved.
 */
public interface MainContract {

    interface Presenter extends BasePresenter {

    }

    interface View extends BaseView {
        boolean inflateMenu(Menu menu);
        boolean menuItemSelected(MenuItem item);
    }
}
