package com.exz.gametrade.gametrade.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.exz.gametrade.gametrade.R;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.szw.framelibrary.imageloder.GlideApp;

import java.util.List;


public class BannerAdapter extends StaticPagerAdapter {

    private Context ctx;
    private List<String> list;

    public BannerAdapter(Context ctx, List<String> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @Override
    public View getView(ViewGroup container, final int position) {
        View inflate = View.inflate(ctx, R.layout.banner_imgview, null);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img);
        //加载图片
        GlideApp.with(ctx)                             //配置上下文
                .load(list.get(position))
                .error(R.mipmap.icon_load_default)           //设置错误图片
                .placeholder(R.mipmap.icon_load_default)     //设置占位图片
                .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                .into(imageView);
        return inflate;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
