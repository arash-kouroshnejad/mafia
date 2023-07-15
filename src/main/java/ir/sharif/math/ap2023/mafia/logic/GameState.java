package ir.sharif.math.ap2023.mafia.logic;

import ir.sharif.math.ap2023.mafia.model.*;

import java.util.*;

public class GameState {

    private final ArrayList<Player> allPlayers = new ArrayList<>();
    private final ArrayList<Player> deadPlayersInLastRound = new ArrayList<>();
    private final ArrayList<Player> alive = new ArrayList<>();
    private int roundCount;
    private boolean isDay = true;
    private Player silentPlayer;
    private ArrayList<Player> winners = new ArrayList<>();
    private Player executed;
    private boolean GodFatherDead;

    public GameState(List<Player> players) {
        alive.addAll(players);
        allPlayers.addAll(players);
    }

    public List<Player> allPlayers() {
        return allPlayers;
    }

    private void jokerWon(Player joker) {
        winners.add(joker);
    }

    public void nextDay() {
        deadPlayersInLastRound.clear(); // here or there ??? 
        silentPlayer = null; // here or there ? 
        roundCount++; // ????? here or in nextDay and the default value ?
        isDay = true;
        Player markedByGodfather = null;
        Player markedBySniper = null;
        Player voted = null;
        int maxVote = 0;
        for (Player player : alive) {
            markedByGodfather = (player.isMarkedByGodfather()) ? player : markedByGodfather;
            markedBySniper = (player.isMarkedBySnipper()) ? player : markedBySniper;
            voted = (player.getMafiaVoteCount() > maxVote) ? player : voted;
            if (voted != null)
                maxVote = voted.getMafiaVoteCount();
            silentPlayer = (player.isMute()) ? player : silentPlayer;
        }
        if (markedByGodfather != null) {
            if (!markedByGodfather.isHeal()) {
                terminate(markedByGodfather);
                deadPlayersInLastRound.add(markedByGodfather);
            }
        }
        if (markedBySniper != null) {
            if (!markedBySniper.isMarkedByLecter()) {
                terminate(markedBySniper);
                deadPlayersInLastRound.add(markedBySniper);
            }
        }
        if (GodFatherDead) {
            if (voted != null) {
                if (!voted.isHeal()) {
                    terminate(voted);
                    deadPlayersInLastRound.add(voted);
                }
            }
        }
        checkState();
    }

    public void nextNight() {
        executed = null;
        isDay = false;
        int countOfAlive = alive.size();
        Player toBeExecuted = null;
        for (Player player : alive) {
            if (player.getVote() > countOfAlive / 2) {
                toBeExecuted = player;
            }
        }
        if (toBeExecuted != null) {
            terminate(toBeExecuted);
            executed = toBeExecuted;
            if (toBeExecuted instanceof Joker) {
                jokerWon(toBeExecuted);
                return;
            }
        }
        checkState();
        for (Player player : allPlayers) {
            player.reset();
        }
    }

    public void checkState() {
        int mafiaCount = 0;
        int citizenCount = 0;
        int jokerCount = 0;
        for (Player player : alive) {
            if (player instanceof Mafia) {
                mafiaCount++;
            } else if (player instanceof Citizen) {
                citizenCount++;
            } else if (player instanceof Joker) {
                jokerCount++;
            }
        }
        if (mafiaCount == 0) {
            citizensWon();
        } else if (citizenCount + jokerCount <= mafiaCount) {
            mafiasWon();
        }
    }

    public void citizensWon() {
        for (Player player : allPlayers) {
            if (player instanceof Citizen) {
                winners.add(player);
            }
        }
    }

    public void mafiasWon() {
        for (Player player : allPlayers) {
            if (player instanceof Mafia) {
                winners.add(player);
            }
        }
    }

    public int getRound() {
        return roundCount;
    }

    public List<Player> getAlivePlayers() {
        return alive;
    }

    public boolean isDay() {
        return isDay;
    }

    public List<Player> getDeadPlayersInLastRound() {
        return deadPlayersInLastRound;
    }

    public Player getSilentPlayerInLastRound() {
        return silentPlayer;
    }

    public List<Player> getWinners() {
        if (winners.size() == 0)
            return new ArrayList<>();
        return winners;
    }

    public Player getExecutedPlayer() {
        return executed;
    }

    public void terminate(Player player) {
        player.terminate();
        if (player instanceof GodFather) {
            GodFatherDead = true;
        }
        alive.remove(player);
    }

    public ArrayList<Player> getAllPlayers() {
        return this.allPlayers;
    }

    public ArrayList<Player> getDeadInLastRound() {
        return this.deadPlayersInLastRound;
    }

    public int getRoundCount() {
        return this.roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public boolean isIsDay() {
        return this.isDay;
    }

    public void setIsDay(boolean isDay) {
        this.isDay = isDay;
    }

    public void setWinners(ArrayList<Player> winners) {
        this.winners = winners;
    }

}