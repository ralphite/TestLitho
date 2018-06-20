package com.example.yadong.testlitho;

import android.graphics.Color;
import android.widget.Button;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.SolidColor;
import com.facebook.litho.widget.Text;

import static com.facebook.yoga.YogaEdge.ALL;
import static com.facebook.yoga.YogaEdge.LEFT;

@LayoutSpec
public class AdsBottomSheetSpec {

  @OnCreateLayout
  static Component onCreateLayout(
      ComponentContext c, @Prop String title, @Prop String description) {

    return Row.create(c)
        .heightDip(100)
        .paddingDip(ALL, 16)
        .backgroundColor(Color.LTGRAY)
        .child(SolidColor.create(c).color(Color.BLUE).widthDip(70).heightDip(70).build())
        .child(
            Column.create(c)
                .paddingDip(LEFT, 16)
                .child(Text.create(c).text(title).textSizeSp(28))
                .child(Text.create(c).text(description).textSizeSp(20).textColor(Color.DKGRAY))
                .build())
        .build();
  }
}
