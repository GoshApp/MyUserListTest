package com.goshapp.myuserlisttest.data.pojo;

import androidx.room.Entity;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.goshapp.myuserlisttest.data.converter.DobListTypeConverter;
import com.goshapp.myuserlisttest.data.converter.IdListTypeConverter;
import com.goshapp.myuserlisttest.data.converter.InfoListTypeConverter;
import com.goshapp.myuserlisttest.data.converter.LocationListTypeConverter;
import com.goshapp.myuserlisttest.data.converter.LoginListTypeConverter;
import com.goshapp.myuserlisttest.data.converter.NameListTypeConverter;
import com.goshapp.myuserlisttest.data.converter.PictureListTypeConverter;
import com.goshapp.myuserlisttest.data.converter.RegisteredTypeConverter;

import java.util.List;

@Entity
public class Result {

    @SerializedName("gender")
    @Expose
    private String gender;

    @TypeConverters(NameListTypeConverter.class)
    private List<Name> name;
    @TypeConverters(LocationListTypeConverter.class)
    private List<Location> location;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("login")
    @Expose
    @TypeConverters(LoginListTypeConverter.class)
    private List<Login> login;
    @TypeConverters(DobListTypeConverter.class)
    private List<Dob> dob;
    @TypeConverters(RegisteredTypeConverter.class)
    private List<Registered> registered;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("cell")
    @Expose
    private String cell;
    @TypeConverters(IdListTypeConverter.class)
    private List<Id> id;

    @TypeConverters(PictureListTypeConverter.class)
    private List<Picture> picture;

    @SerializedName("nat")
    @Expose
    private String nat;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

}