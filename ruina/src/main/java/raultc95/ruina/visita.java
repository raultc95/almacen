package raultc95.ruina;

import java.io.IOException;
import java.net.URISyntaxException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class visita {
	@FXML
	private Button visita;

	@FXML
	protected void enlace() {
		if (java.awt.Desktop.isDesktopSupported()) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
				java.net.URI uri = null;
				try {
					uri = new java.net.URI("https://www.todostuslibros.com/");
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					desktop.browse(uri);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
