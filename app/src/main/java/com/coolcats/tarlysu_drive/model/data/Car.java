package com.coolcats.tarlysu_drive.model.data;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "cars")
public class Car implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "licenseTag")
    private String licenseTag;

    @ColumnInfo(name = "pricePerDay")
    private double pricePerDay;

    @ColumnInfo(name = "isAvailable")
    private boolean isAvailable;

    //Constructor for DB
    public Car(int id, String name, String licenseTag, double pricePerDay, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.licenseTag = licenseTag;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
    }

    //Constructor for Data Entry
    @Ignore
    public Car(String name, String licenseTag, double pricePerDay, boolean isAvailable) {
        this.name = name;
        this.licenseTag = licenseTag;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
    }

    protected Car(Parcel in) {
        id = in.readInt();
        name = in.readString();
        licenseTag = in.readString();
        pricePerDay = in.readDouble();
        isAvailable = in.readByte() != 0;
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    //Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseTag() {
        return licenseTag;
    }

    public void setLicenseTag(String licenseTag) {
        this.licenseTag = licenseTag;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(licenseTag);
        dest.writeDouble(pricePerDay);
        dest.writeBoolean(isAvailable);
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
