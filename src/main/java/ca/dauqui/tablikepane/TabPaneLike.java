package ca.dauqui.tablikepane;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.layout.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Make a tab like layout that can contains TabLike objects
 *
 * It creates a center area that shows the content of the selected TabLike object
 *
 * The tabs are made from Buttons
 * You can choose on which side the Buttons are
 * You cannot change the position of the tabs nor close them
 *
 * Should probably change the superclass from Pane to Control
 *
 */
public class TabPaneLike extends Pane {

    private final Pane nameTab;
    private final StackPane tabContent;

    private final List<TabLike> tabs;

    private TabLabel selected;
    private final TabLabelCreator tabLabelCreator;

    /**
     * Creates a TabLikePane with the button showing on the given side
     * @param side The side on which the button should show
     */
    public TabPaneLike(TabSide side, TabLabelCreator tabLabelCreator){
        BorderPane bp = new BorderPane();

        this.tabLabelCreator = tabLabelCreator;

        getChildren().add(bp);

        bp.maxWidthProperty().bind(widthProperty());
        bp.minWidthProperty().bind(widthProperty());
        bp.prefWidthProperty().bind(widthProperty());

        bp.maxHeightProperty().bind(heightProperty());
        bp.minHeightProperty().bind(heightProperty());
        bp.prefHeightProperty().bind(heightProperty());


        tabContent = new StackPane();
        tabs = new LinkedList<>();

        switch(side){
            case TOP -> {
                nameTab = new HBox();
                tabLabelCreator.setHeights(nameTab);
                bp.setTop(nameTab);
            }
            case BOTTOM -> {
                nameTab = new HBox();
                tabLabelCreator.setHeights(nameTab);
                bp.setBottom(nameTab);
            }
            case RIGHT -> {
                nameTab = new VBox();
                tabLabelCreator.setWidths(nameTab);
                bp.setRight(nameTab);
            }
            case LEFT -> {
                nameTab = new VBox();
                tabLabelCreator.setWidths(nameTab);
                bp.setLeft(nameTab);
            }
            default -> nameTab = new VBox();

        }

        bp.setCenter(tabContent);

        nameTab.setStyle("-fx-background-color: lightgrey");
    }

    /**
     * Removes all the tabs (buttons and contents) from the pane
     */
    public void clear(){
        nameTab.getChildren().clear();
        tabContent.getChildren().clear();
        tabs.clear();
    }

    /**
     * Adds a TabLike to this container
     * @param tab The tab to add
     */
    public void add(TabLike tab){
        TabLabel btn = tabLabelCreator.create(tab.getName(), this);

        tab.setVisible(tabs.isEmpty());
        btn.setDisable(tabs.isEmpty());
        if (tabs.isEmpty()){
            selected = btn;
        }

        tabs.add(tab);
        nameTab.getChildren().add(btn);
        tabContent.getChildren().add(tab);
        tab.setContainer(this);
    }



    /**
     * @return the width property of the content pane
     */
    public ReadOnlyDoubleProperty getContentPaneWidthProperty() {
        return this.tabContent.widthProperty();
    }

    /**
     * @return the height property of the content pane
     */
    public ReadOnlyDoubleProperty getContentPaneHeightProperty() {
        return this.tabContent.heightProperty();

    }

    TabLabel getSelected() {
        return selected;
    }

    public List<TabLike> getTabs() {
        return tabs;
    }

    void setSelected(TabLabel me) {
        selected = me;
    }


    /**
     * Enumerates the sides on which to show the tab buttons
     */
    public enum TabSide {
        TOP,
        BOTTOM,
        RIGHT,
        LEFT,
        ;
    }
}
