package com.example.maunorafiq.pawangcuaca.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maunorafiq.pawangcuaca.presentation.internal.di.component.WeatherComponent;
import com.example.maunorafiq.pawangcuaca.presentation.model.WeatherModel;
import com.example.maunorafiq.pawangcuaca.presentation.presenter.WeatherPresenter;
import com.example.maunorafiq.pawangcuaca.presentation.view.WeatherListView;

import java.util.Collection;

import javax.inject.Inject;

/**
 * Created by maunorafiq on 11/29/16.
 */

public class WeatherFragment extends BaseFragment implements WeatherListView {

    private final String TAG = this.getClass().getSimpleName();

    @Inject WeatherPresenter weatherPresenter;

    private WeatherListListener weatherListListener;

    public interface WeatherListListener {
        void onWeatherClicked(final WeatherModel weatherModel);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WeatherListListener) {
            this.weatherListListener = (WeatherListListener) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(WeatherComponent.class).inject(this);
        weatherPresenter.initialize();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void renderWeatherList(Collection<WeatherModel> weatherModels) {

    }

    @Override
    public void viewWeather(WeatherModel weatherModel) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {

    }

    @Override
    public void hideRetry() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public Context context() {
        return getActivity().getApplicationContext();
    }
}