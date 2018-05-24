package com.example.asus.zneku.myfirstandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.zneku.myfirstandroid.DataBase.MyDataBase;

public class MainActivity extends AppCompatActivity {
    private TextView view;
    private EditText text;
    private EditText username;
    private EditText password;
    private Button submit;
    public static String key="text";
    public static String keyback="back";
    public static String u="USER";
    public static String p="PASS";
    MyDataBase datab;

    private int back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
            datab=new MyDataBase(this);
            SQLiteDatabase db=datab.getReadableDatabase();
        Log.d("n",datab.getDatabaseName());
        Intent second;
        back=0;
        view=(TextView) findViewById(R.id.txt);
        text=(EditText) findViewById(R.id.edit);
        submit=(Button) findViewById(R.id.submit);
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.passwd);

        if(savedInstanceState!=null) {
            text.setText(savedInstanceState.getString(key).toString());
            back =savedInstanceState.getInt(keyback);

        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if(user.equals("")||pass.equals("")){
                    username.setHintTextColor(Color.RED);
                    password.setHintTextColor(Color.RED);
                    Toast.makeText(MainActivity.this, "username or password is empty!!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(user.toLowerCase().equals("zahra")&&pass.toLowerCase().equals("361/871873")){
                        Intent second= new Intent(MainActivity.this,Login.class);
                        second.putExtra(u,user);
                        second.putExtra(p,pass);

                        startActivity(second);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"username or password is wrong!!",Toast.LENGTH_SHORT);
                        findViewById(R.id.submit).setBackgroundColor(Color.RED);
                    }
                }
            }
        });
    }
    public void onclick(View v){
        Log.d("-->", "onclick: ");
        Toast.makeText(this,"change"+text.getText().toString(),Toast.LENGTH_LONG).show();
        String s=text.getText().toString();
        view.setText(s);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(key,text.getText().toString());
        outState.putInt(keyback,back);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder exit = new AlertDialog.Builder(MainActivity.this);
        exit.setIcon(android.R.drawable.bottom_bar);
        exit.setCancelable(false);
        exit.setTitle("exit");
        exit.setNegativeButton("no", null);
        exit.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        exit.setNeutralButton("cancel",null);
        exit.create();
        exit.show();

        Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
    }
    public void onsubmit(View v){
        String user=username.getText().toString();
        String pass=password.getText().toString();
        if(user.equals("")||pass.equals("")){
            username.setHintTextColor(Color.RED);
           password.setHintTextColor(Color.RED);
            Toast.makeText(this, "username or password is empty!!!", Toast.LENGTH_SHORT).show();
        }
        else{
            if(user.toLowerCase().equals("zahra")&&pass.toLowerCase().equals("361/871873")){
              Intent second= new Intent(this,Login.class);
                second.putExtra(u,user);
                second.putExtra(p,pass);

                startActivity(second);
            }
            else{
                Toast.makeText(this,"username or password is wrong!!",Toast.LENGTH_SHORT);
                findViewById(R.id.submit).setBackgroundColor(Color.RED);
            }
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.block:
                Toast.makeText(this, "block", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.search:
                Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);

    }


}
