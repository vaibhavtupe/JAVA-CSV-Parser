
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CSVCleaner {

	public static void main(String[] args)
	{
		/*if (args.length < 2) {
			System.err.println("Usage: CSVCleaner <inputFile> <outputFile>");
			System.exit(1);
		}*/
		String fileToParse = "C:\\Users\\vtupe\\Desktop\\emp.txt";
				String outputFile = "C:\\Users\\vtupe\\Desktop\\output.txt";
		//String fileToParse=args[0];
		//String outputFile=args[1];
		BufferedReader fileReader = null;
		FileWriter writer = null;
		final String DELIMITER = ",";
		try 
		{
			writer = new FileWriter(outputFile);
			String line = "";
			fileReader = new BufferedReader(new FileReader(fileToParse));

			while ((line = fileReader.readLine()) != null) 
			{
				String[] tokens = line.split(DELIMITER);
				for(int i=0; i< tokens.length;i++)
				{
					String token = tokens[i];
					token=token.trim();
					token = token.replaceAll("^\"|\"$", "");
					writer.append(token);
					if(i<tokens.length-1)
						writer.append(DELIMITER);  
				}
				writer.append(System.getProperty("line.separator"));
			}	
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally 
		{
			try {
				writer.flush();
				writer.close();
				fileReader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
