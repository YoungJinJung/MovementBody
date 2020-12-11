package com.project.movementbody.util;

import com.project.movementbody.model.Food;
import com.project.movementbody.model.FoodCategory;
import com.project.movementbody.service.food.FoodService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum FoodCodeGenerator {
    INSTANCE;
    private static final String initFoodCode = "C000001";
    private int foodCodeNumber;
    @Autowired
    FoodService foodService;

    public void init() {
        //초기 FOOD CODE 값을 가져오는 로직
        List<Food> foodList = foodService.findFoodListByCategory(FoodCategory.CUSTOM.name());
        String code;
        if(foodList.size() > 1) {
            Collections.sort(foodList, Comparator.comparing(Food::getFoodCode));
            code = foodList.get(foodList.size() - 1).getFoodCode();
        } else if (foodList.size() == 1) {
            code = foodList.get(0).getFoodCode();
        } else {
            code = initFoodCode;
        }
        foodCodeNumber = checkNumber(code);
        foodCodeNumber++;
    }

    private int checkNumber(String code) {
        int index = 0;
        for (int i = 1; i < code.length(); i++) {
            if (code.charAt(i) != 0) {
                index = i;
            }
        }
        return Integer.parseInt(code.substring(index));
    }

    public String getFoodCode() {
        StringBuilder stringBuilder = new StringBuilder("C");
        for (int i = 1; i < 6; i++) {
            if (foodCodeNumber / (int)Math.pow(10, i) == 0) {
                stringBuilder.append("0");
            }
        }
        stringBuilder.append(foodCodeNumber++);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        List<String> testList = new ArrayList<>();//INIT TEST
        testList.add("C0002");
        testList.add("C0003");
        testList.add("C0004");
        Collections.sort(testList, new Comparator<String>() {
            @Override
            public int compare(String f1, String f2) {
                return f2.compareTo(f1);
            }
        });

        String code = testList.get(testList.size() - 1);//TEST SUBSTRING
        int index = 0;
        for (int i = 1; i < code.length(); i++) {
            if (code.charAt(i) != 0) {
                index = i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("C");
        int testNumber = 123;
        for (int i = 1; i < 6 ; i++) {
            int mod = (int)Math.pow(10,i);
            int num = testNumber / mod;
            if (num == 0) {
                stringBuilder.append("0");
            }
        }
        stringBuilder.append(testNumber++);
        System.out.println(stringBuilder.toString());
    }
}
