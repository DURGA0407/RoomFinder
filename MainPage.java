package com.example.roomfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.roomfinder.databinding.ActivityMainPageBinding;

import com.example.roomfinder.R;


import android.content.ClipData;
import android.os.Bundle;

import com.example.roomfinder.databinding.ActivityMainBinding;

public class MainPage extends AppCompatActivity {

    ActivityMainPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        
        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);
        
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;

                case R.id.preference:
                    replaceFragment(new PreferenceFragment());
                    break;

                case R.id.room:
                    replaceFragment(new SuiteFragment());
                    break;

                case R.id.account:
                    replaceFragment(new AccountFragment());
                    break;
            }
            return  true;
        });
    }
    
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}