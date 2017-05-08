package com.caiiiyua.bleplayground.ui.scanner;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.caiiiyua.bleplayground.R;
import com.caiiiyua.bleplayground.data.local.Timeline;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by pp on 29/01/17.
 */
public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder> {

    private List<Timeline> mTimelines = new ArrayList<>();
    private Context mContext;

    public TimelineAdapter(TimelineActivity context) {
        mContext = context;
    }

    @Override
    public TimelineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_device, parent, false);
        return new TimelineViewHolder(itemView, mContext);
    }

    @Override
    public void onBindViewHolder(TimelineViewHolder holder, int position) {
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mTimelines.size();
    }

    public void setTimeline(List<Timeline> timelines) {
        mTimelines = timelines;
    }

    class TimelineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Context mContext;

        public TimelineViewHolder(View itemView, Context context) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = context;
        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
        }
    }
}
