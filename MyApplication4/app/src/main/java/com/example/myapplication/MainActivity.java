package com.example.myapplication;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    TextView mainTextView;
    Button main_button, ok_btn, cnc_btn, delete_btn; // Добавлена кнопка удаления
    EditText mainEditText;

    ListView mainListView;
    ArrayAdapter<String> mArrayAdapter;
    ArrayList<String> mNameList = new ArrayList<>();
    int selectedPosition = -1; // Переменная для хранения позиции выбранного элемента

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mainTextView = findViewById(R.id.main_textview);
        mainTextView.setText("Set in Java!");

        main_button = findViewById(R.id.main_button);
        main_button.setOnClickListener(this);
        ok_btn = findViewById(R.id.ok_btn);
        ok_btn.setOnClickListener(oclBtn);
        cnc_btn = findViewById(R.id.cnc_btn);
        cnc_btn.setOnClickListener(oclBtn);

        delete_btn = findViewById(R.id.delete_btn); // Инициализация кнопки удаления
        delete_btn.setOnClickListener(this); // Установка слушателя на кнопку удаления

        mainEditText = findViewById(R.id.main_edittext);

        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mNameList);
        mainListView.setAdapter(mArrayAdapter);

        mainListView.setOnItemClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        String inputText = mainEditText.getText().toString().trim();

        if (v.getId() == R.id.delete_btn) { // Проверка нажатия кнопки удаления
            if (selectedPosition != -1) {
                mNameList.remove(selectedPosition); // Удаление выбранного элемента
                mArrayAdapter.notifyDataSetChanged(); // Обновление адаптера
                selectedPosition = -1; // Сброс выбранной позиции
                Toast.makeText(this, "Элемент удален!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Выберите элемент для удаления!", Toast.LENGTH_SHORT).show();
            }
            return; // Возврат, чтобы не выполнять код добавления элемента
        }

        if (!inputText.isEmpty()) {
            if (!mNameList.contains(inputText)) {
                mNameList.add(inputText);
                Collections.sort(mNameList);
                mArrayAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Элемент уже существует!", Toast.LENGTH_SHORT).show();
            }
            mainEditText.setText("");
        } else {
            Toast.makeText(this, "Введите текст!", Toast.LENGTH_SHORT).show();
        }
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.ok_btn) {
                mainTextView.setText("Нажата кнопка ОК");
                Toast.makeText(getApplicationContext(), "Нажата кнопка ОК", Toast.LENGTH_LONG).show();
            } else if (v.getId() == R.id.cnc_btn) {
                mainTextView.setText("Нажата кнопка Cancel");
                Toast.makeText(getApplicationContext(), "Нажата кнопка Cancel", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("omg android", position + ": " + mNameList.get(position));
        mainTextView.setText(mNameList.get(position) + " is learning Android development");
        selectedPosition = position; // Сохранение выбранной позиции
    }
}
