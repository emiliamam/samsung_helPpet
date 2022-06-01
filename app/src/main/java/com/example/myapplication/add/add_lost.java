package com.example.myapplication.add;

import android.content.Intent;
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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Add;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_lost extends AppCompatActivity {
    Button next;
    View bottom_layout;

    Button but_im;
    Button next_add_2;
    Button next_add_3;

    ImageButton arrow_back;
    LinearLayout set_image;
    LinearLayout set_name;
    LinearLayout set_street;

    ProgressBar progressBar;

    EditText category_lost;
    EditText name_anim_lost;
    EditText but_street_lost;

    private FirebaseAuth mAuth;
    private DatabaseReference ref;
    private DatabaseReference myref;
    private FirebaseDatabase database;

    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_lost);


        set_image = (LinearLayout) findViewById(R.id.set_image);
        set_name = (LinearLayout) findViewById(R.id.set_name);
        set_street = (LinearLayout) findViewById(R.id.set_street);

        but_im = (Button) findViewById(R.id.but_im);
        next_add_2 = (Button) findViewById(R.id.next_add_2);
        next_add_3 = (Button) findViewById(R.id.next_add_3);

        arrow_back = (ImageButton) findViewById(R.id.arrow_back_lost);

        category_lost = (EditText) findViewById(R.id.category_lost);
        name_anim_lost = (EditText) findViewById(R.id.name_anim_lost);
        but_street_lost = (EditText) findViewById(R.id.but_street_lost);


        progressBar = (ProgressBar) findViewById(R.id.pb_lost);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        ref = database.getReference();
        myref = ref.child("Lost_animal").child(mAuth.getCurrentUser().getUid());
//        myref = ref.child("Users").child(mAuth.getCurrentUser().getUid()).child("email").setValue("все cool");

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

        Spinner spinner = findViewById(R.id.spinner);

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

        set_name.setVisibility(View.INVISIBLE);
        set_street.setVisibility(View.INVISIBLE);

        progressBar.setMax(3);
        arrow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==1){
                    back(set_image, set_name,set_street);
                    i--;
                    progressBar.setProgress(i);
                    System.out.println("все норм...");
                } else if(i==2){
                    i--;
                    progressBar.setProgress(i);
                    back(set_name, set_image,set_street);
                } else if(i==0){
                    progressBar.setProgress(i);
                    startActivity(new Intent(add_lost.this, Add.class));
                }
            }
        });
        but_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=1;
//                myref.child("category").setValue(category_lost.getText().toString());
//                myref.child("name").setValue(name_anim_lost.getText().toString());
//                System.out.println("its categoru: "+category_lost.getText().toString());

                progressBar.setProgress(i);
                set_image.setVisibility(View.INVISIBLE);
                set_name.setVisibility(View.VISIBLE);
                set_street.setVisibility(View.INVISIBLE);

            }
        });
        next_add_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=2;
//                myref.child("street").setValue(but_street_lost.getText().toString());
                myref.child("category").setValue(category_lost.getText().toString());
                myref.child("name").setValue(name_anim_lost.getText().toString());
                myref.child("email_user").setValue(mAuth.getCurrentUser().getUid());

                progressBar.setProgress(i);
                set_image.setVisibility(View.INVISIBLE);
                set_name.setVisibility(View.INVISIBLE);
                set_street.setVisibility(View.VISIBLE);
            }
        });
        next_add_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myref.child("street").setValue(but_street_lost.getText().toString());
                startActivity(new Intent(add_lost.this, AfterAdd.class));
            }
        });

    }

    private void back(LinearLayout lin_hidden, LinearLayout lin_not_hidden, LinearLayout lin_not_hidden2) {
        lin_hidden.setVisibility(View.VISIBLE);
        lin_not_hidden.setVisibility(View.INVISIBLE);
        lin_not_hidden2.setVisibility(View.INVISIBLE);

    }
}