package configurations;

public enum TestEnums {
	CHROME("chrome"),
	FIREFOX("firefox"),
	PROPFILE("src/test/resources/animana.properties");
	private String value;
	
	TestEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	

}
