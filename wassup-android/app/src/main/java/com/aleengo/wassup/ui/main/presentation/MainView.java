package com.aleengo.wassup.ui.main.presentation;

import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.aleengo.peach.toolbox.utils.Util;
import com.aleengo.wassup.R;
import com.aleengo.wassup.ui.main.views.MainActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;

/**
 * Created by CK_ALEENGO on 14/03/2019.
 * Copyright (c) 2019. All rights reserved.
 */
public class MainView extends FrameLayout {

    @BindView(R.id.home_toolbar)
    Toolbar toolbar;

    private AppCompatActivity activity;
    private Menu menu;

    public MainView(AppCompatActivity activity) {
        super(activity);
        this.activity = activity;
        inflate(getContext(), R.layout.activity_main, this);
    }

    public void init() {
        activity.setSupportActionBar(toolbar);
    }

    public void clear() {
        menu = null;
        activity = null;
    }

    public boolean inflateMenu(Menu menu) {
        this.menu = menu;
        activity.getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    public boolean optionsItemSelected(MenuItem item) {
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
