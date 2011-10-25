package vpm.server.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class Config {

    private static final String VPM = "vpm";

    private static final String CONFIGDIR = System.getProperty("user.home")
	    + System.getProperty("file.separator") + "vpm"
	    + System.getProperty("file.separator");

    private static final String CONFIGFILE = "config.xml";

    private static final String CONFIG = "config";

    Map<String, String> data = new HashMap<String, String>();

    public Config() {

    }

    public void set(String key, String value) {
	data.put(key, value);
    }

    public String get(String key) {
	return data.get(key);
    }

    public void load() {
	load(CONFIGDIR, CONFIGFILE);
    }

    public void load(String dirname, String filename) {
	XMLInputFactory factory = XMLInputFactory.newInstance();
	try {
	    XMLStreamReader parser = factory
		    .createXMLStreamReader(new FileInputStream(dirname
			    + filename));
	    while (parser.hasNext()) {
		switch (parser.getEventType()) {
		case XMLStreamConstants.START_ELEMENT:
		    for (int i = 0; i < parser.getAttributeCount(); i++) {
			data.put(parser.getAttributeLocalName(i),
				parser.getAttributeValue(i));
		    }
		    break;
		default:
		    break;
		}
		parser.next();
	    }
	} catch (FileNotFoundException e) {
	    return;
	} catch (XMLStreamException e) {
	    e.printStackTrace();
	    return;
	}
    }

    public void save() {
	save(CONFIGDIR, CONFIGFILE);
    }

    public void save(String dirname, String filename) {
	File f = new File(dirname);
	if (!f.exists()) {
	    f.mkdirs();
	}
	XMLOutputFactory factory = XMLOutputFactory.newInstance();
	try {
	    XMLStreamWriter writer = factory
		    .createXMLStreamWriter(new FileOutputStream(dirname
			    + filename));

	    writer.writeStartDocument();
	    writer.writeCharacters("\n");
	    writer.writeStartElement(VPM);
	    writer.writeCharacters("\n");
	    for (String s : data.keySet()) {
		writer.writeStartElement(CONFIG);
		writer.writeAttribute(s, data.get(s));
		writer.writeEndElement();
		writer.writeCharacters("\n");
	    }
	    writer.writeEndElement();
	    writer.writeEndDocument();
	    writer.close();

	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	    return;
	} catch (XMLStreamException e) {
	    e.printStackTrace();
	    return;
	}

    }

}
