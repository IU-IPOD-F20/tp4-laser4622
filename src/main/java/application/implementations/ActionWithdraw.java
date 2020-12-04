package application.implementations;

import application.ApplicationContextBankAgency;
import application.action.GenericAction;
import bank.Account;
import bank.exception.AccountException;

import java.io.PrintWriter;

public class ActionWithdraw extends GenericAction<ApplicationContextBankAgency> {
    public ActionWithdraw(Integer code) {
        super(code.toString(), "Withdraw money from an account");
    }

    @Override
    public void execute(ApplicationContextBankAgency context) throws Exception {
        PrintWriter writer = context.getPrintWriter();

        writer.print("Account Number ?");
        writer.flush();
        String number = context.getScanner().next();
        writer.print("Withdraw amount ?");
        writer.flush();
        double amount = context.getScanner().nextDouble();
        Account c = context.getBankAgency().getAccount(number);
        if (c==null) {
            writer.println("Account doesn't exist!");
        } else {
            writer.println("Balance before withdrawal: " + c.balance());
            try {
                c.withdraw(amount);
                writer.println("Balance after withdrawal: "+c.balance());
            } catch (AccountException e) {
                writer.println("Withdraw error, Balance unchanged: " + c.balance());
                writer.println(e.getMessage());
            }
        }
        writer.flush();
    }
}
