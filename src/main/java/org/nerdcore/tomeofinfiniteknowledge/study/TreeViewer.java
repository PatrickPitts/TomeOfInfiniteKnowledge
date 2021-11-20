package org.nerdcore.tomeofinfiniteknowledge.study;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class TreeViewer extends Application {
    private final int NODE_RADIUS = 20;
    private final int FONT_SIZE = 12;
    @Override
    public void start(Stage stage) throws Exception {
        int[] tree = {1,2,3,4,5,6,7};
        stage.setTitle("Tree Viewer");
        Group[] visTreeNodes = new Group[tree.length];
        for(int i = 0; i < tree.length; i++){
            visTreeNodes[i] = makeTreeNode(Integer.toString(tree[i]),
                    50+(3*NODE_RADIUS*i),
                    200);
        }
        Pane root = new Pane(visTreeNodes);
        Scene scene = new Scene(root, 450, 480);
        stage.setScene(scene);

        stage.show();

    }

    private Group makeTreeNode(String val, int x, int y){
        Circle c = new Circle(x,y,NODE_RADIUS);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(1);
        c.setFill(Color.TRANSPARENT);
        Text t = new Text(x,y, val);
        t.setFont(new Font(FONT_SIZE));
        t.setBoundsType(TextBoundsType.VISUAL);
        t.relocate(x-t.getBoundsInLocal().getWidth()/2, y-t.getBoundsInLocal().getHeight()/2);
        Group g = new Group(t,c);

        return g;
    }
}
