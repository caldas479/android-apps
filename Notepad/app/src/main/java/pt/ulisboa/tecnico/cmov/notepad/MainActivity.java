package pt.ulisboa.tecnico.cmov.notepad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;

import androidx.activity.ComponentActivity;


import java.util.List;

// ListNotesActivity
public class MainActivity extends ComponentActivity {

    private List<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadNotes();

        Button createNoteButton = findViewById(R.id.button_id);

        createNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadNotes() {

        SharedPreferences sharedPreferences = getSharedPreferences("MyNotes", Context.MODE_PRIVATE);

    }

    private void saveNotes() {

        SharedPreferences sharedPreferences = getSharedPreferences("MyNotes", Context.MODE_PRIVATE);

    }

    private void addNoteToList(Note note) {
        noteList.add(note);
        saveNotes(); // Save the updated note list
    }
}
