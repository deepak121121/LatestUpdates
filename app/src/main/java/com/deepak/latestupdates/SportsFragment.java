package com.deepak.latestupdates;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SportsFragment extends Fragment {

    String api = "b8505c93f7fe45128cf9f5f2ae272d26";
    ArrayList<NewsModel> list;
    private RecyclerView sportsrecyclerView;
    String country = "in";
    Adapter adapter;
    private String category ="sports";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate( R.layout.fragment_sports, container, false );

        sportsrecyclerView = v.findViewById( R.id.SportsRecycler );

        list = new ArrayList<>();
        sportsrecyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );
        adapter = new Adapter( getContext(), list );
        sportsrecyclerView.setAdapter( adapter );
        try {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl( Api.BASE_URL )
                    .addConverterFactory( GsonConverterFactory.create() )
                    .build();
            Api s = retrofit.create( Api.class );
            Call<MainModel> call = s.getCategory(country,category,100,api );
            call.enqueue( new Callback<MainModel>() {
                @Override
                public void onResponse(@NonNull Call<MainModel> call, @NonNull Response<MainModel> response) {
                    if (response.body() != null) {
                        list.addAll( response.body().getArticles() );
                        adapter.notifyDataSetChanged();
                    }

                }

                @Override
                public void onFailure(@NonNull Call<MainModel> call, @NonNull Throwable t) {

                }
            } );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;

    }

}




