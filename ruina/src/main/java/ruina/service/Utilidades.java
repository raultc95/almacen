package ruina.service;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import ruina.model.DataConnection;

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
		if (file.exists() && file.isFile()) {
			try {
				jaxbContext = JAXBContext.newInstance(DataConnection.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				// We had written this file in marshalling example
				result = (DataConnection) jaxbUnmarshaller.unmarshal(file);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		} else {
			result = new DataConnection();
		}
		return result;
	}

}