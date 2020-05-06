package com.example.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    EditText nameText;
    TextView showText;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = (EditText) findViewById(R.id.nameText);
        showText = (TextView) findViewById(R.id.showText);

        sp =  this.getSharedPreferences("com.example.storingdata", Context.MODE_PRIVATE);

        showText.setText(sp.getString("name","Welcome :)"));



    }

    public void save (View v){


        if(nameText.getText().toString().matches("")){
            Toast.makeText(this,    "Please enter a name", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "saved!", Toast.LENGTH_SHORT).show();
            showText.setText("Welcome :) " + nameText.getText());

            sp.edit().putString("name", showText.getText().toString()).apply();

        }
    }


    public void delete(View v){
        //Kullanıcıya sildiğimizi bildirdik.
        Toast.makeText(this, sp.getString("name","NULL") + " deleted :)", Toast.LENGTH_SHORT).show();
        //sp objesinden o keyin değerini gerçekten sildik.
        sp.edit().remove("name").apply();




    }
}
