package itad230.alarmclock;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

import static android.R.attr.bitmap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //when timer button clicked
    public void onTimerClicked(View v){
        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
    }
    //when alarm clicked
    public void onAlarmClicked(View v){
        Intent intent = new Intent(this, AlarmActivity.class);
        startActivity(intent);
    }
    //when camera clicked
    public void onCameraClicked(View v){
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

}
