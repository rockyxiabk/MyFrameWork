package com.rocky.myframework.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.rocky.myframework.R;
import com.rocky.myframework.bean.Person;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by y7un on 2016/4/22.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Person> list;

    public MyAdapter(Context context, List<Person> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null != convertView) {
            holder = ((ViewHolder) convertView.getTag());
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.items, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder.name.setText(list.get(position).getName());
        holder.num.setText(list.get(position).getNum());
        holder.itemIv.setImageURI(Uri.parse(""));
        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.item_iv)
        SimpleDraweeView itemIv;
        @Bind(R.id.item_name)
        TextView name;
        @Bind(R.id.item_des)
        TextView num;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}