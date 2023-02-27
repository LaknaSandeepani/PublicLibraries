package lk.viva.publiclibraries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AdminTasksActivity extends AppCompatActivity {
    Button btnadd, btnupdate, btnremove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_tasks);

        btnadd = (Button) findViewById(R.id.addBook);
        btnupdate = (Button) findViewById(R.id.updateBook);
        btnremove = (Button) findViewById(R.id.removeBook);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddBooks();
            }

        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateBooks();
            }

        });
        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RemoveBooks();
            }

        });
    }
    private void AddBooks() {
        Intent intent = new Intent(this, AdminAddBookActivity.class);
        startActivity(intent);
    }
    private void UpdateBooks() {
        Intent intent = new Intent(this, AdminUpdateBookActivity.class);
        startActivity(intent);
    }
    private void RemoveBooks() {
        Intent intent = new Intent(this, AdminRemoveBookActivity.class);
        startActivity(intent);
    }
}