package org.nerdcore.tomeofinfiniteknowledge.study;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Mnemonics == Keyboard shortcuts
 * When instantiating a node, pass String parameter with leading "_"
 * First character after the '_' is the mnemonic; Alt+(mnemonic) sends event to node as though it were activated
 * by the mouse.
 *      ex. new Button("_Button") -> 'b' is the mnemonic -> Alt+'B' fires the button
 */
public class MnemonicEx extends Application {
    @Override
    public void start(Stage stage){
        initUI(stage);
    }
    private void initUI(Stage stage){
        var root = new HBox();
        root.setPadding(new Insets(20));
        Tooltip tip = new Tooltip("Mnemonic Button");
        //Node 'btn' has the 'b' mnemonic; Alt+'b' fires the 'btn' node
        var btn = new Button("_Button");
        btn.setOnAction((ActionEvent event) ->{
            System.out.println("Button Fired");
        });
        Tooltip.install(btn, tip);
        root.getChildren().add(btn);
        var scene = new Scene(root, 300, 250);

        stage.setTitle("Mnemonic");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
