package application.implementations;

import application.ApplicationContextBankAgency;
import application.action.GenericAction;
import bank.Account;
import bank.exception.AccountException;

import java.io.PrintWriter;

public class ActionDeposit extends GenericAction<ApplicationContextBankAgency> {
    public ActionDeposit(Integer code) {
        super(code.toString(), "Deposit money on an account");
    }

    @Override
    public void execute(ApplicationContextBankAgency context) throws Exception {
        PrintWriter writer = context.getPrintWriter();

        writer.print("Account Number ?");
        writer.flush();
        String number = context.getScanner().next();

        writer.print("Deposit amount ?");
        writer.flush();
        double amount = context.getScanner().nextDouble();
        Account account = context.getBankAgency().getAccount(number);

        if (account==null) {
            writer.println("Account doesn't exist!");
        } else {
            writer.println("Balance before deposit: " + account.balance());
            writer.flush();
            try {
                account.deposit(amount);
                writer.println("Balance after deposit: " + account.balance());
            } catch (AccountException e) {
                writer.println("Deposit error, Balance unchanged: " + account.balance());
                writer.println(e.getMessage());
            }
        }
        writer.flush();
    }
}
