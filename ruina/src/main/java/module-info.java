module ruina{
	requires javafx.controls;
    requires javafx.fxml;
    requires javafx.baseEmpty;
    requires com.sun.xml.bind;
    requires jakarta.xml.bind;
	requires java.desktop;
	requires java.xml;
	requires javafx.graphics;
	//requires java.activation;
	requires java.sql;
	requires javafx.base;
	
//    opens ruina.controller to javafx.fxml;
    opens raultc95.ruina to javafx.fxml;
    opens ruina.model to com.sun.xml.bind, jakarta.xml.bind;
    exports raultc95.ruina;
}