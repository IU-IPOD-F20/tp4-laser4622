package application;

import application.actionlist.ActionList;
import application.implementations.*;
import bank.BankAgency;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ApplicationContextBankAgency {
    private static ApplicationContextBankAgency instance;
    private static ActionList<ApplicationContextBankAgency> menu;
    private final BankAgency bankAgency;
    private Scanner scanner;
    private PrintWriter printWriter;


    private ApplicationContextBankAgency() {
        bankAgency = KazanTinkoffBank.getBankAgency();
        scanner = new Scanner(System.in);
        printWriter = new PrintWriter(System.out);
        setMenu();
    }

    //Singleton realization
    public static ApplicationContextBankAgency getInstance() {
        if (instance == null) {
            instance = new ApplicationContextBankAgency();
        }
        return instance;
    }

    public BankAgency getBankAgency() {
        return bankAgency;
    }

    public ActionList<ApplicationContextBankAgency> getMenu() {
        return menu;
    }

    private static void setMenu() {
        //setup menu
        menu = new ActionListBankAgency(1, "General Menu", "General Menu");

        //first button
        menu.addAction(new ActionAccountsLists(1));

        //second button
        menu.addAction(new ActionSeeAccountNumber(2));

        //third button
        ActionListBankAgency operationsMenu = new ActionListBankAgency(3, "Operations' Menu", "Operation on an account");
        operationsMenu.addAction(new ActionDeposit(1));
        operationsMenu.addAction(new ActionWithdraw(2));
        menu.addAction(operationsMenu);

        //forth button
        ActionListBankAgency accountMenu = new ActionListBankAgency(4, "Menu Accounts management", "Accounts Management");
        accountMenu.addAction(new ActionAddAccount(1));
        accountMenu.addAction(new ActionRemoveAccount(2));
        menu.addAction(accountMenu);

    }

    //scanners
    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(InputStream stream) {
        scanner.close();
        scanner = new Scanner(stream);
    }


    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(OutputStream stream) {
        printWriter.close();
        printWriter = new PrintWriter(stream);
    }

    public void close() {
        scanner.close();
        printWriter.close();
    }
}
