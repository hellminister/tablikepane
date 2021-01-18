package ca.dauqui.tablikepane;

import javafx.beans.binding.DoubleExpression;
import javafx.scene.layout.Region;

public final class Utilities {

    private Utilities(){}

    /**
     * Bind the size of a pane (min, max, pref) to some Binding expressions
     * @param pane   The pane to set size
     * @param width  The binding expression for width
     * @param height The binding expression for height
     */
    public static void attach(Region pane, DoubleExpression width, DoubleExpression height){
        pane.maxWidthProperty().bind(width);
        pane.minWidthProperty().bind(width);
        pane.prefWidthProperty().bind(width);

        pane.maxHeightProperty().bind(height);
        pane.minHeightProperty().bind(height);
        pane.prefHeightProperty().bind(height);
    }
}
