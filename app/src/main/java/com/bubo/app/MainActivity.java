package com.bubo.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.debug("MainActivity onCreate called");
        
        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        textView.setText("Bubo App");
        Logger.info("Text view set to Bubo App");
        
        button.setOnClickListener(v -> {
            Logger.debug("Button clicked");
            textView.setText("Bubo initialized!");
            Logger.info("Text view updated to Bubo initialized!");
        });
    }
}