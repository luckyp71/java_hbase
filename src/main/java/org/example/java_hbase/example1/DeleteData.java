package org.example.java_hbase.example1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.util.Bytes;
import java.io.IOException;

public class DeleteData {

	public static void main (String[] args) {
		
		try {
			
			// Instantiating Configuration class
			Configuration config = HBaseConfiguration.create();
			
			// Instantiating Connection class
			Connection connection = ConnectionFactory.createConnection(config);
			
			// Instantiating Table class
			Table table = connection.getTable(TableName.valueOf("employee"));
			
			// Instantiating Delete class
			Delete delete = new Delete(Bytes.toBytes("r1"));
			
			try {
				delete.addColumn(Bytes.toBytes("personal data"), 
						Bytes.toBytes("name"));
				
				table.delete(delete);
				System.out.println("Data deleted successfully");
			} finally {
				table.close();
				connection.close();
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}