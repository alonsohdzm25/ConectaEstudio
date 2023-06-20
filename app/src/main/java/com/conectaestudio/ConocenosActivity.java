package com.conectaestudio;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.conectaestudio.databinding.ActivityConocenosBinding;

public class ConocenosActivity extends AppCompatActivity {

    private MediaPlayer mediaplayer;

    private ActivityConocenosBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConocenosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.video.loadUrl("https://www.facebook.com/watch/?extid=WA-UNK-UNK-UNK-AN_GK0T-GK1C&mibextid=2Rb1fB&v=754200452653021");

        mediaplayer = MediaPlayer.create(this, R.raw.entrevista);

        binding.btnEntrevista.setOnClickListener(view -> {
            mediaplayer.start();
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mediaplayer.stop();
        mediaplayer = MediaPlayer.create(this, R.raw.entrevista);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
