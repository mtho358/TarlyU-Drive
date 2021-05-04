package com.coolcats.tarlysu_drive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.coolcats.tarlysu_drive.model.data.Car;
import com.coolcats.tarlysu_drive.model.db.TUDDatabase;
import com.coolcats.tarlysu_drive.model.view.CarAdapter;
import com.coolcats.tarlysu_drive.model.view.InfoFragment;
import com.coolcats.tarlysu_drive.model.view.InputFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements InputFragment.CarDelegate {

    private InputFragment inputFragment;
    private InfoFragment infoFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFragment = (InputFragment) getSupportFragmentManager().findFragmentById(R.id.input_fragment);
        infoFragment = (InfoFragment) getSupportFragmentManager().findFragmentById(R.id.info_fragment);
        readDatabase();
    }


    @Override
    public void insertCar(Car car) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                Log.d("TAG_M", "inserting topic");
                TUDDatabase.getDatabase(MainActivity.this).getDAO().insertCars(car);
                Log.d("TAG_M", "reading all...");
                readDatabase();
            }
        }.start();
    }

    @Override
    public void updateCar(Car car) {
        new Thread(){
            @Override
            public void run() {
                super.run();

                Log.d("TAG_M", "Updating availablility");
                TUDDatabase.getDatabase(MainActivity.this).getDAO().updateCar(car);
                Log.d("TAG_M", "reading all...");
                readDatabase();
            }
        }.start();
    }

    private void readDatabase() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                List<Car> carList = TUDDatabase.getDatabase(MainActivity.this).getDAO().getAllCars();

                runOnUiThread(()->{
                    infoFragment.updateList(carList);
                });
            }
        }.start();
    }

}