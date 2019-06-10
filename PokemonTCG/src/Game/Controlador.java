package game;

import java.util.Scanner;

public class Controlador {
    private Entrenador jugador1;
    private Entrenador jugador2;

    public Controlador(Entrenador j1, Entrenador j2){
        jugador1=j1;
        jugador2=j2;
    }

    public void Turnj1(){
        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("What do you want to do? ('Check Hand', 'Check Pokemon', )";
            String in = s.nextLine();
            if (in.equals("q")){
                break;
            }
            else if ()
        }

    }
}
