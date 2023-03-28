package com.example.userstorage2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.textservice.TextInfo;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private Button goToListView;
    private Button addUser;
    private TextInputEditText firstname;
    private TextInputEditText lastname;
    private TextInputEditText email;

    private RadioGroup degreeGroup;
    private RadioButton degree;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname = findViewById(R.id.editFirstname);
        lastname = findViewById(R.id.editLastName);
        email = findViewById(R.id.editEmail);
        degreeGroup = findViewById(R.id.degreeGroup);

        UserStorage s = UserStorage.getInstance();

        context = MainActivity.this;

        s.loadUsers(context);
        addUser = findViewById(R.id.addUser);
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int degreeId = degreeGroup.getCheckedRadioButtonId();
                degree = findViewById(degreeId);
                s.addUser(new User(firstname.getText().toString(), lastname.getText().toString(), email.getText().toString(), degree.getText().toString()));
                s.saveUsers(context);
            }
        }
        );

        goToListView = findViewById(R.id.listUsers);
        goToListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity();
            }
        });


    }
    public void checkButton(View view){
        int degreeId = degreeGroup.getCheckedRadioButtonId();
        degree = findViewById(degreeId);
        Toast.makeText(this, degree.getText(), Toast.LENGTH_SHORT);
    }
    private void changeActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}