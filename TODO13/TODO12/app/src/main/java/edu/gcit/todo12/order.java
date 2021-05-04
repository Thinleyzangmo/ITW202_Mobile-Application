package edu.gcit.todo12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class order extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        textview = findViewById(R.id.message);
        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textview.setText(msg);

        spinner = findViewById(R.id.spinner);
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_list, R.layout.support_simple_spinner_dropdown_item);
        if(spinner!=null){
            spinner.setAdapter(adapter);
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();


        switch (view.getId()){
            case R.id.same:
                DisplayToast(getString(R.string.same_day));
                break;

            case R.id.next:
                DisplayToast(getString(R.string.next_day));
                break;

            case R.id.pick:
                DisplayToast(getString(R.string.pick_up));
                break;

            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerMessage = parent.getItemAtPosition(position).toString();
        DisplayToast(spinnerMessage);

    }

    private void DisplayToast(String spinnerMessage) {
        Toast.makeText(getApplicationContext(),spinnerMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}