package com.example.se1603_prm392_shoestoreapp_group05.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.se1603_prm392_shoestoreapp_group05.Adapter.CartAdapter;
import com.example.se1603_prm392_shoestoreapp_group05.Data.CartDBHelper;
import com.example.se1603_prm392_shoestoreapp_group05.Model.Cart;
import com.example.se1603_prm392_shoestoreapp_group05.Model.Product;
import com.example.se1603_prm392_shoestoreapp_group05.R;

import java.util.ArrayList;
import java.util.List;


public class CartActivity extends AppCompatActivity {
    private RecyclerView recyclerViewCart;
    private CartAdapter cartAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerViewCart = findViewById(R.id.recyclerViewCart);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewCart.setLayoutManager(layoutManager);


        Intent intent = getIntent();
        List<Cart> cartList = (List<Cart>) intent.getSerializableExtra("cartItem");
        cartAdapter = new CartAdapter(this, cartList);

        recyclerViewCart.setAdapter(cartAdapter);
        Button btncheckout = findViewById(R.id.button_checkout);
        btncheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

    }
}