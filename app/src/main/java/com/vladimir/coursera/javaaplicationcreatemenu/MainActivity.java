package com.vladimir.coursera.javaaplicationcreatemenu;

import androidx.fragment.app.Fragment;

public class MainActivity extends SingleObject {
    @Override
    protected Fragment getFragment() {
        return MainFragment.newInstance();
    }
}
