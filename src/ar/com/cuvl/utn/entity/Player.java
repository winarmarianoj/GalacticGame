package ar.com.cuvl.utn.entity;

import ar.com.cuvl.utn.enums.Capacity;
import com.sun.jdi.ArrayReference;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int ID;
    private String name;
    private String typeWarrior;
    private Hability hability;
    private Weapen weapon;
    private Armor armor;
    private Capacity capacity;
    private int level;
    private int experience;
    private int displacement;
    private int energy;
    private List<Inventary> inventaryList;

    public Player () {}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeWarrior() {
        return typeWarrior;
    }

    public void setTypeWarrior(String typeWarrior) {
        this.typeWarrior = typeWarrior;
    }

    public Hability getHability() {
        return hability;
    }

    public void setHability(Hability hability) {
        this.hability = hability;
    }

    public Weapen getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapen weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getInventarySize () {
        if (inventaryList == null){
            inventaryList = new ArrayList<>();
        }
        return inventaryList.size();
    }

    public Inventary getInventary (int index) {
        if (index < 0 || index >= inventaryList.size()){
            return null;
        }
        return inventaryList.get(index);
    }

    public List<Inventary> getInventaryList () {
        if (inventaryList == null){
            inventaryList = new ArrayList<>();
        }
        return inventaryList;
    }

    public void addInventaryList (Inventary inventary){
        if (inventaryList == null){
            inventaryList = new ArrayList<>();
        }
        inventaryList.add(inventary);
    }

    public boolean removeInventary (int index) {
        if (index < 0 || index >= inventaryList.size()){
            return false;
        }
        inventaryList.remove(index);
        return true;
    }
}
