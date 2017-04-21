package com.example.abhisingh.checkyouriqnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Test extends AppCompatActivity implements View.OnClickListener
{
    private android.support.v7.widget.Toolbar toolBar;
    RadioGroup rg1;
    RadioGroup rg2;
    RadioGroup rg3;
    RadioGroup rg4;
    RadioGroup rg5;
    Button b ;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        toolBar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);

        toolBar.setTitle(R.string.app_name);
        toolBar.setSubtitle(R.string.allbest);

        rg1 = (RadioGroup)findViewById(R.id.radioGroup);
        rg2 = (RadioGroup)findViewById(R.id.radioGroup2);
        rg3 = (RadioGroup)findViewById(R.id.radioGroup3);
        rg4 = (RadioGroup)findViewById(R.id.radioGroup4);
        rg5 = (RadioGroup)findViewById(R.id.radioGroup5);

        b = (Button)findViewById(R.id.submit);
        b.setOnClickListener(this);

    }

    public void onClick(View v)
    {
        int score=0;
        if(rg1.getCheckedRadioButtonId()==R.id.q1o3)
            score+=10;
        if(rg3.getCheckedRadioButtonId()==R.id.q3o4)
            score+=10;
        if(rg4.getCheckedRadioButtonId()==R.id.q4o2)
            score+=10;
        if(rg2.getCheckedRadioButtonId()==R.id.ii)
            score+=5;
        if(rg5.getCheckedRadioButtonId()==R.id.q5o4)
            score+=5;

        Bundle mainData = getIntent().getExtras();
        String uname=mainData.getString("name");

        Intent i = new Intent(this,Final_score.class);
        i.putExtra("score",""+score);
        i.putExtra("uname",uname);
        startActivity(i);
        finish();

    }

}
