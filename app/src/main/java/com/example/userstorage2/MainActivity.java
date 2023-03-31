package com.example.userstorage2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button goToListView;
    private Button addUser;
    private TextInputEditText firstname;
    private TextInputEditText lastname;
    private TextInputEditText email;
    private RadioGroup degreeGroup;
    private RadioButton degree;
    private CheckBox kandi;
    private CheckBox di;
    private CheckBox phd;
    private CheckBox sMaster;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname = findViewById(R.id.editFirstname);
        lastname = findViewById(R.id.editLastName);
        email = findViewById(R.id.editEmail);
        degreeGroup = findViewById(R.id.degreeGroup);
        kandi = findViewById(R.id.checkKandi);
        di = findViewById(R.id.checkDI);
        phd = findViewById(R.id.checkPhd);
        sMaster = findViewById(R.id.checkSwim);

        UserStorage s = UserStorage.getInstance();

        context = MainActivity.this;

        // Load users from file
        s.loadUsers(context);

        addUser = findViewById(R.id.addUser);
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int degreeId = degreeGroup.getCheckedRadioButtonId();
                degree = findViewById(degreeId);

                ArrayList<String> completedDegrees = new ArrayList<>();

                boolean kandiIsChecked = kandi.isChecked();
                boolean diIsChecked = di.isChecked();
                boolean phdiIsChecked = phd.isChecked();
                boolean sMasteriIsChecked = sMaster.isChecked();

                if(kandiIsChecked){
                    completedDegrees.add("Kandidaatin tutkinto");
                }
                if(diIsChecked){
                    completedDegrees.add("Diplomi-insinöörin tutkinto");
                }
                if(phdiIsChecked){
                    completedDegrees.add("Tekniikan tohtorin tutkinto");
                }
                if(sMasteriIsChecked){
                    completedDegrees.add("Uimamaisteri");
                }

                s.addUser(new User(firstname.getText().toString(), lastname.getText().toString(), email.getText().toString(), degree.getText().toString(), completedDegrees));
                completedDegrees.clear();

                // Save users to file
                s.saveUsers(context);
            }
        }
        );

        goToListView = findViewById(R.id.listUsers);
        goToListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
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