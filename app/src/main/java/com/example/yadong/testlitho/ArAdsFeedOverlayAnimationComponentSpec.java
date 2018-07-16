package com.example.yadong.testlitho;

import android.graphics.Color;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.StateValue;
import com.facebook.litho.Transition;
import com.facebook.litho.animation.AnimatedProperties;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.OnCreateTransition;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.OnUpdateState;
import com.facebook.litho.annotations.Param;
import com.facebook.litho.annotations.State;
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;

@LayoutSpec
public class ArAdsFeedOverlayAnimationComponentSpec {
  private static final String CAMERA_TRANSITION_KEY = "CameraGlyphTransition";

  @OnCreateLayout
  static Component onCreateLayout(ComponentContext c, @State boolean small) {
    return Row.create(c)
        .alignContent(YogaAlign.CENTER)
        .alignItems(YogaAlign.CENTER)
        .widthDip(120)
        .heightDip(120)
        .child(
            Column.create(c)
                .child(Image.create(c).drawableRes(R.drawable.ic_camera_24).transitionKey(CAMERA_TRANSITION_KEY).widthDip(50).heightDip(50).scale(small ? 0.5f : 1.0f).alignSelf(YogaAlign.CENTER).build())
                .child(
                    Text.create(c)
                        .text("Tap to Try On")
                        .textSizeDip(20)
                        .textColor(Color.WHITE)
                        .build())
                .build())
        .clickHandler(ArAdsFeedOverlayAnimationComponent.onClick(c))
        .build();
  }

  @OnEvent(ClickEvent.class)
  static void onClick(ComponentContext c, @State boolean small) {
    ArAdsFeedOverlayAnimationComponent.updatePosition(c, !small);
  }

  @OnUpdateState
  static void updatePosition(StateValue<Boolean> small, @Param boolean onSmall) {
    small.set(onSmall);
  }

  @OnCreateTransition
  static Transition onCreateTransition(ComponentContext c) {
    return Transition.create(CAMERA_TRANSITION_KEY)
        .animate(AnimatedProperties.SCALE)
        .animator(Transition.timing(1000));
  }
}
