package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by bezobid on 19.05.2016.
 */
public class CurrencyManipulator {

    String currencyCode;
    Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        if (denominations.containsKey(denomination)){
            int amount = denominations.get(denomination);
            denominations.put(denomination, count+amount);

        }
        else{
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount(){
        int sum = 0;

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()){
            sum += entry.getKey() * entry.getValue();
        }

        return sum;
    }

    public boolean hasMoney(){
        return getTotalAmount() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount){
        return getTotalAmount() >= expectedAmount;
    }


    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {

        TreeSet<Integer> keys = new TreeSet<>(denominations.keySet());
        HashMap<Integer, Integer> result = new HashMap<>();
        int toWithdraw = expectedAmount;

        while(true){
            Integer max = keys.floor(toWithdraw);
            Integer maxAvailable = denominations.get(max);
            int countRequired = 0;

            try {
                countRequired = toWithdraw / max;
            } catch (NullPointerException e){
                throw new NotEnoughMoneyException();
            }

            if (countRequired > maxAvailable){
                result.put(max, maxAvailable);
                toWithdraw -= max * maxAvailable;
            }

            else {
                result.put(max, countRequired);
                toWithdraw -= max * countRequired;
            }

            keys.remove(max);

            if (toWithdraw == 0){
                for (Map.Entry<Integer, Integer> entry : result.entrySet()){
                    if (entry.getValue() < denominations.get(entry.getKey())) {
                        denominations.put(entry.getKey(), denominations.get(entry.getKey()) - entry.getValue());
                    }
                    else{
                        denominations.remove(entry.getKey());
                    }
                }

                break;
            }

            if (keys.isEmpty()){
                throw new NotEnoughMoneyException();
            }
        }
        return result;
    }

}
