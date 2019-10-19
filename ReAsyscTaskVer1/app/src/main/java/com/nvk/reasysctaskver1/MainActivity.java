package com.nvk.reasysctaskver1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvDocDS;
    private BaiThoAdapter baiThoAdapter;
    private List<BaiTho> baiThoList;
    private ArrayList<TextView> tvTacGia,tvTile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_item_baitho);

        //Radiation();
        //CreateAdapter();
        GetDataByJSON();
    }

    private void GetDataByJSON() {
        tvTacGia = new ArrayList<>();
        tvTile = new ArrayList<>();

        tvTacGia.add((TextView) findViewById(R.id.tvTacGia));
        tvTile.add((TextView) findViewById(R.id.tvTieuDe));
        new FetchDSBaiTho(tvTacGia,tvTile).execute();

    }

    private void CreateAdapter() {
        baiThoList = new ArrayList<>();


        baiThoAdapter =new BaiThoAdapter(this,baiThoList);
        rcvDocDS.setLayoutManager(new LinearLayoutManager(this));
        rcvDocDS.setHasFixedSize(true);
        rcvDocDS.setAdapter(baiThoAdapter);

    }

    private void Radiation() {
        rcvDocDS = findViewById(R.id.rcvDocDS);

    }
}
