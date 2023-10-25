package com.example.tabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tabs.fragments.HomeFragment;
import com.example.tabs.fragments.MessagesFragment;
import com.example.tabs.fragments.SettingsFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    MyViewPagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new MessagesFragment();
            case 2:
                return new SettingsFragment();
            default:
                return new HomeFragment();
        }
    }
}