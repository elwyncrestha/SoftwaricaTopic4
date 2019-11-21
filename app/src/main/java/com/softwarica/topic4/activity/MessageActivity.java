package com.softwarica.topic4.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.softwarica.topic4.R;

public class MessageActivity extends AppCompatActivity {

    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        this.tvMessage = findViewById(R.id.tvMessage);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.tvMessage.setText(bundle.getString("message"));
        } else {
            Toast.makeText(getApplicationContext(), "No message!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
