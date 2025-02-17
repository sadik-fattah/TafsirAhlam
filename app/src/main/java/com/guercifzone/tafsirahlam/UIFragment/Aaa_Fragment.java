package com.guercifzone.tafsirahlam.UIFragment;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.guercifzone.tafsirahlam.API.ApiService;
import com.guercifzone.tafsirahlam.Adapter.DataItemAdapter;
import com.guercifzone.tafsirahlam.DataBase.AppDataBase;
import com.guercifzone.tafsirahlam.DataBase.DataItem;
import com.guercifzone.tafsirahlam.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Aaa_Fragment extends Fragment {
    public Aaa_Fragment(){}
    private RecyclerView recyclerView;
    private DataItemAdapter adapter;
    private AppDataBase db;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter =new DataItemAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        db = Room.databaseBuilder(requireContext(), AppDataBase.class, "app_database").build();
        loadDataFromLocalDatabase();
        if (adapter.getItemCount() == 0){
            fetchDataFromApi();
        }
        return root;
    }

    private void loadDataFromLocalDatabase() {
        new AsyncTask<Void, Void, List<DataItem>>() {
            @Override
            protected List<DataItem> doInBackground(Void... voids) {
                return db.dataItemDao().getAllDataItems();
            }

            @Override
            protected void onPostExecute(List<DataItem> dataItems) {
                super.onPostExecute(dataItems);
                adapter.updateData(dataItems);
            }
        }.execute();
    }

    private void fetchDataFromApi() {
        ApiService apiService = ApiService.RetrofitClient.getRetrofitInstance().create(ApiService.class);
        apiService.getData().enqueue(new Callback<List<DataItem>>() {
            @Override
            public void onResponse(Call<List<DataItem>> call, Response<List<DataItem>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<DataItem> dataItems = response.body();

                    // Store data in Room database
                    new AsyncTask<List<DataItem>, Void, Void>() {
                        @Override
                        protected Void doInBackground(List<DataItem>... lists) {
                            db.dataItemDao().insert((DataItem) lists[0]);
                            return null;
                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            super.onPostExecute(aVoid);
                            // Update RecyclerView
                            adapter.updateData(dataItems);
                        }
                    }.execute(dataItems);
                }
            }

            @Override
            public void onFailure(Call<List<DataItem>> call, Throwable t) {
                // Handle failure
                Toast.makeText(requireContext(), "Failed to fetch data", Toast.LENGTH_SHORT).show();
            }
        });
    }


}

