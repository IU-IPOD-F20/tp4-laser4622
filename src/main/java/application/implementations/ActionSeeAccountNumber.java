package application.implementations;

import application.ApplicationContextBankAgency;
import application.action.GenericAction;
import bank.Account;

public class ActionSeeAccountNumber extends GenericAction<ApplicationContextBankAgency> {
    public ActionSeeAccountNumber(Integer code) {
        super(code.toString(), "See an account (by its number)");
    }

    @Override
    public String actionMessage() {
        return message;
    }

    @Override
    public String actionCode() {
        return code;
    }

    @Override
    public void execute(ApplicationContextBankAgency context) throws Exception {
        context.getPrintWriter().println("Account Number ?");
        context.getPrintWriter().flush();
        String number = context.getScanner().next();
        Account account = context.getBankAgency().getAccount(number);
        if (account == null) {
            context.getPrintWriter().println("Account not existing ...");
        } else {
            context.getPrintWriter().println("Account info:");
            context.getPrintWriter().println(account);
        }
    }
}
