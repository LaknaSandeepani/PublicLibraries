package lk.viva.publiclibraries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ClickviewActivity extends AppCompatActivity {
    TextView txt_newtitle,txt_description;
    ImageView book_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickview);

        txt_newtitle = findViewById(R.id.txt_newtitle);
        book_image = findViewById(R.id.book_image);
        txt_newtitle.setText(getIntent().getExtras().getString("title"));
//        txt_description.setText(getIntent().getExtras().getString("description"));
        book_image.setImageURI(Uri.parse(getIntent().getExtras().getString("bookimage")));


    }
}