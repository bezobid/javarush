package com.javarush.test.level25.lesson02.home01;

import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {

        List<Column> result = new LinkedList<>();

        int count = 0;

        for (int x : realOrder) {
            if (x > -1) count++;
        }

        Column[] list = new Column[count];

        for (int x = 0; x < realOrder.length; x++) {
            if (realOrder[x] > -1) {
                list[realOrder[x]] = values()[x];
            }
        }

        for (Column c : list) {
            result.add(c);
        }

        return result;
    }


    @Override
    public String getColumnName() {
        return columnName;
    }

    @Override
    public boolean isShown() {
        return realOrder[ordinal()] != -1;
    }

    @Override
    public void hide() {
        if (realOrder[ordinal()] > -1) {
            for (int x = 0; x < realOrder.length; x++) {
                if (realOrder[x] > realOrder[ordinal()]) {
                    realOrder[x] -= 1;
                }
            }
        }

        realOrder[ordinal()] = -1;
    }
}
