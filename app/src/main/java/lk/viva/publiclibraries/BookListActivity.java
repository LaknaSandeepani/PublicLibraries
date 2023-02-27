package lk.viva.publiclibraries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


import java.util.ArrayList;

public class BookListActivity extends AppCompatActivity   {

    RecyclerView recyclerView;
    DatabaseReference database;
    BooksAdapter booksAdapter;
    ArrayList<Books>list;
    StorageReference storageReference;
    SearchView searchView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        //Search view - not working
        searchView = findViewById(R.id.searchview);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                filterList(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return true;
            }

            private void filterList(String s) {
                FirebaseRecyclerOptions<Books> options =
                        new FirebaseRecyclerOptions.Builder<Books>()
                                .setQuery(FirebaseDatabase.getInstance().getReference().child("books").orderByChild("title").startAt(s).endAt(s+"\uf8ff"), Books.class)
                                .build();

                booksAdapter = new BooksAdapter(options);
                booksAdapter.startListening();
                recyclerView.setAdapter(booksAdapter);



            }
        });
        // for search end
        storageReference = FirebaseStorage.getInstance().getReference();
        recyclerView = findViewById(R.id.booklist);
        database = FirebaseDatabase.getInstance().getReference("books");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        booksAdapter = new BooksAdapter(this,list);
        recyclerView.setAdapter(booksAdapter);


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for ( DataSnapshot  dataSnapshot: snapshot.getChildren())
                {
                    Books books = dataSnapshot.getValue(Books.class);
                    list.add(books);
                }
                booksAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

}