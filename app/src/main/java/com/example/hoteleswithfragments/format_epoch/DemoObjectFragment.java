package com.example.hoteleswithfragments.format_epoch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.hoteleswithfragments.R;
import com.squareup.picasso.Picasso;

public class DemoObjectFragment extends Fragment {

    public static final String ARG_OBJECT = "objet";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_img_hotel_item,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        Picasso.with(requireContext()).load(args.getString(ARG_OBJECT,"")).into((ImageView) view.findViewById(R.id.img_hotel_detail));


    }

}
