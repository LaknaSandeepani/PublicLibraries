package lk.viva.publiclibraries;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    //Variables

    EditText fname, lname, email, editEnrollNo, editCardNo, txt_pwd, txt_confirmpwd;
    RadioGroup radioGroup;
    RadioButton RbtnGender;
    Button register;
    private Spinner userType;
//    private View type;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        fname = findViewById(R.id.txtfname);
        lname = findViewById(R.id.txtlname);
        radioGroup = findViewById(R.id.rb_gender);
        editEnrollNo = findViewById(R.id.editEnrollNo);
        editCardNo = findViewById(R.id.editCardNo);
        txt_pwd = findViewById(R.id.txt_pwd);
        txt_confirmpwd = findViewById(R.id.txt_confirmpwd);
        email = findViewById(R.id.txt_email);
        userType = (Spinner) findViewById(R.id.userType);
        register = findViewById(R.id.btn_register);
//
        List<String> list = new ArrayList<>();
        list.add("Select Account Type");
        list.add("User");
        list.add("Admin");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userType.setAdapter(adapter);
        userType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).toString().equals("Admin")) {

                    fname.setEnabled(true);
                    lname.setEnabled(true);
                    radioGroup.setEnabled(true);
                    editEnrollNo.setEnabled(true);
                    editCardNo.setEnabled(true);
                    txt_pwd.setEnabled(true);
                    txt_confirmpwd.setEnabled(true);
                    email.setEnabled(true);
                    register.setEnabled(true);


                } else if (parent.getItemAtPosition(position).toString().equals("User")) {

                    fname.setEnabled(true);
                    lname.setEnabled(true);
                    radioGroup.setEnabled(true);
                    editEnrollNo.setEnabled(true);
                    editCardNo.setEnabled(true);
                    txt_pwd.setEnabled(true);
                    txt_confirmpwd.setEnabled(true);
                    email.setEnabled(true);
                    register.setEnabled(true);


                } else {

                    fname.setEnabled(false);
                    lname.setEnabled(false);
//                    for (int i = 0; i < radioGroup.getChildCount(); i++) {
//                        radioGroup.getChildAt(i).setEnabled(false);
//                    }
                    editEnrollNo.setEnabled(false);
                    editCardNo.setEnabled(false);
                    txt_pwd.setEnabled(false);
                    txt_confirmpwd.setEnabled(false);
                    email.setEnabled(false);
                    register.setEnabled(false);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //
        register.setOnClickListener(view -> {
            rootNode = FirebaseDatabase.getInstance();
            reference = rootNode.getReference("users");

            if (!fname.getText().toString().isEmpty() && !lname.getText().toString().isEmpty() && !editCardNo.getText().toString().isEmpty()) {

                String Fname = fname.getText().toString();
                String Lname = lname.getText().toString();
                int rID = radioGroup.getCheckedRadioButtonId();
                RbtnGender = findViewById(rID);
                String Gender = RbtnGender.getText().toString();
                String EnrollNo = editEnrollNo.getText().toString();
                String CardNo = editCardNo.getText().toString();
                String Email = email.getText().toString();
                String Password = txt_pwd.getText().toString();
                String Confirmpwd = txt_confirmpwd.getText().toString();
                String Type = userType.getSelectedItem().toString();



                UserHelperClass helperClass = new UserHelperClass(Fname, Lname, Gender, Email, EnrollNo, CardNo, Password, Confirmpwd, Type);
                reference.child(EnrollNo).setValue(helperClass);
                Toast.makeText(getApplicationContext(),
                        "Login successful!!",
                        Toast.LENGTH_LONG)
                        .show();


                // if sign-in is successful
                // intent to home activity
                Intent intent
                        = new Intent(RegisterActivity.this,
                        HomescreenActivity.class);
                startActivity(intent);

            } else {

                Toast.makeText(RegisterActivity.this, "All Fields are required", Toast.LENGTH_SHORT).show();
            }


        });
    }

}