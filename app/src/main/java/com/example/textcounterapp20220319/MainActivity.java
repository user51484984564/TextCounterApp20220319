package com.example.textcounterapp20220319;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.textcounterapp20220319.utils.TextUtils;

public class MainActivity extends AppCompatActivity {

    TextView tvResult;
    EditText txMain;
    Spinner spOptionSelection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvResult = findViewById(R.id.tvResult);
        this.txMain = findViewById(R.id.txMain);
        this.spOptionSelection = (Spinner) findViewById(R.id.spOptionSelector);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.counting_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spOptionSelection.setAdapter(adapter);
    }


    public void onBtnCalculateClick(View view) {
        if(this.txMain.getText().toString().trim().length() > 0){

            if(this.spOptionSelection.getSelectedItemPosition() == 0){ //position 0 = "Words", position 1 = "Chars"
                int wordsCount = TextUtils.getWordsCount(this.txMain.getText().toString().split("\\s+"));
                String wordsCountFormatted = String.valueOf(wordsCount);
                this.tvResult.setText(wordsCountFormatted);

            }
            else {
                int charsCount = TextUtils.getCharsCount(this.txMain.getText().toString());
                String charsCountFormatted = String.valueOf(charsCount);
                this.tvResult.setText(charsCountFormatted);
            }
        }
        else {
            String emptyText = "No text entered";
            this.tvResult.setText(emptyText);
            Toast.makeText(this, "Text is empty", Toast.LENGTH_LONG).show();
        }
    }
}