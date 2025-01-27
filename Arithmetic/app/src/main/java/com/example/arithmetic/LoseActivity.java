package com.example.arithmetic; // Пакет, в котором находится класс
import androidx.appcompat.app.AppCompatActivity; // Импорт базового класса для Activity
import android.content.Intent; // Импорт для перехода между активностями
import android.os.Bundle; // Импорт для работы с состоянием Activity
import android.view.View; // Импорт для обработки нажатий
import android.widget.Button; // Импорт класса для кнопок

// Класс LoseActivity, который наследуется от AppCompatActivity
public class LoseActivity extends AppCompatActivity {
    Button button; // Объявление переменной для кнопки

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Метод, вызываемый при создании Activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose); // Устанавливаем разметку из activity_lose.xml

        // Связываем переменную с кнопкой по её ID
        button = findViewById(R.id.button3);

        // Устанавливаем обработчик нажатия на кнопку
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // При нажатии открываем MainActivity и закрываем текущую активность
                startActivity(new Intent(LoseActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}

