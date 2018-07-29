package zjc.com.yuekaomoni.view.view;

public interface IShoppingListener {
    //成功
    void onSuccess(String json);

    //失败
    void onError(String error);
}
