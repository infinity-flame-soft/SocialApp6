package com.joy.socialapp6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText pass,email;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //-----initialize------------------------
        pass=findViewById(R.id.password);
        email=findViewById(R.id.email);
        login=findViewById(R.id.btn_login);

        //-----onClick--------------
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login(){

        StringRequest stringRequest=new StringRequest(Request.Method.POST, "http://192.168.1.20/infinity/android6/login.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(LoginActivity.this,response,Toast.LENGTH_LONG)
                .show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this,"Something went wrong !!!1 try later..",Toast.LENGTH_LONG)
                        .show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params=new HashMap<>();
                params.put("post_email",email.getText().toString());
                params.put("post_pass",pass.getText().toString());

                return params;

            }
        };

        Volley.newRequestQueue(this).add(stringRequest);

    }


}
