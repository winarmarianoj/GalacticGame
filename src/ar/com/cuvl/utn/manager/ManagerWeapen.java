package ar.com.cuvl.utn.manager;

import ar.com.cuvl.utn.entity.Weapen;
import ar.com.cuvl.utn.enums.Attack;
import ar.com.cuvl.utn.exception.WeapenException;
import ar.com.cuvl.utn.factory.Factory;
import ar.com.cuvl.utn.mapper.Mapper;
import ar.com.cuvl.utn.validator.ValidatorWeapen;

import java.util.ArrayList;
import java.util.List;

public class ManagerWeapen {


    private List<Weapen> weapenList;
    Factory factory = new Factory();
    Mapper mapper = new Mapper();

    public ManagerWeapen () {}

    // GETTERS Y ADD DE LAS LISTAS

    public int getWeapenSize () {
        if (weapenList == null){
            weapenList = new ArrayList<>();
        }
        return weapenList.size();
    }
    public Weapen getWeapen(int index) {
        if (index < 0 || index >= weapenList.size()){
            return null;
        }
        return weapenList.get(index);
    }

    public List<Weapen> getWeapenList () {
        if (weapenList == null){
            weapenList = new ArrayList<>();
        }

        return weapenList;
    }

    public void addWeapenList(Weapen weapen) {
        if (weapenList == null){
            weapenList = new ArrayList<>();
        }
        weapenList.add(weapen);
    }

    public boolean removeWeapen (int index) {
        if (index <0 || index >= weapenList.size()){
            return false;
        }
        weapenList.remove(index);
        return true;
    }

    public int searchWeapenPos (Object name) {
        int pos = -1;
        int i=0;
        String encontrado = String.valueOf(name);
        for (Weapen elemen : getWeapenList()){
            if (encontrado.equals(elemen.getName())){
                pos = i;
            }
            i++;
        }
        return pos;
    }

    //////////////////////////////////////////////////////////////////////////////

    public Weapen weapen = factory.createWeapen("UNO", 12, Attack.PERFORANTE);
    public Weapen weapen1 = factory.createWeapen("DOS", 7,Attack.CORTANTE);
    public Weapen weapen2 = factory.createWeapen("TRES",10,Attack.APLASTANTE);
    public Weapen weapen3 = factory.createWeapen("CUATRO",20,Attack.MAGICO);

    public void createWeapen () {
        ValidatorWeapen validatorWeapen = new ValidatorWeapen();

        try{
            validatorWeapen.validatorWeapen(weapen);
        } catch (WeapenException a) {
            mapper.addException(a.getMessage());
        } finally {
            addWeapenList(weapen);
        }

        try{
            validatorWeapen.validatorWeapen(weapen1);
        } catch (WeapenException a) {
            mapper.addException(a.getMessage());
        } finally {
            addWeapenList(weapen1);
        }

        try{
            validatorWeapen.validatorWeapen(weapen2);
        } catch (WeapenException a) {
            mapper.addException(a.getMessage());
        } finally {
            addWeapenList(weapen2);
        }

        try{
            validatorWeapen.validatorWeapen(weapen3);
        } catch (WeapenException a) {
            mapper.addException(a.getMessage());
        } finally {
            addWeapenList(weapen3);
        }

    }

    public void printWeapen () {
        for (Weapen a : getWeapenList()){
            System.out.println(a.getName());
            System.out.println(a.getAtaque());
            System.out.println(a.getCantDanio());
            System.out.println("////////////////////////////////////////");
        }
    }


}
