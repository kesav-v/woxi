package woxi.woxi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TogglerActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean running;

    public TogglerActivity() {
        running = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggler);
        addListener();
        setContent();


    }

    public void addListener() {
        Button button = (Button) findViewById(R.id.toggle);
        button.setOnClickListener(this);
    }

    public void setContent() {
        Button button = (Button) findViewById(R.id.toggle);
        TextView tv = (TextView) findViewById(R.id.message);
        if (running) {
            tv.setText("Woxi is currently\nRUNNING");
            tv.setGravity(Gravity.CENTER);
            button.setText("STOP WOXI");

            button.setBackgroundColor(Color.parseColor("#22313F"));

            final Intent myIntent = new Intent(this, MainActivity.class);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(myIntent);;
                }
            }, 93000);

        } else {
            tv.setText("Woxi is currently\nNOT RUNNING");
            button.setText("START WOXI!");
            button.setBackgroundColor(Color.parseColor("#BFBFBF"));
        }
    }

    @Override
    public void onClick(View v) {
        running = !running;
        setContent();
    }
}
