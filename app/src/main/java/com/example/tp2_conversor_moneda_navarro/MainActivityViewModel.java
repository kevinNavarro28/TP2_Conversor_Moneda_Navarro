package com.example.tp2_conversor_moneda_navarro;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;

    private MutableLiveData<String> valord = new MutableLiveData<>();
    private MutableLiveData<String> valore = new MutableLiveData<>();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }
    public LiveData<String> getValord() {
        return valord;
    }
    public LiveData<String> getValore() {
        return valore;
    }

    public void convertir(int dolar,int euro){
        if(dolar==0){

        }
        else {
            valord.setValue(String.valueOf(dolar*0.92));

        } if(euro == 0) {


        }
        else {
            valore.setValue(String.valueOf(euro*1.09));

        }
    }
}
