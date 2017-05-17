package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * Created by bezobid on 22.05.2016.
 */
public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {
        boolean verified = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        ConsoleHelper.writeMessage(res.getString("specify.data"));
        Enumeration cards = validCreditCards.getKeys();

        while(!verified){
            String cardString = ConsoleHelper.readString();
            String pinString = ConsoleHelper.readString();

            if (cardString.matches("^\\d{12}$") && pinString.matches("^\\d{4}$")){

                while(cards.hasMoreElements()){
                    String card = (String) cards.nextElement();
                    if (card.equals(cardString) && pinString.equals(validCreditCards.getString(cardString))){
                        System.out.printf(res.getString("success.format")+"\n", cardString);
                        verified = true;
                        break;
                    }
                }
                if (!verified) {
                    System.out.printf(res.getString("not.verified.format") + "\n", cardString);
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                }


            } else {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }

    }
}
