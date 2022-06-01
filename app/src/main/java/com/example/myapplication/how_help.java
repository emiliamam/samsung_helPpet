package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class how_help extends AppCompatActivity {
    Button next;
    View bottom_layout;

    Button but_begin_vol;
    Button but_go_priut;
    Button but_raspr;
    Button but_photo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_help);

        but_begin_vol = (Button) findViewById(R.id.but_begin_vol);
        but_go_priut = (Button) findViewById(R.id.but_go_priut);
        but_raspr = (Button) findViewById(R.id.but_raspr);
        but_photo = (Button) findViewById(R.id.but_photo);



        Toast.makeText(getApplicationContext(), "Коснитесь, чтобы узнать больше",
                Toast.LENGTH_LONG).show();
        but_begin_vol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder albuild = new AlertDialog.Builder(how_help.this);
                albuild.setMessage("Чтобы стать волонтером, можно обратиться в любой приют, а также есть фонд помощи РЭЙ(от фонда есть обучение зооволонтерам, всё бесплатно)").setCancelable(false)
                        .setPositiveButton("Спасибо!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert = albuild.create();
                alert.setTitle("Вы можете стать волонтером");
                alert.show();
            }
        });
        but_go_priut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder albuild = new AlertDialog.Builder(how_help.this);
                albuild.setMessage("Список приютов:" + "\n" +
                        "1)Городской приют для собак в Химках " + "\n" +
                        "2)Приют и фонд помощи животным «Ника» в Зеленограде" + "\n" +
                        "3)Приют для собак «Красная сосна»" + "\n" +
                        "4)Истринский район, приют Лесной" + "\n" +
                        "5)Частный приют «Зов предков» в Одинцовском районе" + "\n" +
                        "6)Приют для собак и кошек в Некрасовке" + "\n" +
                        "7)район Новогиреево, приют Зоорассвет" + "\n" +
                        "8)Муниципальный приют для собак Get Dog, Химки" + "\n" +
                        "9)Частный приют для кошек и собак «Верные друзья»" + "\n" +
                        "10)Ленинский район, Московская область, приют Домашний" + "\n" +
                        "11)Приют для кошек и собак «Умка»" + "\n" +
                        "12)Лесной Городок,приют «Дубовая роща»" + "\n" +
                        "13)Район Останкино,Кожуховский муниципальный приют" + "\n" +
                        "14)Приют собак в Щербинке" + "\n" +
                        "15)город Черноголовка, Московская область, Республика друг" + "\n" +
                        "16)Приют «Муркоша» в Медведково.").setCancelable(false)
                        .setPositiveButton("Спасибо!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert = albuild.create();
                alert.setTitle("Вы можете ездить в приюты");
                alert.show();
            }
        });
        String str = "выкладывать объявление, перерепост в социальных сетях, привлекать к участию добрых дел друзей и знакомых";
        but_raspr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder albuild = new AlertDialog.Builder(how_help.this);
                albuild.setMessage("Вы можете выкладывать объявления о найденных бездомных животных в helPet, делать перерепосты в социальных сетях, привлекать к участию добрых дел друзей и знакомых")
                        .setCancelable(false)
                        .setPositiveButton("Спасибо!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert = albuild.create();
                alert.setTitle("Распространение информации");
                alert.show();
            }
        });
        but_photo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder albuild = new AlertDialog.Builder(how_help.this);
                albuild.setMessage("вы можете заняться фотографированием подопечных приютов и реабилитационных центров. Хорошие фото привлекают внимание людей и тем самым наши друзья быстрее найдут себе дом")
                        .setCancelable(false)
                        .setPositiveButton("Спасибо!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        });
                AlertDialog alert = albuild.create();
                alert.setTitle("Распространение информации");
                alert.show();
            }
        });
    }
}