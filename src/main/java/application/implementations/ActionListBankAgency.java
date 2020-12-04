package application.implementations;

import application.ApplicationContextBankAgency;
import application.action.Action;
import application.actionlist.GenericActionList;

public class ActionListBankAgency extends GenericActionList<ApplicationContextBankAgency> {


    public ActionListBankAgency(Integer code, String title, String message) {
        super(code.toString(), title, message);
    }

    @Override
    public String listTitle() {
        return title;
    }

    @Override
    public int size() {
        return actionList.size();
    }

    @Override
    public boolean addAction(Action<ApplicationContextBankAgency> ac, int index) {
        actionList.add(index, ac);
        return actionList.get(index).equals(ac);
    }

    @Override
    public boolean removeAction(int index) {
        return false;
    }

    @Override
    public boolean removeAction(Action<ApplicationContextBankAgency> ac) {
        return false;
    }

    @Override
    public String[] listOfActions() {
        return new String[0];
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
        String code;
        while (true) {
            context.getPrintWriter().println("--");
            context.getPrintWriter().println(context.getBankAgency().getAgencyName() + " (" + context.getBankAgency().getAgencyLoc() + ")");
            context.getPrintWriter().println(this.title);
            context.getPrintWriter().println("--");
            context.getPrintWriter().println("  Choose:");
            actionList.forEach((a) -> context.getPrintWriter().println("        "+a.actionCode() + " - " + a.actionMessage()));
            context.getPrintWriter().println("\n        0 - To quit this menu");
            context.getPrintWriter().println("Choice ?");
            context.getPrintWriter().flush();

            code = context.getScanner().next();

            if(code.equals("0")) return;

            for(Action<ApplicationContextBankAgency> a:actionList){
                if(a.actionCode().equals(code)){
                    a.execute(context);
                    break;
                }
            }
        }
    }
}
