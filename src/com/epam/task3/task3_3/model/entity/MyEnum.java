package com.epam.task3.task3_3.model.entity;

import java.io.*;

/**
 *
 *
 * @see java.lang.Comparable
 * @see java.io.Serializable
 * @see java.lang.Enum
 */

public abstract class MyEnum<E extends MyEnum<E>> implements Comparable<E>, Serializable{
    private final String name;
    private static int nextOrdinal = 0;
    private final int ordinal;

    public MyEnum(String name) {
        this.name = name;
        this.ordinal = nextOrdinal++;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public int getOrdinal() {
        return ordinal;
    }

    @Override
    public int compareTo(E other) {
        return this.getOrdinal() - other.getOrdinal();
    }

    @Override
    public String toString() {
        return name.toUpperCase();
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
