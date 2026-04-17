package org.example.CoreJava.Task5;

public class LanguageConstructsTasks {
    public int caughtSpeeding(int speed, boolean isBirthday) {
        int allowance = isBirthday ? 5 : 0;
        if (speed <= 60 + allowance) return 0;
        if (speed <= 80 + allowance) return 1;
        return 2;
    }

    public boolean love6(int a, int b) {
        return (a == 6 || b == 6 || a + b == 6 || Math.abs(a - b) == 6);
    }

    public int teaParty(int tea, int candy) {
        if (tea < 5 || candy < 5) return 0;
        if (tea >= 2 * candy || candy >= 2 * tea) return 2;
        return 1;
    }

    public int blueTicket(int a, int b, int c) {
        int ab = a + b;
        int bc = b + c;
        int ac = a + c;
        if (ab == 10 || bc == 10 || ac == 10) return 10;
        if (ab == bc + 10 || ab == ac + 10) return 5;
        return 0;
    }

    public boolean inOrder(int a, int b, int c, boolean bOk) {
        if (bOk) return c > b;
        return b > a && c > b;
    }

    public boolean shareDigit(int a, int b) {
        int a1 = a / 10, a2 = a % 10;
        int b1 = b / 10, b2 = b % 10;
        return (a1 == b1 || a1 == b2 || a2 == b1 || a2 == b2);
    }

    public int sumLimit(int a, int b) {
        int sum = a + b;
        return String.valueOf(sum).length() == String.valueOf(a).length() ? sum : a;
    }

    public String withoutString(String base, String remove) {
        return base.replaceAll("(?i)" + java.util.regex.Pattern.quote(remove), "");
    }

    public int maxBlock(String str) {
        int max = 0, count = 0;
        char prev = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == prev) {
                count++;
            } else {
                count = 1;
                prev = str.charAt(i);
            }
            if (count > max) max = count;
        }
        return max;
    }

    public int sumNumbers(String str) {
        int sum = 0;
        String num = "";
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                num += str.charAt(i);
            } else {
                if (!num.equals("")) {
                    sum += Integer.parseInt(num);
                    num = "";
                }
            }
        }
        if (!num.equals("")) sum += Integer.parseInt(num);
        return sum;
    }
}
