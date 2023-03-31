package com.example.userstorage2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView name, email, degree, completedDegrees;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.nameText);
        email = itemView.findViewById(R.id.emailText);
        degree = itemView.findViewById(R.id.degreeText);
    }
}
