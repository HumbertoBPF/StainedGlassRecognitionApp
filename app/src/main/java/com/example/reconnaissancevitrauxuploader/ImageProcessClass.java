package com.example.reconnaissancevitrauxuploader;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class ImageProcessClass{

    private boolean check = true;

    public String ImageHttpRequest(String requestURL, HashMap<String, String> pData) {

        StringBuilder stringBuilder = new StringBuilder();

        try {
            URL url = new URL(requestURL);;
            HttpURLConnection httpURLConnectionObject = (HttpURLConnection) url.openConnection();;
            httpURLConnectionObject.setReadTimeout(2147000000);
            httpURLConnectionObject.setConnectTimeout(2147000000);
            httpURLConnectionObject.setRequestMethod("POST");
            httpURLConnectionObject.setDoInput(true);
            httpURLConnectionObject.setDoOutput(true);

            OutputStream OutPutStream = httpURLConnectionObject.getOutputStream();

            BufferedWriter bufferedWriterObject = new BufferedWriter(new OutputStreamWriter(OutPutStream, "UTF-8"));;
            bufferedWriterObject.write(bufferedWriterDataFN(pData));
            bufferedWriterObject.flush();
            bufferedWriterObject.close();

            OutPutStream.close();

            int RC = httpURLConnectionObject.getResponseCode();

            if (RC == HttpsURLConnection.HTTP_OK) {

                BufferedReader bufferedReaderObject = new BufferedReader(new InputStreamReader(httpURLConnectionObject.getInputStream()));

                stringBuilder = new StringBuilder();

                String RC2;

                while ((RC2 = bufferedReaderObject.readLine()) != null){

                    stringBuilder.append(RC2);
                }
            }
            Log.i("SUCCESS","OK");
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("FAIL","NOT OK");
        }
        return stringBuilder.toString();
    }

    private String bufferedWriterDataFN(HashMap<String, String> HashMapParams) throws UnsupportedEncodingException {

        StringBuilder stringBuilderObject = new StringBuilder();

        for (Map.Entry<String, String> KEY : HashMapParams.entrySet()) {

            if (check)
                check = false;
            else
                stringBuilderObject.append("&");

            stringBuilderObject.append(URLEncoder.encode(KEY.getKey(), "UTF-8"));
            stringBuilderObject.append("=");
            stringBuilderObject.append(URLEncoder.encode(KEY.getValue(), "UTF-8"));
        }

        return stringBuilderObject.toString();
    }

}