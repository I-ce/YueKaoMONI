package zjc.com.yuekaomoni.presenter;

import android.util.Log;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zjc.com.yuekaomoni.bean.ShoppingBean;
import zjc.com.yuekaomoni.http.HttpConfig;
import zjc.com.yuekaomoni.model.IModel;
import zjc.com.yuekaomoni.view.view.IShoppingListener;
import zjc.com.yuekaomoni.view.view.IShoppingView;

public class PresenterImpel implements IPresenter {
    private static final String TAG = "PresenterImpel----";

    @Override
    public void getShop(IModel iModel, final IShoppingView iShoppingView) {
        Map<String,String> map = new HashMap<String,String> ();

        map.put ("keywords",iShoppingView.getName ());

        map.put ("page",iShoppingView.getPage ()+"");

        map.put ("sort",iShoppingView.getSort ());

        iModel.shop (HttpConfig.url, map, new IShoppingListener () {
            @Override
            public void onSuccess(String json) {
                Log.d (TAG, "onSuccess: 成功-----");

                Gson gson = new Gson ();

                ShoppingBean shoppingBean = gson.fromJson (json, ShoppingBean.class);

                List<ShoppingBean.DataBean> list = shoppingBean.getData ();

                iShoppingView.ShowShoppingToViews (list);
            }

            @Override
            public void onError(String error) {
                Log.d (TAG, "onError: 失败-------");
            }
        });
    }
}
