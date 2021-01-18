package ca.dauqui.tablikepane;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public abstract class TabLabel extends Group {


    public TabLabel(Node btn, String name, TabPaneLike tpl) {
        this.getChildren().add(btn);
        btn.setOnMouseClicked(new Action(name, this, tpl));
        //btn.setOnAction(new Action(name, this, tpl));
    }

    /**
     * This class controls the behavior of the tab buttons
     */
    protected static class Action implements EventHandler<MouseEvent> {
        private final String name;
        private final TabLabel me;
        private final TabPaneLike tpl;

        public Action(String name, TabLabel me, TabPaneLike tpl) {
            this.name = name;
            this.me = me;
            this.tpl = tpl;
        }

        @Override
        public void handle(MouseEvent event) {
            tpl.getSelected().setDisable(false);
            me.setDisable(true);
            tpl.setSelected(me);
            for (var tab : tpl.getTabs()){
                tab.setVisible(name.equals(tab.getName()));
            }
        }
    }


}
