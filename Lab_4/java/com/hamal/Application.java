package com.hamal;

import com.hamal.view.MyView;

public abstract class Application {
    public static void main(String[] args) {
        new MyView().show();
    }
}