package ar.com.cuvl.utn.manager;

import ar.com.cuvl.utn.entity.Armor;
import ar.com.cuvl.utn.enums.Attack;
import ar.com.cuvl.utn.exception.ArmorException;
import ar.com.cuvl.utn.factory.Factory;
import ar.com.cuvl.utn.mapper.Mapper;
import ar.com.cuvl.utn.validator.ValidatorArmor;

import java.util.ArrayList;
import java.util.List;

public class ManagerArmor {


    private List<Armor> armorList;

    Mapper mapper = new Mapper();
    Factory factory = new Factory();


    public ManagerArmor () {}

    // GETTERS Y ADD DE LAS LISTAS

    public int getArmorSize () {
        if (armorList == null){
            armorList = new ArrayList<>();
        }
        return armorList.size();
    }
    public Armor getArmor(int index) {
        if (index < 0 || index >= armorList.size()){
            return null;
        }
        return armorList.get(index);
    }

    public List<Armor> getArmorList () {
        if (armorList == null){
            armorList = new ArrayList<>();
        }

        return armorList;
    }

    public void addArmorList(Armor armor) {
        if (armorList == null){
            armorList = new ArrayList<>();
        }
        armorList.add(armor);
    }

    public boolean removeArmor (int index) {
        if (index <0 || index >= armorList.size()){
            return false;
        }
        armorList.remove(index);
        return true;
    }

    public int searchNamePos (Object name) {
        int pos = -1;
        int i=0;
        String encontrado = String.valueOf(name);
        for (Armor elemen : getArmorList()){
            if (encontrado.equals(elemen.getName())){
                pos = i;
            }
            i++;
        }
        return pos;
    }

    //////////////////////////////////////////////////////////////////////////////

    public Armor armor = factory.createArmor("GRUESA", 11, Attack.PERFORANTE, 2);
    public Armor armor1 = factory.createArmor("MEDIAGRUESA", 8, Attack.CORTANTE, 4);
    public Armor armor2 = factory.createArmor("MASGRUESA", 15, Attack.APLASTANTE, 3);
    public Armor armor3 = factory.createArmor("SUPERGRUESA", 20, Attack.MAGICO, 1);

    public void createArmor () {
        ValidatorArmor validatorArmor = new ValidatorArmor();

        try{
            validatorArmor.validArmor(armor);
        } catch (ArmorException a) {
            mapper.addException(a.getMessage());
        } finally {
            addArmorList(armor);
        }

        try{
            validatorArmor.validArmor(armor1);
        } catch (ArmorException a) {
            mapper.addException(a.getMessage());
        } finally {
            addArmorList(armor1);
        }

        try{
            validatorArmor.validArmor(armor2);
        } catch (ArmorException a) {
            mapper.addException(a.getMessage());
        } finally {
            addArmorList(armor2);
        }

        try{
            validatorArmor.validArmor(armor3);
        } catch (ArmorException a) {
            mapper.addException(a.getMessage());
        } finally {
            addArmorList(armor3);
        }

    }

    public void printArmor () {
        for (Armor a : getArmorList()){
            System.out.println(a.getName());
            System.out.println(a.getAtaque());
            System.out.println(a.getCantDanio());
            System.out.println(a.getDispRestriction());
            System.out.println("////////////////////////////////////////");
        }
    }

    public void printNamesArmor () {
        for (Armor a : getArmorList()){
            System.out.println(a.getName());
            System.out.println("////////////////////////////////////////");
        }
    }


}
