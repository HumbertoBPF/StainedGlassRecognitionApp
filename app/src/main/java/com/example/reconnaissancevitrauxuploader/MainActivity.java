package com.example.reconnaissancevitrauxuploader;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Bitmap bitmap;

    private Button selectImageGallery, uploadImageServer;
    private ImageView imageView;
    private EditText imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView)findViewById(R.id.imageView);
        imageName = (EditText)findViewById(R.id.editTextImageName);
        selectImageGallery = (Button)findViewById(R.id.buttonSelect);
        uploadImageServer = (Button)findViewById(R.id.buttonUpload);

        selectImageGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Image From Gallery"), 1);
            }
        });

        uploadImageServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageUploadToServerFunction(imageName.getText().toString());
            }
        });
    }

    @Override
    protected void onActivityResult(int RC, int RQC, Intent I) {
        super.onActivityResult(RC, RQC, I);

        if (RC == 1 && RQC == RESULT_OK && I != null && I.getData() != null) {
            Uri uri = I.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void ImageUploadToServerFunction(String imageNameEditText) {
        if (bitmap != null){
            AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass(this,imageView, bitmap,imageNameEditText);
            AsyncTaskUploadClassOBJ.execute();
        }else {
            Toast.makeText(this, getString(R.string.no_image_selected_error),Toast.LENGTH_LONG).show();
        }
    }

    public void configurations(View view) {
    }


}