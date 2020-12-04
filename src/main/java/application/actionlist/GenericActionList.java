package application.actionlist;

import application.action.Action;
import bank.BankAgency;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericActionList<E> implements ActionList<E> {
    protected String code, message, title;
    protected ArrayList<Action<E>> actionList;


    public GenericActionList(String code, String title, String message) {
        this.code = code;
        this.title = title;
        this.message = message;
        actionList = new ArrayList<Action<E>>();
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
    public boolean addAction(Action<E> ac) {
        return this.addAction(ac, actionList.size());
    }

    @Override
    public boolean addAction(Action<E> ac, int index) {
        if (actionList.contains(ac)) {
            return false;
        } else {
            actionList.add(index, ac);
            return true;
        }
    }

    @Override
    public boolean removeAction(int index) {
        return actionList.remove(index) != null;
    }

    @Override
    public boolean removeAction(Action<E> ac) {
        return actionList.remove(ac);
    }

    @Override
    public String[] listOfActions() {
        ArrayList<String> stringActions = new ArrayList<>();

        for (Action<E> action: actionList) {
            stringActions.add(action.actionMessage());
        }
        return (String[]) stringActions.toArray();
    }

    @Override
    public String actionMessage() {
        return message;
    }

    @Override
    public String actionCode() {
        return code;
    }
}
