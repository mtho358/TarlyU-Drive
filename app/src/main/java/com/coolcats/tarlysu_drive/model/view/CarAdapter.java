package com.coolcats.tarlysu_drive.model.view;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coolcats.tarlysu_drive.R;
import com.coolcats.tarlysu_drive.databinding.CarItemLayoutBinding;
import com.coolcats.tarlysu_drive.model.data.Car;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private List<Car> cars;

    public CarAdapter(List<Car> cars){
        this.cars = cars;
    }

    private View.OnClickListener onItemClickListener;

    private InputFragment.CarDelegate carDelegate;

    @NonNull
    @Override
    public CarAdapter.CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CarItemLayoutBinding binding = CarItemLayoutBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );

        return new CarViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = cars.get(position);

        holder.binding.idTextview.setText("#ID00" + car.getId());
        holder.binding.nameTextview.setText(car.getName());
        holder.binding.licenseTagTextview.setText(car.getLicenseTag());
        holder.binding.priceTextview.setText("$" +car.getPricePerDay());

        if(car.isAvailable() == true)
                holder.binding.itemConstraintlayput.setBackgroundColor(Color.parseColor("#03BFAE"));
        else
                holder.binding.itemConstraintlayput.setBackgroundColor(Color.parseColor("#0F30E0E"));



        holder.itemView.setOnClickListener(view -> {
            if(car.isAvailable() == true) {
                car.setAvailable(false);
                Log.d("TAG_M", "" + car.isAvailable());
                holder.binding.itemConstraintlayput.setBackgroundColor(Color.parseColor("#F30E0E"));
            }else{
                car.setAvailable(true);
                Log.d("TAG_M", "" + car.isAvailable());
                holder.binding.itemConstraintlayput.setBackgroundColor(Color.parseColor("#03BFAE"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public void setCars(List<Car> cars){
        this.cars = cars;
        notifyDataSetChanged();
    }


    class CarViewHolder extends  RecyclerView.ViewHolder{
        CarItemLayoutBinding binding;

        public CarViewHolder(CarItemLayoutBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
