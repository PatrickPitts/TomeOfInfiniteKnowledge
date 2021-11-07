package org.nerdcore.tomeofinfiniteknowledge.study.LayoutStudy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * The 'Pane' node is used to position child nodes in absolute coordinates. Not recommended unless you need
 * ridiculous control over exact locations of many nodes
 */
public class AbsoluteLayoutEx extends Application {

    @Override
    public void start(Stage stage){
        initUI(stage);
    }

    private void initUI(Stage stage){

        Pane root = new Pane();
        //(x0, y0, width, height)
        Rectangle rect = new Rectangle(25,25,50,50);
        rect.setFill(Color.CADETBLUE);

        Line line = new Line(90, 40, 230, 40);
        line.setStroke(Color.BLACK);

        Circle circle = new Circle(130, 130, 30);
        circle.setFill(Color.CHOCOLATE);

        root.getChildren().addAll(rect, line, circle);

        Scene scene = new Scene(root, 250, 220, Color.WHITESMOKE);

        stage.setTitle("Layout Study - Absolute Layout");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
