package ir.sharif.math.ap2023.mafia.model;

public class Doctor extends Citizen {
    private int numberOfSelfSave = 2;
    public Doctor(String name, int id) {
        super(name, id);
    }

    public String action(Player target) {
        if (target.equals(this)) {
            if (numberOfSelfSave == 0) {
                return "NO_SAVE"; 
            }
            else {
                numberOfSelfSave--;
                target.heal();
                return "";
            }
        }
        target.heal();
        return "";
    }

    public int getNumberOfSelfSave() {
        return this.numberOfSelfSave;
    }

    public void setNumberOfSelfSave(int numberOfSelfSave) {
        this.numberOfSelfSave = numberOfSelfSave;
    }


    
}