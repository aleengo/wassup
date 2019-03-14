package com.aleengo.wassup.ui.main.views;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.aleengo.peach.toolbox.commons.util.Utils;
import com.aleengo.peach.toolbox.ui.BaseActivity;
import com.aleengo.peach.toolbox.utils.Util;
import com.aleengo.wassup.R;
import com.aleengo.wassup.ui.main.presentation.MainView;

public class MainActivity extends BaseActivity {

    private MainView mMvpView;

    @Override
    public String logTag() {
        return "MainActivity";
    }

    @Override
    public View getLayoutView() {
        mMvpView = new MainView(this);
        return mMvpView;
    }

    @Override
    public void daggerConfiguration() {
        // no dagger config right now
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
        }
        mMvpView.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMvpView.clear();
        mMvpView = null;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       return mMvpView.inflateMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mMvpView.optionsItemSelected(item);
    }
}
