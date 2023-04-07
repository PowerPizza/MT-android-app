package com.example.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

class Output_Generator{
    // MT => multiplication table
    TextView changeAble;
    public Output_Generator(TextView view_port){
        changeAble = view_port;
    }
    public void clear_text(){
        changeAble.setText("");
    }
    public void set_text(String value){
        changeAble.setText(value);
    }
    public void display_output_MT(int num){
        for (int i = 0; i < 10; i++) {
            String out_ = "" + (num) + " x " + (i+1) + " = " + ((i+1)*num) + "\n";
            changeAble.setText(changeAble.getText() + out_);
        }
    }
}

public class MainActivity extends AppCompatActivity {
    Output_Generator OG1;

    View.OnKeyListener onInputNumber = (v, keyCode, event) -> {
        EditText input_ = findViewById(R.id.editTextNumber);
        try {
            int num = Integer.parseInt(input_.getText().toString());
            OG1.clear_text();
            OG1.display_output_MT(num);
        }
        catch (Exception e){
            OG1.set_text("Error" + e.toString());
        }
        return false;
    };

    public void onClickDeveloper(View view){
        Toast t1 = Toast.makeText(getApplicationContext(), "PowerPizza/Scihack", Toast.LENGTH_LONG);
        t1.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.editTextNumber).setOnKeyListener(onInputNumber);
        OG1 = new Output_Generator(findViewById(R.id.view_port));
    }
}