package com.app.dialogpopupwindow.popup;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;

import com.app.dialogpopupwindow.utils.ViewUtil;

/**
 * Created by 神马都是浮云 on 2017-10-29.
 */
public class CommonPopupWindow extends PopupWindow {

    final PopupController mPopupController;

    public CommonPopupWindow(Context context) {
        super(context);
        mPopupController = new PopupController(context,this);
    }

    /**
     * 弹框的高度
     * @return
     */
    @Override
    public int getHeight() {
        return super.getHeight();
    }

    /**
     * 弹框的宽度
     * @return
     */
    @Override
    public int getWidth() {
        return super.getWidth();
    }

    /**
     * 弹框小时
     */
    @Override
    public void dismiss() {
        super.dismiss();
        mPopupController.setBackGroundLevel(1.0f);// 恢复透明度
    }

    //--------------------------------popupWindow的显示位置---------------------------------------

    /**
     * 默认显示parent的位置Gravity.CENTER
     * @param parent
     * @param gravity
     * @return
     */
    public PopupWindow showNormal(View parent, int gravity) {
        this.showAtLocation(parent, gravity,0,0);
        return this;
    }

    /**
     * 默认显示parent的位置Gravity.CENTER
     * @param parent
     * @param gravity
     * @return
     */
    public PopupWindow showLeft(View parent, int gravity) {
        this.showAtLocation(parent, gravity,0,0);
        return this;
    }

    /**
     * 默认显示parent的位置Gravity.CENTER
     * @param parent
     * @param gravity
     * @return
     */
    public PopupWindow showUp(View parent, int gravity) {
        this.showAtLocation(parent, gravity,0,0);
        return this;
    }

    /**
     * 默认显示parent的位置Gravity.CENTER
     * @param parent
     * @param gravity
     * @return
     */
    public PopupWindow showRight(View parent, int gravity) {
        this.showAtLocation(parent, gravity,0,0);
        return this;
    }
    /**
     * 展示在目标parent的左下方
     * @param parent
     * @param gravity
     * @return
     */
    public PopupWindow showBottom(View parent, int gravity) {
//        int[] viewLocation = ViewUtil.getViewLocation(parent);
//        int[] viewWH = ViewUtil.getViewWH(parent);
        this.showAtLocation(parent, gravity, 0,0);
        return this;
    }
    //仿AlertDialog中的Builder
    public static class Builder {
        private final PopupController.PopupParams param;


        public Builder(Context context) {
            this.param = new PopupController.PopupParams(context);
        }

        /**
         * 设置PopupWindow的布局ID
         * @param layoutResId
         * @return
         */
        public Builder setView(int layoutResId) {
            param.mView = null;//重复创建的时候蒋之前的View清楚
            param.layoutResId = layoutResId;
            return this;
        }
        /**
         * @param view 设置PopupWindow布局
         * @return Builder
         */
        public Builder setView(View view) {
            param.mView = view;
            param.layoutResId = 0;
            return this;
        }

        /**
         * 设置宽度和高度 如果不设置 默认是wrap_content
         *
         * @param width 宽
         * @return Builder
         */
        public Builder setWidthAndHeight(int width, int height) {
            param.mWidth = width;
            param.mHeight = height;
            return this;
        }

        /**
         * 设置背景灰色程度
         *
         * @param level 0.0f-1.0f
         * @return Builder
         */
        public Builder setBackGroundLevel(float level) {
            param.isShowBg = true;
            param.bg_level = level;
            return this;
        }

        /**
         * 是否可点击Outside消失
         *
         * @param touchable 是否可点击
         * @return Builder
         */
        public Builder setOutsideTouchable(boolean touchable) {
            param.isTouchable = touchable;
            return this;
        }

        /**
         * 设置动画
         *
         * @return Builder
         */
        public Builder setAnimationStyle(int animationStyle) {
            param.isShowAnim = true;
            param.animationStyle = animationStyle;
            return this;
        }

        /**
         * popupWindow的创建
         * @return
         */
        public CommonPopupWindow create() {
            final CommonPopupWindow popupWindow = new CommonPopupWindow(param.mContext);
            param.apply(popupWindow.mPopupController);
            ViewUtil.measureWidthAndHeight(popupWindow.mPopupController.mPopupView);
            return popupWindow;
        }
    }
}
