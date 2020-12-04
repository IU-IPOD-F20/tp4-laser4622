package application.implementations;

import application.ApplicationContextBankAgency;
import application.action.GenericAction;
import bank.Account;

import java.io.PrintWriter;

public class ActionAddAccount extends GenericAction<ApplicationContextBankAgency> {
    public ActionAddAccount(Integer code) {
        super(code.toString(), "Add account");
    }

    @Override
    public void execute(ApplicationContextBankAgency context) throws Exception {
        PrintWriter writer = context.getPrintWriter();
        writer.print("Account Number ?");
        writer.flush();

        String number = context.getScanner().next();
        writer.print("Owner Name ?");
        writer.flush();

        String owner = context.getScanner().next();
        context.getBankAgency().addAccount(new Account(number, owner));
    }
}
