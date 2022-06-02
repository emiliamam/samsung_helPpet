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
import androidx.core.content.ContextCompat;

import com.example.myapplication.Add;
import com.example.myapplication.AfterAdd;
import com.example.myapplication.R;
import com.example.myapplication.model_animal.animal_find;
import com.example.myapplication.model_animal.animal_give;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class add_give extends AppCompatActivity {
    Button next;
    View bottom_layout;

    Button but_im;
    Button next_add_2;
    Button next_add_3;

    ImageButton arrow_back_find;

    LinearLayout set_image;
    LinearLayout set_name;
    LinearLayout set_street;

    ImageView ivPhoto;
    ImageButton ibAddPhoto_give;

    EditText category_find;
    EditText name_find;
    EditText description_find;
    EditText street_find;

    String category, metro, street, name, description;

    private Uri upload_uri;


    ProgressBar progressBar;
    private StorageReference storageRef;

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_give);


        set_image = (LinearLayout) findViewById(R.id.set_image_find);
        set_name = (LinearLayout) findViewById(R.id.set_name_find);
        set_street = (LinearLayout) findViewById(R.id.set_street_find);

        but_im = (Button) findViewById(R.id.but_im_find);
        next_add_2 = (Button) findViewById(R.id.next_add_find2);
        next_add_3 = (Button) findViewById(R.id.next_add_give3);

        category_find = (EditText) findViewById(R.id.category_find);
        name_find = (EditText) findViewById(R.id.name_anim_find);
        description_find = (EditText) findViewById(R.id.about_anim_find);
        street_find = (EditText) findViewById(R.id.street_find);

        arrow_back_find = (ImageButton) findViewById(R.id.arrow_back_find);
        ibAddPhoto_give = (ImageButton) findViewById(R.id.ibAddPhoto_give);

        ivPhoto = (ImageView) findViewById(R.id.ivPhoto_give);

        progressBar = (ProgressBar) findViewById(R.id.pb_find);

        storageRef = FirebaseStorage.getInstance().getReference("Image_give");


        set_name.setVisibility(View.INVISIBLE);
        set_street.setVisibility(View.INVISIBLE);

        progressBar.setMax(3);

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

        Spinner spinner = findViewById(R.id.spinner_find);

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
        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                        Object item = parent.getItemAtPosition(pos);
                        metro=item.toString();

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

        stringListAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(stringListAdapter);
        spinner.setSelection(countries.length);

        arrow_back_find.setOnClickListener(new View.OnClickListener() {
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
                set_street.setVisibility(View.INVISIBLE);


            }
        });
        next_add_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = category_find.getText().toString();
                name = name_find.getText().toString();
                description = description_find.getText().toString();
                if(category.isEmpty()){
                    category_find.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.red));
                }else if(name.isEmpty()){
                    name_find.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.red));
                }else if(description.isEmpty()){
                    description_find.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.red));
                }else {
                    i = 2;
                    progressBar.setProgress(i);
                    set_image.setVisibility(View.INVISIBLE);
                    set_name.setVisibility(View.INVISIBLE);
                    set_street.setVisibility(View.VISIBLE);

                }

            }
        });next_add_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                street = street_find.getText().toString();

                if (street.isEmpty()) {
                    street_find.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), R.color.red));
                } else {

                    FirebaseDatabase.getInstance().getReference().child("Give_animal").push().setValue(
                            new animal_give(FirebaseAuth.getInstance().getCurrentUser().getEmail(),
                                    upload_uri.toString(),
                                    category,
                                    name,
                                    description,
                                    metro,
                                    street)
                    );
                    startActivity(new Intent(add_give.this, AfterAdd.class));
                }

            }
        });

    }

    private void back(LinearLayout lin_hidden, LinearLayout lin_not_hidden, LinearLayout lin_not_hidden2) {
        lin_hidden.setVisibility(View.VISIBLE);
        lin_not_hidden.setVisibility(View.INVISIBLE);
        lin_not_hidden2.setVisibility(View.INVISIBLE);

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
                System.out.println(ivPhoto.getDrawable());
                ivPhoto.setImageURI(data.getData());
                upload_image();
                System.out.println(ivPhoto.getDrawable());
            }
        }
    }
    private void upload_image(){
        System.out.println(ivPhoto.getDrawable());
        Bitmap bitmap = ((BitmapDrawable) ivPhoto.getDrawable()).getBitmap();

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