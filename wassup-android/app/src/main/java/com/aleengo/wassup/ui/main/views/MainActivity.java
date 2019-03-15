package com.aleengo.wassup.ui.main.views;

import lombok.Getter;
import lombok.Setter;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.aleengo.peach.toolbox.ui.BaseActivity;
import com.aleengo.wassup.application.WassupApplication;
import com.aleengo.wassup.ui.main.dagger.MainActivityComponent;
import com.aleengo.wassup.ui.main.dagger.MainActivityModule;
import com.aleengo.wassup.ui.main.presentation.MainPresenter;
import com.aleengo.wassup.ui.main.presentation.MainView;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    MainView mMvpView;
    @Inject
    MainPresenter presenter;

    @Getter
    private MainActivityComponent daggerComponent;

    @Override
    public String logTag() {
        return "MainActivity";
    }

    @Override
    public View getLayoutView() {
        return mMvpView;
    }

    @Override
    public void daggerConfiguration() {
        daggerComponent = WassupApplication.getApplication(MainActivity.this)
                .appComponent()
                .MainActivityComponentBuilder()
                .mainActivityModule(new MainActivityModule(this))
                .build();
        daggerComponent.inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
        }
        mMvpView.init();
        presenter.attach(mMvpView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.clear();
        mMvpView.clear();
        daggerComponent = null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       return mMvpView.inflateMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mMvpView.menuItemSelected(item);
    }
}
