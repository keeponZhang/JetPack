package com.zhang.jetpack.ui.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.zhang.jetpack.AppMainActivity;
import com.zhang.jetpack.R;

public class AppHomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // homeViewModel =
        //         ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        // homeViewModel.getText().observe(this, new Observer<String>() {
        //     @Override
        //     public void onChanged(@Nullable String s) {
        //         textView.setText(s);
        //     }
        // });
        root.findViewById(R.id.jump).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppMainActivity mainActivity = (AppMainActivity) getActivity();
                mainActivity.jump();
            }
        });
        root.findViewById(R.id.deepLink).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppMainActivity appMainActivity = (AppMainActivity) getActivity();
                appMainActivity.getNavController().navigate(Uri.parse("http://www.keepon.com"));
            }
        });
        return root;
    }

}