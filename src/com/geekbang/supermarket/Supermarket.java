package com.geekbang.supermarket;

public class Supermarket {
    public String supermkName;
    public String address;
    public int parkingCount;
    public double incomingSum;
    public Merchandise[] merchandises;
    public int[] merchandiseSold;
    // >> ����ֵ���Ϳ�������������ʱ��ʵ�ʷ��ص�ֵ��������������
    public Merchandise getBiggestProfitMerchandise() {
        Merchandise curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            Merchandise m = merchandises[i];
            if (curr == null) {
                curr = m;
                continue;
            }
            // >> ������Ʒ�ж���ķ�������ͬ��ʵ��������ͬ�ķ�������Ȼ������ͬ������ÿ��ʵ���ڲ������ݲ�ͬ�����Է���ֵҲ��ͬ
            double currProfit = curr.calculateProfit();
            double newProfit = m.calculateProfit();
            if (currProfit < newProfit) {
                curr = m;
            }
        }
        return curr;
    }

    public Merchandise getBiggestProfitMerchindise2() {
        Merchandise curr = null;
        for (int i = 0; i < merchandises.length; i++) {
            Merchandise m = merchandises[i];
            if (curr == null) {
                curr = m;
            } else {
                if (curr.calculateProfit() < m.calculateProfit()) {
                    curr = m;
                }
            }
        }
        return curr;
    }
}
