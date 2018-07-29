package zjc.com.yuekaomoni;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import zjc.com.yuekaomoni.Adapter.TitleFragmentPagerAdapter;
import zjc.com.yuekaomoni.Fragment.PingLunFragment;
import zjc.com.yuekaomoni.Fragment.ShangPinFragmen;
import zjc.com.yuekaomoni.Fragment.XiangQingFragment;
import zjc.com.yuekaomoni.bean.AddCartBean;
import zjc.com.yuekaomoni.bean.DetailBean;
import zjc.com.yuekaomoni.presenter.DetailPresenter;

public class DetailActivity extends AppCompatActivity implements IDetailView,View.OnClickListener{
    private ImageView mIvFanhui;
    private TabLayout mTabview;
    private ImageView mIvFenxiang;
    private ImageView mIvGengduo;
    private ViewPager mPager;
    private LinearLayout mLlSupplier;
    private LinearLayout mLlShop;
    private LinearLayout mLlAttention;
    private LinearLayout mLlCard;
    /**
     * 加入购物车
     */
    private TextView mTvAddCard;
    String uid="71";
    String pid="21";
    DetailPresenter detailPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deta_activity);
        initView();
        detailPresenter = new DetailPresenter(this);
        //获取传过来的pid
//        Intent intent = getIntent();
//        pid = intent.getStringExtra("pid");
//
        detailPresenter.getDetai(pid);
    }

    private void initView() {
        mIvFanhui = (ImageView) findViewById(R.id.iv_fanhui);
        mIvFanhui.setOnClickListener(this);
        mTabview = (TabLayout) findViewById(R.id.tabview);
        mIvFenxiang = (ImageView) findViewById(R.id.iv_fenxiang);
        mIvFenxiang.setOnClickListener(this);
        mIvGengduo = (ImageView) findViewById(R.id.iv_gengduo);
        mIvGengduo.setOnClickListener(this);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setOnClickListener(this);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ShangPinFragmen());
        fragments.add(new XiangQingFragment());
        fragments.add(new PingLunFragment());
        //头部导航的适配器
        TitleFragmentPagerAdapter adapter = new TitleFragmentPagerAdapter(getSupportFragmentManager(), fragments, new String[]{"商品", "详情", "评论"});
        mPager.setAdapter(adapter);
        mTabview.setupWithViewPager(mPager);
        mLlSupplier = (LinearLayout) findViewById(R.id.llSupplier);
        mLlShop = (LinearLayout) findViewById(R.id.llShop);
        mLlAttention = (LinearLayout) findViewById(R.id.llAttention);
        mLlCard = (LinearLayout) findViewById(R.id.llCard);
        mLlCard.setOnClickListener(this);
        mTvAddCard = (TextView) findViewById(R.id.tvAddCard);
        mTvAddCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv_fanhui:
                finish();
                break;
            case R.id.iv_fenxiang:

                break;
            case R.id.iv_gengduo:
                break;
            case R.id.pager:
                break;
            case R.id.llCard:
                break;
            case R.id.tvAddCard:
                //添加购物车
                detailPresenter.getadds(uid, pid);

                break;
        }
    }

    @Override
    public void addshow(AddCartBean addCartBean) {
        //返回数据
        Toast.makeText(this, addCartBean.getMsg() + "", Toast.LENGTH_LONG).show();
    }

    @Override
    public void detailshow(DetailBean detailBean) {

    }
}
