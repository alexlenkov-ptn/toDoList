package com.lnkov.todolist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PageChooseCard extends AppCompatActivity {

    private EditText editTextText;
    private RadioButton cardRadioButtonLow;
    private RadioButton cardRadioButtonMedium;
    private Button cardButtonSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_page_choose_card);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        cardButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();

            }
        });
    }

    private void initViews() {
        editTextText = findViewById(R.id.editTextText);
        cardRadioButtonLow = findViewById(R.id.cardRadioButtonLow);
        cardRadioButtonMedium = findViewById(R.id.cardRadioButtonMedium);
        cardButtonSave = findViewById(R.id.cardButtonSave);
    }

    private void saveNote() {
        String text = editTextText.getText().toString().trim();
        if (text.isEmpty()) {
            Toast.makeText(
                PageChooseCard.this,
                    R.string.toast_for_text,
                    Toast.LENGTH_SHORT
            ).show();
        }
        int priority = getPriority();
    }

    private int getPriority() {
        int priority;
        if (cardRadioButtonLow.isChecked()) {
            priority = 0;
        } else if (cardRadioButtonMedium.isChecked()) {
            priority = 1;
        } else {
            priority = 2;
        }
        return priority;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, PageChooseCard.class);
    }
}