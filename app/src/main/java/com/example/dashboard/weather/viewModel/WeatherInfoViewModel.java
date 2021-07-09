package com.example.dashboard.weather.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.dashboard.weather.services.model.DataModel;
import com.example.dashboard.weather.services.repository.APIRepository;

public class WeatherInfoViewModel extends ViewModel {
    public LiveData<DataModel> weatherInfo;
    public LiveData<Boolean> success;
    private APIRepository apiRepositoryInstance;


    public WeatherInfoViewModel() {
        apiRepositoryInstance = new APIRepository();
    }

    public void getSuccess() {
        success = apiRepositoryInstance.successResponse;
    }

    public void getWeatherInfo(String cityName) {

        weatherInfo = apiRepositoryInstance.loadWeatherInfo(cityName);

    }


}