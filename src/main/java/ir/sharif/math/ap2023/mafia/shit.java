package ir.sharif.math.ap2023.mafia;


import ir.sharif.math.ap2023.mafia.logic.*;
import ir.sharif.math.ap2023.mafia.model.*;
import java.util.*;

public class shit {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("doctor", 1);
        Detective detective = new Detective("detective", 2);
        GodFather godFather = new GodFather("father", 3);
        OrdinaryCitizen citizen = new OrdinaryCitizen("citizen", 4);
        DoctorLecter doctorLecter =new DoctorLecter("doctorLecter",5);
        Sniper sniper =new Sniper("sniper",6);
        OrdinaryMafia ordinaryMafia =new OrdinaryMafia("ordinaryMafia",7);
        Natasha natasha =new Natasha("natasha",8);
        Joker joker =new Joker("joker",9);
        List<Player> players = new ArrayList<>();
        players.add(doctor);
        players.add(godFather);
        players.add(detective);
        players.add(citizen);
        players.add(doctorLecter);
        players.add(sniper);
        players.add(ordinaryMafia);
        players.add(natasha);
        players.add(joker);
       
        GameState gameState = new GameState(players);
       
        gameState.nextNight();
        System.out.println(detective.action(godFather)); // NO_MAFIA
        doctor.action(doctor);
        godFather.action(doctor);
        natasha.action(doctor);
        sniper.action(natasha);
        doctorLecter.action(natasha);
        gameState.nextDay();
      //  godFather.setAlive(false);
        System.out.println(gameState.getAlivePlayers().size()); // 9
        System.out.println(gameState.getDeadPlayersInLastRound().size()); // 0
        System.out.println(godFather.isAsked()); // true
        System.out.println(doctor.getNumberOfSelfSave()); // 1
        System.out.println(gameState.isDay());//true
        System.out.println(gameState.getWinners().size());//0
        // System.out.println(gameState.silentPlayersInLastRound.getName());//doctor
        System.out.println(gameState.getExecutedPlayer());//null
       
        doctor.vote(natasha);
        detective.vote(natasha);
        sniper.vote(natasha);
        citizen.vote(natasha);
        doctorLecter.vote(detective);
        godFather.vote(doctor);
        natasha.vote(godFather);
        joker.vote(natasha);
        ordinaryMafia.vote(doctor);
        gameState.nextNight();
       
        System.out.println(gameState.getExecutedPlayer().getName()); //natasha
        godFather.action(citizen);
        sniper.action(doctorLecter);
        doctorLecter.action(sniper);
        doctor.action(doctor);
        System.out.println(detective.action(godFather)); // MAFIA
        //citizen natasha doctorLecter sick
        gameState.nextDay();
        System.out.println(gameState.getAlivePlayers().size()); // 6
        System.out.println(gameState.getDeadPlayersInLastRound().size()); // 2
        System.out.println(godFather.isAsked()); // true
        System.out.println(doctor.getNumberOfSelfSave()); // 0
        System.out.println(gameState.isDay());//true
        System.out.println(gameState.getWinners().size());//0
        // System.out.println(gameState.silentPlayersInLastRound);//null
        System.out.println(gameState.getExecutedPlayer());//natasha
        System.out.println(gameState.getRound());//2
        detective.vote(godFather);
        doctor.vote(godFather);
        godFather.vote(detective);
        sniper.vote(detective);
        ordinaryMafia.vote(ordinaryMafia);
        gameState.nextNight();
        System.out.println(gameState.getExecutedPlayer()); //null
        System.out.println(godFather.isAlive()); // true
        System.out.println(gameState.getWinners().size()); // 0
        System.out.println(gameState.getWinners().contains(doctor)); // false
        System.out.println(doctor.action(doctor));//NO_SAVE
        System.out.println(sniper.action(godFather));//NO_BULLETS
        System.out.println(detective.action(ordinaryMafia));//MAFIA
        gameState.nextDay();
        System.out.println(gameState.getAlivePlayers().size()); // 6
        System.out.println(gameState.getDeadPlayersInLastRound().size()); // 0
        System.out.println(doctor.getNumberOfSelfSave()); // 0
        System.out.println(gameState.getWinners().size());//0
        System.out.println(gameState.getExecutedPlayer());//null
        detective.vote(godFather);
        doctor.vote(godFather);
        godFather.vote(godFather);
        sniper.vote(godFather);
        ordinaryMafia.vote(ordinaryMafia);
        joker.vote(godFather);
        //father citizen natasha doctorLecter sniper sick
        gameState.nextNight();
        System.out.println(gameState.getAlivePlayers().size());//5
        System.out.println(gameState.getExecutedPlayer().getName()); //father
        System.out.println(godFather.isAlive()); // false
        ordinaryMafia.vote(sniper);
        doctor.action(sniper);
        System.out.println(detective.action(sniper));//false
        gameState.nextDay();
        System.out.println(gameState.getAlivePlayers().size()); // 5
        System.out.println(gameState.getDeadPlayersInLastRound().size()); // 0
        gameState.nextNight();
        ordinaryMafia.action(sniper);
        gameState.nextDay();
        System.out.println(gameState.getAlivePlayers().size()); // 4
        System.out.println(gameState.getDeadPlayersInLastRound().size()); // 1
        detective.vote(ordinaryMafia);
        joker.vote(ordinaryMafia);
        ordinaryMafia.vote(ordinaryMafia);
        gameState.nextNight();
        System.out.println(gameState.getWinners().size());//4
        }
}