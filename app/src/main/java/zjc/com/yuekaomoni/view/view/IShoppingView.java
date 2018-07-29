package zjc.com.yuekaomoni.view.view;

import java.util.List;

import zjc.com.yuekaomoni.bean.ShoppingBean;

public interface IShoppingView {
    void ShowShoppingToViews(List<ShoppingBean.DataBean> data);

    //输入框内容
    String getName();

    //页数
    int getPage();

    //排序参数
    String getSort();
}
