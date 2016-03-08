package in.swatcchindia.goclean;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PROPHET on 06-03-2016.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    List<ListItem> items;

    public CardAdapter(String[] names, String[] url, Bitmap[] images) {
        super();
        items = new ArrayList<ListItem>();
        for (int i = 0; i < names.length; ++i) {
            ListItem item = new ListItem();
            item.setName(names[i]);
            item.setUrl(url[i]);
            item.setImage(images[i]);
            items.add(item);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    ListItem list = items.get(position);
        holder.imageView.setImageBitmap(list.getImage());
        holder.textViewUrl.setText(list.getUrl());
        holder.textViewName.setText(list.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewUrl;
        public ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);


        }
    }
}
