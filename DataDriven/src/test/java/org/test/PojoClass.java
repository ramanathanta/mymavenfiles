package org.test;

	
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.FindBys;
	import org.openqa.selenium.support.PageFactory;

	public class PojoClass extends BaseClass {

		public PojoClass() {
			
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (name="email")
		private WebElement txtuser;
		
		//@FindBy (name="pass")
		//private WebElement txtPass;
		
		
		@FindBys({
			@FindBy(xpath="//input[@type='password']"),
			@FindBy(xpath="//input[@name='pass']")
		})
		private WebElement txtPass;
		
		
		@FindBy (name="login")
		private WebElement btnLogin;

		public WebElement getTxtuser() {
			return txtuser;
		}

		public WebElement getTxtPass() {
			return txtPass;
		}

		public WebElement getBtnLogin() {
			return btnLogin;
		}



	}


