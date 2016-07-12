package com.jewelmahmud.calculator.sensorslist;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    private AudioManager audioManager;
    private Button  ringing,
                    silent,
                    mode,
                    vibrate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ringing = (Button)findViewById(R.id.ring);
        vibrate = (Button)findViewById(R.id.vibrate);
        mode = (Button)findViewById(R.id.mode);
        silent = (Button)findViewById(R.id.silent);

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        //set the righ mode in vibrate.

        /**
         * VIBRATE MODE
         */
        vibrate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View sender){
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
                Toast.makeText(MainActivity.this, "Now in 'Vibrate' Mode.",Toast.LENGTH_SHORT).show();
            }

        });


        /**
         * RINGING MODE
         */
        ringing.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View sender){
                audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                Toast.makeText(MainActivity.this, "Now in 'RINGING' Mode.",Toast.LENGTH_SHORT).show();
            }

        });

        /**
         * RINGING MODE
         */
        silent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View sender) {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                Toast.makeText(MainActivity.this, "Now in 'SILENT' Mode.", Toast.LENGTH_SHORT).show();
            }

        });


        mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View sender) {

                int mode = audioManager.getRingerMode();

                if(mode == AudioManager.RINGER_MODE_NORMAL){
                    Toast.makeText(MainActivity.this, "NOW in 'Ringing' mode", Toast.LENGTH_SHORT).show();

                }else if(mode == AudioManager.RINGER_MODE_SILENT){
                    Toast.makeText(MainActivity.this, "NOW in 'Slient' mode", Toast.LENGTH_SHORT).show();

                }else if(mode == AudioManager.RINGER_MODE_VIBRATE){
                    Toast.makeText(MainActivity.this, "NOW in 'Vibrate' mode", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
