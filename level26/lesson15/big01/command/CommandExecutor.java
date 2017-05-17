package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bezobid on 19.05.2016.
 */
public class CommandExecutor {

    private CommandExecutor() {}

    private static Map<Operation, Command> operations;

    static{
        operations = new HashMap<>();
        operations.put(Operation.DEPOSIT, new DepositCommand());
        operations.put(Operation.INFO, new InfoCommand());
        operations.put(Operation.WITHDRAW, new WithdrawCommand());
        operations.put(Operation.EXIT, new ExitCommand());
        operations.put(Operation.LOGIN, new LoginCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException {
        operations.get(operation).execute();
    }
}
