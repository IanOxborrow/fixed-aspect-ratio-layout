package ian.oxborrow.fixedaspectratiolayout;

/**
 * @author Created by Ian for Flawless Logic on 8/07/2016.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FixedAspectRatioLinearLayout extends LinearLayout {
    private int mAspectRatioWidth;
    private int mAspectRatioHeight;
    private String mDeterminingSide;

    public FixedAspectRatioLinearLayout(Context context) {
        super(context);
    }

    public FixedAspectRatioLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    public FixedAspectRatioLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FixedAspectRatioLinearLayout);

        mAspectRatioWidth = a.getInt(R.styleable.FixedAspectRatioLinearLayout_ll_aspect_ratio_width, 4);
        mAspectRatioHeight = a.getInt(R.styleable.FixedAspectRatioLinearLayout_ll_aspect_ratio_height, 3);
        mDeterminingSide = a.getString(R.styleable.FixedAspectRatioLinearLayout_ll_determining_side);

        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int originalWidth = MeasureSpec.getSize(widthMeasureSpec);
        int originalHeight = MeasureSpec.getSize(heightMeasureSpec);

        int finalWidth, finalHeight;

        if (mDeterminingSide != null && mDeterminingSide.equals("vertical")) {

            finalHeight = originalHeight;
            finalWidth = originalHeight * mAspectRatioWidth / mAspectRatioHeight;

        } else if (mDeterminingSide != null && mDeterminingSide.equals("horizontal")) {

            finalWidth = originalWidth;
            finalHeight = originalWidth * mAspectRatioHeight / mAspectRatioWidth;

        } else {

            int calculatedHeight = originalWidth * mAspectRatioHeight / mAspectRatioWidth;

            if (calculatedHeight > originalHeight) {
                finalWidth = originalHeight * mAspectRatioWidth / mAspectRatioHeight;
                finalHeight = originalHeight;
            } else {
                finalWidth = originalWidth;
                finalHeight = calculatedHeight;
            }
        }

        super.onMeasure(MeasureSpec.makeMeasureSpec(finalWidth, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(finalHeight, MeasureSpec.EXACTLY));
    }
}
