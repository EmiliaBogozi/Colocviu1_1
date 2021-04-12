package ro.pub.cs.systems.eim.colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Colocviu1_1MainActivity extends AppCompatActivity {

    private TextView buttonPress;
    private Button north, east, west, south;
    private Button navigate_to_secondary_activity;

    private int number_of_clicks;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String text = buttonPress.getText().toString();
            if(text != "")
                text = text + ", ";
            if(v.getId() == R.id.north_button) {
                number_of_clicks++;
                text = text + "North";
                buttonPress.setText(text);
            }
            if(v.getId() == R.id.west_button) {
                number_of_clicks++;
                text = text + "West";
                buttonPress.setText(text);
            }
            if(v.getId() == R.id.south_button) {
                number_of_clicks++;
                text = text + "South";
                buttonPress.setText(text);
            }
            if(v.getId() == R.id.east_button) {
                number_of_clicks++;
                text = text + "East";
                buttonPress.setText(text);
            }
        }
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Log.d(Constants.TAG, "onCreate() method was invoked");

            buttonPress = (TextView)findViewById(R.id.buttons_press);
        buttonPress.setText("");

        number_of_clicks = 0;

        north = (Button)findViewById(R.id.north_button);
        north.setOnClickListener(buttonClickListener);

        west = (Button)findViewById(R.id.west_button);
        west.setOnClickListener(buttonClickListener);

        south = (Button)findViewById(R.id.south_button);
        south.setOnClickListener(buttonClickListener);

        east = (Button)findViewById(R.id.east_button);
        east.setOnClickListener(buttonClickListener);

        navigate_to_secondary_activity = (Button)findViewById(R.id.navigate_tp_secondary_activity);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.d(Constants.TAG, "onSaveInstanceState() method was invoked");
        savedInstanceState.putInt(Constants.COUNT_CLICKS, number_of_clicks);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(Constants.TAG, "onRestoreInstanceState() method was invoked");
        if(savedInstanceState.containsKey(Constants.COUNT_CLICKS))
        {
            number_of_clicks = savedInstanceState.getInt(Constants.COUNT_CLICKS);
            Log.d(Constants.TAG, String.valueOf(number_of_clicks));
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(Constants.TAG, "onRestart() method was invoked");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(Constants.TAG, "onStart() method was invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(Constants.TAG, "onStop() method was invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Constants.TAG, "onResume() method was invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Constants.TAG, "onPause() method was invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(Constants.TAG, "onDestroy() method was invoked");
    }

}