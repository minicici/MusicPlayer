package cn.itcast.musicplayer;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private  FrameLayout content;
    private TextView tv1,tv2;
    private FragmentManager fm;//碎片管理
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = (FrameLayout) findViewById(R.id.content);

        tv1 = (TextView)findViewById(R.id.menu1);
        tv2 = (TextView)findViewById(R.id.menu2);


        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.content,new Frag1());
        ft.commit();
    }
    @Override
    public  void onClick(View v) {
        ft = fm.beginTransaction();
        switch (v.getId()){
            case R.id.menu1:
                ft.replace(R.id.content,new Frag1());
                break;
            case R.id.menu2:
                ft.replace(R.id.content,new Frag2());
                break;
            default:
                break;
        }
        ft.commit();
    }
}