package com.deepak.latestupdates;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    ArrayList<NewsModel> list;
    Context mContext;


    public Adapter(Context mContext, ArrayList<NewsModel> list) {

        this.list = list;
        this.mContext=mContext;
    }


    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View v;
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        v=layoutInflater.inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  Adapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.Header.setText( list.get( position ).getTitle() );
        holder.Author1.setText( list.get( position ).getAuthor() );
        holder.published.setText( list.get( position ).getPublishedAt() );

        Glide.with( mContext ).load( list.get( position ).getUrlToImage() ).into( holder.imageView );

        holder.cardView1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,web.class);
                intent.putExtra( "url",list.get( position ).getUrl() );
                mContext.startActivity( intent );
            }
        } );


    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Header,Author1,published;
        ImageView imageView;
        CardView cardView1;




        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            Header=itemView.findViewById( R.id.header );
            Author1=itemView.findViewById( R.id.author );
            published=itemView.findViewById( R.id.Published );
            cardView1=itemView.findViewById( R.id.cardview );
            imageView=itemView.findViewById( R.id.img1);




        }
    }


}




