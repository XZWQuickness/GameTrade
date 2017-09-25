package com.exz.gametrade.gametrade.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.activity.LoginActivity;
import com.exz.gametrade.gametrade.activity.MsgListActivity;
import com.exz.gametrade.gametrade.activity.SelectGameActivity;
import com.exz.gametrade.gametrade.adapter.BannerAdapter;
import com.exz.gametrade.gametrade.adapter.GamePropsAdapter;
import com.exz.gametrade.gametrade.adapter.MainImgAdapter;
import com.exz.gametrade.gametrade.entity.GamePropsEntity;
import com.exz.gametrade.gametrade.entity.MainImgEntity;
import com.exz.gametrade.gametrade.utils.RecycleViewDivider;
import com.jude.rollviewpager.RollPagerView;
import com.szw.framelibrary.base.MyBaseFragment;
import com.szw.framelibrary.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by pc on 2017/9/18.
 */

public class MainFragment extends MyBaseFragment {

    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.mLeftImg)
    ImageView mLeftImg;
    @BindView(R.id.mRightImg)
    ImageView mRightImg;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    List<GamePropsEntity> data = new ArrayList<>();
    List<String> dataBanner = new ArrayList<>();
    List<MainImgEntity> dataHeader = new ArrayList<>();
    GamePropsAdapter adapter;
    MainImgAdapter adapterHeader;
    int toolbarHeight;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_main, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void initView() {
        initToolbar();
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        adapter = new GamePropsAdapter(1, data);
        View headView = LayoutInflater.from(getContext()).inflate(R.layout.lay_maine_healad, null);
        adapter.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.view_empty, new RelativeLayout(getContext()), false));
        final ViewHolder v = new ViewHolder(headView);
        adapter.addHeaderView(headView);
        adapter.setHeaderAndEmpty(true);
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL,
                1, ContextCompat.getColor(getContext(), R.color.line_bg)));
        initHeader(v);
        v.moreRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Utils.INSTANCE.startActivity(getContext(), LoginActivity.class);
            }
        });

        initListeners();

    }

    int mDistanceY;

    private void initListeners() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //滑动的距离
                mDistanceY += dy;
                //toolbar的高度
                int toolbarHeight = toolbar.getBottom();

                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
                if (mDistanceY <= toolbarHeight) {
                    float scale = (float) mDistanceY / toolbarHeight;
                    float alpha = scale * 255;
                    mTitle.setVisibility(View.VISIBLE);
                    mTitle.setTextColor(Color.argb((int) alpha, 255, 255, 255));
                    toolbar.setBackgroundColor(Color.argb((int) alpha, 18, 113, 222));
                } else {
                    //上述虽然判断了滑动距离与toolbar高度相等的情况，但是实际测试时发现，标题栏的背景色
                    //很少能达到完全不透明的情况，所以这里又判断了滑动距离大于toolbar高度的情况，
                    //将标题栏的颜色设置为完全不透明状态
                    toolbar.setBackgroundResource(R.color.blue);
                    mTitle.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
                }

            }
        });

    }

    private void initHeader(ViewHolder v) {
        dataBanner.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3454737647,4030834292&fm=27&gp=0.jpg");
        dataBanner.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2851332314,1609888653&fm=27&gp=0.jpg");
        v.banner.setAdapter(new BannerAdapter(getContext(), dataBanner));

        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
        adapterHeader = new MainImgAdapter(dataHeader);
        adapterHeader.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        v.moreRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        v.moreRecyclerView.setAdapter(adapterHeader);
        v.moreGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SelectGameActivity.class).putExtra("className", getString(R.string.MoreGame)));
            }
        });
    }

    private void initToolbar() {
        toolbar.setContentInsetsAbsolute(0, 0);
        mLeftImg.setVisibility(View.GONE);
        mRightImg.setBackgroundResource(R.mipmap.ic_message);
        mTitle.setTextSize(18);
        mTitle.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        mTitle.setText(getString(R.string.home));
        toolbar.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.blue));
        mRightImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.INSTANCE.startActivity(getContext(), MsgListActivity.class);
            }
        });
    }

    static class ViewHolder {
        @BindView(R.id.banner)
        RollPagerView banner;
        @BindView(R.id.moreGame)
        TextView moreGame;
        @BindView(R.id.moreRecyclerView)
        RecyclerView moreRecyclerView;
        @BindView(R.id.newReleases)
        RadioButton newReleases;
        @BindView(R.id.rg)
        RadioGroup rg;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
