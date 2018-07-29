package zjc.com.yuekaomoni.model;

import com.google.gson.Gson;
import java.util.Map;
import zjc.com.yuekaomoni.bean.ShoppingBean;
import zjc.com.yuekaomoni.utils.HttpUtils;
import zjc.com.yuekaomoni.view.view.IShoppingListener;

public class ModelImpel implements IModel {

    //搜索列表
    @Override
    public void shop(String url, Map<String, String> map, final IShoppingListener iShoppingListener) {
        HttpUtils httpUtils = HttpUtils.getHttpUtils ();

        httpUtils.okPost (url,map);

        httpUtils.setOkLoadListener (new HttpUtils.OkLoadListener () {
            @Override
            public void okLoadSuccess(String json) {
                Gson gson = new Gson ();

                ShoppingBean shoppingBean = gson.fromJson (json, ShoppingBean.class);

                if(shoppingBean.getCode ().equals ("0")){
                       iShoppingListener.onSuccess (json);
                }else{
                    iShoppingListener.onError (json);
                }
            }

            @Override
            public void okLoadError(String error) {
               iShoppingListener.onError (error);
            }
        });
    }
}
