import application.ApplicationContextBankAgency;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class BankAppTest {



    @Test
    public void testFromGitExample() throws Exception{
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ByteArrayInputStream in = new ByteArrayInputStream("3\r\n0\r\n4\r\n0\n0\n".getBytes());
        final PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        ApplicationContextBankAgency context = ApplicationContextBankAgency.getInstance();

        context.setScanner(in);
        context.setPrintWriter(out);

        context.getMenu().execute(context);

        String exp = "--\n" +
                "Tinkoff Bank (Kazan)\n" +
                "General Menu\n" +
                "--\n" +
                "  Choose:\n" +
                "        1 - List of the Agency accounts\n" +
                "        2 - See an account (by its number)\n" +
                "        3 - Operation on an account\n" +
                "        4 - Accounts Management\n" +
                "\n" +
                "        0 - To quit this menu\n" +
                "Choice ?\n" +
                "--\n" +
                "Tinkoff Bank (Kazan)\n" +
                "Operations' Menu\n" +
                "--\n" +
                "  Choose:\n" +
                "        1 - Deposit money on an account\n" +
                "        2 - Withdraw money from an account\n" +
                "\n" +
                "        0 - To quit this menu\n" +
                "Choice ?\n" +
                "--\n" +
                "Tinkoff Bank (Kazan)\n" +
                "General Menu\n" +
                "--\n" +
                "  Choose:\n" +
                "        1 - List of the Agency accounts\n" +
                "        2 - See an account (by its number)\n" +
                "        3 - Operation on an account\n" +
                "        4 - Accounts Management\n" +
                "\n" +
                "        0 - To quit this menu\n" +
                "Choice ?\n" +
                "--\n" +
                "Tinkoff Bank (Kazan)\n" +
                "Menu Accounts management\n" +
                "--\n" +
                "  Choose:\n" +
                "        1 - Add account\n" +
                "        2 - Remove account\n" +
                "\n" +
                "        0 - To quit this menu\n" +
                "Choice ?\n" +
                "--\n" +
                "Tinkoff Bank (Kazan)\n" +
                "General Menu\n" +
                "--\n" +
                "  Choose:\n" +
                "        1 - List of the Agency accounts\n" +
                "        2 - See an account (by its number)\n" +
                "        3 - Operation on an account\n" +
                "        4 - Accounts Management\n" +
                "\n" +
                "        0 - To quit this menu\n" +
                "Choice ?\n";

        assertEquals(exp, out.toString());
        System.setOut(originalOut);
    }
}
