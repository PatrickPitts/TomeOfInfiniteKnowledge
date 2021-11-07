module org.nerdcore.tomeofinfiniteknowledge {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.nerdcore.tomeofinfiniteknowledge to javafx.fxml;
    exports org.nerdcore.tomeofinfiniteknowledge;
    exports org.nerdcore.tomeofinfiniteknowledge.study;
    opens org.nerdcore.tomeofinfiniteknowledge.study to javafx.fxml;
    exports org.nerdcore.tomeofinfiniteknowledge.study.LayoutStudy;
    opens org.nerdcore.tomeofinfiniteknowledge.study.LayoutStudy to javafx.fxml;
}