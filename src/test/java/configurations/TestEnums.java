package configurations;

/**
 * Enum class to store constants.
 * 
 * @author anujteotia
 *
 */
public enum TestEnums {
	CHROME("chrome"), FIREFOX("firefox"), SAUCELAB_CHROME("sauce_chrome"), SAUCELAB_FIREFOX("sauce_firefox"),
	PROPFILE("src/test/resources/animana.properties");

	private String value;

	TestEnums(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
