package jsonData.nopCommerce;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserInfoData {
	public static UserInfoData getUserInfo() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.RESOURCE_PATH + "userData.Json"), UserInfoData.class);

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@JsonProperty("firstname")
	private String firstName;

	@JsonProperty("lastname")
	private String lastName;

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

}
