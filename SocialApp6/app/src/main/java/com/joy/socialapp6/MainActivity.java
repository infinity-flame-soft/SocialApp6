package com.joy.socialapp6;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    private EditText name, email, pass, mobile;
    private Button buttonReg,buttonLogin,buttonUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //---initialize------------
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        mobile = findViewById(R.id.mobile_no);
        buttonReg = findViewById(R.id.btn_reg);
        buttonLogin=findViewById(R.id.btn_login);
        buttonUsers=findViewById(R.id.btn_users);

        //----onClick------------------------
        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registration();

            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----start loginActivity------------------
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
        buttonUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //----start usersActivity------------------
                startActivity(new Intent(MainActivity.this,UsersActivity.class));
            }
        });


    }

    private void registration() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.1.20/infinity/android6/registration.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Something went wrong  !!!",Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params=new HashMap<>();
                params.put("post_name",name.getText().toString());
                params.put("post_email",email.getText().toString());
                params.put("post_pass",pass.getText().toString());
                params.put("post_mobile",mobile.getText().toString());

                return params;
            }
        };

        Volley.newRequestQueue(this).add(stringRequest);
    }


}
