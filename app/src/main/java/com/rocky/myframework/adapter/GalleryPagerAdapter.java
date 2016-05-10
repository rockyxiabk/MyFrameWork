package com.rocky.myframework.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by y7un on 2016/5/3.
 */
public class GalleryPagerAdapter extends PagerAdapter {
    private Context context;
    private int[] images;

    public GalleryPagerAdapter(Context context, int[] list) {
        this.context = context;
        this.images = list;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView item = new ImageView(context);
        item.setScaleType(ImageView.ScaleType.CENTER_CROP);
        item.setImageResource(images[position]);
        container.addView(item);
        return item;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }
}
