package com.example.muham.aplikasimodul2kel19.ui.detailCar;

import com.example.muham.aplikasimodul2kel19.data.model.DataCar;

import java.util.List;

public interface DetailView {
    void showErrorCarById(String message);
    void showSuccessCarById(List<DataCar> car);
}
