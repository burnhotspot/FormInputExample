package com.example.myapplicationtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.ListView;
import android.view.Menu;
import android.widget.Toast;

import java.util.Date;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatePicker dobselector;
    ArrayList<String> workstatus = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText txtname = (EditText) findViewById(R.id.name);
        dobselector = (DatePicker) findViewById(R.id.dob);
        EditText txtemail = (EditText) findViewById(R.id.email);
        final CheckBox txtcb = (CheckBox) findViewById(R.id.checkbox);
        Button btnnext = (Button) findViewById(R.id.submit);
        ListView listview = (ListView) findViewById(R.id.listview);

        workstatus.add("Full Time");
        workstatus.add("Part Time");

        dobselector.init(1900,1,1, null);

        

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtcb.isChecked()){
                    displayNextAlert();
                }

                else{
                    Error();
                }

            }
        });
    }

    private void displayNextAlert(){

        EditText txtname = (EditText) findViewById(R.id.name);
        EditText txtemail = (EditText) findViewById(R.id.email);

        CheckBox chkbox = (CheckBox) findViewById(R.id.checkbox);

        String dob_day = dobselector.getDayOfMonth() + "";
        String dob_month = dobselector.getMonth() + "";
        String dob_year = dobselector.getYear() + "";
        String name = txtname.getText().toString();
        String email = txtemail.getText().toString();

        new AlertDialog.Builder(this).setTitle("Details entered").setMessage(
                "Details"+"\n" + "Name : " + name +"\n" + "Email : " +
                        email +"\n" + "Date Of Birth : " + dob_day +"/"+dob_month+"/"+dob_year)
                .setNeutralButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                }).show();
    }

    private void Error(){
        new AlertDialog.Builder(this).setTitle("Error").setMessage("Please agree to Terms and Conditions to proceed")
                .setNeutralButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                }).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()) {
            case R.id.itemNext:
                displayNextAlert();
                return true;
            case R.id.itemExit:
                popupToast("PLEASE DON'T KILL ME");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void popupToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
