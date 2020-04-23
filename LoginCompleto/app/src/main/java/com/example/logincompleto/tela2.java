package com.example.logincompleto;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class tela2 extends AppCompatActivity
{
    EditText textoRecebido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        
        Intent intent = getIntent();
        String message = intent.getStringExtra(telaLogin.EXTRA_MESSAGE);

        textoRecebido = (EditText)findViewById(R.id.editText3);
        textoRecebido.setText(message);
        textoRecebido.setTextColor(Color.BLUE);
        textoRecebido.setTextSize((float) 22.5);
    }
}
