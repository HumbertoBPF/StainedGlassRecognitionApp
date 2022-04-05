package com.example.reconnaissancevitrauxuploader;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

public class AsyncTaskUploadClass extends AsyncTask<Void,Void,String> {

    private Context context;
    private ProgressDialog progressDialog ;
    private ImageView imageView;
    private Bitmap bitmap;
    private String imageNameEditText;
    private final String ServerUploadPath = "http://192.168.15.2:888/upload_to_server.php" ;

    public AsyncTaskUploadClass(Context context, ImageView imageView, Bitmap bitmap, String imageNameEditText){
        this.context = context;
        this.imageView = imageView;
        this.bitmap = bitmap;
        this.imageNameEditText = imageNameEditText;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, context.getString(R.string.title_dialog_upload),
                context.getString(R.string.wait_dialog_upload),false,false);
    }
    @Override
    protected String doInBackground(Void... voids) {
        ByteArrayOutputStream byteArrayOutputStreamObject = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStreamObject);
        byte[] byteArrayVar = byteArrayOutputStreamObject.toByteArray();
        final String convertImage = Base64.encodeToString(byteArrayVar, Base64.DEFAULT);

        ImageProcessClass imageProcessClass = new ImageProcessClass();

        HashMap<String,String> hashMapParams = new HashMap<>();
        hashMapParams.put("image_name", imageNameEditText);
        hashMapParams.put("image_path", convertImage);

        Log.i("CONTENT_SENT", convertImage);

        return imageProcessClass.ImageHttpRequest(ServerUploadPath, hashMapParams);
    }

    @Override
    protected void onPostExecute(String string1) {

        super.onPostExecute(string1);

        Log.i("RESULT",string1);

        // Dismiss the progress dialog after done uploading.
        progressDialog.dismiss();
        // Setting image as transparent after done uploading.
        imageView.setImageResource(android.R.color.transparent);

        Intent displayResults = new Intent();
        displayResults.setClass(context,DisplayResults.class);
        displayResults.putExtra("contentToDisplay",string1);
        context.startActivity(displayResults);
    }

}