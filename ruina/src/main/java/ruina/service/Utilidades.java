package ruina.service;

import java.io.File;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import ruina.model.DataConnection;
/*
 * @Author Raul Tenllado
 */

public class Utilidades {

	public static void saveFile(DataConnection dc, String path) {
		// marshaling
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(DataConnection.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(dc, new File(path));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static DataConnection loadFile(String path) {
		DataConnection result = null;
		JAXBContext jaxbContext;
		File file = new File(path);
		if (file.exists() && file.isFile() && !path.isEmpty()) {
			try {
				jaxbContext = JAXBContext.newInstance(DataConnection.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				result = (DataConnection) jaxbUnmarshaller.unmarshal(file);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		} else {
			DataConnection dc = new DataConnection("localhost", "almacen", "root", "");
			saveFile(dc,path);
			result = new DataConnection();
		}
		return result;
	}

}