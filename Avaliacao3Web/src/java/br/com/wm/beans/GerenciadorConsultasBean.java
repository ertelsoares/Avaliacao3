/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package br.com.wm.beans;

import br.com.av3.modelo.Consulta;
import br.com.av3.servico.ServicoConsulta;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;

/**
 *
 * @author aluno
 */
@Named(value = "gerenciadorConsultasBean")
@SessionScoped
public class GerenciadorConsultasBean implements Serializable {
   // colocar lookup certo para gerenciador consulta Bean 
   @EJB(lookup="java:global/Avaliacao3EJB/ConsultaDao!br.com.av3.servico.ServicoConsulta")
    ServicoConsulta servicoConsulta;
    
    @Inject
    MedicoBean medicoBean;
    
     private String nomePaciente;
     private String telefonePaciente;
     private Date dataHora;
     private Consulta consultaagendada;
    public GerenciadorConsultasBean() {
        consultaagendada =  new Consulta();
    }

     public String confirmarConsulta() {
         consultaagendada.setNomePaciente(nomePaciente);
         consultaagendada.setTelefonePaciente(telefonePaciente);
         consultaagendada.setDataHora(dataHora);
         consultaagendada.setIdMedico(medicoBean.getMedicoSelecionado());
         
         servicoConsulta.marcarConsulta(consultaagendada);
         
         getConsultasPormedico();
        return null;
     }
     
     public String cancelarConsulta(Consulta c) {
        servicoConsulta.cancelarConsulta(c);
        return null;
     }
    public MedicoBean getMedicoBean() {
        return medicoBean;
    }

    public void setMedicoBean(MedicoBean medicoBean) {
        this.medicoBean = medicoBean;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getTelefonePaciente() {
        return telefonePaciente;
    }

    public void setTelefonePaciente(String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    
    
    public ServicoConsulta getServicoConsulta() {
        return servicoConsulta;
    }

    public void setServicoConsulta(ServicoConsulta servicoConsulta) {
        this.servicoConsulta = servicoConsulta;
    }

    public Consulta getConsultaagendada() {
        return consultaagendada;
    }

    public void setConsultaagendada(Consulta consultaagendada) {
        this.consultaagendada = consultaagendada;
    }
    
    public List<Consulta> getConsultasPormedico() {
        if(medicoBean.getMedicoSelecionado().getId() == null){
             return servicoConsulta.listarConsultas();
        }else{
           return servicoConsulta.listarconsultasPormedico(medicoBean.getMedicoSelecionado());
        }
    }
    
    public List<Consulta> getConsultasAgendadas() {
             return servicoConsulta.listarConsultas();
        
    }
    
    
    
}
