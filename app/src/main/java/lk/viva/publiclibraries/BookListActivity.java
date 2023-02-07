package lk.viva.publiclibraries;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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
//    SearchView searchView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        // Assign FirebaseStorage instance to storageReference.
//        searchView = findViewById(R.id.searchview);
//        searchView.clearFocus();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                filerList(newText);
//                return true;
//            }
//        });
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

//    @Override
//    public void onItemClicked(int position) {
//        Intent intent = new Intent(BookListActivity.this, StoryActivity.class);
//        intent.putExtra("title",list.get(position).getTitle());
//        startActivity(intent);
//    }

//    private void filerList(String text) {
//        ArrayList<Books> filteredList = new ArrayList<>();
//        for (Books books : list){
//            if (books.getTitle().toLowerCase().contains(text.toLowerCase())) {
//                filteredList.add(books);
//            }
//
//        }
//        if (filteredList.isEmpty()) {
//            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
//        }else{
//
//            BooksAdapter.setFilteredList(filteredList);
//
//
//        }
//
//    }

}