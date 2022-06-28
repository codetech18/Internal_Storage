package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText, passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = (EditText) findViewById(R.id.nameEditTextID);
        passwordEditText = (EditText) findViewById(R.id.passwordEditTextID);

    }

    public void save(View view){
        String name = nameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        File file = null;
        FileOutputStream fileOutputStream = null;

        try{
            name = name + " ";
            file = getFilesDir();

            fileOutputStream = openFileOutput("androidext.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(name.getBytes());
            fileOutputStream.write(password.getBytes());

            Toast.makeText(MainActivity.this,"Your file have been \n at path " + file + "\tandroidtext.txt ", Toast.LENGTH_LONG).show();

            nameEditText.setText("");
            passwordEditText.setText("");

            return;

        }catch (Exception e){
            Log.e("Exception", e.toString());

        }finally {
            try{
                fileOutputStream.close();

            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
    public void Next (View view){
        Intent intent = new Intent(MainActivity.this, RetrieveActivity.class);
        startActivity(intent);

    }


}