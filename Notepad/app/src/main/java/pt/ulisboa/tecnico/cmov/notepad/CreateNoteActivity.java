package pt.ulisboa.tecnico.cmov.notepad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.ComponentActivity;

public class CreateNoteActivity extends ComponentActivity {

    private EditText titleEditText;
    private EditText textEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_node);

        titleEditText = findViewById(R.id.titleEditText);
        textEditText = findViewById(R.id.textEditText);
        Button okButton = findViewById(R.id.okButton);
        Button cancelButton = findViewById(R.id.cancelButton);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelNote();
            }
        });
    }

    private void saveNote() {
        String title = titleEditText.getText().toString();
        String text = textEditText.getText().toString();

        Intent resultIntent = new Intent();
        resultIntent.putExtra("title", title);
        resultIntent.putExtra("text", text);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    private void cancelNote() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
