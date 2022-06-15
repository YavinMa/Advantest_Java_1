package com.geekbang;

import com.geekbang.supermarket.Supermarket;
import com.geekbang.supermarket.Merchandise;
public class Supermarket_3 {
    public static void main(String[] args) {
        // ����һ��С������
        Supermarket supermarket = new Supermarket();
        // ���θ����е����֣���ַ��ͣ��λ��ֵ
        supermarket.supermkName = "�м�С����";
        supermarket.address = "�ֶ����520��";
        supermarket.parkingCount = 100;
        // ������200����Ʒ
        supermarket.merchandises = new Merchandise[3];
        // ͳ���õ�����
        supermarket.merchandiseSold = new int[supermarket.merchandises.length];

        // Ϊ��ʹ�÷��㣬����һ����Ʒ�������ã���supermarket.merchandisesָ��ͬһ���������
        Merchandise[] all = supermarket.merchandises;

        Merchandise giftNoodle = new Merchandise();
        giftNoodle.name = "��Ʒ-����";
        giftNoodle.count = 2000;
        giftNoodle.purchasePrice = 5;
        giftNoodle.soldPrice = 0.05;
        giftNoodle.id = "GIFT001";

        Merchandise giftBowl = new Merchandise();
        giftBowl.name = "��Ʒ-��";
        giftBowl.count = 2000;
        giftBowl.purchasePrice = 8;
        giftBowl.soldPrice = 0.08;
        giftBowl.id = "GIFT002";

        // ��������200����Ʒ��ֵ
        for (int i = 0; i < all.length; i++) {
            // ����������Ʒ�����Ը�ֵ
            Merchandise m = new Merchandise();
            m.name = "��Ʒ" + i;
            m.count = 200;
            m.purchasePrice = (i + 1) * 100;
            m.soldPrice = m.purchasePrice * (1 + Math.random());
            m.id = "ID" + i;
            m.gift = giftNoodle;
            // �ô�������Ʒ������Ʒ����ĵ�i�����ø�ֵ��all��С���е���Ʒ��������ָ�����ͬһ���������
            all[i] = m;
            m.describe();
        }

        int index = 0;

        Merchandise m = supermarket.merchandises[index];

        int c = 7;


        double totalCost = m.buy((c + 2) * 5);
        System.out.println("��Ʒ�ܼ�Ϊ��" + totalCost);

        boolean biggerThan = m.totalValueBiggerThan(supermarket.merchandises[index + 1]);
        System.out.println(biggerThan);


        Merchandise paramRef = supermarket.merchandises[2];
        int paramPrime = 7;

        System.out.println("����ǰ");
        System.out.println(paramPrime);
        System.out.println(paramRef);

        m.willOutsideValueChangeIfParameterValueChangeHerePrime(paramPrime);
        // Ч���������´���
        // �β�ʵ�θ�ֵ��int intVal = paramPrime;
        // ������ִ�У�intVal = 99999999;
        m.willOutsideValueChangeIfParameterValueChangeHereRef(paramRef);
        // Ч���������´���
        // �β�ʵ�θ�ֵ��MerchandiseV2 m2 = paramRef;
        // ������ִ�У�m2 = gift;

        System.out.println("���ú�");
        System.out.println(paramPrime);
        System.out.println(paramRef);

        // ------ ����ֵ -------

        double soldPrice = m.getSoldPrice();

        System.out.println(soldPrice);
        m.describe();


        System.out.println("����getGiftAndHowCanOutsideChangeIt��getSoldPrice֮ǰ");

        m.describe();

        Merchandise giftOfM = m.getGiftAndHowCanOutsideChangeIt();

        giftOfM = giftBowl;

        double mSoldPrice = m.getSoldPrice();

        mSoldPrice = 9999999;

        System.out.println("�ܸı�m�����gift���ܸı�m��soldPrice��");

        m.describe();
    }
}
