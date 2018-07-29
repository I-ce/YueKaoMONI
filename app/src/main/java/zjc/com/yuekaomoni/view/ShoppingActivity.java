package zjc.com.yuekaomoni.view;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.List;

import zjc.com.yuekaomoni.DetailActivity;
import zjc.com.yuekaomoni.R;
import zjc.com.yuekaomoni.adapters.ShoppingRecycleAdapter;
import zjc.com.yuekaomoni.base.BaseActivity;
import zjc.com.yuekaomoni.bean.ShoppingBean;
import zjc.com.yuekaomoni.model.ModelImpel;
import zjc.com.yuekaomoni.presenter.PresenterImpel;
import zjc.com.yuekaomoni.view.view.IShoppingView;

public class ShoppingActivity extends BaseActivity implements View.OnClickListener,IShoppingView{
    private static final String TAG = "ShoppingActivity---";
    private String tvName;
    private ImageView back;
    private ImageView select;
    private EditText etName;
    private ImageView xx;
    private ImageView diss;
    private Button tvZhonghe;
    private Button tvXiaoliang;
    private Button tvPrice;
    private int page=1;
    private String sort="0";
    private ShoppingRecycleAdapter shoppingRecycleAdapter;
    private XRecyclerView xRecyclerView;
    private PresenterImpel presenterImpel;
    private String name;
    private boolean b = false;

    @Override
    protected void initData() {
        //得到intent
        Intent intent = getIntent ();

        //判断
        if (intent != null) {
            tvName = intent.getStringExtra ("name");

            Log.d (TAG, "onCreate:(数据信息-----) " + tvName);
        }

        presenterImpel = new PresenterImpel ();

        //赋值
        etName.setText (tvName);

        xRecyclerView.setLoadingListener (new XRecyclerView.LoadingListener () {
            @Override
            public void onRefresh() {
                page ++;

                presenterImpel.getShop (new ModelImpel (),ShoppingActivity.this);

                xRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;

                presenterImpel.getShop (new ModelImpel (),ShoppingActivity.this);

                xRecyclerView.loadMoreComplete();
            }
        });
    }

    @Override
    protected void initView() {
        //得到控件
        back = findViewById (R.id.back);

        xRecyclerView = findViewById (R.id.xrecycle);

        select = findViewById (R.id.select);

        etName = findViewById (R.id.et_name);

        xx = findViewById (R.id.Xx);

        diss = findViewById (R.id.diss);

        tvZhonghe = findViewById (R.id.tvZhonghe);

        tvXiaoliang = findViewById (R.id.tvXiaoliang);

        tvPrice = findViewById (R.id.tvPrice);

        back.setOnClickListener (this);
        select.setOnClickListener (this);
        xx.setOnClickListener (this);
        diss.setOnClickListener (this);
        tvZhonghe.setOnClickListener (this);
        tvXiaoliang.setOnClickListener (this);
        tvPrice.setOnClickListener (this);
    }

    @Override
    protected int createView() {
        //返回布局
        return R.layout.activity_shopping;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId ()){
            case R.id.back://返回

                finish ();

                break;
            case R.id.select://查询
                //获取输入框内容
                name = etName.getText ().toString ();

                presenterImpel.getShop (new ModelImpel (),ShoppingActivity.this);

                break;
            case R.id.Xx://取消

                //清空
                etName.getText ().clear ();

                break;
            case R.id.diss://切换
                if (b == false) {
                    //点击后想要变成什么要的布局样式就搞一个你的需求
                    xRecyclerView .setLayoutManager(new GridLayoutManager (ShoppingActivity.this, 2));

                    //给布尔值重新赋值
                    b = true;

                    //给点击按钮的图片重新赋值
                    diss.setImageResource(R.mipmap.ac3);
                } else if (b == true) {
                    xRecyclerView.setLayoutManager(new LinearLayoutManager(ShoppingActivity.this));

                    //给布尔值重新赋值
                    b = false;
                    diss.setImageResource(R.mipmap.kind_grid);

                    //给点击按钮的图片重新赋值
                    /*   cIv.setImageResource(R.mipmap.ic_grid);*/
                }
                break;
            case R.id.tvZhonghe://综合
                sort = "0";

                presenterImpel.getShop (new ModelImpel (),ShoppingActivity.this);
                break;
            case R.id.tvXiaoliang://销量
                sort = "1";

                presenterImpel.getShop (new ModelImpel (),ShoppingActivity.this);
                break;
            case R.id.tvPrice://价格
                sort = "2";

                presenterImpel.getShop (new ModelImpel (),ShoppingActivity.this);
                break;
        }
    }

    @Override
    public void ShowShoppingToViews(List<ShoppingBean.DataBean> data) {
        Log.d (TAG, "ShowShoppingToViews:数据信息---- "+data);

        //设置适配器
        shoppingRecycleAdapter = new ShoppingRecycleAdapter (this, data);

        xRecyclerView.setLayoutManager (new LinearLayoutManager (this));

        xRecyclerView.setAdapter (shoppingRecycleAdapter);

        shoppingRecycleAdapter.setOnClickItemListener(new ShoppingRecycleAdapter.OnClickItemListener() {
            @Override
            public void onItemClick(View v, int position) {
                startActivity(new Intent(ShoppingActivity.this, DetailActivity.class));
            }
        });
    }

    //输入框内容
    @Override
    public String getName() {
        return name;
    }

    //页数
    @Override
    public int getPage() {
        return page;
    }

    //排序参数值
    @Override
    public String getSort() {
        return sort;
    }
}
