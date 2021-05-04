package com.coolcats.tarlysu_drive.model.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.coolcats.tarlysu_drive.MainActivity;
import com.coolcats.tarlysu_drive.databinding.InfoFragmentBinding;
import com.coolcats.tarlysu_drive.model.data.Car;

import java.util.LinkedList;
import java.util.List;

public class InfoFragment extends Fragment implements CarAdapter.CarUpdateDelegate {
    private InfoFragmentBinding binding;
    private CarAdapter carAdapter = new CarAdapter(new LinkedList<>(), this);

    private InputFragment.CarDelegate carDelegate;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = InfoFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.carRecyclerview.setAdapter(carAdapter);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(binding.carRecyclerview);
    }

    public void updateList(List<Car> cars){
        carAdapter.setCars(cars);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        carDelegate = (MainActivity)context;
    }
    @Override
    public void updateAvailability(Car car) {
        carDelegate.updateCar(car);

    }
}
