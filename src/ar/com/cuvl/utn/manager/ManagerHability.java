package ar.com.cuvl.utn.manager;

import ar.com.cuvl.utn.entity.Hability;
import ar.com.cuvl.utn.exception.HabilityException;
import ar.com.cuvl.utn.factory.Factory;
import ar.com.cuvl.utn.mapper.Mapper;
import ar.com.cuvl.utn.validator.ValidatorHability;

import java.util.ArrayList;
import java.util.List;

public class ManagerHability {


    private List<Hability> habilityList;
    Factory factory = new Factory();
    Mapper mapper = new Mapper();

    public ManagerHability () {}

    // GETTERS Y ADD DE LAS LISTAS

    public int getHabilitySize () {
        if (habilityList == null){
            habilityList = new ArrayList<>();
        }
        return habilityList.size();
    }
    public Hability getHability (int index) {
        if (index < 0 || index >= habilityList.size()){
            return null;
        }
        return habilityList.get(index);
    }

    public List<Hability> getHabilityList () {
        if (habilityList == null){
            habilityList = new ArrayList<>();
        }
        return habilityList;
    }

    public void addHabilityList(Hability hability) {
        if (habilityList == null){
            habilityList = new ArrayList<>();
        }
        habilityList.add(hability);
    }

    public boolean removeHability (int index) {
        if (index <0 || index >= habilityList.size()){
            return false;
        }
        habilityList.remove(index);
        return true;
    }

    public int searchHabilityPos (Object name) {
        int pos = -1;
        int i=0;
        String encontrado = String.valueOf(name);
        for (Hability elemen : getHabilityList()){
            if (encontrado.equals(elemen.getName())){
                pos = i;
            }
            i++;
        }
        return pos;
    }

    //////////////////////////////////////////////////////////////////////////////

    public Hability hability = factory.createHability("YAGO",6,4,"ATAQUE");
    public Hability hability1 = factory.createHability("PIGNATTA",3,2,"ATAQUE");
    public Hability hability2 = factory.createHability("FANELLI",2,1,"DEFENSA");
    public Hability hability3 = factory.createHability("BARBIERI",5,3,"ATAQUE");
    public Hability hability4 = factory.createHability("MONTI",7,4,"DEFENSA");
    public Hability hability5 = factory.createHability("CANABARRO",4,2,"ATAQUE");
    public Hability hability6 = factory.createHability("AMADO",4,1,"DEFENSA");
    public Hability hability7 = factory.createHability("MARIAN",3,2,"DEFENSA");
    public Hability hability8 = factory.createHability("RAMASCO",3,1,"DEFENSA");
    public Hability hability9 = factory.createHability("ARAUJO",2,1,"DEFENSA");
    public Hability hability10 = factory.createHability("FORCINITO",3,1,"ATAQUE");

    public void createHability () {
        ValidatorHability validatorHability = new ValidatorHability();

        try {
            validatorHability.validHability(hability);
        } catch (HabilityException a){
            mapper.addException(a.getMessage());
        } finally {
            addHabilityList(hability);
        }

        try {
            validatorHability.validHability(hability1);
        } catch (HabilityException a){
            mapper.addException(a.getMessage());
        } finally {
            addHabilityList(hability1);
        }

        try {
            validatorHability.validHability(hability2);
        } catch (HabilityException a){
            mapper.addException(a.getMessage());
        } finally {
            addHabilityList(hability2);
        }

        try {
            validatorHability.validHability(hability3);
        } catch (HabilityException a){
            mapper.addException(a.getMessage());
        } finally {
            addHabilityList(hability3);
        }

        try {
            validatorHability.validHability(hability4);
        } catch (HabilityException a){
            mapper.addException(a.getMessage());
        } finally {
            addHabilityList(hability4);
        }

        try {
            validatorHability.validHability(hability5);
        } catch (HabilityException a){
            mapper.addException(a.getMessage());
        } finally {
            addHabilityList(hability5);
        }

        try {
            validatorHability.validHability(hability6);
        } catch (HabilityException a){
            mapper.addException(a.getMessage());
        } finally {
            addHabilityList(hability6);
        }

        try {
            validatorHability.validHability(hability7);
        } catch (HabilityException a){
            mapper.addException(a.getMessage());
        } finally {
            addHabilityList(hability7);
        }

        try {
            validatorHability.validHability(hability8);
        } catch (HabilityException a){
            mapper.addException(a.getMessage());
        } finally {
            addHabilityList(hability8);
        }

        try {
            validatorHability.validHability(hability9);
        } catch (HabilityException a){
            mapper.addException(a.getMessage());
        } finally {
            addHabilityList(hability9);
        }

        try {
            validatorHability.validHability(hability10);
        } catch (HabilityException a){
            mapper.addException(a.getMessage());
        } finally {
            addHabilityList(hability10);
        }
    }

    public void printHability () {
        for (Hability a : getHabilityList()){
            System.out.println(a.getName());
            System.out.println(a.getType());
            System.out.println(a.getLevelRequired());
            System.out.println(a.getPointsLevels());
            System.out.println("////////////////////////////////////////");
        }
    }

    public Hability searchHability(String nameHability) {
        Hability habilitySearch = new Hability();
        boolean found = false;

        for (int i=0; i<getHabilitySize() && !found; ++i){
            habilitySearch = getHability(i);
            if (habilitySearch.getName().equals(nameHability)){
                found = true;
            }
        }
        return habilitySearch;
    }
}
