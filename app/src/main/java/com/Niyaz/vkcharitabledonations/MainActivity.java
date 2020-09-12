package com.Niyaz.vkcharitabledonations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    static final int GALLERY_REQUEST = 1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        // Убрать ActionBar
        getSupportActionBar().hide();
        if (android.os.Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ((Window) window).setStatusBarColor(Color.DKGRAY);
        }
    }
    public void start(View v){
        setContentView(R.layout.start2);
    }

    public void back2(View v){
        setContentView(R.layout.start);
    }

    public void target2(View v){
        setContentView(R.layout.target3);
    }
    public void enter(View v){

    }

    public void backtostart(View v){
        setContentView(R.layout.start2);
    }
    public void enterimage(View v){
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;
        ImageView imageView = (ImageView) findViewById(R.id.imageButton);

        switch(requestCode) {
            case GALLERY_REQUEST:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageView.setImageBitmap(bitmap);
                }
        }
    }

    public void regular2(View v){
    }

}