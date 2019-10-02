/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage;

import fit5042.heritage.repository.entities.Architecturalstyle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adnan
 */
@Stateless
public class ArchitecturalstyleFacade extends AbstractFacade<Architecturalstyle> {

    @PersistenceContext(unitName = "WebSecuredAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArchitecturalstyleFacade() {
        super(Architecturalstyle.class);
    }
    
}
