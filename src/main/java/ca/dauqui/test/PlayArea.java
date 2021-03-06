package ca.dauqui.test;

import ca.dauqui.tablikepane.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class PlayArea extends Scene {
    /**
     * Creates a Scene for a specific root Node.
     *
     */
    public PlayArea() {
        super(new StackPane());
        var root = (StackPane)getRoot();

        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

        TabPaneLike tpl = new TabPaneLike(TabPaneLike.TabSide.LEFT, new RoundButtonTabLabelCreator());

        TabLike tab1 = new SimpleTabLike("First", new StackPane(label));
        TabLike tab2 = new SimpleTabLike("Second", new StackPane());

        tpl.add(tab1);
        tpl.add(tab2);

        root.getChildren().add(tpl);
    }
}
