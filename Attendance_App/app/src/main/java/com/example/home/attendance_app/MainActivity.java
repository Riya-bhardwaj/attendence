package com.example.home.attendance_app;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public int sectioninteger;
    public int totalstudents;
    public String presentstudent;
    public  int presentstudents; int sectionnumber;
    int yearnumber; int TotalStudents;
    float percent;
    DatabaseReference databaseReference;
    public int yearinteger; Spinner section;   Spinner year;
    EditText text ;
    public int nmber;
    public int attendencepercent;
    public String numberstring;
    int Numberinteger;
    Button button0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0=(Button)findViewById(R.id.button);
        section =(Spinner)findViewById(R.id.section);
        ArrayAdapter<String> sectionList= new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.section));
        sectionList.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        section.setAdapter(sectionList);
     databaseReference=FirebaseDatabase.getInstance().getReference();
        year =(Spinner)findViewById(R.id.year);
        ArrayAdapter<String> yearList= new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.year));
        yearList.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        year.setAdapter(yearList);
        text=(EditText) findViewById(R.id.numberid);;// Extracted value fron EditText field

        //   numberstring=text.getText().toString();       //nuberstring contains number of students present
        //  Numberinteger=Integer.parseInt(text.getText().toString()); //Number is Total students
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean x = true;

                numberstring = text.getText().toString();
                if (numberstring.isEmpty()) {
                    Toast.makeText(MainActivity.this, "PLEASE ENTER VALID ATTENDANCE", Toast.LENGTH_LONG).show();
                }
                //   if (numberstring != null) {
                else {
                    Numberinteger = Integer.parseInt(numberstring);  //attendance

                    sectioninteger = Integer.parseInt(section.getSelectedItem().toString());  //converting to integer

                    yearinteger = Integer.parseInt(year.getSelectedItem().toString());

                    //   Toast.makeText(MainActivity.this, "present is"+Numberinteger+"sectin is"+ sectioninteger+"year is "+yearinteger+" %" , Toast.LENGTH_LONG).show();

                    if (yearinteger == 2) {
                        if (sectioninteger == 1) {
                            TotalStudents = 70;
                        }
                        if (sectioninteger == 2) {
                            TotalStudents = 60;
                        }
                        if (sectioninteger == 3) {
                            TotalStudents = 50;
                        }
                    }    //second year ends here

                    if (yearinteger == 3) {
                        if (sectioninteger == 1) {
                            TotalStudents = 65;
                        }
                        if (sectioninteger == 2) {
                            TotalStudents = 62;
                        }
                        if (sectioninteger == 3) {
                            TotalStudents = 40;
                        }
                    } //third year ends here

                    if (yearinteger == 4) {
                        if (sectioninteger == 1) {
                            TotalStudents = 57;
                        }
                        if (sectioninteger == 2) {
                            TotalStudents = 80;
                        }
                        if (sectioninteger == 3) {
                            TotalStudents = 100;
                        }
                    } //Fourth year ends here

                    if (Numberinteger > TotalStudents) {
                        x = false;

                    }
//String id =databaseReference.push().getKey();
    //      firebase fire=new firebase();

                    if (!x) {

                        Toast.makeText(MainActivity.this, "SORRY ENTER VALID ATTENDANCE ", Toast.LENGTH_LONG).show();
                    }

//                    percent = (float) (Numberinteger) / (TotalStudents) * 100;
//                    String id =databaseReference.push().getKey();
//                    firebase fire=new firebase(yearinteger,sectioninteger,Numberinteger);

                    if (x) {
                        Log.d("viva","skdhvkjsdhv");
             /*           String id =databaseReference.push().getKey();
                        firebase fire=new firebase(yearinteger,sectioninteger,Numberinteger);

                        databaseReference.child(id).setValue(fire);  */
                        Toast.makeText(MainActivity.this,"SUBMITTED", Toast.LENGTH_LONG).show();

                        Toast.makeText(MainActivity.this, percent + " %" + " Students are present", Toast.LENGTH_LONG).show();

                        percent = (float) (Numberinteger) / (TotalStudents) * 100;
                        String id = databaseReference.push().getKey();
                        Log.d("viva",id);
                        firebase fire=new firebase(yearinteger,sectioninteger,Numberinteger);

                        databaseReference.child(id).setValue(fire);
                        Log.d("viva","psuh");
                    }
                }

            }
        });




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_tools) {
            Intent i= new Intent(MainActivity.this,Tools  .class);
            startActivity(i);
        } else if (id == R.id.nav_about_us){
            Intent i= new Intent(MainActivity.this,AboutUs  .class);
            startActivity(i);
        } else if (id == R.id.nav_feedback) {
            Intent i= new Intent(MainActivity.this,Feedback  .class);
            startActivity(i);

        } else if (id == R.id.nav_report) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
