package com.example.edgarreyes.possiblecodetest;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;

public class DvdPresenter implements DvdContract.Presenter{

    private DvdContract.View view;
    private DvdModel model;

    public DvdPresenter(DvdContract.View view){
        this.view = view;
        initPresenter();
    }

    //passes data back to the view to load into the recyclerview
    @Override
    public void passDvdData(JSONArray jArray) {
        view.setDvdData(jArray);
    }

    //Starts the model
    @Override
    public void intiateLoad(Bundle bundle) {
        if(bundle == null){
            model.loadDvdData();
        }else{
            //TODO --> persist data in case of state change such as phone rotation
        }
    }
    //creates a model class to handle network calls
    private void initPresenter(){
        model = new DvdModel(this);
    }

}
