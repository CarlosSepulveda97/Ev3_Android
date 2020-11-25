package com.example.ev3_carlos_sepulveda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class Menu_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);
        getSupportActionBar().hide();

        VideoView videoview = (VideoView) findViewById(R.id.videoView2);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
        videoview.setVideoURI(uri);

        videoview.start();

    }

    public void gestionar(View v){
        Intent intent = new Intent(this, Firebase_act.class);
        startActivity(intent);
    }

    public void promociones(View v){
        Intent intent = new Intent(this, Promociones_act.class);
        startActivity(intent);
    }


}