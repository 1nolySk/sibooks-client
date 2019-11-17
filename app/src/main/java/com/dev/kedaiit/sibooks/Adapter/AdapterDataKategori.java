package com.dev.kedaiit.sibooks.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.kedaiit.sibooks.ModelData.ModelDataKategori;
import com.dev.kedaiit.sibooks.R;

import java.util.List;

public class AdapterDataKategori extends RecyclerView.Adapter<AdapterDataKategori.HolderData> {
    private List<ModelDataKategori> mItems;
    private Context context;

    public AdapterDataKategori(Context context, List<ModelDataKategori> items){
        this.mItems = items;
        this.context = context;
    }


    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data_kategori,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        ModelDataKategori md = mItems.get(position);
        holder.tv_kategori.setText(md.getKategori());
        holder.md = md;

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class HolderData extends RecyclerView.ViewHolder {
        TextView tv_kategori;
        ModelDataKategori md;
        public HolderData (View view) {
            super(view);

            tv_kategori = (TextView) view.findViewById(R.id.tv_kategori);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent update = new Intent(context, InserData.class);
                    update.putExtra("update",1);
                    update.putExtra("id_kategori",md.getId_kategori());
                    update.putExtra("kategori",md.getKategori());
                }
            });
        }
    }
}
