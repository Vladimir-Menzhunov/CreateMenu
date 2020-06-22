package com.vladimir.coursera.javaaplicationcreatemenu;

import android.content.SharedPreferences;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

public class SharedPreferenceHelper {

    private static final String NAME_SHARED = "NAME_SHARED";
    private static final String SELECT_ITEM_KEY = "SELECT_ITEM_KEY";

    private static final Type TYPE = new TypeToken<String>(){}.getType();

    private SharedPreferences sharedPreferences;

    private Gson gson;
    //TODO

    SharedPreferenceHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(NAME_SHARED, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public String getSelectItem() {
        String item = gson.fromJson(sharedPreferences.getString(SELECT_ITEM_KEY, ""), TYPE);
        return item == null ? "google" : item;
    }

    public void addSelectItem(String item) {
        sharedPreferences.edit().putString(SELECT_ITEM_KEY, gson.toJson(item, TYPE)).apply();
    }

}
