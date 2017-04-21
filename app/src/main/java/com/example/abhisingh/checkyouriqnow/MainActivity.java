package com.example.abhisingh.checkyouriqnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private android.support.v7.widget.Toolbar toolBar;
    Button button;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);

        toolBar.setTitle(R.string.app_name);

        button = (Button)findViewById(R.id.button);
        et = (EditText)findViewById(R.id.editText);

        button.setOnClickListener(this);

    }


    public void onClick(View v)
    {
        if (v == button)
        {
            if (et.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this,R.string.toast,Toast.LENGTH_SHORT).show();
            }

            else
            {
                Intent i = new Intent(this, Test.class);
                i.putExtra("name", et.getText().toString());
                startActivity(i);
            }

        }

    }
}
