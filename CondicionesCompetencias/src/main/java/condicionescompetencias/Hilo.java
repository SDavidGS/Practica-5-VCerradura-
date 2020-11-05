
package condicionescompetencias;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

public class Hilo extends Thread {
    private JTextArea area;
    private RCompartido rc;
    private final static int inicio=995;
    private final static int fin=1000;
    private boolean dead=false;
    
    Hilo(JTextArea area,RCompartido rc){
        this.area=area;
        this.rc=rc;
    }
    
    public void run(){
        while(true){
                    try{
                        if(rc.isEntra_VC()){//Verifica si el RC esta siendo utilizado
                            rc.bloquear_VC();//Bloquea el RC
                            if(!isdead()){//Verifica si el hilo esta muerto
                                rc.setrc_VC(this.getName());
                                area.append(rc.getrc_VC()+": Eats\n");
                                rc.desbloquear_VC();//Desbloquea el RC antes de su salida
                            }
                        }
                        else{//Si esta siendo utilizado manda un mensaje de espera
                            if(!isdead())
                                area.append("En espera...\n");
                        }
                        Thread.sleep((int) (inicio+Math.random()*fin));
                    }catch(Exception e){e.printStackTrace();}
        }
    }
    
    public boolean isdead(){
        return dead;
    }
    public void setdead(boolean dead){
        this.dead=dead;
    }
    
}
