package com.example.myapplication.add;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Add;
import com.example.myapplication.AfterAdd;
import com.example.myapplication.R;
import com.example.myapplication.model_animal.animal_find;
import com.example.myapplication.model_animal.animal_give;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class add_find extends AppCompatActivity {
    Button next;
    View bottom_layout;

    Button but_im;
    Button next_add_2;
    Button next_add_3;

    ImageButton arrow_back;
    ImageButton ibAddPhoto_find;

    ImageView ivPhoto_find;

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

    String category, metro, street;


    ProgressBar progressBar;

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_find);


        set_image = (LinearLayout) findViewById(R.id.set_image_give);
        set_name = (LinearLayout) findViewById(R.id.set_name_give);

        but_im = (Button) findViewById(R.id.but_im_give);
        next_add_2 = (Button) findViewById(R.id.next_add_give2);

        arrow_back = (ImageButton) findViewById(R.id.arrow_back_give);
        ibAddPhoto_find = (ImageButton) findViewById(R.id.ibAddPhoto_find);

        ivPhoto_find = (ImageView) findViewById(R.id.ivPhoto_find);

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
                        metro = item.toString();
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
                    startActivity(new Intent(add_find.this, Add.class));
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
//                i=2;
                category = category_give.getText().toString();
                street = but_street_give.getText().toString();
                FirebaseDatabase.getInstance().getReference().child("Find_animal").push().setValue(
                        new animal_find(FirebaseAuth.getInstance().getCurrentUser().getEmail(),
                                upload_uri.toString(),
                                category,
                                metro,
                                street)
                );
                progressBar.setProgress(i);
                startActivity(new Intent(add_find.this, AfterAdd.class));
            }
        });
//        next_add_3.setOnClickListener();

    }

    private void back(LinearLayout lin_hidden, LinearLayout lin_not_hidden) {
        lin_hidden.setVisibility(View.VISIBLE);
        lin_not_hidden.setVisibility(View.INVISIBLE);

    }
    public void OnClickChooseImage(View view){
        getImage();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && data.getData()!=null){
            if(resultCode == RESULT_OK){
                Log.d("MyLog", "IMAGE URI" + data.getData());
//                upload_image();
                System.out.println(ivPhoto_find.getDrawable());
                ivPhoto_find.setImageURI(data.getData());
                upload_image();
                System.out.println(ivPhoto_find.getDrawable());
            }
        }
    }
    private void upload_image(){
        System.out.println(ivPhoto_find.getDrawable());
        Bitmap bitmap = ((BitmapDrawable) ivPhoto_find.getDrawable()).getBitmap();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] byte_array = baos.toByteArray();
        final StorageReference myref = storageRef.child(System.currentTimeMillis()+"my_image");
        UploadTask uploadTask = myref.putBytes(byte_array);
        Task<Uri> task = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
            @Override
            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                return myref.getDownloadUrl();
            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                upload_uri = task.getResult();
            }
        });

    }

    private void getImage(){
        Intent intentChooser = new Intent();
        intentChooser.setType("image/");
        intentChooser.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intentChooser, 1);
    }

}