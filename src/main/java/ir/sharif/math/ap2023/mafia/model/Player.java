package ir.sharif.math.ap2023.mafia.model;

public abstract class Player {
    protected int id;
    protected String name;
    protected boolean alive = true;
    protected boolean mute;
    protected boolean heal;
    private int voteCount;
    private int mafiaVoteCount;
    private boolean markedByGodfather;
    private boolean markedBySniper;
    private boolean markedByLecter;

    public Player(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public abstract String action(Player target);

    public void vote(Player target) {
        target.vote();
    }    

    public void reset() {
        mute = false;
        heal = false;
        voteCount = 0;
        mafiaVoteCount = 0;
        markedByGodfather = false;
        markedByLecter = false;
        markedBySniper = false;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void terminate() {
        alive = false;
    }

    public boolean isMute() {
        return this.mute;
    }

    public void mute() {
        mute = true;
    }

    public boolean isHeal() {
        return this.heal;
    }

    public void heal() {
        heal = true;
    }

    public void vote() {
        voteCount++;
    }

    public int getVote() {
        return voteCount;
    }

    public int getMafiaVoteCount() {
        return mafiaVoteCount;
    }

    public void mafiaVote() {
        mafiaVoteCount++;
    }

    public boolean isMarkedByGodfather() {
        return markedByGodfather;
    }

    public void markedByGodfather() {
        markedByGodfather = true;
    }

    public boolean isMarkedBySnipper() {
        return markedBySniper;
    }

    public void markedBySniper() {
        markedBySniper = true;
    }

    public boolean isMarkedByLecter() {
        return markedByLecter;
    }

    public void markedByLecter() {
        markedByLecter = true;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    public void setHeal(boolean heal) {
        this.heal = heal;
    }

    public int getVoteCount() {
        return this.voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public void setMafiaVoteCount(int mafiaVoteCount) {
        this.mafiaVoteCount = mafiaVoteCount;
    }

    public boolean getMarkedByGodfather() {
        return this.markedByGodfather;
    }

    public void setMarkedByGodfather(boolean markedByGodfather) {
        this.markedByGodfather = markedByGodfather;
    }

    public boolean isMarkedBySniper() {
        return this.markedBySniper;
    }

    public void setMarkedBySniper(boolean markedBySniper) {
        this.markedBySniper = markedBySniper;
    }

    public void setMarkedByLecter(boolean markedByLecter) {
        this.markedByLecter = markedByLecter;
    }

    
}