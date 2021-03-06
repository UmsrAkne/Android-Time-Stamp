package com.example.timestampapp;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public final class TimeStamp {

    @PrimaryKey
    public int id;
    public long msTime;

    @Ignore
    private Date dateTime = new Date();

    @Ignore
    private String dateTimeString = "";

    public Date getDateTime(){
        return dateTime;
    }

    public TimeStamp(){ }

    public TimeStamp(Date dt){
        dateTime = dt;
        msTime = dt.getTime();
    }

    public String getDateTimeString(){
        if(dateTimeString == ""){
            SimpleDateFormat df = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
            dateTimeString = df.format(getDateTime());
        }

        return dateTimeString;
    }

    public String getElapsedTimeString(){
        Date elapsedDate = new Date(new Date().getTime() - getDateTime().getTime());

        long h = elapsedDate.getTime() / 1000 / 3600 % 24;
        long m = elapsedDate.getTime() / 1000 / 60 % 60;
        long s = elapsedDate.getTime() / 1000 % 60;

        return String.format("%02d:%02d:%02d",h,m,s);
    }

    public void setDate(Date dt){
        this.dateTime = dt;
        msTime = dt.getTime();
    }
}
