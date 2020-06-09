package xyz.godi.popularmovies.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import xyz.godi.popularmovies.model.Video;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.godi.popularmovies.R;
import xyz.godi.popularmovies.utils.ConstantsUtils;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder> {

    private Context mContext;
    // trailer item
    private List<Video> videoList;

    public TrailerAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public TrailerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(mContext)
                .inflate(R.layout.trailer_item,parent,false);

        return new TrailerViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerViewHolder holder, int position) {
        Video trailersItem = videoList.get(position);
        // bind data
        Uri thumbUrl = Uri.parse(ConstantsUtils.YOUTUBE_THUMB__URL).buildUpon()
                .appendPath(trailersItem.getVideoKey()).appendPath("hqdefault.jpg").build();
        Log.println(Log.ASSERT,"URL",thumbUrl.toString());
        Picasso.get()
                .load(thumbUrl)
                .placeholder(new ColorDrawable(Color.GRAY))
                .error(new ColorDrawable(Color.BLACK))
                .into(holder.trailer_iv);
    }

    @Override
    public int getItemCount() {
        return videoList == null ? 0 : videoList.size();
    }

    public void setItems(List<Video> items) {
        videoList = new ArrayList<>();
        this.videoList.addAll(items);
        notifyDataSetChanged();
    }

    class TrailerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.iv_trailer_thumb)
        ImageView trailer_iv;

        TrailerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Video video = videoList.get(position);
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("vnd.youtube:" +video.getVideoKey()));
            v.getContext().startActivity(intent);
        }
    }
}
