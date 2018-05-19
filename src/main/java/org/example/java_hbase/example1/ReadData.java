package org.example.java_hbase.example1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class ReadData {

	public static void main (String[] args) {
		
		try {
			
			// Instantiating Configuration class
			Configuration config = HBaseConfiguration.create();
			
			// Instantiating Connection class
			Connection connection = ConnectionFactory.createConnection(config);
			
			// Instantiating Table class
			Table table = connection.getTable(TableName.valueOf("employee"));
			
			try {
				// Retrieve row 1's data
				Get row1 = new Get(Bytes.toBytes("r1"));
				Result result = table.get(row1);
				
				// Reading values from Result class object.
				// The getValue method pass two arguments i.e. column family and its member (qualifier)
				byte[] name_field = result.getValue(Bytes.toBytes("personal data"), Bytes.toBytes("name"));
				byte[] nickName_field = result.getValue(Bytes.toBytes("personal data"), Bytes.toBytes("nick_name"));
				byte[] address_field = result.getValue(Bytes.toBytes("personal data"), Bytes.toBytes("address"));
				
				String name = Bytes.toString(name_field);
				String nick_name = Bytes.toString(nickName_field);
				String address = Bytes.toString(address_field);
				
				System.out.println("Name: "+name+"\nNick Name: "+nick_name+"\nAddress: "+address);
			} finally {
				table.close();
				connection.close();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}