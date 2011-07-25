package exist.practice.dao;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import exist.practice.Org;

public class JasperDAO {

	/**
	 * Our dummy datasource. Retrieves a collection of data that is wrapped by a JRBeanCollectionDataSource.
	 *  
	 * @return a JRBeanCollectionDataSource collection
	 */
	public  JRDataSource getDataSource() {
		// Create an array list of Org 
		List<Org> items = new ArrayList<Org>();
		
		
		//**************START --- CAN BE REPLACED BY ACCESS TO DB************************
		// We'll add three Org items
		// You can populate data from a custom JDBC or DAO layer
		// For this demo, we'll create an in-memory list of items
		
		// Create first item
		Org item1 = new Org();
		item1.setOrgId(1001L);
		item1.setOrgName("Pencil");
		
		// Create second item
		Org item2 = new Org();
		item2.setOrgId(1002L);
		item2.setOrgName("Pen");
		
		// Create third item
		Org item3 = new Org();
		item3.setOrgId(1003L);
		item3.setOrgName("Bag");
		
		// Add to list
		items.add(item1);
		items.add(item2);
		items.add(item3);
		//**************END --- CAN BE REPLACED BY ACCESS TO DB************************
		
		
		// Wrap the collection in a JRBeanCollectionDataSource
		// This is one of the collections that Jasper understands
		JRDataSource ds = new JRBeanCollectionDataSource(items);	
		
		// Return the wrapped collection
		return ds;
	}
}
