package ca.dauqui.tablikepane;

import javafx.scene.control.Button;

public class ButtonTabLabelCreator extends TabLabelCreator {
    private static final int BUTTON_MAX_HEIGHT = 25;
    private static final int BUTTON_PREF_HEIGHT = 25;
    private static final int BUTTON_MIN_HEIGHT = 25;
    private static final int BUTTON_MAX_WIDTH = 150;
    private static final int BUTTON_PREF_WIDTH = 150;
    private static final int BUTTON_MIN_WIDTH = 150;


    @Override
    public TabLabel create(String name, TabPaneLike tpl) {
        Button btn = new Button(name);

        btn.setMaxSize(BUTTON_MAX_WIDTH, BUTTON_MAX_HEIGHT);
        btn.setMinSize(BUTTON_MIN_WIDTH, BUTTON_MIN_HEIGHT);
        btn.setPrefSize(BUTTON_PREF_WIDTH, BUTTON_PREF_HEIGHT);

        return new ButtonTabLabel(btn, name, tpl);
    }



    @Override
    public double getMaxHeight() {
        return BUTTON_MAX_HEIGHT;
    }

    @Override
    public double getMinHeight() {
        return BUTTON_MIN_HEIGHT;
    }

    @Override
    public double getPrefHeight() {
        return BUTTON_PREF_HEIGHT;
    }

    @Override
    public double getMaxWidth() {
        return BUTTON_MAX_WIDTH;
    }

    @Override
    public double getMinWidth() {
        return BUTTON_MIN_WIDTH;
    }

    @Override
    public double getPrefWidth() {
        return BUTTON_PREF_WIDTH;
    }
}
