package com.chinasofti.model;

import java.text.DecimalFormat;

import org.junit.Test;

public class housingArea {

    @Test
    public void haoLaiCheng_includingTheWall() {
        //  好莱城-包括墙的面积：
        //  主卧：3900*3600  飘窗：600*((80/112)*3600) 主卫：3600*2200
        //  客卧：2800*3400   飘窗：1800*600
        //  次卫：1800*3400
        //  书房：3400*3300   飘窗：3000*600
        //  厨房：2100*3400 
        //  空中花园：2400*3400
        //  进门长廊：1500*（1800+3300+2100+2400）
        //  客厅+餐厅：（1800+3300+2100）*3100
        //  阳台：3400*1500
        System.out.println("弘德西街-好莱城");
        double firstBed = (3900 * 3600 + 600 * 3600 + 3600 * 2200) / 1000000;
        System.out.println("主卧加飘窗加主卫面积：" + firstBed + "㎡");
        double secondBed = (2800 * 3400 + 1800 * 600) / 1000000;
        System.out.println("客卧面积：" + secondBed + "㎡");
        double secondWc = (1800 * 3400) / 1000000;
        System.out.println("次卫面积：" + secondWc + "㎡");
        double bookRoom = (3400 * 3300 + 3000 * 600) / 1000000;
        System.out.println("书房面积：" + bookRoom + "㎡");
        double kitchen = (2100 * 3400) / 1000000;
        System.out.println("厨房面积：" + kitchen + "㎡");
        double airGarden = (2400 * 3400) / 1000000;
        System.out.println("空中花园面积：" + airGarden + "㎡");
        double longCorridor = (1500 * (1800 + 3300 + 2100 + 2400)) / 1000000;
        System.out.println("进门长廊面积：" + longCorridor + "㎡");
        double living_diningRoom = ((1800 + 3300 + 2100) * 3100) / 1000000;
        System.out.println("客厅和餐厅面积：" + living_diningRoom + "㎡");
        double balcony = (3400 * 1500) / 1000000;
        System.out.println("阳台面积：" + balcony + "㎡");
        double total = firstBed + secondBed + secondWc + bookRoom + kitchen + airGarden + longCorridor + living_diningRoom + balcony;
        System.out.println("面积总和：" + total + "㎡");
        double thePool = 128 - total;
        System.out.println("公摊面积：" + thePool);
        System.out.println("公摊面积率：" + thePool / 128 * 100 + "%");
    }

