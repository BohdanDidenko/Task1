package com.epam.task3.task3_1.model;

import com.epam.task3.task3_1.model.entity.KidsToy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GameRoom<T extends KidsToy> {
    private ArrayList<T> kidsToys;

    public GameRoom() {
    }

    public GameRoom(ArrayList<T> kidsToys) {
        this.kidsToys = kidsToys;
    }

    public ArrayList<T> getKidsToys() {
        return kidsToys;
    }

    public void setKidsToys(ArrayList<T> kidsToys) {
        this.kidsToys = kidsToys;
    }

    public void sort(Comparator<T> comparator){
        Collections.sort(kidsToys, comparator);
    }

    public String calculateTotalValueAllKidsToy(){
        double result = 0;
        for (T kidsToy : kidsToys)
            result += kidsToy.getPrice();

        return String.format("%.2f", result);
    }

    public ArrayList<T> searchForKidsToysAtTheUserRequest(String title, String manufacturer,String material,
            double price, int warrantyDays, int packingWidth, int packingHeight, String ageGroup) {
        ArrayList<T> result = new ArrayList<>();
        ArrayList<T> selection = kidsToys;

        if(title != null && title.equals("") == false) {
            result = searchByTitle(title, selection, result);
            selection = result;
        }

        if(manufacturer != null && manufacturer.equals("") == false){
            result = searchByManufacturer(manufacturer, selection, result);
            selection = result;
        }

        if(material != null && material.equals("") == false) {
            result = searchByMaterial(material, selection, result);
            selection = result;
        }

        if(price > 0) {
            result = searchByPrice(price, selection, result);
            selection = result;
        }

        if(warrantyDays > 0) {
            result = searchByWarrantyDays(warrantyDays, selection, result);
            selection = result;
        }

        if(packingWidth > 0) {
            result = searchByPackingWidth(packingWidth, selection, result);
            selection = result;
        }

        if(packingHeight > 0) {
            result = searchByPackingHeight(packingHeight, selection, result);
            selection = result;
        }

        if(ageGroup != null && ageGroup.equals("") == false) {
            result = searchByAgeGroup(ageGroup, selection, result);
            selection = result;
        }

        return result;
    }

    private ArrayList<T> searchByTitle(String title, ArrayList<T> selection, ArrayList<T> result){
        for (T kidsToy : selection) {
            if(kidsToy.getTitle().equals(title) && result.contains(kidsToy) == false) {
                result.add(kidsToy);
            }
        }
        return result;
    }

    private ArrayList<T> searchByManufacturer(String manufacturer, ArrayList<T> selection, ArrayList<T> result){
        for (T kidsToy : selection) {
            if(kidsToy.getManufacturer().equals(manufacturer)&& result.contains(kidsToy) == false) {
                result.add(kidsToy);
            }
        }
        return result;
    }

    private ArrayList<T> searchByMaterial(String material, ArrayList<T> selection, ArrayList<T> result){
        for (T kidsToy : selection) {
            if(kidsToy.getMaterial().equals(material) && result.contains(kidsToy) == false){
                result.add(kidsToy);
            }
        }
        return result;
    }

    private ArrayList<T> searchByPrice(double price, ArrayList<T> selection, ArrayList<T> result){
        for (T kidsToy : selection) {
            if(kidsToy.getPrice() <= price && result.contains(kidsToy) == false) {
                result.add(kidsToy);
            }
        }
        return result;
    }

    private ArrayList<T> searchByWarrantyDays(int warrantyDays, ArrayList<T> selection, ArrayList<T> result){
        for (T kidsToy : selection) {
            if(kidsToy.getWarrantyDays() >= warrantyDays && result.contains(kidsToy) == false){
                result.add(kidsToy);
            }
        }
        return result;
    }

    private ArrayList<T> searchByPackingWidth(int packingWidth, ArrayList<T> selection, ArrayList<T> result){
        for (T kidsToy : selection) {
            if(kidsToy.getPackingWidth() <= packingWidth && result.contains(kidsToy) == false) {
                result.add(kidsToy);
            }
        }
        return result;
    }

    private ArrayList<T> searchByPackingHeight(int packingHeight, ArrayList<T> selection, ArrayList<T> result){
        for (T kidsToy : selection) {
            if(kidsToy.getPackingHeight() <= packingHeight && result.contains(kidsToy) == false){
                result.add(kidsToy);
            }
        }
        return result;
    }

    private ArrayList<T> searchByAgeGroup(String ageGroup, ArrayList<T> selection, ArrayList<T> result){
        for (T kidsToy : selection) {
            if(kidsToy.getAgeGroup().equals(ageGroup) && result.contains(kidsToy) == false){
                result.add(kidsToy);
            }
        }
        return result;
    }
}