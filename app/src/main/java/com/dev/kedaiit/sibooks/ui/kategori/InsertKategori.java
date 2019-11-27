package com.dev.kedaiit.sibooks.ui.kategori;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dev.kedaiit.sibooks.R;
import com.dev.kedaiit.sibooks.util.AppController;
import com.dev.kedaiit.sibooks.util.ServerAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class InsertKategori extends AppCompatActivity {
    EditText id_kategori, kategori;
    Button btnbatal, btnsimpan;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_kategori);

        /*get data from intent*/
        Intent data = getIntent();
        final int update = data.getIntExtra("update",0);
        String intent_idkategori = data.getStringExtra("id_kategori");
        String intent_kategori = data.getStringExtra("kategori");
        /*end get data from intent*/

        id_kategori = (EditText) findViewById(R.id.edt_idkategori);
        kategori = (EditText) findViewById(R.id.edt_kategori);
        btnbatal = (Button) findViewById(R.id.btn_cancel);
        btnsimpan = (Button) findViewById(R.id.btn_simpan);
        pd = new ProgressDialog(InsertKategori.this);

        /*kondisi update / insert*/
        if(update == 1)
        {
            btnsimpan.setText("Update Data");
            id_kategori.setText(intent_idkategori);
            id_kategori.setVisibility(View.GONE);
            kategori.setText(intent_kategori);

        }


        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(update == 1)
                {
                    Update_data();
                }else {
                    simpanData();
                }
            }
        });

        btnbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(InsertKategori.this, KategoriFragment.class);
                startActivity(main);
            }
        });
    }

    private void Update_data()
    {
        pd.setMessage("Update Data");
        pd.setCancelable(false);
        pd.show();

        StringRequest updateReq = new StringRequest(Request.Method.POST, ServerAPI.URL_UPDATE_KATEGORI,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.cancel();
                        try {
                            JSONObject res = new JSONObject(response);
                            Toast.makeText(InsertKategori.this, ""+   res.getString("message") , Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        startActivity( new Intent(InsertKategori.this,KategoriFragment.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Toast.makeText(InsertKategori.this, "Gagal Insert Data", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("id_kategori",id_kategori.getText().toString());
                map.put("kategori",kategori.getText().toString());

                return map;
            }
        };

        AppController.getInstance().addToRequestQueue(updateReq);
    }

    private void simpanData()
    {

        pd.setMessage("Menyimpan Data");
        pd.setCancelable(false);
        pd.show();

        StringRequest sendData = new StringRequest(Request.Method.POST, ServerAPI.URL_INSERT_KATEGORI,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.cancel();
                        try {
                            JSONObject res = new JSONObject(response);
                            Toast.makeText(InsertKategori.this, ""+   res.getString("message") , Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        startActivity( new Intent(InsertKategori.this,KategoriFragment.class));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Toast.makeText(InsertKategori.this, "Gagal Insert Data", Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("id_kategori",id_kategori.getText().toString());
                map.put("kategori",kategori.getText().toString());

                return map;
            }
        };

        AppController.getInstance().addToRequestQueue(sendData);
    }
}
