module ruina{
	requires javafx.controls;
    requires javafx.fxml;
    requires javafx.baseEmpty;
    requires java.xml.bind;
	requires java.desktop;
	requires java.xml;
	requires javafx.graphics;
	//requires java.activation;
	requires java.sql;
	requires javafx.base;
	

    opens raultc95.ruina to javafx.fxml;
    opens model to java.xml.bind;
    exports raultc95.ruina;
}