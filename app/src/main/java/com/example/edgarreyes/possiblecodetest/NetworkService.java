package com.example.edgarreyes.possiblecodetest;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkService{
    private OkHttpClient mClient;
    private DvdModel model;

    public NetworkService(String url, DvdModel model){
        mClient = new OkHttpClient();
        this.model = model;
        makeUrlRequest(url);
    }

    private void makeUrlRequest(String url){
        Request request = new Request.Builder()
                .url(url)
                .build();
        mClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("failure", " -->"+ e);

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    JSONArray jArray = new JSONArray(jsonData);
                    model.getLoadedData(jArray);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
