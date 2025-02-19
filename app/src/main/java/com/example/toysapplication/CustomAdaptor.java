package com.example.toysapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CustomAdaptor extends BaseAdapter {
    private Context context ;
    private List<ProductList> productList;



    public CustomAdaptor(Context context, List<ProductList> productList)
    {
        this.context = context;
        this.productList = productList;


    }



    @Override
    public int getCount(){
        return  productList.size();
    }


    @Override
    public  Object getItem(int position){
        return  productList.get(position);
    }


    @Override
    public  long getItemId(int position)
    {
        return  position;
    }

    @Override
    public View getView(int position , View contentView , ViewGroup parent)
    {
        if(contentView == null)
        {
            contentView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        }

        TextView toysName = contentView.findViewById(R.id.toysName);
        TextView toysPrice = contentView.findViewById(R.id.toysPrice);
        ImageView toysImage = contentView.findViewById(R.id.toysImage);

        ProductList product = productList.get(position);

        toysName.setText(product.getName());
        toysPrice.setText(product.getPrice());

        Glide.with(context)
                .load(product.getImageResId())
                .override(200, 200)
                .centerCrop()
                .into(toysImage);

        return contentView;
    }
}