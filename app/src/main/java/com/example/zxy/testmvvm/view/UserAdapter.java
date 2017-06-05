package com.example.zxy.testmvvm.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zxy.testmvvm.R;
import com.example.zxy.testmvvm.databinding.ItemUserBinding;
import com.example.zxy.testmvvm.model.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxy on 2017/5/2.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {
    private static final int USER_COUNT = 10;

    @NonNull
    private List<UserBean> mUsers;

    public UserAdapter() {
        mUsers = new ArrayList<>(10);
        for (int i = 0; i < USER_COUNT; i ++) {
            UserBean user = new UserBean();
            mUsers.add(user);
        }
    }

    public static class UserHolder extends RecyclerView.ViewHolder {
        private ItemUserBinding mBinding;

        public UserHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        public void bind(@NonNull UserBean user) {
            mBinding.setUser(user);
        }
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_user, viewGroup, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        holder.bind(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}