/**
 * 
 */
package edu.buffalo.cse.irf14.document;
import java.io.*;

import com.oracle.jrockit.jfr.DataType;
/**
 * @author nikhillo
 * Class that parses a given file into a Document
 */
public class Parser {
	/**
	 * Static method to parse the given file into the Document object
	 * @param filename : The fully qualified filename to be parsed
	 * @return The parsed and fully loaded Document object
	 * @throws ParserException In case any error occurs during parsing
	 */
	public static Document parse(String filename) throws ParserException {
		// TODO YOU MUST IMPLEMENT THIS
		System.out.println("Hello World!!");
		
		if(filename==null || filename.isEmpty())
			throw new ParserException();

		FileReader fr;
		BufferedReader br = null;
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ParserException();
		}
		
		Document doc =  new Document();
		File f = new File(filename);
		
		String fname = f.getName();
		doc.setField(FieldNames.FILEID, fname);
		
		String category =  f.getParentFile().getName();
		doc.setField(FieldNames.CATEGORY, category);
		
		
		boolean isAuthor=true, isTitle=true, isDatePlace= true, isOrg=true;
		String line,org;
		StringBuilder content = new StringBuilder();
		try {
			while((line = br.readLine())!= null)
			{
				if(line.trim().isEmpty())
					continue;
				if(isTitle)
				{
					doc.setField(FieldNames.TITLE, line);
					isTitle = false;
					
				}
				else
				if(line.contains("<AUTHOR>") && isAuthor)
				{
					
					line = line.replaceAll("(?i)(</AUTHOR>|<AUTHOR>)", "");
					System.out.println(line);
					line = line.replaceAll("(?i)by", "");
					String author = line.split(",")[0];
					author = author.trim();
					org = line.split(",")[1];
					org = org.trim();
					doc.setField(FieldNames.AUTHORORG, org);
					
					line.trim();
					//System.out.println(line);
					doc.setField(FieldNames.AUTHOR,author );
					isAuthor = false;
				
				}
				else
				if(isDatePlace)
				{
					
					String placedate = line.split("-")[0];
					
					int ind =placedate.lastIndexOf(",");
					String place = placedate.substring(0, ind);					
					place = place.trim();				
					
					String date = placedate.substring(ind,placedate.length());
					date = date.replaceAll(",", "");
					date = date.trim();					
					
					doc.setField(FieldNames.PLACE, place);
					doc.setField(FieldNames.NEWSDATE,date);
					content.append(line.split("-")[1]);
					isDatePlace = false;
				}
				else
				content.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
		
	}

}
