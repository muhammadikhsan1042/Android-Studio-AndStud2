package com.example.muham.aplikasimodul2kel19.ui.home;

import com.example.muham.aplikasimodul2kel19.data.model.DataCar;

import java.util.List;

public interface HomeView {
    void successShowCar(List<DataCar> dataCars);
    void failedShowCar(String message);
}
