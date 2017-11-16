package com.joy.socialapp6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {

    private TextView name,email;
    private List<Model> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);


        //---initialize---------------
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);


        //----method call--------
        getJSONData();

    }
    private void getJSONData(){

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest("http://192.168.1.20/infinity/android6/user-json.php", new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i=0;i<response.length();i++){

                    try {

                        JSONObject jsonObject= (JSONObject) response.get(i);

                        Model model=new Model();

                        model.setEmail(jsonObject.getString("email"));
                        model.setName(jsonObject.getString("name"));

                        //name.setText(jsonObject.getString("name"));
                       // email.setText(jsonObject.getString("email"));

                        list.add(model);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(UsersActivity.this,"Wrong !!!!!!!!!",Toast.LENGTH_LONG)
                        .show();

            }
        });

        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }

}
