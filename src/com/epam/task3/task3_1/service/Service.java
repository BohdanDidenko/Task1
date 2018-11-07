package com.epam.task3.task3_1.service;

import com.epam.task3.task3_1.model.entity.KidsToy;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public interface Service {
    void sortByTitle(List<KidsToy> listKidsToys);
    void sortByManufacturer(List<KidsToy> listKidsToys);
    void sortByMaterial(List<KidsToy> listKidsToys);
    void sortByPrice(List<KidsToy> list);
    void sortByWarrantyDays(List<KidsToy> listKidsToys);
    String calculateTotalValueAllKidsToy(List<KidsToy> listKidsToys);
    List<KidsToy> searchForKidsToysAtTheUserRequest(List<KidsToy> listKidsToys, String title, String manufacturer,String material,
                                                    double price, int warrantyDays, int packingWidth, int packingHeight, String ageGroup);


}
