package com.example.a27_material_design;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //스와이프 리프레쉬
        swipeRefreshLayout = findViewById(R.id.swipe);
        swipeRefreshLayout.setOnRefreshListener(this);
        //돌 때 색 변함
        swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE);

        findViewById(R.id.btn_move_to_navi).setOnClickListener(v -> {
            startActivity(new Intent(this, Navigation_Drawer_Activity.class));
        });
    }

    @Override
    public void onRefresh() {
        //갱신 처리
        new Handler().postDelayed(() -> {
            swipeRefreshLayout.setRefreshing(false);
        }, 3000);
    }
}