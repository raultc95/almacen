package raultc95.ruina;

import java.io.IOException;
import java.net.URISyntaxException;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class donation {
	@FXML
	private Text mensaje;
	@FXML
	private ImageView paypal;

	@FXML
	protected void enlace() {
		if (java.awt.Desktop.isDesktopSupported()) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
				java.net.URI uri = null;
				try {
					uri = new java.net.URI("https://www.paypal.com/paypalme/raultc95");
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
				try {
					desktop.browse(uri);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
