package com.dominigames.numberbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class AboutDevicePage extends AppCompatActivity {

    TextView aboutTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_device_page);

        this.setTitle("Об устройстве");

        StringBuffer infoBuffer = new StringBuffer();

        infoBuffer.append("Бренд: " + Build.BRAND + "\n");
        infoBuffer.append("Модель :" + Build.MODEL + "\n");
        infoBuffer.append("Версия операционной системы" + Build.ID + "\n");

        aboutTextView.setText(infoBuffer);

    }
}