package com.example.atul.emi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        final Button bt=(Button) findViewById(R.id.button);
        final EditText p=(EditText)findViewById(R.id.editText);
        final EditText t=(EditText)findViewById(R.id.editText2);

        final TextView EMI=(TextView)findViewById(R.id.ans);
        bt.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {

           String ans="Months\t\t\t\t\tEMI\t\t\t\t\t\tTotal\n\n";
           for(int i=-3;i<=3;i++) {
               int power=Integer.parseInt(t.getText().toString())-i;
               Double sol=Integer.parseInt(p.getText().toString())*0.03* Math.pow(1.03,power);
               sol/=Math.pow(1.03,power)-1;
               ans+="\t\t"+Integer.toString(Integer.parseInt(t.getText().toString())-i)+"\t\t\t\t\t"+ String.format("%.2f",sol)+"\t\t\t\t\t"+String.format("%.2f",sol*power)+"\n";
           }
           EMI.setText(ans);
           p.setText("");
           t.setText("");
       }

   });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
