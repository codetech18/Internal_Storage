package com.example.internalstorage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.internalstorage.MainActivity;
import com.example.internalstorage.R;

import java.io.FileInputStream;

public class RetrieveActivity extends AppCompatActivity {
    EditText nameEditText, passwordEditText;



    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        nameEditText = (EditText)findViewById(R.id.name2EditTextID);
        passwordEditText = (EditText)findViewById(R.id.password2EditTextID);


    }
    public void Retrieve(View view){
        try{
            FileInputStream fileInputStream = openFileInput("androidtext.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while ((read = fileInputStream.read())  != -1){
                buffer.append((char)read);

            }
            String name = buffer.substring(0, buffer.indexOf(" "));
            String password = buffer.substring(0, buffer.indexOf(" ") + 1);

            nameEditText.setText(name);
            passwordEditText.setText(password);

        }catch (Exception e){
            Log.e("Exception: ", e.toString());

        }

    }

    public void Back (View view){
        Intent intent = new Intent(RetrieveActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
