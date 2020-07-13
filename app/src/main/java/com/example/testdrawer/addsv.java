package com.example.testdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class addsv extends BaseAdapter {

    Context context;
    private int layout;
    private List<itemsv> list;

    public addsv(Context context, int layout, List<itemsv> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public class ViewHoder
    {
        TextView tvname,tvbirt,tvschool,tvsex,tvfavorite;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoder viewHoder;
        if(view==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            viewHoder=new ViewHoder();
            viewHoder.tvname=(TextView) view.findViewById(R.id.hienthiname);
            viewHoder.tvbirt=(TextView)view.findViewById(R.id.hienthinamsinh);
            viewHoder.tvschool=(TextView)view.findViewById(R.id.hienthitruonghoc);
            viewHoder.tvsex=(TextView)view.findViewById(R.id.hienthigioitinh);
            viewHoder.tvfavorite=(TextView)view.findViewById(R.id.hienthisothich);
            view.setTag(viewHoder);
        }
        else
        {
            viewHoder=(ViewHoder) view.getTag();
        }
        viewHoder.tvname.setText(list.get(i).name);
        viewHoder.tvbirt.setText(list.get(i).birt);
        viewHoder.tvschool.setText(list.get(i).school);
        viewHoder.tvsex.setText(list.get(i).sex);
        viewHoder.tvfavorite.setText(list.get(i).favorite);
        return view;
    }
}
