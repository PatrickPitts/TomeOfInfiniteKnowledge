package org.nerdcore.tomeofinfiniteknowledge;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SimpleCharClass implements CharacterBean{
    private final StringProperty characterClass = new SimpleStringProperty();
    private final StringProperty characterRace = new SimpleStringProperty();

    public final String getCharacterClass(){
        return this.characterClass.get();
    }

    public final String getCharacterRace(){
        return this.characterRace.get();
    }

    public void setCharacterClass(String characterClass){
        this.characterClass.setValue(characterClass);
    }

    public void setCharacterRace(String characterRace){
        this.characterRace.setValue(characterRace);
    }

    public StringProperty characterClassProperty() {
        return characterClass;
    }

    public StringProperty characterRaceProperty() {
        return characterRace;
    }
}
