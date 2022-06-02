package com.example.myapplication.add;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Add;
import com.example.myapplication.AfterAdd;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class add_give extends AppCompatActivity {
    Button next;
    View bottom_layout;

    Button but_im;
    Button next_add_2;
    Button next_add_3;

    ImageButton arrow_back;

    LinearLayout set_image;
    LinearLayout set_name;
    LinearLayout set_street;

    EditText category_give;
    EditText name_anim_give;
    EditText but_street_give;

    private FirebaseAuth mAuth;
    private DatabaseReference ref;
    private DatabaseReference myref;
    private FirebaseDatabase database;
    private StorageReference storageRef;
    private Uri upload_uri;

    ProgressBar progressBar;

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_give);


        set_image = (LinearLayout) findViewById(R.id.set_image_give);
        set_name = (LinearLayout) findViewById(R.id.set_name_give);

        but_im = (Button) findViewById(R.id.but_im_give);
        next_add_2 = (Button) findViewById(R.id.next_add_give2);

        arrow_back = (ImageButton) findViewById(R.id.arrow_back_give);

        category_give = (EditText) findViewById(R.id.category_give);
        but_street_give = (EditText) findViewById(R.id.name_street_give);



        progressBar = (ProgressBar) findViewById(R.id.pb_give);

        set_name.setVisibility(View.INVISIBLE);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        storageRef = FirebaseStorage.getInstance().getReference("Image_find");

        ref = database.getReference();
        myref = ref.child("Find_animal").child(mAuth.getCurrentUser().getUid());

        progressBar.setMax(2);
        String[] countries = {"Авиамоторная",
                "Автозаводская",
                "Академическая",
                "Александровский сад",
                "Алексеевская",
                "Алма-Атинская",
                "Алтуфьево",
                "Аннино",
                "Арбатская",
                "Аэропорт",
                "Бабушкинская",
                "Багратионовская",
                "Баррикадная",
                "Бауманская",
                "Беговая",
                "Белорусская",
                "Беляево",
                "Бибирево",
                "Библиотека имени Ленина",
                "Битцевский парк",
                "Борисово",
                "Боровицкая",
                "Ботанический сад",
                "Братиславская",
                "Бульвар адмирала Ушакова",
                "Бульвар Дмитрия Донского",
                "Бульвар Рокоссовского",
                "Бунинская аллея",
                "Варшавская",
                "ВДНХ",
                "Владыкино",
                "Водный стадион",
                "Войковская",
                "Волгоградский проспект",
                "Волжская",
                "Волоколамская",
                "Воробьевы горы,",
                "Выставочная",
                "Выхино",
                "Деловой центр",
                "Динамо",
                "Дмитровская",
                "Добрынинская",
                "Домодедовская",
                "Достоевская",
                "Дубровка",
                "Жулебино",
                "Зябликово",
                "Измайловская",
                "Калужская",
                "Кантемировская",
                "Каховская",
                " Каширская",
                "Киевская",
                "Китай-город",
                "Кожуховская",
                "Коломенская",
                "Комсомольская",
                "Коньково",
                "Красногвардейская",
                "Краснопресненская",
                "Красносельская",
                "Красные ворота",
                "Крестьянская застава",
                "Кропоткинская",
                "Крылатское",
                "Кузнецкий мост",
                "Кузьминки",
                "Кунцевская",
                "Курская",
                "Кутузовская",
                "Ленинский проспект",
                "Лермонтовский проспект",
                "Лесопарковая",
                "Лубянка",
                "Люблино",
                "Марксистская",
                "Марьина роща",
                "Марьино",
                "Маяковская",
                "Медведково",
                "Международная",
                "Менделеевская",
                "Митино",
                "Молодежная",
                "Выставочный центр",
                "Телецентр",
                "Улица Академика Королева",
                "Улица Милашенкова",
                "Улица Сергея Эйзенштейна",
                "Тимирязевская",
                "Мякинино",
                "Нагатинская",
                "Нагорная",
                "Нахимовский проспект",
                "Новогиреево",
                "Новокосино",
                "Новокузнецкая",
                "Новослободская",
                "Новоясеневская",
                "Новые Черемушки",
                "Октябрьская",
                "Октябрьское поле",
                "Орехово",
                "Отрадное",
                "Охотный ряд",
                "Павелецкая",
                "Парк культуры",
                "Парк Победы",
                "Партизанская",
                "Первомайская",
                "Перово",
                "Петровско-Разумовская",
                "Печатники",
                "Пионерская",
                "Планерная",
                "Площадь Ильича",
                "Площадь Революции",
                "Полежаевская",
                "Полянка",
                "Пражская",
                "Преображенская площадь",
                "Пролетарская",
                "Проспект Вернадского",
                "Проспект Мира",
                "Профсоюзная",
                "Пушкинская",
                "Пятницкое шоссе",
                "Речной вокзал",
                "Рижская",
                "Римская",
                "Рязанский проспект",
                "Савеловская",
                "Свиблово",
                "Севастопольская",
                "Семеновская",
                "Серпуховская",
                "Славянский бульвар",
                "Смоленская",
                "Сокол",
                "Сокольники",
                "Спартак",
                "Спортивная",
                "Сретенский бульвар",
                "Строгино",
                "Студенческая",
                "Сухаревская",
                "Сходненская",
                "Таганская",
                "Тверская",
                "Театральная",
                "Текстильщики",
                "Теплый стан",
                "Тимирязевская",
                "Третьяковская",
                "Тропарево",
                "Трубная",
                "Тульская",
                "Тургеневская",
                "Тушинская",
                "Улица Академика Янгеля",
                "Улица Горчакова",
                "Улица Скобелевская",
                "Улица Старокачаловская",
                "Улица 1905 года",
                "Университет",
                "Филевский парк",
                "Фили",
                "Фрунзенская",
                "Царицыно",
                "Цветной бульвар",
                "Черкизовская",
                "Чертановская",
                "Чеховская",
                "Чистые пруды",
                "Чкаловская",
                "Шаболовская",
                "Шипиловская",
                "Шоссе Энтузиастов",
                "Щелковская",
                "Щукинская",
                "Электрозаводская",
                "Юго-Западная",
                "Южная",
                "Ясенево",
                "select a task"
        };

        Spinner spinner = findViewById(R.id.spinner_give);
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                        Object item = parent.getItemAtPosition(pos);
                        myref.child("metro").setValue(item.toString());
                        System.out.println(item.toString());     //prints the text in spinner item.

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

        ArrayAdapter<String> stringListAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, countries) {

            @Nullable
            @Override
            public String getItem(int position) {
                if(position == getCount())
                    return "Выберите метро";
                else
                    return super.getItem(position);
            }
        };
        stringListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(stringListAdapter);
        spinner.setSelection(countries.length);

        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==1){
                    back(set_image, set_name);
                    i--;
                    progressBar.setProgress(i);
                    System.out.println("все норм...");
                } else if(i==2){
                    i--;
                    progressBar.setProgress(i);
                    back(set_name, set_image);
                } else if(i==0){
                    progressBar.setProgress(i);
                    startActivity(new Intent(add_give.this, Add.class));
                }
            }
        });

        but_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=1;
                progressBar.setProgress(i);
                set_image.setVisibility(View.INVISIBLE);
                set_name.setVisibility(View.VISIBLE);

            }
        });
        next_add_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=2;
                myref.child("category").setValue(category_give.getText().toString());
                myref.child("street").setValue(but_street_give.getText().toString());
                myref.child("email_user").setValue(mAuth.getCurrentUser().getUid());
                progressBar.setProgress(i);
                startActivity(new Intent(add_give.this, AfterAdd.class));
            }
        });
//        next_add_3.setOnClickListener();

    }

    private void back(LinearLayout lin_hidden, LinearLayout lin_not_hidden) {
        lin_hidden.setVisibility(View.VISIBLE);
        lin_not_hidden.setVisibility(View.INVISIBLE);

    }
}