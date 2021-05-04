package Utilidades;



import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Almacen.Almacen;
import model.DataConnection;


public  class Utilidades {
	
	public static void saveFile(DataConnection dc,String path) {
		//marshaling
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(DataConnection.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     
		    //Marshal the list in console
		    //jaxbMarshaller.marshal(_instance, System.out);
		     
		    //Marshal the employees list in file
		    jaxbMarshaller.marshal(dc, new File(path));
		} catch (JAXBException e) {
			e.printStackTrace();
		}	
	}
	
	public static DataConnection loadFile(String path) {
		DataConnection result= null;
		JAXBContext jaxbContext;
		File file=new File(path);
		if(file.exists() && file.isFile()) {
			try {
				jaxbContext = JAXBContext.newInstance(DataConnection.class);
			    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			    //We had written this file in marshalling example
			    result= (DataConnection) jaxbUnmarshaller.unmarshal(file);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		} else {
			result = new DataConnection();
		}
		
		return result;
	}
	/*public static Connection connect(DataConnection c) throws SQLException {
        Connection conn=null;
        if(c==null){
            return null;
        }
        //Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://"+c.getHost()+"/"+c.getDb(),c.getUser(),c.getPassword());
        return conn;
    }
	*/
	
	
}