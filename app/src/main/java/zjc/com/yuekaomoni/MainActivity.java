package zjc.com.yuekaomoni;

import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import zjc.com.yuekaomoni.base.BaseActivity;
import zjc.com.yuekaomoni.view.fragment.CartFragment;
import zjc.com.yuekaomoni.view.fragment.DzFragment;
import zjc.com.yuekaomoni.view.fragment.HomeFragment;
import zjc.com.yuekaomoni.view.fragment.MyFragment;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_bottom)
    BottomTabBar mainBottom;

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {

    }

    /**
     * 初始化控件
     */
    @Override
    protected void initView() {
        //.setChangeColor(R.color.headercolor, Color.BLACK)
        ButterKnife.bind(this);
        /*
         * 底部导航
         * */
        mainBottom.init(getSupportFragmentManager())
                .setImgSize(80, 60)
                .setFontSize(12)
                .setTabPadding(10, 6, 10)
                .addTabItem("首页", R.mipmap.ac1, R.mipmap.ac0, HomeFragment.class)
                .addTabItem("店主招募", R.mipmap.abx, R.mipmap.abw, DzFragment.class)
                .addTabItem("购物车", R.mipmap.abv, R.mipmap.abu, CartFragment.class)
                .addTabItem("个人", R.mipmap.ac3, R.mipmap.ac2, MyFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
//                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                        if (position == 0) {
                            //recommendTvHeadername.setText("推荐");
                        } else if (position == 1) {
                            //recommendTvHeadername.setText("段子");
                        } else if (position == 2) {
                           // recommendTvHeadername.setText("视频");
                        }
                    }
                });
    }

    /**
     * 初始化视图
     *
     * @return
     */
    @Override
    protected int createView() {
        return R.layout.activity_main;
    }

}
