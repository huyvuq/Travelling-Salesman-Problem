import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataProvider {
	private static List<City> cityList = new ArrayList<>();
	
	public static List<City> retrieveCitiesFromFile(String fileName) {
		boolean canRead = false;
		try {
		    BufferedReader reader = new BufferedReader(new FileReader(fileName));
		    String line;
		    while ((line = reader.readLine()) != null)
		    {
		    		if (line.equals("NODE_COORD_SECTION")) {
		    			canRead = true;	
		    	  		continue;
		    		}
		      
		    		if (line.equals("EOF")) {
		    			canRead = false;
		    		}
		      
		    		if (canRead){
		    			String strArray[] = line.split(" ");
		    			City city = new City(Double.parseDouble(strArray[1]), Double.parseDouble(strArray[2]));
		    			cityList.add(city);
		    		}
		    }
		    reader.close();
		} catch (Exception e){
		    System.err.format("Exception occurred trying to read '%s'.", fileName);
		    e.printStackTrace();
		}	
		  
		  Collections.shuffle(cityList);
		  return cityList;
	}
}
