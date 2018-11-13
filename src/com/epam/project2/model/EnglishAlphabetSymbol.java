package com.epam.project2.model;

import com.epam.project2.model.Entity.Symbol;

public class EnglishAlphabetSymbol extends Symbol {
    private char [] vawels = {'a', 'e','o','u','i','y','A','E','O','U','I','Y'};

    public EnglishAlphabetSymbol() {
    }

    public EnglishAlphabetSymbol(char symbol) throws Exception {
        isAlphabetSymbol(symbol);
    }

    private void isAlphabetSymbol (char symbol) throws Exception {
        if ((symbol >= 'A') && (symbol <= 'z')){
            super.setSymbol(symbol);
        }else {
            throw new Exception();
        } //todo
    }

    public boolean isVawel (){
       for (char ch : vawels){
           if (super.getSymbol() == ch) return true;
       }
       return false;
    }

    @Override
    public String toString() {
        return String.valueOf(super.getSymbol());
    }
}
