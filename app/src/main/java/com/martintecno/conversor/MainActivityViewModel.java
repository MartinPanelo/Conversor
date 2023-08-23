package com.martintecno.conversor;
import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {

    private Context context;

    private double monto;
    private MutableLiveData<Double>  montoM;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<Double> getmontoM(){

        if(montoM == null){
            montoM = new MutableLiveData<>();
        }
        return montoM;
    }

    public void convertir(String Smonto, boolean DolarEuro){

        double monto = Double.parseDouble(Smonto);

        monto = DolarEuro ? monto * 0.92 : monto * 1.08;

        montoM.setValue(monto);
    }



}
