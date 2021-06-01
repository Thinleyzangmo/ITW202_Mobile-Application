package edu.gcit.todo_25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.gcit.todo_24i.R;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText editname, editsurname, editmarks, editidnumber;
    Button btnADDDATA, btnVIEWALL, btnUPDATE, btnDELETE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DataBaseHelper(this);
        editname = findViewById(R.id.first_name);
        editsurname = findViewById(R.id.second_name);
        editmarks = findViewById(R.id.ITW2002_MARKS);
        editidnumber = findViewById(R.id.ID_number);
        btnADDDATA = findViewById(R.id.add_data);
        btnVIEWALL = findViewById(R.id.view_all);
        btnUPDATE = findViewById(R.id.update);
        btnDELETE = findViewById(R.id.delete);
    }

    public void ADD_DATA(View view) {
        btnADDDATA.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editidnumber.getText().toString(),
                                editname.getText().toString(),
                                editsurname.getText().toString(),
                                editmarks.getText().toString());

                        if (isInserted == true)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}