package com.example.userstorage2;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<>();
    private static UserStorage storage = null;

    private UserStorage(){
    }

    public static UserStorage getInstance(){
        if(storage == null){
            storage = new UserStorage();
        }
        return storage;
    }

    public ArrayList<User> getUsers(){
        ArrayList<User> list = this.users;
        Collections.sort(list);
        return list;
    }

    public void addUser(User user){
        users.add(user);
        return;
    }

    public void saveUsers(Context context){
        try{
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();
        } catch (IOException e) {
            System.out.println("Käyttäjien tallentaminen epäonnistui.");
        }
    }

    public void loadUsers(Context context){
        try{
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
            userReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Käyttäjien lukeminen epäonnistui.");
        } catch (ClassNotFoundException e) {
            System.out.println("Käyttäjien lukeminen epäonnistui.");
        } catch (IOException e) {
            System.out.println("Käyttäjien lukeminen epäonnistui.");
        }
    }
}
