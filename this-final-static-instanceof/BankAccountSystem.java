class BankAccoun{
	static String BankName ;
	private final int AccountNumber;
	private String AccountHolderName;
	static int totalAccount =0;
	
	BankAccoun(int AccountNumber , String AccountHolderName){
		this.AccountNumber = AccountNumber;
		this.AccountHolderName = AccountHolderName;
		BankName = "ICICI BANK";
		totalAccount++;
	}
	
	static void getTotalAccount() {
		System.out.println("The Total Number of Account in ICICI Bank are : " + totalAccount);
	}
	
	void displaydetails(Object ac1) {
		if(ac1 instanceof BankAccoun) {
			System.out.println("AccountHolderName : " +AccountHolderName );
			System.out.println("AccountNumber : " +AccountNumber );
		}
	}
}


public class BankAccountSystem{
	public static void main(String[]args) {
		BankAccoun ac1 = new BankAccoun(1002323233,"Pushpak");
		BankAccoun ac2 = new BankAccoun(1003124433,"Singhal");
		
		
		ac1.displaydetails(ac1);
		ac2.displaydetails(ac2);
		
		
		BankAccoun.getTotalAccount();
	}
}