package com.shashank.apidatafetchassigment.common;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sha2nkk on 17/2/16.
 */
public class SpacingItemDecoration extends RecyclerView.ItemDecoration {

    private float mLeftSpace;
    private float mTopSpace;
    private float mRightSpace;
    private float mBottomSpace;

    public SpacingItemDecoration(float LeftSpace, float TopSpace, float RightSpace, float BottomSpace) {
        this.mLeftSpace = LeftSpace;
        this.mTopSpace = TopSpace;
        this.mRightSpace = RightSpace;
        this.mBottomSpace = BottomSpace;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mLeftSpace != -1 )
            outRect.left = (int) mLeftSpace;

        if (mRightSpace != -1)
            outRect.right = (int) mRightSpace;

        if (mBottomSpace != -1)
            outRect.bottom = (int) mBottomSpace;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildPosition(view) == 0 && mTopSpace != -1)
            outRect.top = (int) mTopSpace;
    }
}
