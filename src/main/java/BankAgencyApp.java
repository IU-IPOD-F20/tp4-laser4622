
import application.ApplicationContextBankAgency;

public class BankAgencyApp {

	public static void main(String argv[]) throws Exception {
		ApplicationContextBankAgency context = ApplicationContextBankAgency.getInstance();
		context.getMenu().execute(context);
	}

}
