package com.jclark.imagegallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {

    private MaterialButton viewPlacesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPlacesButton = findViewById(R.id.view_places);
        viewPlacesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PlaceGalleryActivity.class);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==getResources().getInteger(R.integer.IMAGE_GALLERY_REQUEST_CODE)) {
            Bitmap bmp = null;
            String filename = getIntent().getStringExtra("IMAGE");
            try {
                FileInputStream is = this.openFileInput(filename);
                bmp = BitmapFactory.decodeStream(is);
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String message=data.getStringExtra("MESSAGE");

        }
    }
}