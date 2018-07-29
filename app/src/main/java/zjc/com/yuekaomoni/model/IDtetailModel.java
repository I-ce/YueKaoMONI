package zjc.com.yuekaomoni.model;

import zjc.com.yuekaomoni.bean.AddCartBean;
import zjc.com.yuekaomoni.bean.DetailBean;
import zjc.com.yuekaomoni.utils.NetListenter;

public interface IDtetailModel {
    void getAdd(String uid, String pid, String source, NetListenter<AddCartBean> onNetListner);

    void getDetail(String pid, String source, NetListenter<DetailBean> onNetListner);

}
