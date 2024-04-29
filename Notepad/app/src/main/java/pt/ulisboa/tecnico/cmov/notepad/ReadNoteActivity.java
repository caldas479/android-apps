package pt.ulisboa.tecnico.cmov.notepad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.ComponentActivity;

public class ReadNoteActivity extends ComponentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_note);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("text");

        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);

        titleTextView.setText(title);
        descriptionTextView.setText(description);
    }
}
