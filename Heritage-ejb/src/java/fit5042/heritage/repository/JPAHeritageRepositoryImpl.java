/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.repository;

import fit5042.heritage.repository.entities.Address;
import fit5042.heritage.repository.entities.Heritage;
import fit5042.heritage.repository.entities.HeritageGroup;
import fit5042.heritage.repository.entities.Users;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Adnan
 */

@Stateless
public class JPAHeritageRepositoryImpl implements HeritageRepository{

    @PersistenceContext(unitName = "Heritage-ejbPU")
    private EntityManager entityManager;
        
    @Override
    public void addHeritage(Heritage heritage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Heritage searchHeritageById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Heritage> getAllHeritages() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Address> getAllAddress() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeHeritage(int heritageId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editHeritage(Heritage heritage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Heritage> searchHeritageByCity(String city) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(Users user) throws Exception {
         System.out.println("Before Adding 5"); 
         List<Users> users =  entityManager.createNamedQuery(Users.FIND_ALL_QUERY_NAME).getResultList(); 
         user.setId(users.get(0).getId()+ 1);
         entityManager.persist(user);
    }

    @Override
    public void addHeritageGroup(HeritageGroup heritageGroup) throws Exception {
        entityManager.persist(heritageGroup);
    }

    @Override
    public List<HeritageGroup> getAllHeritageGroups() throws Exception {
        List<HeritageGroup> hr = entityManager.createNamedQuery(HeritageGroup.GET_ALL_QUERY_NAME).getResultList();
        System.out.println("Size of the list: "+hr.size());
        return hr;
    }

    @Override
    public void editHeritageGroup(HeritageGroup heritageGroup) throws Exception {
         try {
            entityManager.merge(heritageGroup);
        } catch (Exception ex) {
            
        }        
    }

    @Override
    public void removeHeritageGroup(int groupId) throws Exception {
        HeritageGroup heritageGroup = entityManager.find(HeritageGroup.class, groupId);
        if(heritageGroup!=null){
            entityManager.remove(heritageGroup);
        }
        
    }
    
}
