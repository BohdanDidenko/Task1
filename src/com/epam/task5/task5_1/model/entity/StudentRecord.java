package com.epam.task5.task5_1.model.entity;

public class StudentRecord {
    private String studentName;
    private String studentSecondName;
    private String dateOfBirth;
    private String phoneNumber;
    private String homeAddress;

    public StudentRecord() {
    }

    public StudentRecord(String studentName, String studentSecondName,
                         String dateOfBirth, String phoneNumber, String homeAddress) {
        this.studentName = studentName;
        this.studentSecondName = studentSecondName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSecondName() {
        return studentSecondName;
    }

    public void setStudentSecondName(String studentSecondName) {
        this.studentSecondName = studentSecondName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentRecord)) return false;

        StudentRecord that = (StudentRecord) o;

        if (getStudentName() != null ? !getStudentName().equals(that.getStudentName()) : that.getStudentName() != null)
            return false;
        if (getStudentSecondName() != null ? !getStudentSecondName().equals(that.getStudentSecondName()) : that.getStudentSecondName() != null)
            return false;
        if (getDateOfBirth() != null ? !getDateOfBirth().equals(that.getDateOfBirth()) : that.getDateOfBirth() != null)
            return false;
        if (getPhoneNumber() != null ? !getPhoneNumber().equals(that.getPhoneNumber()) : that.getPhoneNumber() != null)
            return false;
        return getHomeAddress() != null ? getHomeAddress().equals(that.getHomeAddress()) : that.getHomeAddress() == null;
    }

    @Override
    public int hashCode() {
        int result = getStudentName() != null ? getStudentName().hashCode() : 0;
        result = 31 * result + (getStudentSecondName() != null ? getStudentSecondName().hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        result = 31 * result + (getHomeAddress() != null ? getHomeAddress().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + "{" +
                "studentName='" + studentName + '\'' +
                ", studentSecondName='" + studentSecondName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                '}';
    }
}
