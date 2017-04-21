package com.example.abhisingh.checkyouriqnow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.text.DecimalFormat;

public class Final_score extends AppCompatActivity
{
    private android.support.v7.widget.Toolbar toolBar;
    TextView perc;
    TextView final_IQ;
    TextView userName;
    Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        toolBar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        toolBar.setTitle(R.string.result);

        perc= (TextView)findViewById(R.id.perc);
        Bundle testData = getIntent().getExtras();
        String sc= testData.getString("score");

        Double score = Double.valueOf(sc);
        Double score2 = (score/40)*100;

        DecimalFormat formatVal = new DecimalFormat("##.##");

        perc.setText(formatVal.format(score2));

        final_IQ= (TextView)findViewById(R.id.final_IQ);
        if(score==0)
            final_IQ.setText(R.string.sleep);
        else if(score<=25)
            final_IQ.setText(R.string.average);
        else
            final_IQ.setText(R.string.sup_IQ);

        userName = (TextView)findViewById(R.id.userName);
        userName.setText(testData.getString("uname")+",");

        exit= (Button)findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(startMain);
            }
        });


    }
}
