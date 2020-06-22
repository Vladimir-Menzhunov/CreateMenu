package com.vladimir.coursera.javaaplicationcreatemenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Objects;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_main, container, false);

        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings:
                FragmentManager fragmentManager = getFragmentManager();
                assert fragmentManager != null;
                fragmentManager.beginTransaction()
                        .replace(R.id.acSingleFragment, new SettingFragment())
                        .addToBackStack(null)
                        .commit();
                Toast.makeText(getActivity(), R.string.settings, Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                assert getFragmentManager() != null;
                getFragmentManager().beginTransaction()
                        .replace(R.id.acSingleFragment, new SearchFragment())
                        .addToBackStack(null)
                        .commit();
                Toast.makeText(getActivity(), R.string.search, Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                Objects.requireNonNull(getActivity()).finish();
                Toast.makeText(getActivity(), R.string.exit, Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
