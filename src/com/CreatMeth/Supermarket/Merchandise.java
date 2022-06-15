package com.CreatMeth.Supermarket;

public class Merchandise {

    public String name;
    public String id;
    public int count;
    public double soldPrice;
    public double purchasePrice;

    public static double DISCOUNT_FOR_VIP = 0.91;


    public static double getVIPDiscount() {
        return DISCOUNT_FOR_VIP;
    }

  public static double getDiscountOnDiscount(SuperMarket littleSuperMarket) {
        double activityDiscount = littleSuperMarket.activityDiscount;
        return DISCOUNT_FOR_VIP * activityDiscount;
    }

    public Merchandise(String name, String id, int count, double soldPrice, double purchasePrice) {
        this.name = name;
        this.id = id;
        this.count = count;
        this.soldPrice = soldPrice;
        this.purchasePrice = purchasePrice;

    }

    public String getName() {
        return name;
    }

    public Merchandise(String name, String id, int count, double soldPrice) {

        this(name, id, count, soldPrice, soldPrice * 0.8);
    }

    public Merchandise() {
        this("����", "000", 0, 1, 1.1);

    }

    public void describe() {
        System.out.println("��Ʒ���ֽ���" + name + "��id��" + id + "�� ��Ʒ�ۼ���" + soldPrice
                + "����Ʒ������" + purchasePrice + "����Ʒ�������" + count +
                "������һ����ë������" + (soldPrice - purchasePrice) + "���ۿ�Ϊ" + DISCOUNT_FOR_VIP);
    }

    public double calculateProfit() {
        double profit = soldPrice - purchasePrice;
        return profit;
    }


    public double buy() {
        return buy(1);
    }

    public double buy(int count) {
        return buy(count, false);
    }

    public double buy(int count, boolean isVIP) {
        if (this.count < count) {
            return -1;
        }
        this.count -= count;
        double totalCost = count * soldPrice;
        if (isVIP) {
            return totalCost * getVIPDiscount();
        } else {
            return totalCost;
        }
    }
}
