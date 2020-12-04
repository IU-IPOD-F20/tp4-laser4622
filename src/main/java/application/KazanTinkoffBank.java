package application;


import bank.BankAgency;
import bank.Account;
import bank.exception.ABAccountAlreadyExistingException;
import bank.exception.ABNullAccountException;

public class KazanTinkoffBank {
	
	public static BankAgency getBankAgency () {
		BankAgency ag = new BankAgency("Tinkoff Bank", "Kazan");
		
		try {
			ag.addAccount(new Account("010101", "Durand"));
			ag.addAccount(new Account("010102", "Durand"));
			
			ag.addAccount(new Account("050501", "Leon"));
			ag.addAccount(new Account("050502", "Leon"));
			ag.addAccount(new Account("050503", "Leon"));			
			ag.addAccount(new Account("090904", "Zeste"));
			ag.addAccount(new Account("090905", "Zeste"));
			
		} catch (ABNullAccountException e) {
			throw new RuntimeException();
		} catch (ABAccountAlreadyExistingException e) {
			e.printStackTrace();
		}
		return ag;
	}

}
