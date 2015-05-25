package net.manuelbauer.android.ui;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * RecyclerView with predefined BasicLinearLayoutManager, DividerItemDecoration and DefaultItemAnimator
 */
public class BasicRecyclerView extends RecyclerView {
    public BasicRecyclerView(Context context) {
        super(context);
        init(context);
    }

    public BasicRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public BasicRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        BasicLinearLayoutManager layoutManager = new BasicLinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        this.setLayoutManager(layoutManager);
        this.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST));
        this.setItemAnimator(new DefaultItemAnimator());
        this.setHasFixedSize(true);
    }
}