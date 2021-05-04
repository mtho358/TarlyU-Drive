package com.coolcats.tarlysu_drive.model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.coolcats.tarlysu_drive.model.data.Car;

import java.util.List;

@Dao
public interface CarDAO {

    @Query("SELECT * FROM cars")
    List<Car> getAllCars();

    @Query("SELECT * FROM cars WHERE id = :id")
    List<Car> getSingleCar(int id);

    @Insert
    void insertCars(Car... car);

    @Update
    void updateCar(Car car);

    @Delete
    void deleteCar(Car car);

}
