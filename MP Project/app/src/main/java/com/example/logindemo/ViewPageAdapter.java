package com.example.logindemo;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentlist = new ArrayList<>();
    private final List<String> FragmentListTitles = new ArrayList<>();


    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return FragmentListTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentListTitles.get(position);
    }

    public void AddFragment(Fragment fragment,String Title){
        fragmentlist.add(fragment);
        FragmentListTitles.add(Title);
    }
}
