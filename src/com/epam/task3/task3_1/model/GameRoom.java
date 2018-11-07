package com.epam.task3.task3_1.model;

import com.epam.task3.task3_1.model.entity.KidsToy;

import java.util.ArrayList;
import java.util.List;

public class GameRoom<T extends KidsToy> {
    private List<T> kidsToys;

    public GameRoom(ArrayList<T> kidsToys) {
        this.kidsToys = kidsToys;
    }

    public List<T> getKidsToys() { return kidsToys; }

    public void setKidsToys(ArrayList<T> kidsToys) {
        this.kidsToys = kidsToys;
    }
}