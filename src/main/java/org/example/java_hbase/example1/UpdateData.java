package org.example.java_hbase.example1;

/* Updating data in HBase is same with inserting data*/

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class UpdateData {
	public static void main (String[] args) {
		
		try {
		// Instantiating Configuration class
		Configuration config = HBaseConfiguration.create();
		
		// Instantiating Connection class
		Connection connection = ConnectionFactory.createConnection(config);
		
		// Instantiating Table class
		Table table = connection.getTable(TableName.valueOf("employee"));
		
		// Instantiating Put class
		// Accepts a row name
		Put p = new Put(Bytes.toBytes("r2"));
			try {
				// Updating values using addColumn() method.
				// The method pass three arguments i.e. column family, qualifier, and value
				p.addColumn(Bytes.toBytes("personal data"),
						Bytes.toBytes("name"),Bytes.toBytes("Pratama Lucky"));
				
				p.addColumn(Bytes.toBytes("personal data"),
						Bytes.toBytes("nick_name"), Bytes.toBytes("Pratama"));
				
				p.addColumn(Bytes.toBytes("personal data"), 
						Bytes.toBytes("address"), Bytes.toBytes("Jakarta"));
			
				// Update data
				table.put(p);
				System.out.println("Data updated successfully");
				
			} finally {
				table.close();
				connection.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}