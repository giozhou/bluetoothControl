package com.example.bt;

import java.io.File;
import java.util.Hashtable;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DiyListAdapter extends ArrayAdapter<Hashtable>{ 
    private int resource; 
    public DiyListAdapter(Context context, int resourceId, List<Hashtable> objects) { 
        super(context, resourceId, objects); 
        // ��¼�����Ժ�ʹ�� 
        resource = resourceId; 
    }

    public View getView(int position, View convertView, ViewGroup parent) { 
        LinearLayout imageListView; 
        // ��ȡ���� 
        Hashtable obj = getItem(position); 
//        String fileName = file.getName(); 
//        Bitmap bitmap = getBitmapFromFile(file);

        // ϵͳ��ʾ�б�ʱ������ʵ����һ�������������ｫʵ�����Զ�������������� 
        // ���ֶ��������ʱ�������ֶ�ӳ�����ݣ�����Ҫ��дgetView���������� 
        // ϵͳ�ڻ����б��ÿһ�е�ʱ�򽫵��ô˷����� 
        // getView()������������ 
        // position��ʾ����ʾ���ǵڼ��У� 
        // covertView�ǴӲ����ļ���inflate���Ĳ��֡� 
        // ������LayoutInflater�ķ���������õ�image_item.xml�ļ���ȡ��Viewʵ��������ʾ�� 
        // Ȼ��xml�ļ��еĸ������ʵ�������򵥵�findViewById()�������� 
        // ��������Խ����ݶ�Ӧ������������ˡ� 
        // 
        if(convertView == null) { 
            imageListView = new LinearLayout(getContext()); 
            // ��һ��android�ĵ��й���LayoutInflater�Ķ���� 
            // This class is used to instantiate layout XML file into its corresponding View objects. 
            // It is never be used directly -- use getLayoutInflater() or getSystemService(String) 
            // to retrieve a standard LayoutInflater instance that is already hooked up to the current 
            // context and correctly configured for the device you are running on. . For example: 
            String inflater = Context.LAYOUT_INFLATER_SERVICE; 
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater); 
            vi.inflate(resource, imageListView, true); 
            // ���ÿ��select imagesʱ�������� 
            Log.d("Adapter", "convertView is null now"); 
        } else {
            // ����ֻ���û�����ù� 
            imageListView = (LinearLayout)convertView;
            Log.d("Adapter", "convertView is not null now");
        }

        // ����Զ������� 
//        ImageView imageView = (ImageView) imageListView.findViewById(R.id.imageView1); 
        TextView textView = (TextView) imageListView.findViewById(R.id.MyAdapter_TextView_info);
        TextView textView2 = (TextView) imageListView.findViewById(R.id.textView1);
        ImageView imageView = (ImageView) imageListView.findViewById(R.id.imageView1);
        textView.setText((String)obj.get("name"));
        textView2.setText((String)obj.get("status"));
        if ((String)obj.get("pic") == ""){
        	imageView.setVisibility(View.INVISIBLE);
        }
        else{
        	if ((String)obj.get("pic") == "@drawable/tip"){
            	imageView.setImageResource(R.drawable.tip);
        	}
        	else{
            	imageView.setImageResource(R.drawable.tip_gray);
        	}
        }
        	
//        imageView.setImageBitmap(bitmap);

        return imageListView; 
    }

    // ���ļ���ȡBitmap������� 
    private Bitmap getBitmapFromFile(File file) { 
        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath()); 
        return  bitmap; 
    } 
}