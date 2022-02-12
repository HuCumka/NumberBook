package com.dominigames.numberbook;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.dominigames.numberbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView contactsRecycler;
    CategoryAdapter contactsAdapter;
    MainActivity contacts;


    static {
        System.loadLibrary("numberbook");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Category> contactsList = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            contactsList.add(new Category(i + 1, contact_name_list()[i], contact_number_list()[i]));
        }

        setContactsRecycler(contactsList);

        StringBuffer infoBuffer = new StringBuffer();

        infoBuffer.append("Model :" + Build.MODEL + "\n");//The end-user-visible name for the end product.
        infoBuffer.append("Device: " + Build.DEVICE + "\n");//The name of the industrial design.
        infoBuffer.append("Manufacturer: " + Build.MANUFACTURER + "\n");//The manufacturer of the product/hardware.
        infoBuffer.append("Board: " + Build.BOARD + "\n");//The name of the underlying board, like "goldfish".
        infoBuffer.append("Brand: " + Build.BRAND + "\n");//The consumer-visible brand with which the product/hardware will be associated, if any.
        infoBuffer.append("Serial: " + Build.SERIAL + "\n");

    }

    private void setContactsRecycler(List<Category> contactsList) {

        contactsRecycler = findViewById(R.id.contactsRecycler);

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