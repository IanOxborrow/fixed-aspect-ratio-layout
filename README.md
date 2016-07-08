# fixed-aspect-ratio-layout
A module for android applications that provides LinearLayouts and RelativeLayouts with a customizable aspect ratio.

Usage
===

Add dependence to build.gradel:

    dependencies {
      compile 'com.github.IanOxborrow:fixed-aspect-ratio-layout:1.0.0’
    }
If this method gives you a "failed to resolve" error, then download the project to your computer and import it as a module via
 
        File -> New -> Import Module


Sample Usage

    <ian.oxborrow.fixedaspectratiolayout.FixedAspectRatioRelativeLayout
        android:id="@+id/watchPreviewLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="16dp"
        android:background="@color/wallet_dim_foreground_inverse_holo_dark"
    
        app:rl_aspect_ratio_width="1"
        app:rl_aspect_ratio_height="1"
        app:rl_determining_side="horizontal" > <!-- value can be either "horizontal" or "vertical" -->
    
    </ian.oxborrow.fixedaspectratiolayout.FixedAspectRatioRelativeLayout>
