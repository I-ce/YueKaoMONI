package zjc.com.yuekaomoni.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;

import java.util.ArrayList;
import java.util.List;

import zjc.com.yuekaomoni.MainActivity;
import zjc.com.yuekaomoni.R;
import zjc.com.yuekaomoni.view.ShoppingActivity;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private List<String> list;
    private TextView auto_tv;
    private AutoFlowLayout auto_layout;
    private ImageView select;
    private EditText etName;
    private TextView diss;
    private ImageView delete;
    private String name;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment_layout, container, false);

        //初始化界面
        initViews();

        return view;
    }

    private void initViews() {
        //创建一个集合
        list = new ArrayList<> ();

        //得到控件
        auto_tv = view.findViewById (R.id.auto_tv);

        select = view.findViewById (R.id.select);

        etName = view.findViewById (R.id.et_name);

        auto_layout = view.findViewById (R.id.auto_layout);

        diss = view.findViewById (R.id.diss);

        delete = view.findViewById (R.id.delete);

        select.setOnClickListener (this);
        diss.setOnClickListener (this);
        delete.setOnClickListener (this);
    }
    //添加监听事件
    @Override
    public void onClick(View v) {
        switch (v.getId ()) {
            case R.id.select://搜索
                name = etName.getText ().toString ();

                list.add (name);

                auto ();
                break;
            case R.id.diss://取消
                etName.getText ().clear ();

                list.clear ();
                break;
            case R.id.delete://删除
                etName.getText ().clear ();

                list.clear ();

                auto_layout.removeAllViews ();
                break;
        }
    }

        private void auto() {
            auto_layout.setAdapter (new FlowAdapter (list) {

                private View view;

                @Override
                public View getView(int i) {

                    if(list != null){
                        view = View.inflate(getActivity (), R.layout.layout_auto, null);
                        final TextView auto_tv = view.findViewById(R.id.auto_tv);
                        final String mname=list.get(i);
                        auto_tv.setText(mname);

                        auto_tv.setOnClickListener (new View.OnClickListener () {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent (getActivity (), ShoppingActivity.class);

                                intent.putExtra ("name",mname);

                                startActivity (intent);
                            }
                        });
                        list.clear();
                    }

                    return view;
                }
            });

        }
}
