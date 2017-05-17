package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by bezobid on 19.05.2016.
 */
class InfoCommand implements Command{

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");


    @Override
    public void execute() {

        ConsoleHelper.writeMessage(res.getString("before"));

        ArrayList<CurrencyManipulator> list = (ArrayList<CurrencyManipulator>)CurrencyManipulatorFactory.getAllCurrencyManipulators();

        boolean anyMoney = false;

        for (CurrencyManipulator cm : list){
            if (cm.hasMoney()) anyMoney = true;
        }

        if (!anyMoney) {
            ConsoleHelper.writeMessage(res.getString("no.money"));

        }else {
            for (CurrencyManipulator cm : list){
                ConsoleHelper.writeMessage(cm.getCurrencyCode() + " - " + cm.getTotalAmount());
            }
        }
    }
}
