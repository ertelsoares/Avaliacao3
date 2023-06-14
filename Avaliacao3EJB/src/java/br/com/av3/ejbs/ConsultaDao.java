
package br.com.av3.ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.av3.modelo.Consulta;
import br.com.av3.servico.ServicoConsulta;

@Stateless
public class ConsultaDao implements ServicoConsulta {
     @PersistenceContext
     EntityManager em;

    @Override
    public void marcarConsulta(Consulta c) {
        em.persist(c);
    }

    @Override
    public void cancelarConsulta(Consulta c) {
        em.remove(c); 
    }

    @Override
    public Consulta buscar(int id) {
        return em.find(Consulta.class, id);
    }
     
     
}
