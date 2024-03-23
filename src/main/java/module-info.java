module edu.sdccd.cisc191.architectbankaccount {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens edu.sdccd.cisc191.architectbankaccount to javafx.fxml;
    exports edu.sdccd.cisc191.architectbankaccount;
}