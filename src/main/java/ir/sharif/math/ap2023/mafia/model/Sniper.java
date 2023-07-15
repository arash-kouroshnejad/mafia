package ir.sharif.math.ap2023.mafia.model;

public class Sniper extends Citizen {
    private int numberOfBulletsLeft = 2;
    public Sniper(String name, int id) {
        super(name, id);
    }

    public String action(Player target) {
        if (numberOfBulletsLeft == 0) {
            return "NO_BULLETS";
        }
        else {
            // kill player
            target.markedBySniper();
            numberOfBulletsLeft--;
            return "";
        }
    }

    public int getNumberOfBulletsLeft() {
        return this.numberOfBulletsLeft;
    }

    public void setNmberOfBulletsLeft(int nmberOfBulletsLeft) {
        this.numberOfBulletsLeft = nmberOfBulletsLeft;
    }

}