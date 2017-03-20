package view;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import model.Product;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ProductStore {

	private static ArrayList<Product> stores;
	private static InputStream resource;
	
	private static class ProductStoreHolder {
		private static final ProductStore INSTANCE = new ProductStore();
	}

	private ProductStore(){
		stores=new ArrayList<Product>();
		
		Product a=new Product("Internet&WWW How To Program",121.99f);

		a.setAuthors("PaulDeitel, Harvey Deitel and Abbey Deitel");
		a.setPaperBack(992);
		a.setLanguage("English");
		a.setIsbn10("0132151006");
		a.setIsbn13("978-0132151009");
		
		a.setPublisher("Prentice Hall");
		a.setEdition("5");
		a.setPubDate("2011-1900,10,19");

		a.setImgFile("1.jpg");
		stores.add(a);
		Product b=new Product("Web application architecture",54.56f);
		b.setAuthors("Leon Shkar and Rich Rosen");
		b.setPaperBack(440);
		b.setLanguage("English");
		b.setIsbn10("047051860X");
		b.setIsbn13("978-0470518601");
		
		
		b.setPublisher("Wiley");
		b.setEdition("2");
		b.setPubDate("2009-1900,3,27");
		

		b.setImgFile("2.jpg");
		stores.add(b);
		Product c=new Product("Design Patterns",39.53f);
		c.setAuthors("Erich Gamma, Richard Helm, Ralph Johnson and John Vlissides");
		c.setPaperBack(395);
		c.setLanguage("English");
		c.setIsbn10("0201633612");
		c.setIsbn13("078-5342633610");
		
		c.setPublisher("Addison-Wesley Professional");
		c.setEdition("1");
		c.setPubDate("1994-1900,10,10");
	
		c.setImgFile("3.jpg");
		stores.add(c);
		Product d=new Product("Head First Servlets and JSP",35.46f);
		d.setAuthors("Bryan Basham , Kathy Sierra and Bert Bates");
		d.setPaperBack(914);
		d.setLanguage("English");
		d.setIsbn10("0596516681");
		d.setIsbn13("978-0596516680");
		
		
		d.setPublisher("O'Reilly Media");
		d.setEdition("2");
		d.setPubDate("2008-1900,3,4");
		
		d.setImgFile("4.jpg");
		stores.add(d);
		
		
	
	}

	public static ProductStore getInstance(InputStream res) {
		resource=res;
		return ProductStoreHolder.INSTANCE;
	}
	
	public void addProdcut(Product p){
			stores.add(p);
	}

	public void modifyProdcut(int index,Product p){
			stores.set(index, p);
	}
	
	public ArrayList<Product> getProducts(){
		return stores;
	}

	public Product getProdcut(int index){
		return stores.get(index);
	}


}
