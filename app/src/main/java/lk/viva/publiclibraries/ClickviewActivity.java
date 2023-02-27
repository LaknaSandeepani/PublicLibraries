package lk.viva.publiclibraries;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

public class ClickviewActivity extends AppCompatActivity {
    TextView txt_newtitle;
    ImageView book_image;



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clickview);

        txt_newtitle = findViewById(R.id.txt_newtitle);
        book_image = findViewById(R.id.book_image);
        txt_newtitle.setText(getIntent().getExtras().getString("title"));
//        txt_description.setText(getIntent().getExtras().getString("description"));
//        book_image.setImageURI(Uri.parse(getIntent().getExtras().getString("bookimage")));

        ImageView imageView = findViewById(R.id.book_image);
        String bookimage = getIntent().getStringExtra("bookimage");
        Glide.with(this)
                .load(bookimage)
                .into(imageView);
//    ToDo - not working......
        imageView.setOnTouchListener(new View.OnTouchListener() {
            private float lastX;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        lastX = event.getRawX();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float dx = event.getRawX() - lastX;
                        float x = v.getX() + dx;
                        if (x > 0 && x < v.getWidth() - v.getMeasuredWidth()) {
                            v.setX(x);
                        }
                        lastX = event.getRawX();
                        break;
                }
                return true;
            }
        });








    }
}