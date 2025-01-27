package com.example.arithmetic; // Пакет, в котором находится класс
import androidx.appcompat.app.AppCompatActivity; // Импорт базового класса для Activity
import android.content.Intent; // Импорт для перехода между активностями
import android.os.Bundle; // Импорт для работы с состоянием Activity
import android.view.View; // Импорт для обработки нажатий
import android.widget.Button; // Импорт класса для кнопок

// Класс WinActivity, который наследуется от AppCompatActivity
public class WinActivity extends AppCompatActivity {
    Button button; // Объявление переменной для кнопки

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Метод, вызываемый при создании Activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win); // Устанавливаем разметку из activity_win.xml

        // Связываем переменную с кнопкой по её ID
        button = findViewById(R.id.button2);

        // Устанавливаем обработчик нажатия на кнопку
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // При нажатии открываем MainActivity и закрываем текущую активность
                startActivity(new Intent(WinActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}

