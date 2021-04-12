package ro.pub.cs.systems.eim.colocviu1_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Colocviu1_1SecondaryActivity extends AppCompatActivity {

    private Button registerButton, cancelButton;
    private TextView instr;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()) {
                case R.id.register_button:
                    setResult(RESULT_OK, intent);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, intent);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_1_secondary);

        instr = (TextView)findViewById(R.id.instr);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.INSTRUCTIONS)) {
            String instructions = intent.getExtras().getString(Constants.INSTRUCTIONS);
            instr.setText(instructions);
        }

        registerButton = (Button)findViewById(R.id.register_button);
        registerButton.setOnClickListener(buttonClickListener);

        cancelButton = (Button)findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(buttonClickListener);
    }
}