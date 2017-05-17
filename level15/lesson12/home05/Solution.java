package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution (){}
    public Solution(int a){}
    public Solution(String a){}

    protected Solution(byte a){}
    protected Solution(short a){}
    protected Solution(long a){}

    Solution(float a){}
    Solution(double a){}
    Solution(char a){}

    private Solution(int a, byte c){}
    private Solution(int a, short c){}
    private Solution(int a, char c){}
}

