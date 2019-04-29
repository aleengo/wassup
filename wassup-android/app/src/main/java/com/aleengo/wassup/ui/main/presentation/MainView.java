package com.aleengo.wassup.ui.main.presentation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.aleengo.peach.toolbox.utils.Util;
import com.aleengo.wassup.R;
import com.aleengo.wassup.ui.main.views.MainActivity;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;

/**
 * Created by CK_ALEENGO on 14/03/2019.
 * Copyright (c) 2019. All rights reserved.
 */
public class MainView implements MainContract.View {

    @BindView(R.id.home_toolbar)
    Toolbar toolbar;

    private WeakReference<MainActivity> activityWeakRef;
    private WeakReference<Menu> menuWeakRef;

    private View mView;

    @Inject
    public MainView(MainActivity activity) {
        this.activityWeakRef = new WeakReference<>(activity);
        final FrameLayout parentLayout = new FrameLayout(activityWeakRef.get());
        mView = LayoutInflater.from(activityWeakRef.get()).
                inflate(R.layout.activity_main, parentLayout);
    }

    public View view() {
        return mView;
    }

    @Override
    public void init() {
        activityWeakRef.get().setSupportActionBar(toolbar);
    }

    @Override
    public void clear() {
        menuWeakRef.clear();
        menuWeakRef = null;

        activityWeakRef.clear();
        activityWeakRef = null;
    }

    @Override
    public boolean inflateMenu(Menu menu) {
        this.menuWeakRef = new WeakReference<>(menu);
        activityWeakRef.get().getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean menuItemSelected(MenuItem item) {
        final int id = item.getItemId();
        switch (id) {
            case R.id.menu_action:
                return true;
            case R.id.signin_action:
                Util.toast(activityWeakRef.get(), "Sign in");
                return true;
            case R.id.signup_action:
                Util.toast(activityWeakRef.get(), "Sign up");
                return true;
            default:
                return activityWeakRef.get().getParent().onOptionsItemSelected(item);
        }
    }

}
