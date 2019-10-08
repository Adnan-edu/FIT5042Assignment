/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.heritage.repository;

import fit5042.heritage.repository.entities.Address;
import fit5042.heritage.repository.entities.Architecturalstyle;
import fit5042.heritage.repository.entities.Heritage;
import fit5042.heritage.repository.entities.HeritageGroup;
import fit5042.heritage.repository.entities.Users;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
        Architecturalstyle architecturalstyle = heritage.getArchitecturalstyle();
        entityManager.persist(architecturalstyle);
        System.out.println("Inside JPAHeritageRepositoryImpl");
        entityManager.persist(heritage);
    }

    @Override
    public Heritage searchHeritageById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Heritage> getAllHeritages() throws Exception {
        List<Heritage> heritages = entityManager.createNamedQuery(Heritage.GET_ALL_QUERY_NAME).getResultList();
        return heritages;
    }

    @Override
    public List<Address> getAllAddress() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeHeritage(int heritageId) throws Exception {
        Heritage heritage= entityManager.find(Heritage.class, heritageId);
        if(heritage!=null){
            entityManager.remove(heritage);
        }        
    }

    @Override
    public void editHeritage(Heritage heritage) throws Exception {
        entityManager.merge(heritage);
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
        //System.out.println("Size of the list: "+hr.size());
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

    @Override
    public HeritageGroup getHeritageGroupById(int groupId) throws Exception {
        HeritageGroup heritageGroup = entityManager.find(HeritageGroup.class, groupId);
        return heritageGroup;
    }

    @Override
    public List<Architecturalstyle> getAllArchitecturalstyle() throws Exception {
    
        List<Architecturalstyle> architecturalstylesList = entityManager.createNamedQuery(Architecturalstyle.GET_ALL_QUERY_NAME).getResultList();
        return architecturalstylesList;
    }

    @Override
    public List<Heritage> searchHeritageByBoth(int searchHeritageByGrpId, int searchHeriByArchId) throws Exception {
        HeritageGroup heritageGroup = entityManager.find(HeritageGroup.class,searchHeritageByGrpId);
        Architecturalstyle architecturalstyle = entityManager.find(Architecturalstyle.class,searchHeriByArchId);
        heritageGroup.getHeritages().size();
        entityManager.refresh(heritageGroup);
        Set<Heritage> heritages1 = heritageGroup.getHeritages();
        architecturalstyle.getHeritages().size();
        entityManager.refresh(architecturalstyle);
        Set<Heritage> heritages2 = architecturalstyle.getHeritages();
        List<Heritage> newHeritage = new ArrayList<Heritage>();

        int size1 = heritages1.size();
        int size2 = heritages2.size();
        if(size1>size2)
        {
            for (Heritage heritage : heritages1)
            {
                if(heritages2.contains(heritage)){
                    newHeritage.add(heritage);
                }
            }
        }else{
            for (Heritage heritage : heritages2)
            {
                if(heritages1.contains(heritage)){
                    newHeritage.add(heritage);
                }
            }     
        }
        System.out.println("Added Heritage: "+newHeritage.get(0).getAuthority());
        
        /*CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Heritage.class);
        Root<Heritage> p = query.from(Heritage.class);
        //query.select(p).where(builder.lessThanOrEqualTo(p.get("price").as(Double.class), budget));
        query.select(p).where(builder.equals(p.get("") .as(int.class), searchHeritageByGrpId));
        List<Property> lp = entityManager.createQuery(query).getResultList();
        return lp;*/
        return newHeritage;
    }
    
}
