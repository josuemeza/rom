package cl.josuemeza.rom.model;

public interface Fighter {

    Integer attack(Fighter enemy);
    Integer defend(Integer damage);

}
