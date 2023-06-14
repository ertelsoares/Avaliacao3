package br.com.wm.beans;

import br.com.av3.modelo.Especialidade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import br.com.av3.modelo.Medico;
import br.com.av3.servico.ServicoMedico;

@Named(value = "medicoBean")
@SessionScoped
public class MedicoBean implements Serializable {
    @EJB(lookup="java:global/Avaliacao3EJB/MedicoDao!br.com.av3.servico.ServicoMedico")
    ServicoMedico servicoMedico;
    
     private Especialidade especialidadeSelecionada;
    
     private Medico medicoSelecionado;

    public MedicoBean() {
        medicoSelecionado = new Medico();
    }

    public Medico getMedicoSelecionado() {
        return medicoSelecionado;
    }

    public void setMedicoSelecionado(Medico medicoSelecionado) {
        this.medicoSelecionado = medicoSelecionado;
    }

    public Especialidade getEspecialidadeSelecionada() {
        return especialidadeSelecionada;
    }

    public void setEspecialidadeSelecionada(Especialidade especialidadeSelecionada) {
        this.especialidadeSelecionada = especialidadeSelecionada;
    }
     
   
     public List<Medico> getMedicosEspecialidade() {
        if(especialidadeSelecionada == null){
          return new LinkedList<>();   
        }else{
           return servicoMedico.listarMedicosPorEspecilidade(especialidadeSelecionada);
        }
        
    }
    
    public List<SelectItem> getMedicosEspeAsItems() {
        LinkedList<SelectItem> items = new LinkedList<>();
  
          for (Medico me : getMedicosEspecialidade()) {
            items.add(new SelectItem(me, me.getNome()));
          }
       
        return items;
    }
    
}
