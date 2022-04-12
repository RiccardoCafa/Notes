package br.com.senaicimatec.sqllite02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    private NotaDAO notaContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.btn_save);

        notaContext = new NotaDAO(this);

        ArrayList<Nota> note = notaContext.get();

        // Lookup the recyclerview in activity layout
        RecyclerView rvNote = (RecyclerView) findViewById(R.id.note_list);

        // Create adapter passing in the sample user data
        NoteAdapter adapter = new NoteAdapter(note);
        // Attach the adapter to the recyclerview to populate items
        rvNote.setAdapter(adapter);
        // Set layout manager to position the items
        rvNote.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }

    public void Add(View view) {
        Intent intent = new Intent(this, ActivityInsert.class);
        startActivity(intent);
    }

}