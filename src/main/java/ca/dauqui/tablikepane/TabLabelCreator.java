package ca.dauqui.tablikepane;

import javafx.scene.layout.Pane;

public abstract class TabLabelCreator {
    public abstract TabLabel create(String name, TabPaneLike tpl);

    final void setHeights(Pane nameTab){
        nameTab.setPrefHeight(getPrefHeight());
        nameTab.setMinHeight(getMinHeight());
        nameTab.setMaxHeight(getMaxHeight());
    }

    public abstract double getMaxHeight();

    public abstract double getMinHeight();

    public abstract double getPrefHeight();

    final void setWidths(Pane nameTab){
        nameTab.setPrefWidth(getPrefWidth());
        nameTab.setMinWidth(getMinWidth());
        nameTab.setMaxWidth(getMaxWidth());
    }

    public abstract double getMaxWidth();

    public abstract double getMinWidth();

    public abstract double getPrefWidth();
}
