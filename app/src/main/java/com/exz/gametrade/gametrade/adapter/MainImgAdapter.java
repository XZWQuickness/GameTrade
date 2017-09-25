package com.exz.gametrade.gametrade.adapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.entity.MainImgEntity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc on 2017/9/18.
 */

public class MainImgAdapter extends BaseQuickAdapter<MainImgEntity, BaseViewHolder> {

    @BindView(R.id.img)
    SimpleDraweeView img;
    @BindView(R.id.title)
    TextView title;

    public MainImgAdapter(@Nullable List<MainImgEntity> data) {
        super(R.layout.item_main_img, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainImgEntity item) {
        ButterKnife.bind(this, helper.itemView);
        img.setImageURI(item.getImg());
        title.setText(item.getTitle());


    }
}
