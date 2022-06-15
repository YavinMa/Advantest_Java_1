package com.NumGame;

import java.util.Scanner;

public class Guess_Num {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        GameSetting setting = new GameSetting();
        setting.rangeStart = 1;
        setting.rangeEnd = 8;
        setting.guessTotal = 5;
        setting.stopGame = false;
        // ��Ϸͳ��
        setting.totalGameCount = 0;
        setting.totalCorrectCount = 0;

        while (!setting.stopGame) {
            // ��ʼ��������Ϸ�ı���
            int guessLeft = setting.guessTotal;
            int mod = setting.rangeEnd - setting.rangeStart;
            double randNum = Math.random();
            int num = ((int) (randNum * setting.rangeEnd * 100)) % mod;
            num += setting.rangeStart;
            if (num <= setting.rangeStart) {
                num = setting.rangeStart + 1;
            }
            if (num >= setting.rangeEnd) {
                num = setting.rangeEnd - 1;
            }

            setting.describe();

            // ������Ϸ�Ƿ�ʼ��
            boolean gameStart = true;
            // �����Ƿ��������
            setting.guessCorrect = false;



            while (guessLeft > 0) {
                System.out.println("����" + guessLeft + "�λ��ᣬ������²�����֣��س�ȷ��");
                int guessNum = in.nextInt();
                int condition = setting.togame(guessNum,num,guessLeft);
                if (condition == 1)
                    break;
                else if (condition == 2)
                    continue;
                if (gameStart) {
                    setting.totalGameCount++;
                    gameStart = false;
                }
                guessLeft--;
            }
            if (!setting.guessCorrect) {
                System.out.println("���ε�Ŀ��������" + num + "�����û�в��С�");
            }
        }

        System.out.println("��������" + setting.totalGameCount + "����Ϸ��������ȷ��Ϊ" + setting.totalCorrectCount + "��");
    }
}
