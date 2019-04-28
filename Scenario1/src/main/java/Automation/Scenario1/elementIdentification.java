package Automation.Scenario1;

public class elementIdentification {
	public String appLogin ="//a[@id = 'nav-link-accountList']";
	public String appUserName = "//input[@name='email']";
	public String appPassword = "//input[@name='password']";
	public String appSubmit = "//input[@type='submit']";
	public String productSearch ="//input[@name='field-keywords']";
	public String hoverdepartment = "//span[text() = 'Departments']";
	public String selectdepartment = "//span[text() = \"@deptName\"]";
	public String feshionName = "//span[contains(text(), '@feshion')]";
	public String fashionProductName = "//a/h2[contains(text(), '@productName')]";
	public String dropdown = "//span[@class = 'a-dropdown-container']//span[contains(text(), 'Select')]";
	public String selectSize = "//a[text() =  '@size']";
	public String buyingOption = "//a[contains(text(),'See All Buying Options')]";
	public String addToCart = "//span[contains(text(),'@OptionName')]/parent::span";
	public String proceedToCheckOut = "(//a[contains(text(),'Proceed to checkout (@selectedProductCnt)')])[2]";
	public void reportGnerate() {
		// TODO Auto-generated method stub
		
	}

}
