package zjc.com.yuekaomoni.view.view;

import java.util.List;

import zjc.com.yuekaomoni.model.CartBean;

public interface ICartView {
    void onSuccess(List<CartBean.DataBean> data);

    void onFailed(String err);
}
