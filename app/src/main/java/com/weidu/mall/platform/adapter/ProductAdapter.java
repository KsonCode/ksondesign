package com.weidu.mall.platform.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.weidu.mall.platform.R;
import com.weidu.mall.platform.entity.HomeBean;

import java.util.List;

public class ProductAdapter extends XRecyclerView.Adapter<RecyclerView.ViewHolder> {
    //
    private final int TYPE_ONE = 0;
    private final int TYPE_TWO = 1;
    private final int TYPE_THREE = 2;

    private List<HomeBean.ProductItemBean> list;
    private Context context;

    public ProductAdapter(List<HomeBean.ProductItemBean> list, Context context){

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = null;
        System.out.println("pppppp==="+getItemViewType(position));
        if (getItemViewType(position)==TYPE_ONE){

            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item1_layout,viewGroup,false);

            OneVH oneVH = new OneVH(view);

            return oneVH;

        }else if (TYPE_TWO==getItemViewType(position)){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item2_layout,viewGroup,false);

            TwoVH twoVH = new TwoVH(view);

            return twoVH;

        }else{
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item3_layout,viewGroup,false);

            ThreeVH threeVH = new ThreeVH(view);

            return threeVH;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int positionn) {

        if (viewHolder instanceof OneVH){//当前vieholder对象是oneviewholder类型

                ((OneVH) viewHolder).titleTv.setText(list.get(positionn).name);
                ((OneVH) viewHolder).recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                ((OneVH) viewHolder).recyclerView.setAdapter(new ItemOneAdapter(context,list.get(positionn).commodityList));

        }else if (viewHolder instanceof TwoVH){
            ((TwoVH) viewHolder).titleTv.setText(list.get(positionn).name);
        }else{
            ((ThreeVH) viewHolder).titleTv.setText(list.get(positionn).name);
        }

    }

    @Override
    public int getItemCount() {
        return list ==null ?0:list.size();
    }

    @Override
    public int getItemViewType(int position) {
        System.out.println("pos======="+position);

        HomeBean.ProductItemBean productItemBean = list.get(position);
        if ("1002".equals(productItemBean.id)){
            return TYPE_ONE;
        }else if ("1003".equals(productItemBean.id)){
            return TYPE_TWO;
        }else {
            return  TYPE_THREE;
        }

    }

    class OneVH extends RecyclerView.ViewHolder{

        private TextView titleTv;
        private RecyclerView recyclerView;

        public OneVH(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.text1);
            recyclerView = itemView.findViewById(R.id.rv);
        }
    }
    class TwoVH extends RecyclerView.ViewHolder{
        private TextView titleTv;
        public TwoVH(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.text2);
        }
    }
    class ThreeVH extends RecyclerView.ViewHolder{
        private TextView titleTv;
        public ThreeVH(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.text3);
        }
    }
}
