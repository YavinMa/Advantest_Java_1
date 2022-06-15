package com.geekbang;

import com.geekbang.supermarket.*;
import com.geekbang.person.*;
import java.util.Scanner;

public class RunSmallSupermarket {
    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();
        supermarket.address = "�ֶ����520��";
        supermarket.supermkName = "Advantest����";
        supermarket.parkingCount = 200;
        supermarket.merchandises = new Merchandise[200];
        supermarket.merchandiseSold = new int[supermarket.merchandises.length];

        Merchandise[] all = supermarket.merchandises;

        for (int i = 0; i < all.length; i++) {
            Merchandise m = new Merchandise();
            m.count = 200;
            m.id = "ID" + i;
            m.name = "��Ʒ" + i;
            m.purchasePrice = Math.random() * 200;
            m.soldPrice = (1 + Math.random()) * 200;
            all[i] = m;

        }

        System.out.println("���п�������");

        boolean open =true;
        Scanner scanner = new Scanner(System.in);

        
        while (open)
        {
            System.out.println("�������"+supermarket.supermkName);
            System.out.println("�����ַ"+supermarket.address);
            System.out.println("ͣ��λ��"+supermarket.parkingCount);
            System.out.println("����Ӫҵ��Ϊ"+supermarket.incomingSum);
            System.out.println("ȫ����Ʒ��"+supermarket.merchandises.length+"��");

            Customer customer = new Customer();
            customer.name = "�˿ͱ��" + ((int) (Math.random() * 10000));
            customer.money = (1 + Math.random()) * 1000;
            customer.isDrivingCar = Math.random() > 0.5;

            if (customer.isDrivingCar) {
                if (supermarket.parkingCount > 0) {
                    System.out.println("��ӭ" + customer.name + "�ݳ������������Ѿ�Ϊ�������˳�λ��ͣ�����Ŷ����λ���Ϊ" + supermarket.parkingCount);
                    supermarket.parkingCount--;
                } else {
                    System.out.println("������˼�����공λ��������ӭ���´ι���");
                    continue;
                }
            } else {
                System.out.println("��ӭ" + customer.name + "���ٱ���");
            }

            double totalCost = 0;
            while (true) {
                System.out.println("�����ṩ" + all.length + "����Ʒ����ӭѡ������������Ʒ���");
                int index = scanner.nextInt();

                if (index < 0) {
                    break;
                }

                if (index >= all.length) {
                    System.out.println("����û��������Ʒ�������������0��" + (all.length - 1) + "֮�ڵ���Ʒ��š�");
                    continue;
                }

                Merchandise m = all[index];

                System.out.println("��ѡ������Ʒ����" + m.name + "��������" + m.soldPrice + "��������Ҫ������ٸ���");
                int numToBuy = scanner.nextInt();

                if (numToBuy <= 0) {
                    System.out.println("���򿴿�Ҳ�ã���ӭ������ѡ��");
                    continue;
                }

                if (numToBuy > m.count) {
                    System.out.println("�������Ʒ���û����ô�࣬��ӭ����ѡ����");
                    continue;
                }

                // ��Ƶ�д˴��д���, Ӧ���� numToBuy * m.soldPrice ������ numToBuy * m.purchasePrice . ��л @ʱ��������Ĵ� ��æ��׽bugһֻ.
                if (numToBuy * m.soldPrice + totalCost > customer.money) {
                    System.out.println("������Ǯ��������ӭ������ѡ");
                    continue;
                }

                totalCost += numToBuy * m.soldPrice;

                m.count -= numToBuy;
                supermarket.merchandiseSold[index] += numToBuy;
            }

            customer.money -= totalCost;

            if (customer.isDrivingCar) {
                supermarket.parkingCount++;
            }

            System.out.println("�˿�" + customer.name + "��������" + totalCost);

            supermarket.incomingSum += totalCost;

            System.out.println("������Ӫҵ��");
            open = scanner.nextBoolean();

        }

        System.out.println("���й����ˣ�");
        System.out.println("�����ܵ�Ӫҵ��Ϊ" + supermarket.incomingSum + "��Ӫҵ�������");

        for (int i = 0; i < supermarket.merchandiseSold.length; i++) {
            Merchandise m = all[i];
            int numSold = supermarket.merchandiseSold[i];
            if (numSold > 0) {
                double incomming = m.soldPrice * numSold;
                double netIncomming = (m.soldPrice - m.purchasePrice) * numSold;
                System.out.println(m.name + "�۳���" + numSold + "�������۶�Ϊ"
                        + incomming + "��������Ϊ" + netIncomming);
            }
        }

    }
}
