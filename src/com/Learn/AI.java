package com.Learn;

import java.util.Scanner;

public class AI {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.next();
            if ("exit".equals(input)) {
                System.out.println("�ټ���");
                break;
            }

            boolean replied = false;

            String[] canStart = new String[]{"��", "��", "��", "��", "��"};
            for (int i = 0; i < canStart.length && (!replied); i++) {
                if (input.startsWith(canStart[i])) {
                    System.out.println(canStart[i] + "��");
                    replied = true;
                    break;
                }
            }

            String[] askTail = new String[]{"��", "��?", "��"};
            for (int i = 0; i < askTail.length && (!replied); i++) {
                if (input.endsWith(askTail[i])) {
                    System.out.println(input.replace(askTail[i], "��"));
                    replied = true;
                    break;
                }
            }

            if (!replied) {
                System.out.println(input + "��");
            }
        }

    }
}