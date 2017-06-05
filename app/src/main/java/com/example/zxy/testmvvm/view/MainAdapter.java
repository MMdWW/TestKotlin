package com.example.zxy.testmvvm.view;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.zxy.testmvvm.BR;
import com.example.zxy.testmvvm.R;
import com.example.zxy.testmvvm.databinding.ItemUserBinding;
import com.example.zxy.testmvvm.model.UserBean;

import java.util.List;

/**
 * Created by zxy on 2017/4/28.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.BindingHolder>{
    private Context context;
    List<UserBean> userBeanList;


    public MainAdapter(Context context,List<UserBean> userBeanList) {
        this.context = context;
        this.userBeanList=userBeanList;

    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemUserBinding mItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_user, parent, false);
        BindingHolder mHolder = new BindingHolder(mItemBinding.getRoot());
        mHolder.setBinding(mItemBinding);//把mItemBinding设置给ViewHolder
        return mHolder;
    }

    @Override
    public void onBindViewHolder(final BindingHolder holder, int position) {
        //通过holder.getBinding()得到Binding Class
        UserBean user = userBeanList.get(position);
        holder.getBinding().setVariable(BR.user, user);
        holder.getBinding().executePendingBindings();//立即更新UI

        //判断是否设置了监听器
        if(mOnItemClickListener != null){
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView,position); // 2
                }
            });
        }
        if(mOnItemLongClickListener != null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(holder.itemView,position);
                    //返回true 表示消耗了事件 事件不会继续传递
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return userBeanList.size();
    }

    class BindingHolder extends RecyclerView.ViewHolder {
        private ItemUserBinding binding;

        public BindingHolder(View itemView) {
            super(itemView);
        }

        public ItemUserBinding getBinding() {
            return binding;
        }

        public void setBinding(ItemUserBinding binding) {
            this.binding = binding;
        }
    }

    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public interface OnItemLongClickListener{
        void onItemLongClick(View view,int position);
    }
}
