package com.example.muham.aplikasimodul2kel19.ui.detailCar;

import android.util.Log;

import com.example.muham.aplikasimodul2kel19.data.model.DataCar;
import com.example.muham.aplikasimodul2kel19.data.network.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPresenter {

    private final DetailView detailView;

    public DetailPresenter(DetailView detailView) {
        this.detailView = detailView;
    }

    public void getCarById(DataCar car) {
        RetrofitClient.getInstance()
                .getApi()
                .GetCarById(car.getId())
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()) {
                            JsonObject body = response.body();
                            JsonArray array = body.get("result").getAsJsonArray();
                            Type type = new TypeToken<List<DataCar>>(){}.getType();
                            List<DataCar> dataCars = new Gson().fromJson(array, type);
                            detailView.showSuccessCarById(dataCars);
                        } else {
                            detailView.showErrorCarById("Maaf terjadi kesalahan");
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        Log.d("DATA", t.getMessage());
                        detailView.showErrorCarById(t.getMessage());
                    }
                });
    }
}

