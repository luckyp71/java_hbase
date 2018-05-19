package org.example.java_hbase.example1;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.util.Bytes;
import java.io.IOException;

public class ScanTable {

	public static void main(String[] args) {

		try {
			// Instantiating Configuration class
			Configuration config = HBaseConfiguration.create();

			// Instantiating Connection class
			Connection connection = ConnectionFactory.createConnection(config);

			// Instantiating Table class
			Table table = connection.getTable(TableName.valueOf("employee"));

			// Instantiating Scan class
			Scan scan = new Scan();

			// Scanning the column family.
			// Change two colum families (personal data and professional data) below with yours.
			scan.addFamily(Bytes.toBytes("personal data"));
			scan.addFamily(Bytes.toBytes("professional data"));
			
			// Getting the scan result
			ResultScanner scanner = table.getScanner(scan);
			
			try {
				// Reading values form scan result
				for (Result result = scanner.next(); result != null; result = scanner.next()) {
					System.out.println(result);
				}
			} finally {
				scanner.close();
				table.close();
				connection.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}