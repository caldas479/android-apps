package pt.ulisboa.tecnico.cmov.notepad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ComponentActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<Note> noteList;

    private static final int REQUEST_CREATE_NOTE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        noteList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        Button createNoteButton = findViewById(R.id.button_id);

        createNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateNoteActivity.class);
                startActivityForResult(intent, REQUEST_CREATE_NOTE);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Note selectedNote = noteList.get(position);
                Intent intent = new Intent(MainActivity.this, ReadNoteActivity.class);
                intent.putExtra("title", selectedNote.getTitle());
                intent.putExtra("text", selectedNote.getText());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CREATE_NOTE && resultCode == RESULT_OK && data != null) {
            String title = data.getStringExtra("title");
            String text = data.getStringExtra("text");
            Note newNote = new Note(title, text);
            noteList.add(newNote);
            adapter.add(title);
        }
    }
}
