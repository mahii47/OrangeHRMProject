package testData;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="loginDataFromDB")
	public Object[][]getLoginData() throws Exception 
	{
		List<Object[]> data = new ArrayList<>();
		 String query = "SELECT username, password, expected_result FROM login";
	     ResultSet rs = commonLibs.utils.DatabaseUtils.getData(query);
			
			while(rs.next())
			{
				String user = rs.getString("username");
				String pass = rs.getString("password");
				boolean expected = rs.getBoolean("expected_result");
				data.add(new Object[] {user,pass,expected});
				
			}
			return data.toArray(new Object[0][]);
	}
}

