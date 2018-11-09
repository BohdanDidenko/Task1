package com.epam.task3.task3_2.service;

import com.epam.task3.task3_2.model.Store;
import java.util.*;

public class StoreService {
    public boolean isExistDepartment(Store model, String departmentName){
        for (Store.Department department : model.getListDepartments()) {
            if(department.getDepartmentName().equals(departmentName)) return true;
        }
        return false;
    }

    public <E>void sortByDepartmentName(Store model, List<E> list) {
        redistributionDepartment(model, (o1, o2) ->
                o1.getDepartmentName().compareTo(o2.getDepartmentName()));
    }

    public <E>void sortByTypeOfProducts(Store model, List<E> list){
        redistributionDepartment(model, (o1,o2)
                -> o1.getTypeOfProducts().compareTo(o2.getTypeOfProducts()));
    }

    public <E>void sortByService(Store model, List<E> list){
        redistributionDepartment(model, (o1, o2)
                -> o1.getService().compareTo(o2.getService()));
    }

    public Store.Department creatDepartment(Store model, String departmentName, String typeOfProducts,
                                            String service, String location){
        return model.creatDepartment(departmentName, typeOfProducts, service, location);
    }

    public void deleteDepartmentByName(Store model, String departmentNameForDelete){
        model.deleteDepartmentByName(departmentNameForDelete);
    }

    private void redistributionDepartment(Store model, Comparator<Store.Department> comparator){
        Collections.sort(model.getListDepartments(), comparator);
    }

    public void deliveryProducts(Store model, String departmentName, String ... products){
        if(departmentName == null && products.length == 0) return;

        for (Store.Department department : model.getListDepartments()) {
            if(department.getDepartmentName().equals(departmentName))
                department.setListOfProducts(products);
        }
    }
}
