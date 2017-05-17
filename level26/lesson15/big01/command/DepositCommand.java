package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by bezobid on 19.05.2016.
 */
class DepositCommand implements Command{

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");


    @Override
    public void execute() throws InterruptOperationException {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        String[] nomi = ConsoleHelper.getValidTwoDigits(code);
        ConsoleHelper.writeMessage(res.getString("before"));
        int denomination = Integer.parseInt(nomi[0]);
        int count = Integer.parseInt(nomi[1]);
        manipulator.addAmount(denomination, count);
        System.out.printf(res.getString("success.format")+"\n", denomination*count, code);
    }
}
