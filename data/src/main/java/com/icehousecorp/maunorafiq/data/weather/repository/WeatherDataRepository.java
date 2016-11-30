package com.icehousecorp.maunorafiq.data.weather.repository;

import com.icehousecorp.maunorafiq.data.weather.entity.mapper.WeatherEntityDataMapper;
import com.icehousecorp.maunorafiq.data.weather.repository.datasource.WeatherDataStore;
import com.icehousecorp.maunorafiq.data.weather.repository.datasource.WeatherDataStoreFactory;
import com.icehousecorp.maunorafiq.domain.weather.Weather;
import com.icehousecorp.maunorafiq.domain.weather.repository.WeatherRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by Raffi on 11/25/2016.
 */
@Singleton
public class WeatherDataRepository implements WeatherRepository {

    private final WeatherDataStoreFactory weatherDataStoreFactory;
    private final WeatherEntityDataMapper weatherEntityDataMapper;

    @Inject
    public WeatherDataRepository(WeatherDataStoreFactory weatherDataStoreFactory,
                                 WeatherEntityDataMapper weatherEntityDataMapper) {
        this.weatherDataStoreFactory = weatherDataStoreFactory;
        this.weatherEntityDataMapper = weatherEntityDataMapper;
    }

    @Override
    public Observable<Weather> currentWeather(String city) {
        final WeatherDataStore weatherDataStore = this.weatherDataStoreFactory.create();

        return weatherDataStore
                .getWeatherEntity(city)
                .map(weatherResponse -> weatherEntityDataMapper.transform(weatherResponse, city));
    }
}