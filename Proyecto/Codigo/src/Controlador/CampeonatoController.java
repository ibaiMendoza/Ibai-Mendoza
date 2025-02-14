package Controlador;

import javax.swing.*;

public class CampeonatoController {
    public void generarCampeonato(){
        boolean continuar = false;
        do {
            try{
               JOptionPane.showMessageDialog(null, "cual sera la id del campeonato");

            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error al generar el campeonato");
            }
        }
        while(!continuar);
    }
}
