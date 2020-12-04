package application.implementations;

import application.ApplicationContextBankAgency;
import application.action.GenericAction;

import java.io.PrintWriter;

public class ActionRemoveAccount extends GenericAction<ApplicationContextBankAgency> {
    public ActionRemoveAccount(Integer code) {
        super(code.toString(), "Remove account");
    }

    @Override
    public void execute(ApplicationContextBankAgency context) throws Exception {
        PrintWriter writer = context.getPrintWriter();
        writer.print("Account Number ?");
        writer.flush();
        String number = context.getScanner().next();
        context.getBankAgency().removeAccount(number);
    }
}
