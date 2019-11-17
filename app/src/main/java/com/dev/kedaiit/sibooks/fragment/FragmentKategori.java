package com.dev.kedaiit.sibooks.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.dev.kedaiit.sibooks.Adapter.AdapterDataKategori;
import com.dev.kedaiit.sibooks.ModelData.ModelDataKategori;
import com.dev.kedaiit.sibooks.R;
import com.dev.kedaiit.sibooks.crud.InsertKategori;
import com.dev.kedaiit.sibooks.util.AppController;
import com.dev.kedaiit.sibooks.util.ServerAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragmentKategori extends AppCompatActivity {
    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    List<ModelDataKategori> mItems;
    Button btnInsert, btnDelete;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerviewKategori);
        btnInsert = (Button) findViewById(R.id.btn_insert);
//        btnDelete = (Button) findViewById(R.id.btn_delete);
        pd = new ProgressDialog(FragmentKategori.this);
        mItems = new ArrayList<>();

        loadJson();

        mManager = new LinearLayoutManager(FragmentKategori.this,LinearLayoutManager.VERTICAL,false);
        mRecyclerview.setLayoutManager(mManager);
        mAdapter = new AdapterDataKategori(FragmentKategori.this,mItems);
        mRecyclerview.setAdapter(mAdapter);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FragmentKategori.this, InsertKategori.class);
                startActivity(intent);
            }
        });

//        btnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent hapus = new Intent(InsertKategori.this,DeleteKategori.class);
//                startActivity(hapus);
//            }
//        });
    }


    private void loadJson()
    {
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();

        JsonObjectRequest reqData = new JsonObjectRequest(Request.Method.GET, ServerAPI.URL_DATA_KATEGORI, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                pd.cancel();
                try {
                    JSONArray jsonArray = response.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject data = jsonArray.getJSONObject(i);

                        ModelDataKategori md = new ModelDataKategori();
                        md.setId_kategori(data.getString("id_kategori"));
                        md.setKategori(data.getString("kategori"));

                        mItems.add(md);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mAdapter.notifyDataSetChanged();

            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Log.d("volley", "error : " + error.getMessage());
                    }
                });

        AppController.getInstance().addToRequestQueue(reqData);
    }
}
