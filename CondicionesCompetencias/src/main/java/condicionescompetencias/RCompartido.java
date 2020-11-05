package condicionescompetencias;
import java.util.ArrayList;

public class RCompartido {
    private String rc;
    private Cerradura c;
    RCompartido(){
        rc="";
        c= new Cerradura();
    }
    public void bloquear_VC(){
        c.setCerradura(true);
    }
    public void desbloquear_VC(){
        c.setCerradura(false);
    }
    public String getrc_VC() {
        return rc;
    }
    public boolean isEntra_VC(){
        if(c.isCerradura() == false)
            return true;
        return false;
    }
    public void setrc_VC(String rc) {
        this.rc = rc;
    }
}
