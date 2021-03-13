package cn.itcast.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment {
    private View view;
    private  String[] Song ={"THIRSTY","BAD GIRL","Let It Rain","Lips","SLOW DOWN","歌舞伎町女王"};
    private  String[] message ={"Girl'Day","少女时代","少女时代","少女时代","向井太一","椎名林檎"};
    public static   int[] icons ={R.drawable.t1,R.drawable.t2,R.drawable.t4,R.drawable.t5,R.drawable.t4,R.drawable.t5,R.drawable.t6,R.drawable.t7};
    @Override
    public  View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState) {
        view = inflater.inflate(R.layout.fragment_frag1,null);
        ListView listView =view.findViewById(R.id.lv);
        MyBaseAdapter mAdapter = new  MyBaseAdapter();
        listView.setAdapter(mAdapter);
                                                                              //*************添加list点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
               Intent intent = new Intent(Frag1.this.getContext(), MusicActivity.class);
               intent.putExtra("Song",Song[i]);
               intent.putExtra("position",String.valueOf(i));
               startActivity(intent);
            }
        });
        return view;
    };

    class MyBaseAdapter extends BaseAdapter {
        @Override
        public int getCount(){
            return Song.length;
        }
        @Override
        public Object getItem(int i) {
            return Song[i];
        }
        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView,ViewGroup parent) {
            View view = View.inflate(Frag1.this.getContext(),R.layout.list_item,null);
            TextView title = (TextView) view.findViewById(R.id.Song);
            TextView mood = (TextView) view.findViewById(R.id.Singer);
            ImageView iv = (ImageView) view.findViewById(R.id.iv);

            title.setText(Song[i]);
            mood.setText(message[i]);
            iv.setBackgroundResource(icons[i]);
            return view;

        }
    }
}