    @Test
    public void laoLaiCheng_exclusiveTheWall() {
        //  比例尺换算因子：407:(3600+3400+3800+2400)   单位：mm
        //  好莱城-实际居住面积：
        //  1.0、主卧：105*113  
        //  1.1、主卧飘窗：81*22 
        //  1.2、主卫：68*68 
        //  1.3主卧走廊：38*35
        //  2.0、客卧：80*105   
        //  2.1、客卧飘窗：64*22
        //  3、次卫：53*105
        //  4.0、书房：95*105   
        //  4.1、书房飘窗：81*22
        //  5、厨房：62*105 
        //  6、空中花园：70*101
        //  7、进门长廊：329*34+75*6
        //  8、客厅：121*101
        //  9、餐厅：92*95
        //  10、阳台：93*43+7*35
        double includeWallArea = 109;
        double i = 407;
        double j = 3600 + 3400 + 3800 + 2400;
        DecimalFormat df = new DecimalFormat("######0.00");
        System.out.println("弘德西街-好莱城-122104(按实际居住面积计算)");
        System.out.println("----------------------------");
        double masterBedRoom = ((105 / i * j) * (113 / i * j)) / 1000000;
        System.out.println("主卧面积：" + df.format(masterBedRoom) + "㎡");
        double masterBedRoomBayWindow = ((81 / i * j) * (22 / i * j)) / 1000000;
        System.out.println("主卧飘窗面积：" + df.format(masterBedRoomBayWindow) + "㎡");
        double masterBedBathRoom = ((68 / i * j) * (68 / i * j)) / 1000000;
        System.out.println("主卫面积：" + df.format(masterBedBathRoom) + "㎡");
        double masterBedRoomCorridor = ((38 / i * j) * (35 / i * j)) / 1000000;
        System.out.println("主卧走廊面积：" + df.format(masterBedRoomCorridor) + "㎡");
        System.out.println("主卧面积合计：" + df.format((masterBedRoom + masterBedRoomBayWindow + masterBedBathRoom + masterBedRoomCorridor)) + "㎡");
        System.out.println("----------------------------");
        double secondBedRoom = ((80 / i * j) * (105 / i * j)) / 1000000;
        System.out.println("客卧面积：" + df.format(secondBedRoom) + "㎡");
        double secondBedRoomBayWindow = ((64 / i * j) * (22 / i * j)) / 1000000;
        System.out.println("客卧飘窗面积：" + df.format(secondBedRoomBayWindow) + "㎡");
        System.out.println("客卧面积合计：" + df.format((secondBedRoom + secondBedRoomBayWindow)) + "㎡");
        System.out.println("----------------------------");
        double studyRoom = ((95 / i * j) * (105 / i * j)) / 1000000;
        System.out.println("书房面积：" + df.format(studyRoom) + "㎡");
        double studyRoomBayWindow = ((81 / i * j) * (22 / i * j)) / 1000000;
        System.out.println("书房飘窗面积：" + df.format(studyRoomBayWindow) + "㎡");
        System.out.println("书房面积合计：" + df.format((studyRoom + studyRoomBayWindow)) + "㎡");
        System.out.println("----------------------------");
        double secondBathRoom = ((53 / i * j) * (105 / i * j)) / 1000000;
        System.out.println("次卫面积：" + df.format(secondBathRoom) + "㎡");
        double cookRoom = ((62 / i * j) * (105 / i * j)) / 1000000;
        System.out.println("厨房面积：" + df.format(cookRoom) + "㎡");
        double airGarden = ((70 / i * j) * (101 / i * j)) / 1000000;
        System.out.println("空中花园面积：" + df.format(airGarden) + "㎡");
        double longCorridor = (((329 / i * j) * (34 / i * j)) + ((75 / i * j) * (6 / i * j))) / 1000000;
        System.out.println("进门长廊面积：" + df.format(longCorridor) + "㎡");
        double balcony = (((93 / i * j) * (43 / i * j)) + ((7 / i * j) * (35 / i * j))) / 1000000;
        System.out.println("阳台面积：" + df.format(balcony) + "㎡");
        System.out.println("----------------------------");
        double livingRoom = ((121 / i * j) * (101 / i * j)) / 1000000;
        System.out.println("客厅面积：" + df.format(livingRoom) + "㎡");
        double diningRoom = ((92 / i * j) * (95 / i * j)) / 1000000;
        System.out.println("餐厅面积：" + df.format(diningRoom) + "㎡");
        System.out.println("客厅和餐厅面积合计：" + df.format((livingRoom + diningRoom)) + "㎡");
        System.out.println("----------------------------");
        System.out.println("----------------------------");
        double allGiftArea = masterBedRoomBayWindow + secondBedRoomBayWindow + studyRoomBayWindow;
        System.out.println("全赠送面积总和：" + df.format(allGiftArea) + "㎡");
        double halfGiftArea = airGarden + balcony;
        System.out.println("半赠送面积总和：" + df.format(halfGiftArea) + "㎡");
        double livingSpace = masterBedRoom + masterBedRoomBayWindow + masterBedBathRoom + masterBedRoomCorridor +
                secondBedRoom + secondBedRoomBayWindow + secondBathRoom +
                studyRoom + studyRoomBayWindow +
                cookRoom + airGarden + longCorridor + livingRoom + diningRoom + balcony;
        System.out.println("实际赠送面积合计：" + df.format((allGiftArea + halfGiftArea / 2)) + "㎡");
        System.out.println("居住面积总和：" + df.format(livingSpace) + "㎡");
        double actualPurchaseArea = masterBedRoom + masterBedBathRoom + masterBedRoomCorridor +
                secondBedRoom + secondBathRoom + studyRoom +
                cookRoom + airGarden / 2 + longCorridor + livingRoom + diningRoom + balcony / 2;
        System.out.println("实际购买面积:" + df.format(actualPurchaseArea) + "㎡");
        System.out.println("承重墙以及隔墙的面积：" + df.format((includeWallArea - livingSpace)));
        double includeGiftAreaOfThePool = 128.96 - includeWallArea;
        System.out.println("含赠送面积公摊面积：" + df.format(includeGiftAreaOfThePool));
        System.out.println("含赠送面积公摊面积率：" + df.format(includeGiftAreaOfThePool / 128.96 * 100) + "%");
        double exclusiveGiftAreaOfThePool = 128.96 - (includeWallArea-(allGiftArea + halfGiftArea / 2));
        System.out.println("不含赠送面积公摊面积(实际公摊面积)：" + df.format(exclusiveGiftAreaOfThePool));
        System.out.println("不含赠送面积公摊面积率(实际公摊率)：" + df.format(exclusiveGiftAreaOfThePool / 128.96 * 100) + "%");
        System.out.println("----------------------------");
    }

    @Test
    public void yangGuangCheng() {
        System.out.println("--------------------------------");
        //      阳光城：
        DecimalFormat df = new DecimalFormat("######0.00");
        double x = 473;
        //最终求和后需要乘的数
        double y = 77.63;
        System.out.println("蜜桃-阳光城");
        double firstBed = (((192 / x) * (155 / x) + (123 / x) * (31 / x))) * y;
        System.out.println("主卧加飘窗面积：" + df.format(firstBed) + "㎡");
        double secondBed = ((143 / x) * (164 / x)) * y;
        System.out.println("客卧1面积：" + df.format(secondBed) + "㎡");
        double secondBed2 = ((150 / x) * (128 / x)) * y;
        System.out.println("客卧2面积：" + df.format(secondBed2) + "㎡");
        double washRoom = ((86 / x) * (134 / x)) * y;
        System.out.println("洗手间面积：" + df.format(washRoom) + "㎡");
        double kitchen = ((124 / x) * (122 / x)) * y;
        System.out.println("厨房面积：" + df.format(kitchen) + "㎡");
        double longCorridor = ((437 / x) * (57 / x)) * y;
        System.out.println("进门长廊面积：" + df.format(longCorridor) + "㎡");
        double longCorridor2 = ((315 / x) * (51 / x)) * y;
        System.out.println("室内长廊面积：" + df.format(longCorridor2) + "㎡");
        double livingRoom = ((183 / x) * (172 / x)) * y;
        System.out.println("客厅面积：" + df.format(livingRoom) + "㎡");
        double diningRoom = ((134 / x) * (172 / x)) * y;
        System.out.println("餐厅面积：" + df.format(diningRoom) + "㎡");
        double balcony = ((172 / x) * (67 / x)) * y;
        System.out.println("阳台面积：" + df.format(balcony) + "㎡");
        double total = firstBed + secondBed + secondBed2 + washRoom + kitchen + longCorridor + longCorridor2 + livingRoom + diningRoom + balcony;
        System.out.println("面积总和：" + df.format(total) + "㎡");
        double thePool = 91.22 - total;
        System.out.println("公摊面积：" + thePool);
        System.out.println("公摊面积率：" + thePool / 91.22 * 100 + "%");
    }
}
