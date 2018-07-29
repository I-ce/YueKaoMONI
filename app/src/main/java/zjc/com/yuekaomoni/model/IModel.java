package zjc.com.yuekaomoni.model;

import java.util.Map;

import zjc.com.yuekaomoni.view.view.IShoppingListener;

public interface IModel {
    //商品详情
    void shop(String url, Map<String,String> map, IShoppingListener iShoppingListener);
}
