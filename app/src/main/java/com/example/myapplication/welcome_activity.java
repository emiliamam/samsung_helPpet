package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.util.List;

public class welcome_activity extends AppCompatActivity {
    Button next;
    View bottom_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    {
                        PermissionListener permissionlistener = new PermissionListener() {
                            @Override
                            public void onPermissionGranted() {
                                startActivity(new Intent(welcome_activity.this, map.class));
                            }

                            @Override
                            public void onPermissionDenied(List<String> deniedPermissions) {
                                Toast.makeText(welcome_activity.this, "Доступ запрещен\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                            }


                        };
                        TedPermission.create()
                            .setPermissionListener(permissionlistener)
                            .setDeniedMessage("Для просмотра дальше необходимо предоставить разрешение")
                            .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                            .check();
                    }
                }
            }
        };
        thread.start();
    }
}