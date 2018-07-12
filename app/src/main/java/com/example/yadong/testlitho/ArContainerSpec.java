package com.example.yadong.testlitho;

import android.graphics.Color;
import android.util.Log;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaJustify;

@LayoutSpec
public class ArContainerSpec {
  @OnCreateLayout
  static Component onCreateLayout(ComponentContext context) {
    return Row.create(context)
        .flex(1)
        .justifyContent(YogaJustify.CENTER)
        .alignItems(YogaAlign.CENTER)
        .backgroundColor(Color.CYAN)
        .child(ArAdsFeedOverlayAnimationComponent.create(context).build())
        .clickHandler(ArContainer.onClick(context))
        .build();
  }

  @OnEvent(ClickEvent.class)
  static void onClick(ComponentContext c) {
    Log.d("ArContainerSpec", "Hello");
  }
}
