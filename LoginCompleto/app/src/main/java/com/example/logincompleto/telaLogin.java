package com.example.logincompleto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class telaLogin extends AppCompatActivity
{
    public static final String EXTRA_MESSAGE = "com.example.logincompleto.MESSAGE";

    EditText usuario, senha;
    Button botao;

    avaliaLogin avalia;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
    }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        usuario = (EditText)findViewById(R.id.editText1);
        senha = (EditText)findViewById(R.id.editText2);
        botao = (Button)findViewById(R.id.botao1);

        usuario.addTextChangedListener(new textoListener());
        senha.addTextChangedListener(new textoListener());

        avalia = new avaliaLogin(usuario, senha);
    }

    public void logarOUregistrar(View view)
    {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        if (avalia.liberaLogin)
        {
            Intent i = new Intent(telaLogin.this, tela2.class);
            i.putExtra(EXTRA_MESSAGE, usuario.getText().toString() + "\n"
                    + senha.getText().toString());
            startActivity(i);
        }
        else
        {
            Toast.makeText(telaLogin.this, "USUARIO ou SENHA invalidos", 1).show();
        }
    }

    public class textoListener implements TextWatcher
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {}
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {}
        @Override
        public void afterTextChanged(Editable s)
        {
            avalia.testaLogin(usuario.getText().toString(), senha.getText().toString());
        }
    }
}
