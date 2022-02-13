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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView contactsRecycler;
    CategoryAdapter contactsAdapter;
    MainActivity contacts;
    ImageView aboutImage;


    static {
        System.loadLibrary("numberbook");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] contactNameList = contact_name_list();
        String[] contactNumberList = contact_number_list();
        List<Category> contactsList = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            contactsList.add(new Category(i + 1, contactNameList[i], contactNumberList[i]));
        }

        setContactsRecycler(contactsList);

        aboutImage = findViewById(R.id.aboutButton);
        aboutImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Button");
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
    public native String[] contact_name_list();

    public native String[] contact_number_list();
}