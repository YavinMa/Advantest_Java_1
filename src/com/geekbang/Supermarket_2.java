package com.geekbang;

import com.geekbang.supermarket.Supermarket;
import com.geekbang.supermarket.Merchandise;

import java.util.Scanner;

public class Supermarket_2 {
    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();
        // ���θ����е����֣���ַ��ͣ��λ��ֵ
        supermarket.supermkName = "�м�С����";
        supermarket.address = "�ֶ����520��";
        supermarket.parkingCount = 100;
        // ������200����Ʒ
        supermarket.merchandises = new Merchandise[200];
        // ͳ���õ�����
        supermarket.merchandiseSold = new int[supermarket.merchandises.length];

        // Ϊ��ʹ�÷��㣬����һ����Ʒ�������ã���supermarket.merchandisesָ��ͬһ���������
        Merchandise[] all = supermarket.merchandises;

        // ��������200����Ʒ��ֵ
        for (int i = 0; i < all.length; i++) {
            // ����������Ʒ�����Ը�ֵ
            Merchandise m = new Merchandise();
            m.name = "��Ʒ" + i;
            m.count = 200;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = m.purchasePrice * (1 + Math.random());
            m.id = "ID" + i;
            // �ô�������Ʒ������Ʒ����ĵ�i�����ø�ֵ��all��С���е���Ʒ��������ָ�����ͬһ���������
            all[i] = m;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("���ճ��д��ػݣ�������Ʒ�ڶ�����ۣ�ѡ��Ҫ�������Ʒ������");
            int index = scanner.nextInt();

            if (index < 0) {
                break;
            }

            if (index >= all.length) {
                System.out.println("��Ʒ������������");
                continue;
            }

            Merchandise m = all[index];
            System.out.println("��Ʒ" + m.name + "�ۼ�Ϊ" + m.soldPrice + "�����ʹ��򼸸���");
            int numToBuy = scanner.nextInt();

            if (numToBuy > m.count) {
                System.out.println("��治��");
                continue;
            }

            int fullPriceCount = numToBuy / 2 + numToBuy % 2;
            int halfPriceCount = numToBuy - fullPriceCount;

            double totalCost = fullPriceCount * m.soldPrice + (halfPriceCount * m.soldPrice / 2);

            m.count -= numToBuy;

            System.out.println("ѡ������Ʒ�ܼ�Ϊ" + totalCost);
        }

    }

}
