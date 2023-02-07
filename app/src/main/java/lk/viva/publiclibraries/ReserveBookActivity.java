package lk.viva.publiclibraries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ReserveBookActivity extends AppCompatActivity {
    Button btn_reserve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_book);

        btn_reserve = findViewById(R.id.idBtnborrow);

        btn_reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Openit();
            }
        });
    }
    public void Openit(){
        Intent intent = new Intent(this,AfterReserveActivity.class);
        startActivity(intent);
    }
}