package com.NumGame;

public class GameSetting {
    // ��Ϸ����
    public int rangeStart;
    public int rangeEnd;
    public int guessTotal;
    // �Ƿ������Ϸ
    public boolean stopGame;

    public boolean guessCorrect;
    public int totalGameCount;
    public int totalCorrectCount;

    public void describe() {
        System.out.println("Ŀ�����Ѿ����ɣ�������" + rangeStart + "��" + rangeEnd + "֮�䣬" +
                "��������������������" + guessTotal + "�β²�Ļ��ᡣ����-1��ʱ������Ϸ��");
    }
    public int togame(int guessNum,int num,int guessLeft){
        if (guessNum == -1) {
            stopGame = true;
            return 1;
        }
        if (guessNum <= rangeStart || guessNum >= rangeEnd) {
            System.out.println("��������" + rangeStart + "��" + rangeEnd + "֮�䣬�����֣�����������������");
            return 2;
        }
        if (guessNum == num)
        {
            totalCorrectCount++;
            guessCorrect = true;
            System.out.println("��ϲ��¶��ˣ���ε����־���" + num +
                    "�������㹲����" + (guessTotal - guessLeft) + "�Ρ�");
            return 1;
        }else if (guessNum > num) {
            System.out.println("�²�����ֱ�Ŀ�����ִ�");
        } else {
            System.out.println("�²�����ֱ�Ŀ������С��");
        }
        return guessNum;
    }


    }
