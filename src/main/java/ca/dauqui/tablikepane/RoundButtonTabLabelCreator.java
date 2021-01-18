package ca.dauqui.tablikepane;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class RoundButtonTabLabelCreator extends TabLabelCreator {

    private static final int BUTTON_MAX_RADIUS = 37;
    private static final int BUTTON_PREF_RADIUS = 37;
    private static final int BUTTON_MIN_RADIUS = 37;


    @Override
    public TabLabel create(String name, TabPaneLike tpl) {
        Button btn = new Button(name);

        btn.setMaxSize(getMaxWidth(), getMaxHeight());
        btn.setMinSize(getMinWidth(), getMinHeight());
        btn.setPrefSize(getPrefWidth(), getPrefHeight());

        btn.setShape(new Circle(BUTTON_PREF_RADIUS));


        return new ButtonTabLabel(btn, name, tpl);
    }



    @Override
    public double getMaxHeight() {
        return BUTTON_MAX_RADIUS*2;
    }

    @Override
    public double getMinHeight() {
        return BUTTON_MIN_RADIUS*2;
    }

    @Override
    public double getPrefHeight() {
        return BUTTON_PREF_RADIUS*2;
    }

    @Override
    public double getMaxWidth() {
        return BUTTON_MAX_RADIUS*2;
    }

    @Override
    public double getMinWidth() {
        return BUTTON_MIN_RADIUS*2;
    }

    @Override
    public double getPrefWidth() {
        return BUTTON_PREF_RADIUS*2;
    }
}
