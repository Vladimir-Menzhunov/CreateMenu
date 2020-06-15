package com.vladimir.coursera.javaaplicationcreatemenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingFragment extends Fragment {
    private RadioButton rYandex;
    private RadioButton rGoogle;
    private RadioButton rBing;

    public static SettingFragment newInstance() {

        Bundle args = new Bundle();

        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);

        rBing = view.findViewById(R.id.Rbing);
        rYandex = view.findViewById(R.id.Ryandex);
        rGoogle= view.findViewById(R.id.Rgoogle);

        rYandex.setOnClickListener(onClickListenerRatio);
        rBing.setOnClickListener(onClickListenerRatio);
        rGoogle.setOnClickListener(onClickListenerRatio);

        return view;
    }

    View.OnClickListener onClickListenerRatio = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            assert getFragmentManager() != null;
            getFragmentManager().popBackStack();
        }
    };
}
