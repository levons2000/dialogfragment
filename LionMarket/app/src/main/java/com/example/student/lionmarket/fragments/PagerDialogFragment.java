package com.example.student.lionmarket.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.lionmarket.R;
import com.example.student.lionmarket.adapters.PagerAdapter;

@SuppressLint("ValidFragment")
public class PagerDialogFragment extends DialogFragment {


    private final Context context;
    private final int currentPosition;

    @SuppressLint("ValidFragment")
    public PagerDialogFragment(Context context, int currentPosition) {
        this.context = context;
        this.currentPosition = currentPosition;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.pager_dialog_style, container, false);
        PagerAdapter pagerAdapter = new PagerAdapter(context);
        ViewPager viewPager = rootView.findViewById(R.id.pager_for_dialog);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(currentPosition);
        return rootView;
    }

}
