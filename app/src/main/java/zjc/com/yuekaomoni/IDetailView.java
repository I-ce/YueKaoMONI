package zjc.com.yuekaomoni;

import zjc.com.yuekaomoni.bean.AddCartBean;
import zjc.com.yuekaomoni.bean.DetailBean;

public interface IDetailView {
    void detailshow(DetailBean detailBean);
    void addshow(AddCartBean addCartBean);
}
