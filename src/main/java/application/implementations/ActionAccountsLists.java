package application.implementations;
import application.ApplicationContextBankAgency;
import application.action.GenericAction;

public class ActionAccountsLists extends GenericAction<ApplicationContextBankAgency> {

    public ActionAccountsLists(Integer code){
        super(code.toString(), "List of the Agency accounts");
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

        //context.getBankAgency().print() should return String to print it in right stream
        //I thought we can not change bank classes and did not changed it
        context.getBankAgency().print();
    }
}
