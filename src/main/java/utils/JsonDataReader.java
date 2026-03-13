package utils;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;

public class JsonDataReader {

	public static LoginData[] getLoginData() throws Exception {

		Reader reader = null;
		try {
			System.out.println("111");
			File file = new File("src/test/resources/testdata/login.json");
			
			reader = new FileReader(file.getPath());
		} catch (Exception e) {
			System.out.print(e.getMessage());
			// TODO: handle exception
		}
		Gson gson = new Gson();
		System.out.println(gson.toString());
		return gson.fromJson(reader, LoginData[].class);
	}

	public static class LoginData {
		public String username;
		public String password;
	}
}