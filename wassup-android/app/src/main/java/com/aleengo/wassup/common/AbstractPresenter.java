package com.aleengo.wassup.common;

import lombok.Getter;

/**
 * Created by CK_ALEENGO on 15/03/2019.
 * Copyright (c) 2019. All rights reserved.
 */
public abstract class AbstractPresenter<MVPView extends BaseView> {

    @Getter
    private MVPView view;

    public void attach(MVPView view) {
        if (this.view != null) {
            throw new IllegalArgumentException("view is already attached.");
        }
        this.view = view;
    }

    public void detach() {
        if (this.view == null) {
            throw new RuntimeException("view is already detached.");
        }
        this.view = null;
    }

}
