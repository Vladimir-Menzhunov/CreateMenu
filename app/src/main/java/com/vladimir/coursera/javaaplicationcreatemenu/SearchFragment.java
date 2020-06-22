package com.vladimir.coursera.javaaplicationcreatemenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {

    private EditText editText;
    private Button button;
    private SharedPreferenceHelper sharedPreferenceHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ac_search_fragment, container, false);

        sharedPreferenceHelper = new SharedPreferenceHelper(getActivity());

        editText = view.findViewById(R.id.etEnterText);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(onClickListener);
        return view;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri uri;
            switch(sharedPreferenceHelper.getSelectItem()) {
                case "Yandex":
                    uri = Uri.parse("https://yandex.ru/search/?text=" + editText.getText().toString());
                    break;
                case "Bing":
                    uri = Uri.parse("https://www.bing.com/search?q=" + editText.getText().toString());
                    break;
                case "Google":
                default:
                    uri = Uri.parse("https://www.google.com/search?q=" + editText.getText().toString());

            }
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    };
}
