package com.example.resthttp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity
{
    Button botao;
    EditText endPoint, httpReturn;

    private static final String TAG = MainActivity.class.getName();
    private RequestQueue mRequestQueue;
    private StringRequest stringRequest;
    private String url = "http://www.mocky.io/v2/5dfa2319360000e699bd6a5d";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        endPoint = (EditText)findViewById(R.id.url);
        //usuario.addTextChangedListener(new textoListener());
        httpReturn = (EditText)findViewById(R.id.retorno);
        //senha.addTextChangedListener(new textoListener());
        botao = (Button)findViewById(R.id.botao);
        botao.setOnClickListener(new testaGet());
    }

    public class testaGet implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            mRequestQueue = Volley.newRequestQueue(MainActivity.this);
            stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response)
                {
                    //Log.i(TAG, "RESPOSTA: " + response.toString());
                    //Toast.makeText(MainActivity.this, "RESPOSTA: " + response.toString(), 1).show();
                    httpReturn.setText("RESPOSTA:\n" + response.toString());
                    httpReturn.setTextColor(Color.BLUE);
                    httpReturn.setTextSize((float) 22.5);
                }
            },
            new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Log.i(TAG, "ERRO: " + error.toString());
                }
            });

            mRequestQueue.add(stringRequest);
        }
        //endPoint.getText().toString()

    }
}
