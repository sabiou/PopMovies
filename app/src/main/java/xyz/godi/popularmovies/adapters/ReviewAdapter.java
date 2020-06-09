package xyz.godi.popularmovies.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.godi.popularmovies.R;
import xyz.godi.popularmovies.model.Review;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private Context mContext;
    private List<Review> reviewList;

    // review adapter
    public ReviewAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(mContext)
                .inflate(R.layout.review_item, parent, false);
        return new ReviewViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        // get the review item located at $position
        Review reviewItem = reviewList.get(position);

        // set the author pseudo
        holder.authorPseudo.setText(reviewItem.getAuthor());
        // set the review content
        holder.contentText.setText(reviewItem.getContent());
    }

    @Override
    public int getItemCount() {
        return reviewList == null ? 0 : reviewList.size();
    }

    // add all reviews
    public void setItems(List<Review> items) {
        reviewList = new ArrayList<>();
        reviewList.clear();
        this.reviewList.addAll(items);
        notifyDataSetChanged();
    }

    // Review viewHolder
    class ReviewViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.author_tv)
        TextView authorPseudo;
        @BindView(R.id.content_tv) TextView contentText;
        ReviewViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
