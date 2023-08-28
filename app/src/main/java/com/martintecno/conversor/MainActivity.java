package com.martintecno.conversor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import com.martintecno.conversor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel vmMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());//
        setContentView(binding.getRoot());

        vmMain = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding.BTNConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.ETResultado.setEnabled(false);
               // Log.d("monto", String.valueOf(binding.ETMonto.getText().length()));
                vmMain.convertir(binding.ETMonto.getText().toString(),binding.RBTNDolarEuro.isChecked());
            }
        });

        binding.RBTNDolarEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.TVDivisa.setText("Dolar");
                binding.TVResultado.setText("Euro");
            }
        });
        binding.RBTNEuroDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.TVDivisa.setText("Euro");
                binding.TVResultado.setText("Dolar");
            }
        });



        vmMain.getmontoM().observe(this, new Observer<Double>() {
            @Override
            public void onChanged(Double aDouble) {
                binding.ETResultado.setText(aDouble.toString());
            }
        });


    }
}