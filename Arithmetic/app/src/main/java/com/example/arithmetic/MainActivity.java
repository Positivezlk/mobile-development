package com.example.arithmetic; // Пакет, в котором находится класс

import androidx.appcompat.app.AppCompatActivity; // Импорт базового класса для Activity
import android.content.Intent; // Импорт для перехода между активностями
import android.os.Bundle; // Импорт для работы с состоянием Activity
import android.view.View; // Импорт для работы с кнопками и другими элементами интерфейса
import android.widget.Button; // Импорт класса для кнопок
import android.widget.CompoundButton;
import android.widget.EditText; // Импорт класса для текстового ввода
import android.widget.Switch;
import android.widget.Toast; // Импорт класса для всплывающих уведомлений

// Основной класс MainActivity, который наследуется от AppCompatActivity
public class MainActivity extends AppCompatActivity {

    // Объявление переменных для поля ввода и кнопки
    EditText editText;
    Button button;

    Switch mainSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Метод, вызываемый при создании Activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Устанавливаем разметку из activity_main.xml

        // Инициализация переменных, связываем их с элементами интерфейса по ID
        editText = findViewById(R.id.editTextPersonName);
        button = findViewById(R.id.button);
        mainSwitch = findViewById(R.id.switch1);

        // Устанавливаем обработчик нажатия на кнопку
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Получаем текст, введённый пользователем
                String edit = editText.getText().toString();

                // Проверяем, не пустое ли поле
                if (edit.isEmpty()){
                    Toast.makeText(MainActivity.this, "Поле пустое", Toast.LENGTH_SHORT).show(); // Выводим сообщение
                } else {
                    // Проверяем, равно ли введённое число 4
                    if (Integer.parseInt(edit) == 4) {
                        // Если да, открываем WinActivity и закрываем текущую активность
                        startActivity(new Intent(MainActivity.this, WinActivity.class));
                        finish();
                    } else {
                        // Если нет, открываем LoseActivity и закрываем текущую активность
                        startActivity(new Intent(MainActivity.this, LoseActivity.class));
                        finish();
                    }
                }
            }
        });
        mainSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked)
                {
                    mainSwitch.setText("Вкл");
                } else
                {
                    mainSwitch.setText("Выкл");
                }
            }
        });
    }
}
