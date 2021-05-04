package com.coolcats.tarlysu_drive.model.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.coolcats.tarlysu_drive.databinding.InputFragmentBinding;
import com.coolcats.tarlysu_drive.model.data.Car;

public class InputFragment extends Fragment {

    private InputFragmentBinding binding;

    public interface CarDelegate{
        void insertCar(Car car);
        void updateCar(Car car);
    }

    private CarDelegate carDelegate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = InputFragmentBinding.inflate(inflater, container, false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.insertButton.setOnClickListener(v -> {
            String name = binding.nameEdittext.getText().toString().trim();
            double price = Double.parseDouble(binding.priceEdittext.getText().toString().trim());
            String licenseTag = binding.licenseTagEditview.getText().toString().trim();

            Car newCar = new Car(name, licenseTag, price, true);
            carDelegate.insertCar(newCar);

            binding.nameEdittext.setText("");
            binding.licenseTagEditview.setText("");
            binding.priceEdittext.setText("");
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        carDelegate = (CarDelegate) context;
    }
}
