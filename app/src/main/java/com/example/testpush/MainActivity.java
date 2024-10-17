package com.example.testpush;

import android.os.Bundle;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseObject;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Parse: Saving your first data object on Back4App
        ParseObject person = new ParseObject("Person");
        person.put("name", "John Snow");
        person.put("age", 27);
        person.saveInBackground(e -> {
            if (e == null) {
                Log.d("Parse", "Object saved successfully.");
            } else {
                e.printStackTrace();
            }
        });
    }
}
