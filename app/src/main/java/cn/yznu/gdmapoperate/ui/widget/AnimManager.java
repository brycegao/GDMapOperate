package cn.yznu.gdmapoperate.ui.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 作者：uiho_mac
 * 时间：2018/9/4
 * 描述：
 * 版本：1.0
 * 修订历史：
 */
public class AnimManager {
    public static final int ANIM_BOTTOM_TO_TOP = 0;
    public static final int ANIM_TOP_TO_BOTTOM = 1;

    /**
     * 动画类型
     */
    private int mAnimType = ANIM_BOTTOM_TO_TOP;
    /**
     * 变化因子
     */
    private float mAnimFactor = 0.2f;

    public void setAnimation(RecyclerView recyclerView, int position, float percent) {
        switch (mAnimType) {
            case ANIM_BOTTOM_TO_TOP:
                setBottomToTopAnim(recyclerView, position, percent);
                break;
            case ANIM_TOP_TO_BOTTOM:
                setTopToBottomAnim(recyclerView, position, percent);
                break;
            default:
                setBottomToTopAnim(recyclerView, position, percent);
                break;
        }
    }


    /**
     * 从下到上的动画效果
     *
     * @param recyclerView RecyclerView
     * @param position     int
     * @param percent      float
     */
    private void setBottomToTopAnim(RecyclerView recyclerView, int position, float percent) {
        // 中间页
        View mCurView = recyclerView.getLayoutManager().findViewByPosition(position);
        // 右边页
        View mRightView = recyclerView.getLayoutManager().findViewByPosition(position + 1);
        // 左边页
        View mLeftView = recyclerView.getLayoutManager().findViewByPosition(position - 1);
        // 右右边页
        View mRRView = recyclerView.getLayoutManager().findViewByPosition(position + 2);

        if (mLeftView != null) {
            mLeftView.setScaleX((1 - mAnimFactor) + percent * mAnimFactor);
            mLeftView.setScaleY((1 - mAnimFactor) + percent * mAnimFactor);
        }
        if (mCurView != null) {
            mCurView.setScaleX(1 - percent * mAnimFactor);
            mCurView.setScaleY(1 - percent * mAnimFactor);
        }
        if (mRightView != null) {
            mRightView.setScaleX((1 - mAnimFactor) + percent * mAnimFactor);
            mRightView.setScaleY((1 - mAnimFactor) + percent * mAnimFactor);
        }
        if (mRRView != null) {
            mRRView.setScaleX(1 - percent * mAnimFactor);
            mRRView.setScaleY(1 - percent * mAnimFactor);
        }
    }


    /***
     * 从上到下的效果
     * @param recyclerView RecyclerView
     * @param position int
     * @param percent int
     */
    private void setTopToBottomAnim(RecyclerView recyclerView, int position, float percent) {
        // 中间页
        View mCurView = recyclerView.getLayoutManager().findViewByPosition(position);
        // 右边页
        View mRightView = recyclerView.getLayoutManager().findViewByPosition(position + 1);
        // 左边页
        View mLeftView = recyclerView.getLayoutManager().findViewByPosition(position - 1);
        // 左左边页
        View mLLView = recyclerView.getLayoutManager().findViewByPosition(position - 2);

        if (mLeftView != null) {
            mLeftView.setScaleX(1 - percent * mAnimFactor);
            mLeftView.setScaleY(1 - percent * mAnimFactor);
        }
        if (mCurView != null) {
            mCurView.setScaleX((1 - mAnimFactor) + percent * mAnimFactor);
            mCurView.setScaleY((1 - mAnimFactor) + percent * mAnimFactor);
        }
        if (mRightView != null) {
            mRightView.setScaleX(1 - percent * mAnimFactor);
            mRightView.setScaleY(1 - percent * mAnimFactor);
        }
        if (mLLView != null) {
            mLLView.setScaleX((1 - mAnimFactor) + percent * mAnimFactor);
            mLLView.setScaleY((1 - mAnimFactor) + percent * mAnimFactor);
        }
    }

    public void setAnimFactor(float mAnimFactor) {
        this.mAnimFactor = mAnimFactor;
    }

    public void setAnimType(int mAnimType) {
        this.mAnimType = mAnimType;
    }
}
