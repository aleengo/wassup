package com.aleengo.wassup.ui.main.presentation;

import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.aleengo.peach.toolbox.utils.Util;
import com.aleengo.wassup.R;
import com.aleengo.wassup.ui.main.views.MainActivity;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;

/**
 * Created by CK_ALEENGO on 14/03/2019.
 * Copyright (c) 2019. All rights reserved.
 */
public class MainView extends FrameLayout implements MainContract.View {

    @BindView(R.id.home_toolbar)
    Toolbar toolbar;

    private MainActivity activity;
    private Menu menu;

    @Inject
    public MainView(MainActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(getContext(), R.layout.activity_main, this);
    }

    @Override
    public void init() {
        activity.setSupportActionBar(toolbar);
    }

    @Override
    public void clear() {
        menu = null;
        activity = null;
    }

    @Override
    public boolean inflateMenu(Menu menu) {
        this.menu = menu;
        activity.getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean menuItemSelected(MenuItem item) {
        final int id = item.getItemId();
        switch (id) {
            case R.id.menu_action:
                return true;
            case R.id.signin_action:
                Util.toast(activity, "Sign in");
                return true;
            case R.id.signup_action:
                Util.toast(activity, "Sign up");
                return true;
            default:
                return activity.getParent().onOptionsItemSelected(item);
        }
    }

}
