package com.example.myapplication.tab3fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.fragment.BlankFragment1;
import com.example.myapplication.fragment.BlankFragment2;
import com.example.myapplication.fragment.BlankFragment3;

public class Tab3ViewPagerAdapter extends FragmentStatePagerAdapter {
    public Tab3ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 : {
                return new Name();
            }
            case 1 : {
                return new Class();
            }
            case 2 : {
                return new Lecturer();
            }
            default: return new Name();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0 : {
                return "Tab1";
            }
            case 1 : {
                return "Tab2";
            }
            case 2 : {
                return "Tab3";
            }
            default: return "Tab1";
        }
    }
}
