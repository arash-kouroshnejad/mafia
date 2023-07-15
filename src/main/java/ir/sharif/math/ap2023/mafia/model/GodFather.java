package ir.sharif.math.ap2023.mafia.model;

public class GodFather extends Mafia{
    private boolean asked;
    public GodFather(String name, int id) {
        super(name, id);
    }

    public String action (Player target) {
        // kill target
        target.markedByGodfather();
        return "";
    }

    public boolean isAsked() {
        return this.asked;
    }

    public void Asked() {
        asked = true;
    }


    public boolean getAsked() {
        return this.asked;
    }

    public void setAsked(boolean asked) {
        this.asked = asked;
    }


}