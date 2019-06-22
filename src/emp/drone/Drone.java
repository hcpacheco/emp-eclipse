package emp.drone;
import java.util.List;

import  emp.persistencia.Pessoa;
		
public class Drone {
    private int notificacao;
    private double posx;
    private double posy;
    private String status;
    private boolean disponivel;
    private List<Pessoa> detectados;
    
    public List<Pessoa> statusPatrulha(){
		return detectados;

    }

    
    public boolean checarPatrulha() {
		return disponivel;

    }
    

    
}

