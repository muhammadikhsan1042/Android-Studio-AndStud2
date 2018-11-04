package com.example.muham.aplikasimodul2kel19.ui.detailCar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muham.aplikasimodul2kel19.R;
import com.example.muham.aplikasimodul2kel19.data.model.DataCar;
import com.example.muham.aplikasimodul2kel19.utility.Constant;

import java.util.List;

public class DetailActivity extends AppCompatActivity implements DetailView {

    private DataCar car;
    private DetailPresenter detailPresenter;
    private TextView tvNama;
    private TextView tvMerk;
    private TextView tvModel;
    private TextView tvTahun;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        initIntentData();
        initPresenter();
        initData();
    }

    private void initView() {
        tvNama = findViewById(R.id.setNama);
        tvMerk = findViewById(R.id.setMerk);
        tvModel = findViewById(R.id.setModel);
        tvTahun = findViewById(R.id.setTahun);
    }

    private void initData() {
        detailPresenter.getCarById(car);
    }

    private void initPresenter() {
        detailPresenter = new DetailPresenter(this);
    }

    private void initIntentData() {
        car = getIntent().getParcelableExtra(Constant.Extra.DATA);
        if (car == null) finish();
    }

    @Override
    public void showErrorCarById(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccessCarById(List<DataCar> car) {
        tvNama.setText(car.get(0).getName());
        tvMerk.setText(car.get(0).getMerk());
        tvModel.setText(car.get(0).getModel());
        tvTahun.setText(car.get(0).getYear());
    }
}
