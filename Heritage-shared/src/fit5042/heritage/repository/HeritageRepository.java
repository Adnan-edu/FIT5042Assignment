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
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

/**
 *
 * @author Adnan
 */
@Remote

public interface HeritageRepository {
    
     public void addHeritage(Heritage heritage) throws Exception;
     
     public void addUser(Users user) throws Exception;
     
     public Heritage searchHeritageById(int id) throws Exception;
     
     public List<Heritage> getAllHeritages() throws Exception;
     
     public List<Architecturalstyle> getAllArchitecturalstyle() throws Exception;
     
     public List<Address> getAllAddress() throws Exception;
     
     public void removeHeritage(int heritageId) throws Exception;
     
     public List<Heritage> searchHeritageByBoth(int searchHeritageByGrpId, int searchHeriByArchId) throws Exception;;
     
     public void editHeritage(Heritage heritage) throws Exception;
     
     public void editHeritageGroup(HeritageGroup heritageGroup) throws Exception;
     
     public void editArchStyle(Architecturalstyle architecturalstyle) throws Exception;
     
     Set<Heritage> searchHeritageByCity(String city) throws Exception;
     
     public void addHeritageGroup(HeritageGroup heritageGroup)throws Exception;
     
     public void removeHeritageGroup(int groupId) throws Exception;
     
     public void removeArchStyle(int archStyleId) throws Exception;
     
     public List<HeritageGroup> getAllHeritageGroups() throws Exception;
    
     public HeritageGroup getHeritageGroupById(int groupId) throws Exception;
}
