package itad230.alarmclock;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.widget.EditText;

public class AlarmActivity extends AppCompatActivity {

    private String hourstr, minutestr, message; //declare variables to get user inputs
    private EditText editHour, editMin, editMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        editHour = (EditText)findViewById(R.id.Hour);
        editMin = (EditText)findViewById(R.id.Minute);
        editMsg = (EditText)findViewById(R.id.Msg);
    }

    //when set Alarm clicked
    protected void onSetAlarmClicked(View v){
        hourstr = editHour.getText().toString();
        minutestr = editMin.getText().toString();
        message = editMsg.getText().toString();

        int hour = Integer.parseInt(hourstr);
        int min = Integer.parseInt(minutestr);

        //creating the Alarm
        createAlarm(message, hour, min);
    }

    //creating the alarm
    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    //when cancel button clicked
    public void cancel(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
