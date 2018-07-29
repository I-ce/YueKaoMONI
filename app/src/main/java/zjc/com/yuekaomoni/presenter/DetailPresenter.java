package zjc.com.yuekaomoni.presenter;

import zjc.com.yuekaomoni.IDetailView;
import zjc.com.yuekaomoni.bean.AddCartBean;
import zjc.com.yuekaomoni.bean.DetailBean;
import zjc.com.yuekaomoni.model.DetailModel;
import zjc.com.yuekaomoni.model.IDtetailModel;
import zjc.com.yuekaomoni.utils.NetListenter;

public class DetailPresenter {
    private IDetailView activity;
    private final IDtetailModel model;

    public DetailPresenter(IDetailView activity) {
        this.activity = activity;
        model = new DetailModel();
    }

    public void onDestroys() {
        if (activity != null) {
            activity = null;
        }
    }

    public void getDetai(String pid) {
        model.getDetail(pid, "android", new NetListenter<DetailBean>() {
            @Override
            public void onSccess(DetailBean detailBean) {
                if (activity != null) {

                    activity.detailshow(detailBean);
                }
            }

            @Override
            public void onFailuer(Exception e) {

            }


        });
    }

    public void getadds(String uid, String pid) {
        model.getAdd(uid, pid, "android", new NetListenter<AddCartBean>() {
            @Override
            public void onSccess(AddCartBean addCartBean) {
                if (activity != null) {
                    activity.addshow(addCartBean);
                }
            }

            @Override
            public void onFailuer(Exception e) {

            }


        });

    }

}
