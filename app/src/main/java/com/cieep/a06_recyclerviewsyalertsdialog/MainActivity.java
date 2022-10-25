package com.cieep.a06_recyclerviewsyalertsdialog;

import android.os.Bundle;

import com.cieep.a06_recyclerviewsyalertsdialog.adapters.TodosAdapter;
import com.cieep.a06_recyclerviewsyalertsdialog.modelos.ToDo;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;


import com.cieep.a06_recyclerviewsyalertsdialog.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;
    private ArrayList<ToDo> todosList;

    private TodosAdapter adapter;
    // Encargado de indicar como se organizaran los elementos en el recycler
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        todosList = new ArrayList<>();
        creaTodos();

        adapter = new TodosAdapter(MainActivity.this, todosList, R.layout.todo_model_view);
        layoutManager = new LinearLayoutManager(MainActivity.this);

        binding.contentMain.contenedor.setAdapter(adapter);
        binding.contentMain.contenedor.setLayoutManager(layoutManager);


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void creaTodos() {
        for (int i = 0; i < 1000; i++) {
            todosList.add(new ToDo("Tarea "+i, "Contenido "+i, false));
        }
    }

}