package ir.sharif.math.ap2023.mafia.model;

public class Natasha extends Mafia {
    public Natasha(String name, int id) {
        super(name, id);
    }
    
    public String action(Player target) {
        target.mute();
        return "";
    }

}