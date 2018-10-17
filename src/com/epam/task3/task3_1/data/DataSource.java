package com.epam.task3.task3_1.data;

import com.epam.task3.task3_1.model.entity.*;
import java.util.ArrayList;
import java.util.Collections;

public class DataSource {
    public static ArrayList<KidsToy> getKidsToys(){
        ArrayList<KidsToy> listKidsToy = new ArrayList<>();
        Collections.addAll(listKidsToy,
                new Car("XK120", "TINY LOVE", "metal", 120.5, 90, 5,
                        20, "3-7", "Roadster", "Jaguar", 5 ),
                new Constructor("Imperial transport", "LEGO", "Plastic", 59.99, 14, 40,
                        25, "8-14", "Star Wars", 622),
                new ToyWeaponSet("M16", "GOTZ", "Plastic", 30.99, 30, 40, 15,
                        "12-16", "Police", 3),
                new Puzzles("Map of Ukraine", "PLAYMOBIL","Cardboard", 29.99, 14,
                        36, 28, "3-7", "Geography", 84),
                new Doll("Ariel", "MATTEL", "Plastic", 490.90, 14,
                        11, 35, "4-7", "Hasbro Disney Princess", false),
                new Car("AMG GT", "SMOBY", "metal", 140.0, 90, 4,
                        18, "3-7", "Coupe", "Mercedes", 5 ),
                new Doll("Bambolina Molly", "HANSA", "Rubber", 689.0, 30,
                        15, 99, "3-7", "Ballerina with accessories", true),
                new Puzzles("Truck - Mechanical 3D puzzle", "ZAPF CREATION", "Wood", 899.99, 30,
                        30, 14, "10-16", "Cars", 537),
                new Constructor("Mega Bloks", "KLEIN", "Plastic", 35.5, 14, 35, 20,
                        "1-5", "First Builders", 80),
                new Car("Mustang GT", "FISHER-PRICE", "metal", 110.0, 90, 6,
                        20, "3-7", "Coupe", "Ford", 5 ));
    return listKidsToy;
    }
}
