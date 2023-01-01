package lk.viva.publiclibraries;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SeatActivity extends AppCompatActivity {
    EditText name,nic,dateEdt,timeFrom,timeTo;
    RadioGroup radioGroup;
    RadioButton RbtnGender;
    Spinner room,seat;
    DatePicker Date;
    TimePicker FromTime, ToTime;
    Button Reserve;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);

        name = findViewById(R.id.txtname);
        radioGroup = findViewById(R.id.rb_gender);
        nic = findViewById(R.id.txtnic);
        room = findViewById(R.id.sp_room);
        seat = findViewById(R.id.sp_seat);
//        Date = findViewById(R.id.date);
//        FromTime = findViewById(R.id.from_time);
//        ToTime = findViewById(R.id.to_time);
        Reserve = findViewById(R.id.btn_reserve);
        dateEdt = findViewById(R.id.idEdtDate);
        timeFrom = findViewById(R.id.idFromTime);
        timeTo = findViewById(R.id.idToTime);
        timeTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(SeatActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        timeTo.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
        timeFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(SeatActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        timeFrom.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });
        dateEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        SeatActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our edit text.
                                dateEdt.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });


        Reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("seat");

                if (!name.getText().toString().isEmpty() && !nic.getText().toString().isEmpty() && nic.getText().toString().length() >= 9) {

                    String Name = name.getText().toString();
                    String Nic = nic.getText().toString();
                    String Room = (String) room.getSelectedItem();
                    String Seat = (String) seat.getSelectedItem();
                    String Date = dateEdt.getText().toString();
                    String FromTime = timeFrom.getText().toString();
                    String ToTime = timeTo.getText().toString();
                    int rID = radioGroup.getCheckedRadioButtonId();
                    RbtnGender =findViewById(rID);
                    String Gender=RbtnGender.getText().toString();




                    SeatClass seatClass = new SeatClass(Name,Gender,Nic,Room,Seat,Date,FromTime,ToTime);
                    reference.child(Nic).setValue(seatClass);
                    Toast.makeText(getApplicationContext(),
                            "Login successful!!",
                            Toast.LENGTH_LONG)
                            .show();


                    // if sign-in is successful
                    // intent to home activity
                    Intent intent
                            = new Intent(SeatActivity.this,
                            WaitActivity.class);
                    startActivity(intent);

                } else {
                    if(nic.getText().toString().length() < 9 && !name.getText().toString().isEmpty())
                    {
                        Toast.makeText(SeatActivity.this, "NIC is not Valid", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(SeatActivity.this, "All Fields are required", Toast.LENGTH_SHORT).show();
                    }
                    return;
                }



            }
        });
    }
}