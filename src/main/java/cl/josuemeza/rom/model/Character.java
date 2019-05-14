package cl.josuemeza.rom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Character extends BaseModel implements Fighter {

    public static Integer BASE_HEALTH = 100;
    public static Integer BASE_LEVEL = 1;
    public static Integer BASE_ATTACK = 10;
    public static Integer BASE_DEFENSE = 5;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;
    private Integer level = BASE_LEVEL;
    private Integer health = BASE_HEALTH;

    protected Character() {}

    public Character(String name) {
        this.name = name;
    }

    public void heal(Integer healthToRestore) {
        health = Math.min(getMaxHealth(), health + healthToRestore);
    }

    public Long getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getMaxHealth() {
        return BASE_HEALTH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                ", level: " + level +
                '}';
    }

    @Override
    public Integer attack(Fighter enemy) {
        return enemy.defend(BASE_ATTACK);
    }

    @Override
    public Integer defend(Integer attack) {
        Integer damage = Math.max(0, attack - BASE_DEFENSE);
        health = Math.max(0, health - damage);
        return damage;
    }
}
