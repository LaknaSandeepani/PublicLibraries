package lk.viva.publiclibraries;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity{
    //Variables

    EditText fname,lname,nic,address,phone,email;
    RadioGroup radioGroup;
    RadioButton RbtnGender;
    Spinner status,district,library;
    Button register;
    FirebaseDatabase rootNode;
    DatabaseReference reference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        fname = findViewById(R.id.txtfname);
        lname = findViewById(R.id.txtlname);
        nic = findViewById(R.id.txtnic);
        address = findViewById(R.id.txtaddress);
        phone = findViewById(R.id.txt_phone);
        email = findViewById(R.id.txt_email);
        radioGroup = findViewById(R.id.rb_gender);
        status = findViewById(R.id.sp_status);
        district = findViewById(R.id.sp_district);
        library = findViewById(R.id.sp_library);
        register = findViewById(R.id.btn_register);


        register.setOnClickListener(view -> {
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("users");

            if (!fname.getText().toString().isEmpty() && !lname.getText().toString().isEmpty() && !nic.getText().toString().isEmpty() && nic.getText().toString().length() >= 9 && !address.getText().toString().isEmpty() && !phone.getText().toString().isEmpty() && !email.getText().toString().isEmpty()) {

                String Fname = fname.getText().toString();
                String Lname = lname.getText().toString();
                int rID = radioGroup.getCheckedRadioButtonId();
                RbtnGender =findViewById(rID);
                String Gender=RbtnGender.getText().toString();
                String Nic = nic.getText().toString();
                String Address = address.getText().toString();
                String Phone = phone.getText().toString();
                String Email = email.getText().toString();
                String Status = (String) status.getSelectedItem();
                String District = (String) district.getSelectedItem();
                String Library = (String) library.getSelectedItem();



                UserHelperClass helperClass = new UserHelperClass(Fname,Lname,Gender,Nic,Address,Phone,Email,Status,District,Library);
                reference.child(Nic).setValue(helperClass);
                Toast.makeText(getApplicationContext(),
                        "Login successful!!",
                        Toast.LENGTH_LONG)
                        .show();


                // if sign-in is successful
                // intent to home activity
                Intent intent
                        = new Intent(RegisterActivity.this,
                        WaitActivity.class);
                startActivity(intent);

            } else {
                if(nic.getText().toString().length() < 9 && !fname.getText().toString().isEmpty() && !lname.getText().toString().isEmpty())
                {
                    Toast.makeText(RegisterActivity.this, "NIC is not Valid", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RegisterActivity.this, "All Fields are required", Toast.LENGTH_SHORT).show();
                }
            }



            });
    }
}