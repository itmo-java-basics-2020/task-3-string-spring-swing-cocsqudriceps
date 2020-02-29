package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null){
            return new int[]{};
        }
        if (inputArray.length == 0) {
            return inputArray;
        }
        int t = inputArray[inputArray.length - 1];
        System.arraycopy(inputArray, 0, inputArray, 1, inputArray.length - 1);
        inputArray[0] = t;
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {

        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }

        if (inputArray.length == 1) {
            return inputArray[0];
        }

        int mult = 1;
        int tempMax = -1;
        for (int j = 0; j < 2; j++) {
            int num = 0;
            for (int i = 0; i < inputArray.length; i++) {
                if (num == tempMax || (tempMax != i && inputArray[i] > inputArray[num])) {
                    num = i;
                }
            }
            tempMax = num;
            mult *= inputArray[num];
        }
        return mult;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        String s = input.toLowerCase();
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'b') {
                r++;
            }
        }
        return 100 * r / s.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null)
            return false;

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i))
                return false;
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0)
            return "";

        StringBuilder str = new StringBuilder();
        int c = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(i - 1)) {
                str.append(input.charAt(i - 1)).append(c);
                c = 1;
            }
            else
                c++;
        }

        str.append(input.charAt(input.length() - 1)).append(c);
        return str.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() != two.length() || one == "" || two == "")
            return false;

        int[] alphabet = new int[256];
        for (int i = 0; i < one.length(); i++) {
            alphabet[one.charAt(i)]++;
            alphabet[two.charAt(i)]--;
        }


        for (int v : alphabet)
            if (v != 0)
                return false;

        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null)
            return false;
        if (s == "")
            return false;
        int[] alphabet = new int[256];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i)]++;
            if (alphabet[s.charAt(i)] == 2)
                return false;
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m[0].length == 0)
            return new int[][]{{}, {}};



        int[][] trm = new int[m[0].length][m[0].length];
        for (int i = 0; i < m[0].length; i++)
            for (int j = 0; j < m[0].length; j++)
                trm[j][i] = m[i][j];

        return trm;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0)
            return "";

        if (separator == null)
            separator = ' ';

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < inputStrings.length - 1; i++)
            res.append(inputStrings[i]).append(separator);

        return res.append(inputStrings[inputStrings.length - 1]).toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null)
            return 0;
        int count = 0;
        for(int i = 0; i < inputStrings.length; ++i)
        {
            if (inputStrings[i].startsWith(prefix))
                count++;
        }
        return count;
    }
}
