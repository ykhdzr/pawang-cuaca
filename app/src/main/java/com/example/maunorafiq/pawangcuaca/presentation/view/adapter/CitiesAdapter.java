package com.example.maunorafiq.pawangcuaca.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maunorafiq.pawangcuaca.R;
import com.example.maunorafiq.pawangcuaca.presentation.model.CityModel;
import com.example.maunorafiq.pawangcuaca.presentation.model.WeatherModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by maunorafiq on 11/8/16.
 */

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ItemViewHolder> {

    public interface OnItemClickListener {
        void onCityItemClicked(CityModel cityModel);
    }

    private Context context;
    private List<CityModel> cityModelList;
    private final LayoutInflater layoutInflater;

    private OnItemClickListener onItemClickListener;

    @Inject
    public CitiesAdapter(Context context) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        cityModelList = new ArrayList<>();
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return (cityModelList != null) ? cityModelList.size() : 0;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = layoutInflater.inflate(R.layout.item_list_location, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        final CityModel cityModel = cityModelList.get(position);

        holder.tvLocation.setText(cityModel.getCityName());
        holder.tvLastChecked.setText("Last checked : today");

        if (cityModel.getWeatherModel() != null) {
            char drajat = 0x00B0;
            holder.tvTemperature.setText(cityModel.getWeatherModel().getTemperature().concat(String.valueOf(drajat)));
            Picasso.with(context).load(cityModel.getWeatherModel().getWeatherIcon()).into(holder.ivTemperature);
        } else {
            holder.tvTemperature.setText("--");
        }

        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onCityItemClicked(cityModel);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setCityModelList(List<CityModel> cityModelList) {
        if (cityModelList != null) this.cityModelList.addAll(cityModelList);
        notifyDataSetChanged();
    }

    public void addNewCity(CityModel cityModel) {
        cityModelList.add(cityModel);
        notifyDataSetChanged();
    }

    public void updateCityModel(WeatherModel weatherModel) {
        for (CityModel cityModel : cityModelList) {
            if (cityModel.getCityName().equals(weatherModel.getCityName())) {
                cityModel.setWeatherModel(weatherModel);
            }
        }
        notifyDataSetChanged();
    }

    public void setOnItemClickListener (OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_location) TextView tvLocation;
        @Bind(R.id.tv_location_temperature) TextView tvTemperature;
        @Bind(R.id.tv_location_last_checked) TextView tvLastChecked;
        @Bind(R.id.image_weather) ImageView ivTemperature;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
