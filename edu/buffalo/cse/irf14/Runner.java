/**
 * 
 */
package edu.buffalo.cse.irf14;

import java.io.File;

import edu.buffalo.cse.irf14.document.Document;
import edu.buffalo.cse.irf14.document.Parser;
import edu.buffalo.cse.irf14.document.ParserException;
import edu.buffalo.cse.irf14.index.IndexWriter;
import edu.buffalo.cse.irf14.index.IndexerException;

/**
 * @author nikhillo
 *
 */
public class Runner {

	/**
	 * 
	 */
	public Runner() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String ipDir = args[0];
		//String indexDir = args[1];
		//more? idk!
		
		//File ipDirectory = new File(ipDir);
		//String[] catDirectories = ipDirectory.list();
		
	//	String[] files;
		File dir;
		
		Document d = null;
		//IndexWriter writer = new IndexWriter(indexDir);
		
		try {
			/*for (String cat : catDirectories) {
				dir = new File(ipDir+ File.separator+ cat);
				files = dir.list();
				
				if (files == null)
					continue;
				
				for (String f : files) {
					try {
						d = Parser.parse(dir.getAbsolutePath() + File.separator +f);
						writer.addDocument(d);
					} catch (ParserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
				}
				
			}*/
			dir = new File("/home/meghna/git/newsindexer/training/acq/0000027");
			d = Parser.parse("/home/meghna/git/newsindexer/training/acq/0000027");
			//writer.addDocument(d);
			System.out.println(d);
		//	writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
