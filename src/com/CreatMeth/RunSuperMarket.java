package com.CreatMeth;

import com.CreatMeth.Supermarket.SuperMarket;
import com.CreatMeth.Supermarket.Merchandise;
public class RunSuperMarket {

    public static void main(String[] args) {
        // ����һ��С������
        SuperMarket littleSuperMarket = new SuperMarket(
                "�м�С����", "�ֶ����520��",
                100, 200, 200);

        System.out.println("VIP���������ۿ�����Ϊ��" + Merchandise.getDiscountOnDiscount(littleSuperMarket));

    }
}

