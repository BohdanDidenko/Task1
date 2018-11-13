package com.epam.project2.model;

public class Word{
    private EnglishAlphabetSymbol[] letters;
    private int countVowels;

    public Word() {
    }

    public Word(EnglishAlphabetSymbol[] letters) {
        this.letters = letters;
        doCountVawels();
    }

    public EnglishAlphabetSymbol[] getLetters() {
        return letters;
    }

    public int getCountVowel() {
        return countVowels;
    }

    public int doCountVawels (){
        this.countVowels = 0;
        for (EnglishAlphabetSymbol ch: letters){
            if (ch.isVawel()) this.countVowels++;
        }
        return this.countVowels;
    }

    public int getCountAllSumbols() {
        int countAllSumbols = letters.length;
        return countAllSumbols;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Word)) return true;
      Word word = (Word) o;
      if (!(this.letters.length == word.getLetters().length)) return false;
      for (int i = 0; i < word.getLetters().length; i++ ){
          if (this.letters[i] != word.getLetters()[i]) return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        long temp;
        for (EnglishAlphabetSymbol ch: this.letters){
            result += ch.hashCode();
        }
        result = 31 * result + countVowels;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (EnglishAlphabetSymbol ch: letters){
            sb.append(ch);
        }
        return sb.toString();
    }
}