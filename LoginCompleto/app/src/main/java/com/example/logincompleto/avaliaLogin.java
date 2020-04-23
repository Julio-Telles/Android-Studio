package com.example.logincompleto;

import android.util.Patterns;
import android.widget.EditText;

public class avaliaLogin
{
    private EditText user, pass;
    public boolean liberaLogin;

    public avaliaLogin(EditText email, EditText senha)
    {
        user = email;
        pass = senha;
        liberaLogin = false;
    }

    public void testaLogin(String textoEmail, String textoSenha)
    {
        if(!isUsuarioValido(textoEmail))
        {
            user.setError("EMAIL invalido");
            liberaLogin = false;
        }

        if(!isSenhaValida(textoSenha))
        {
            pass.setError("SENHA invalida");
            liberaLogin = false;
        }

        if (isUsuarioValido(textoEmail) && isSenhaValida(textoSenha))
        {
            liberaLogin = true;
        }
    }

    private boolean isUsuarioValido(String textoEmail)
    {
        if (textoEmail.equals("") || textoEmail.trim().isEmpty())
        {
            return false;
        }
        else
        {
            return Patterns.EMAIL_ADDRESS.matcher(textoEmail).matches();
        }
    }

    private boolean isSenhaValida(String textoSenha)
    {
        return textoSenha != null && textoSenha.length() > 7;
    }
}
