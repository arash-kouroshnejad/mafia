package ir.sharif.math.ap2023.mafia.model;


public class Detective extends Citizen{

   public Detective(String name, int id) {
      super(name, id);
   }

   public String action (Player target) {
      if (target instanceof GodFather) {
         if(((GodFather)((Mafia)target)).isAsked()) {
            return "MAFIA";
         }
         else {
            ((GodFather)((Mafia)target)).Asked();
            return "NO_MAFIA";
         }
      }
      else if (target instanceof Mafia) {
         return "MAFIA";
      }
      else {
         return "NO_MAFIA";
      }
   }
}