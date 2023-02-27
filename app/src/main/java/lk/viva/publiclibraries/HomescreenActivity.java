package lk.viva.publiclibraries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.ImageButton;

public class HomescreenActivity extends AppCompatActivity{
    ImageButton btnbooks, btneBooks, btnseat, btnstory, btnmore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        btnbooks = (ImageButton) findViewById(R.id.btn_books);
        btneBooks = (ImageButton) findViewById(R.id.btn_ebooks);
        btnseat = (ImageButton) findViewById(R.id.btn_seat);
        btnstory = (ImageButton) findViewById(R.id.btn_story);
        btnmore = (ImageButton) findViewById(R.id.btn_more);

        btnbooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenBooks();
            }
        });
        btneBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpeneBooks();
            }
        });
        btnseat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReserveSeat();
            }
        });
        btnstory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WriteStory();
            }
        });
        btnstory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenWhatsapp();
            }
        });
        btnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminActivities();
            }
        });
    }
    public void OpenBooks(){
        Intent intent = new Intent(this,BookListActivity.class);
        startActivity(intent);
    }
    public void OpeneBooks(){
        Intent intent = new Intent(this, eBooksActivity.class);
        startActivity(intent);
    }
    public void ReserveSeat(){
        Intent intent = new Intent(this, SeatActivity.class);
        startActivity(intent);
    }
    public void WriteStory(){
        Intent intent = new Intent(this, StoryActivity.class);
        startActivity(intent);
    }
    public void OpenWhatsapp(){
        Intent intentWhatsapp = new Intent(Intent.ACTION_VIEW);
        String url = "https://chat.whatsapp.com/https://chat.whatsapp.com/EE4nbbje9Wc3HHyH3xlfao";
        intentWhatsapp.setData(Uri.parse(url));
        intentWhatsapp.setPackage("com.whatsapp");
        startActivity(intentWhatsapp);

    }
    private void AdminActivities() {
        Intent intent = new Intent(this, AdminTasksActivity.class);
        startActivity(intent);
    }
}