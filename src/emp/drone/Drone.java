<<<<<<< HEAD

package emp.drone;

public class Drone {
    private int notificacao;
    private double posx;
    private double posy;
    private String status;
    private boolean disponivel;
    private List<Pessoa> detectados;
    
    public List<Pessoa> statusPatrulha(){

    }

    
    public boolean checarPatrulha() {

    }
    

    
}
=======
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

>>>>>>> c37a89cf1ef885e96828aa158535d9b3f996adad
