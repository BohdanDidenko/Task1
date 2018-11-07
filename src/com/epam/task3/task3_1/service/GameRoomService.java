package com.epam.task3.task3_1.service;

import com.epam.task3.task3_1.model.entity.KidsToy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GameRoomService implements Service{

    @Override
    public void sortByTitle(List<KidsToy> listKidsToys) {
        sort(listKidsToys, (o1, o2) -> o1.getTitle().compareTo(o2.getTitle()));
    }

    @Override
    public void sortByManufacturer(List<KidsToy> listKidsToys){
        sort(listKidsToys, (o1,o2) -> o1.getManufacturer().compareTo(o2.getManufacturer()));
    }

    @Override
    public void sortByMaterial(List<KidsToy> listKidsToys){
        sort(listKidsToys, (o1, o2) -> o1.getMaterial().compareTo(o2.getMaterial()));
    }

    @Override
    public void sortByPrice(List<KidsToy> listKidsToys){
        sort(listKidsToys, (o1, o2) -> (int)(o1.getPrice() - o2.getPrice()));
    }

    @Override
    public void sortByWarrantyDays(List<KidsToy> listKidsToys){
        sort(listKidsToys, (o1, o2) -> o1.getWarrantyDays() - o2.getWarrantyDays());
    }

    private void sort(List<KidsToy> listKidsToys, Comparator<KidsToy> comparator){
        Collections.sort(listKidsToys, comparator);
    }

    @Override
    public String calculateTotalValueAllKidsToy(List<KidsToy> listKidsToys){
        double result = 0;
        for (KidsToy kidsToy : listKidsToys)
            result += kidsToy.getPrice();

        return String.format("%.2f", result);
    }

    @Override
    public List<KidsToy> searchForKidsToysAtTheUserRequest(List<KidsToy> listKidsToys, String title, String manufacturer,String material,
            double price, int warrantyDays, int packingWidth, int packingHeight, String ageGroup) {
        List<KidsToy> result = new ArrayList<>();
        List<KidsToy> selection = listKidsToys;

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

    private List<KidsToy> searchByTitle(String title, List<KidsToy> selection, List<KidsToy> result){
        for (KidsToy kidsToy : selection) {
            if(kidsToy.getTitle().equals(title) && result.contains(kidsToy) == false) {
                result.add(kidsToy);
            }
        }
        return result;
    }

    private List<KidsToy> searchByManufacturer(String manufacturer, List<KidsToy> selection, List<KidsToy> result){
        for (KidsToy kidsToy : selection) {
            if(kidsToy.getManufacturer().equals(manufacturer)&& result.contains(kidsToy) == false) {
                result.add(kidsToy);
            }
        }
        return result;
    }

    private List<KidsToy> searchByMaterial(String material, List<KidsToy> selection, List<KidsToy> result){
        for (KidsToy kidsToy : selection) {
            if(kidsToy.getMaterial().equals(material) && result.contains(kidsToy) == false){
                result.add(kidsToy);
            }
        }
        return result;
    }

    private List<KidsToy> searchByPrice(double price, List<KidsToy> selection, List<KidsToy> result){
        for (KidsToy kidsToy : selection) {
            if(kidsToy.getPrice() <= price && result.contains(kidsToy) == false) {
                result.add(kidsToy);
            }
        }
        return result;
    }

    private List<KidsToy> searchByWarrantyDays(int warrantyDays, List<KidsToy> selection, List<KidsToy> result){
        for (KidsToy kidsToy : selection) {
            if(kidsToy.getWarrantyDays() >= warrantyDays && result.contains(kidsToy) == false){
                result.add(kidsToy);
            }
        }
        return result;
    }

    private List<KidsToy> searchByPackingWidth(int packingWidth, List<KidsToy> selection, List<KidsToy> result){
        for (KidsToy kidsToy : selection) {
            if(kidsToy.getPackingWidth() <= packingWidth && result.contains(kidsToy) == false) {
                result.add(kidsToy);
            }
        }
        return result;
    }

    private List<KidsToy> searchByPackingHeight(int packingHeight, List<KidsToy> selection, List<KidsToy> result){
        for (KidsToy kidsToy : selection) {
            if(kidsToy.getPackingHeight() <= packingHeight && result.contains(kidsToy) == false){
                result.add(kidsToy);
            }
        }
        return result;
    }

    private List<KidsToy> searchByAgeGroup(String ageGroup, List<KidsToy> selection, List<KidsToy> result){
        for (KidsToy kidsToy : selection) {
            if(kidsToy.getAgeGroup().equals(ageGroup) && result.contains(kidsToy) == false){
                result.add(kidsToy);
            }
        }
        return result;
    }
}