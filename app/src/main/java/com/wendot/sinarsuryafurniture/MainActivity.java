package com.wendot.sinarsuryafurniture;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wendot.sinarsuryafurniture.Fragment.CartFragment;
import com.wendot.sinarsuryafurniture.Fragment.HomeFragment;
import com.wendot.sinarsuryafurniture.Fragment.ProfileFragment;
import com.wendot.sinarsuryafurniture.Fragment.WishlistFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        HomeFragment homeFragment = new HomeFragment();
        CartFragment cartFragment = new CartFragment();
        WishlistFragment wishlistFragment = new WishlistFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
                    return true;
                }
                if(item.getItemId()==R.id.cart){
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, cartFragment).commit();
                    return true;
                }
                if(item.getItemId()==R.id.wishlist){
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, wishlistFragment).commit();
                    return true;
                }
                if(item.getItemId()==R.id.profile){
                    getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profileFragment).commit();
                    return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.home);

    }
}