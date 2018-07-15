package com.example.yadong.testlitho;

import android.graphics.Color;
import android.graphics.drawable.Icon;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;

@LayoutSpec
public class ArAdsFeedOverlayAnimationComponentSpec {
  @OnCreateLayout
  static Component onCreateLayout(ComponentContext c) {
//      DraweeController controller = Fresco.newDraweeControllerBuilder()
//              .setAutoPlayAnimations(true)
//    .build();
    return Row.create(c)
        .alignContent(YogaAlign.CENTER)
        .alignItems(YogaAlign.CENTER)
        .widthDip(120)
        .heightDip(120)
        .child(
            Column.create(c)
                .child(Image.create(c).drawableRes(R.drawable.ic_camera_24).widthDip(50).heightDip(50).alignSelf(YogaAlign.CENTER).build())
                .child(
                    Text.create(c)
                        .text("Tap to Try On")
                        .textSizeDip(20)
                        .textColor(Color.WHITE)
                        .build())
                .build())
        .build();
  }
}
