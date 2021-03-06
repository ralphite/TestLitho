package com.example.yadong.testlitho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.litho.ClickEvent;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    final ComponentContext context = new ComponentContext(this);
    final Component component =
        RecyclerCollectionComponent.create(context)
            .disablePTR(true)
            .section(ListSection.create(new SectionContext(context)).build())
            .build();

    final Component ar = ArContainer.create(context).build();

    setContentView(LithoView.create(context, ar));
  }
}
