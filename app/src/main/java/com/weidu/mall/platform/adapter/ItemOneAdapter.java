package com.weidu.mall.platform.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weidu.mall.platform.R;
import com.weidu.mall.platform.entity.ProductBean;

import java.util.List;

public class ItemOneAdapter extends RecyclerView.Adapter<ItemOneAdapter.MyVh> {
    private Context context;
    private List<ProductBean.ProductItemBean.ProductItem> commodityList ;
    public ItemOneAdapter(Context context,List<ProductBean.ProductItemBean.ProductItem> commodityList) {
        this.commodityList = commodityList;
        this.context =context;
    }

    @NonNull
    @Override
    public MyVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemone_layout,viewGroup,false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVh myVh, int i) {

        myVh.titleTv.setText(commodityList.get(i).commodityName);
        Glide.with(context).load(commodityList.get(i).masterPic).into(myVh.iv);
        myVh.priceTv.setText("¥："+commodityList.get(i).price);


    }

    @Override
    public int getItemCount() {
        return commodityList.size();
    }

    public class MyVh extends RecyclerView.ViewHolder{
        private TextView titleTv,priceTv;
        private ImageView iv;
        public MyVh(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.tv);
            iv = itemView.findViewById(R.id.iv);
            priceTv = itemView.findViewById(R.id.price);

        }
    }
}
