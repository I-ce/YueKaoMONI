package zjc.com.yuekaomoni.presenter;

import zjc.com.yuekaomoni.model.CartBean;

public interface ICartPresenter {
    void onFormSuccess(CartBean cartBean);
    void onFormFailed(String error);
}
