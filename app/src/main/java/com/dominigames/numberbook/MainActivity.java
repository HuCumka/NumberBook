package com.dominigames.numberbook;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dominigames.numberbook.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView contactsRecycler;
    CategoryAdapter contactsAdapter;
    ImageView aboutImage;
    JSONArray contactsListJSON;
    List<Category> contactsList;


    static {
        System.loadLibrary("numberbook");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        contactsList = new ArrayList<>();

        try {
            contactsListJSON = new JSONObject(contactListAsJSONString()).getJSONArray("contacts");
            for(int i = 0; i < contactsListJSON.length(); i++){
                contactsList.add(new Category(i + 1, contactsListJSON.getJSONObject(i).getString("name"), contactsListJSON.getJSONObject(i).getString("number")));

            }
            setContactsRecycler(contactsList);
        } catch (JSONException e) {
            e.printStackTrace();
        }




        aboutImage = findViewById(R.id.aboutButton);
        aboutImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutDevicePage.class);
                startActivity(intent);
            }
        });

    }

    private void setContactsRecycler(List<Category> contactsList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        contactsRecycler = findViewById(R.id.contactsRecycler);
        contactsRecycler.setLayoutManager(layoutManager);

        contactsAdapter = new CategoryAdapter(this, contactsList);
        contactsRecycler.setAdapter(contactsAdapter);
    }

    /**
     * A native method that is implemented by the 'numberbook' native library,
     * which is packaged with this application.
     */

    public native String contactListAsJSONString();
}