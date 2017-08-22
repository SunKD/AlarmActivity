package itad230.alarmclock;

import android.content.Intent;
import android.os.CountDownTimer;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private String length, message;
    private int lengthSecond;
    private EditText EXTRA_LENGTH, EXTRA_MESSAGE;
    private TextView TIMER;
    private final String Tag = "Timer Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Tag, "Timer app Created");
        setContentView(R.layout.activity_timer);

        EXTRA_LENGTH = (EditText)findViewById(R.id.Second);
        EXTRA_MESSAGE = (EditText)findViewById(R.id.Message);
       /* TIMER = (TextView)findViewById(R.id.timeview);*/
    }

    public void onSetTimerClicked(View v) {
        Log.d(Tag, "SetTimer button Clicked");
        length = EXTRA_LENGTH.getText().toString();
        message = EXTRA_MESSAGE.getText().toString();
        lengthSecond = Integer.parseInt(length);
        startTimer(message, lengthSecond);

       /* CountDownTimer time = new CountDownTimer((long) lengthSecond*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TIMER.setText("" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                TIMER.setText(message);
            }
        }.start();*/
    }

    public void startTimer(String message, int seconds) {
        Log.d(Tag, "Timer started");
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, lengthSecond)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void cancel(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Tag, "App Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Tag, "App on Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Tag, "App on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Tag, "App Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Tag, "App Destroyed");
    }
}
