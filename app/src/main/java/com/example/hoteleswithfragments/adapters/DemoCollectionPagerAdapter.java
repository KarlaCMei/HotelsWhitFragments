package com.example.hoteleswithfragments.adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.hoteleswithfragments.format_epoch.DemoObjectFragment;

import java.util.ArrayList;

public class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {

    private  ArrayList<Imagen> arrayImages ;



    public DemoCollectionPagerAdapter(@NonNull FragmentManager fm, ArrayList<Imagen> arrayImages ) {
        super(fm);
        this.arrayImages = arrayImages;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new DemoObjectFragment();
        Bundle args = new Bundle();
        args.putString(DemoObjectFragment.ARG_OBJECT, arrayImages.get(position).url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return arrayImages.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        //return imagen[position].titulo.toString();


       return arrayImages.get(position).titulo;
    }

}
