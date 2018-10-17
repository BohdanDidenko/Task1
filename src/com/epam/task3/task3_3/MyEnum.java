package com.epam.task3.task3_3;

import java.io.*;

/**
 *
 *
 * @see java.lang.Comparable
 * @see java.io.Serializable
 * @see java.lang.Enum
 */

public class MyEnum<E extends MyEnum<E>> implements Comparable<E>, Serializable{
    private final String name;

    private final int ordinal;

    public MyEnum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

    public String getName() {
        return name;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public <T extends Enum<T>> T valueOf(Class<T> enumType, String name) {

        //todo

//        T result = enumType.enumConstantDirectory().get(name);
//        if (result != null)
//            return result;
//        if (name == null)
//            throw new NullPointerException("Name is null");
//        throw new IllegalArgumentException(
//                "No enum constant " + enumType.getCanonicalName() + "." + name);
        return null;
    }

    @Override
    public int compareTo(E other) {
        return this.getOrdinal() - other.getOrdinal();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyEnum)) return false;

        MyEnum myEnum = (MyEnum) o;

        if (getOrdinal() != myEnum.getOrdinal()) return false;
        return getName() != null ? getName().equals(myEnum.getName()) : myEnum.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getOrdinal();
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw  new CloneNotSupportedException();
    }




    /**
     * prevent default deserialization
     */
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        throw new InvalidObjectException("can't deserialize MyEnum");
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("can't deserialize MyEnum");
    }
}
