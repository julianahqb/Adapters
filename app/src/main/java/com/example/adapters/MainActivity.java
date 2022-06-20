package com.example.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    private ListView lista;
    private Spinner spinner;
    private AutoCompleteTextView auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lista = findViewById(R.id.lista);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planetas, android.R.layout.simple_list_item_1);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapterSpinner =
                ArrayAdapter.createFromResource(this, R.array.planetas,
                        android.R.layout.simple_spinner_item);

        adapterSpinner.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapterSpinner);
        spinner.setOnItemSelectedListener(this);

        auto = findViewById(R.id.auto);

        ArrayAdapter<CharSequence> adapterAuto =
                ArrayAdapter.createFromResource(this, R.array.planetas,
                        android.R.layout.simple_list_item_1);

        auto.setAdapter(adapterAuto);
        auto.setThreshold(1);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, (CharSequence) adapterView.getItemAtPosition(i),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, (CharSequence) adapterView.getItemAtPosition(i),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}