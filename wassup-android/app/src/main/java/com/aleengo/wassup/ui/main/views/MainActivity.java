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

import java.lang.ref.WeakReference;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    MainView mMvpView;
    @Inject
    MainPresenter presenter;

    @Getter
    private MainActivityComponent daggerComponent;
    private static WeakReference<MainActivity> mainActivityWeakRef;

    @Override
    public String logTag() {
        return "MainActivity";
    }

    @Override
    public View getLayoutView() {
        return mMvpView.view();
    }

    @Override
    public void daggerConfiguration() {

        mainActivityWeakRef = new WeakReference<>(this);

        daggerComponent = WassupApplication.getApplication(mainActivityWeakRef.get())
                .appComponent()
                .MainActivityComponentBuilder()
                .mainActivityModule(new MainActivityModule(mainActivityWeakRef.get()))
                .build();
        daggerComponent.inject(mainActivityWeakRef.get());
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
        mainActivityWeakRef.clear();
        mainActivityWeakRef = null;
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
