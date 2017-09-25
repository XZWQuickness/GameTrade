package com.exz.gametrade.gametrade.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.adapter.MainImgAdapter;
import com.exz.gametrade.gametrade.adapter.SelectGameAdapter;
import com.exz.gametrade.gametrade.entity.MainImgEntity;
import com.exz.gametrade.gametrade.entity.SelectGamEntity;
import com.exz.gametrade.gametrade.utils.MyLinearLayoutManager;
import com.exz.gametrade.gametrade.utils.RecycleViewDivider;
import com.exz.gametrade.gametrade.utils.SideBar;
import com.szw.framelibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pc on 2017/9/19.
 * 选择游戏
 */

public class SelectGameActivity extends BaseActivity {
    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edContent)
    EditText edContent;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    SelectGameAdapter adapter;
    @BindView(R.id.dialog)
    TextView dialog;
    @BindView(R.id.mSideBar)
    SideBar mSideBar;
    RecyclerView mHotGameRecyler;
    private List<SelectGamEntity> listBeen = new ArrayList<>();
    MainImgAdapter adapterHeader;
    List<MainImgEntity> dataHeader = new ArrayList<>();
    MyLinearLayoutManager mLinearLayoutManager = null;

    @Override
    public boolean initToolbar() {
        toolbar.setContentInsetsAbsolute(0, 0);
        mTitle.setTextSize(16);
        mTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        mTitle.setText(getIntent().getStringExtra("className"));
        toolbar.setBackgroundResource(R.color.blue);
        return false;
    }

    @Override
    public int setInflateId() {
        return R.layout.activity_select_game;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mSideBar.setTextView(dialog);
        mLinearLayoutManager = new MyLinearLayoutManager(mContext);
        mSideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                int position = getPositionForSection(s);
                if (position != -1) {

                    MoveToPosition(mLinearLayoutManager, mRecyclerView, position);
                }
            }
        });
        adapter = new SelectGameAdapter();
        adapter.setNewData(JSON.parseArray(json, SelectGamEntity.class));

        adapter.setEmptyView(LayoutInflater.from(mContext).inflate(R.layout.view_empty, new RelativeLayout(mContext), false));

        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(mContext, LinearLayoutManager.VERTICAL,
                1, ContextCompat.getColor(mContext, R.color.line_bg)));
        edContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() <= 0) {
                    mSideBar.setVisibility(View.VISIBLE);
                    if (mHotGameRecyler != null) mHotGameRecyler.setVisibility(View.VISIBLE);
                    adapter.setNewData(JSON.parseArray(json, SelectGamEntity.class));
                    mRecyclerView.setAdapter(adapter);
                } else {
                    mSideBar.setVisibility(View.GONE);
                    if (mHotGameRecyler != null) mHotGameRecyler.setVisibility(View.GONE);
                    listBeen.clear();
                    for (SelectGamEntity selectCoachEntity : adapter.getData()) {
                        for (SelectGamEntity.LetterListBean coachListBean : selectCoachEntity.getLetterList()) {
                            if (coachListBean.getName().contains(s)) {
                                listBeen.add(selectCoachEntity);
                            }
                        }
                    }
                    adapter.setNewData(listBeen);
                    adapter.loadMoreEnd();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        if (getIntent().getStringExtra("className").equals(getString(R.string.MoreGame))) {

//            initHeader();
        }


    }

    int headerHeight = 0;

//    private void initHeader() {
//        final View v = LayoutInflater.from(mContext).inflate(R.layout.lay_hot_game, null);
//        mHotGameRecyler = v.findViewById(R.id.mHotGameRecyler);
//        adapter.addHeaderView(v);
//        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
//        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
//        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
//        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
//        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
//        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
//        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
//        dataHeader.add(new MainImgEntity("王者荣耀", "http://img2.imgtn.bdimg.com/it/u=2580465248,3953034496&fm=27&gp=0.jpg"));
//        adapterHeader = new MainImgAdapter(dataHeader);
//        adapterHeader.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
//        mHotGameRecyler.setLayoutManager(new GridLayoutManager(mContext, 4));
//        mHotGameRecyler.setAdapter(adapterHeader);
////        mSideBar.setVisibility(View.GONE);
//        mHotGameRecyler.addOnItemTouchListener(new OnItemClickListener() {
//            @Override
//            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Utils.INSTANCE.startActivity(mContext, LoginActivity.class);
//            }
//        });
//
//    }


    /**
     * RecyclerView 移动到当前位置，
     *
     * @param manager       设置RecyclerView对应的manager
     * @param mRecyclerView 当前的RecyclerView
     * @param n             要跳转的位置
     */
    public static void MoveToPosition(LinearLayoutManager manager, RecyclerView mRecyclerView, int n) {


        int firstItem = manager.findFirstVisibleItemPosition();
        int lastItem = manager.findLastVisibleItemPosition();
        if (n <= firstItem) {
            mRecyclerView.scrollToPosition(n);
        } else if (n <= lastItem) {
            int top = mRecyclerView.getChildAt(n - firstItem).getTop();
            mRecyclerView.scrollBy(0, top);
        } else {
            mRecyclerView.scrollToPosition(n);
        }

    }


    public int getPositionForSection(String letter) {
        int index = -1;
        for (int i = 0; i < adapter.getData().size(); i++) {
            String sortStr = adapter.getData().get(i).getLetter().toUpperCase();
            if (sortStr.equals(letter)) {
                index = i;
                break;
            }
        }

        return index;
    }


    String json = "[\n" +
            "    {\n" +
            "        \"letter\": \"A\",\n" +
            "        \"letterList\": [\n" +
            "            {\n" +
            "                \"name\": \"艾尔战记\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"暗黑力量\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"letter\": \"B\",\n" +
            "        \"letterList\": [\n" +
            "            {\n" +
            "                \"name\": \"霸气江湖\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"name\": \"霸王的大陆\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "]";


    @OnClick(R.id.mLeftImg)
    public void onViewClicked() {
        finish();
    }
}
