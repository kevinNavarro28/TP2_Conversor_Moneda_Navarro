package com.example.tp2_conversor_moneda_navarro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.tp2_conversor_moneda_navarro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        binding.RdDolaraEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.EtDolares.setEnabled(true);
                binding.EtEuros.setEnabled(false);
                binding.EtEuros.setText("0");


            }
        });
        binding.REuroaDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.EtEuros.setEnabled(true);
                binding.EtDolares.setEnabled(false);
                binding.EtDolares.setText("0");


            }
        });

        binding.BtConversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mv.convertir(Integer.parseInt(binding.EtDolares.getText().toString()),Integer.parseInt(binding.EtEuros.getText().toString()));

            }
        });
        mv.getValord().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String d) {
                binding.EtResultado.setText(d);
            }
        });
        mv.getValore().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String e) {
                binding.EtResultado.setText(e);
            }
        });

    }
}