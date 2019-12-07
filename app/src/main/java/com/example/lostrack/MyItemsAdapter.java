package com.example.lostrack;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//implements ListAdapter
class MyItemsAdapter extends BaseAdapter {
    private ArrayList<MyItems> arrayList;
    private Context context;
    MyItemsAdapter(Context context, ArrayList<MyItems> arrayList) {
//        super(context,R.layout.example_of_list_of_items, arrayList);
        this.arrayList=arrayList;
        this.context=context;
    }
    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }
    @Override
    public boolean isEnabled(int position) {
        return true;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        observer.onChanged();
        super.registerDataSetObserver(observer);
        }
    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        super.unregisterDataSetObserver(observer);
        observer.onInvalidated();
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public MyItems getItem(int position) {
        return arrayList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MyItems myItems = arrayList.get(position);
        final ViewHolder viewHolder;
        View view;

        if(convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.example_of_list_of_items, parent, false);

            viewHolder.nameOfItem = view.findViewById(R.id.exampleTextView);
            viewHolder.iconImage = view.findViewById(R.id.exampleImageViewLeft);
            viewHolder.trashCanImage = view.findViewById(R.id.exampleImageViewTrash);
            viewHolder.position = position+1;
            viewHolder.forwardButtonImage = view.findViewById(R.id.ForwardImageView);
            viewHolder.forwardButtonImage.setOnClickListener(v -> {

            });
            viewHolder.trashCanImage.setOnClickListener(v -> {
//                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
                    arrayList.remove(position);
                    notifyDataSetChanged();
                    notifyDataSetInvalidated();
            });
            view.setTag(viewHolder);
        }else  {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.nameOfItem.setText(myItems.itemName);
        viewHolder.iconImage.setImageResource(myItems.itemImage);
        viewHolder.trashCanImage.setImageResource(R.drawable.trash);

        return view;

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }
    @Override
    public boolean isEmpty() {
        return false;
    }


}

class ViewHolder {
    ImageView iconImage;
    TextView nameOfItem;
    ImageView trashCanImage;
    ImageView forwardButtonImage;
    int position;
}