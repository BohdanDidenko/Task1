package com.epam.task3.task3_2.model;

import java.util.*;

public class Store {
    private String storeName;
    private List<Department> listDepartments = new ArrayList<>();

    public Store() {
    }

    public Store(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Department> getListDepartments() {
        return listDepartments;
    }

    public Department creatDepartment(String departmentName, String typeOfProducts,
                                      String service, String location){
        if(departmentName == null && departmentName.equals("") == false) return null;
        else if(typeOfProducts == null && typeOfProducts.equals("") == false) return null;
        else if(service == null && service.equals("") == false) return null;
        else if(location == null && location.equals("") == false) return null;

        return new Store.Department(departmentName, typeOfProducts, service, location);
    }

    public void deleteDepartmentByName(String departmentNameForDelete){
        if(departmentNameForDelete == null && listDepartments.size() == 0) return;

        Iterator<Department> iterator = listDepartments.iterator();
        while (iterator.hasNext()){
            Department department = iterator.next();
            if(department.departmentName.equals(departmentNameForDelete)) iterator.remove();
        }
    }

    public void redistributionDepartment(Comparator<Department> comparator){
        Collections.sort(listDepartments, comparator);
    }

    public void deliveryProducts(String departmentName, String ... products){
        if(departmentName == null && products.length == 0) return;

        for (Department department : listDepartments) {
            if(department.departmentName.equals(departmentName))
                department.setListOfProducts(products);
        }
    }

    public class Department{
        private String departmentName;
        private String typeOfProducts;
        private String service;
        private String location;
        private List<String> listOfProducts = new ArrayList<>();

        public Department() {
        }

        public Department(String departmentName, String typeOfProducts, String service,
                          String location) {
            this.departmentName = departmentName;
            this.typeOfProducts = typeOfProducts;
            this.service = service;
            this.location = location;
        }

        public void setListOfProducts(String ... products) {
            for (String product : products) {
                listOfProducts.add(product);
            };
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public String getTypeOfProducts() {
            return typeOfProducts;
        }

        public void setTypeOfProducts(String typeOfProducts) {
            this.typeOfProducts = typeOfProducts;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public List<String> getListOfProducts() {
            return listOfProducts;
        }

        public void setListOfProducts(ArrayList<String> listOfProducts) {
            this.listOfProducts = listOfProducts;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "{" +
                    "departmentName='" + departmentName + '\'' +
                    ", typeOfProducts='" + typeOfProducts + '\'' +
                    ", service='" + service + '\'' +
                    ", location='" + location + '\'' +
                    ", listOfProducts=" + listOfProducts +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Department)) return false;

            Department that = (Department) o;

            if (getDepartmentName() != null ? !getDepartmentName().equals(that.getDepartmentName()) : that.getDepartmentName() != null)
                return false;
            if (getTypeOfProducts() != null ? !getTypeOfProducts().equals(that.getTypeOfProducts()) : that.getTypeOfProducts() != null)
                return false;
            if (getService() != null ? !getService().equals(that.getService()) : that.getService() != null)
                return false;
            if (getLocation() != null ? !getLocation().equals(that.getLocation()) : that.getLocation() != null)
                return false;
            return getListOfProducts() != null ? getListOfProducts().equals(that.getListOfProducts()) : that.getListOfProducts() == null;
        }

        @Override
        public int hashCode() {
            int result = getDepartmentName() != null ? getDepartmentName().hashCode() : 0;
            result = 31 * result + (getTypeOfProducts() != null ? getTypeOfProducts().hashCode() : 0);
            result = 31 * result + (getService() != null ? getService().hashCode() : 0);
            result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
            result = 31 * result + (getListOfProducts() != null ? getListOfProducts().hashCode() : 0);
            return result;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "storeName='" + storeName + '\'' +
                ", listDepartments=" + listDepartments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;

        Store store = (Store) o;

        if (getStoreName() != null ? !getStoreName().equals(store.getStoreName()) : store.getStoreName() != null)
            return false;
        return getListDepartments() != null ? getListDepartments().equals(store.getListDepartments()) : store.getListDepartments() == null;
    }

    @Override
    public int hashCode() {
        int result = getStoreName() != null ? getStoreName().hashCode() : 0;
        result = 31 * result + (getListDepartments() != null ? getListDepartments().hashCode() : 0);
        return result;
    }
}
