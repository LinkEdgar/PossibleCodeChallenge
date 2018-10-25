package com.example.edgarreyes.possiblecodetest;

import android.os.Bundle;

import org.json.JSONArray;

public interface DvdContract {
    //This contract defines the relationships between the view, model and presenter

    interface View{
        void setDvdData(JSONArray jsonArray);
        void initViews();
    }

    interface Model{
        void loadDvdData();
        void getLoadedData(JSONArray jsonArray);
        JSONArray getDvdData();
    }

    interface Presenter{
        //passes dvd data to view
        void passDvdData(JSONArray jArray);
        //starts a load for the web service
        void intiateLoad(Bundle bundle);
    }
}
