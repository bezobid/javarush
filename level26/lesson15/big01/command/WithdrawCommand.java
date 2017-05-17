package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by bezobid on 19.05.2016.
 */
class WithdrawCommand implements Command{

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");


    @Override
    public void execute() throws InterruptOperationException {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cm = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        int amount = 0;
        String amountString;
        ConsoleHelper.writeMessage(res.getString("specify.amount"));


        while (true){
            amountString = ConsoleHelper.readString();
            if (amountString.matches("^\\d+$") && !amountString.equals("0")){
                amount = Integer.parseInt(amountString);
                if (cm.isAmountAvailable(amount)){
                    ConsoleHelper.writeMessage(res.getString("before"));
                    Map<Integer, Integer> result = null;
                    try {
                        result = cm.withdrawAmount(amount);
                        ArrayList<Integer> keys = new ArrayList<>(result.keySet());
                        Collections.sort(keys);
                        Collections.reverse(keys);

                        for (Integer i : keys){
                            ConsoleHelper.writeMessage(i + " - " + result.get(i));
                        }

                        System.out.printf(res.getString("success.format")+"\n", amount, code);
                        break;
                    } catch (NotEnoughMoneyException e) {
                        ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                    }



                }
                else{
                    try {
                        throw new NotEnoughMoneyException();
                    } catch (NotEnoughMoneyException e) {
                        ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    }
                }
            }
            else {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
        }


    }
}
