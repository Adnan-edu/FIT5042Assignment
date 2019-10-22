/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.restful.service;

import fit5042.restful.Heritage;
import fit5042.restful.Heritagegroup;
import fit5042.restful.Architecturalstyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Adnan
 */
@Stateless
@Path("fit5042.restful.heritage")
public class HeritageFacadeREST extends AbstractFacade<Heritage> {

    @PersistenceContext(unitName = "WebSecuredAppPU")
    private EntityManager em;

    public HeritageFacadeREST() {
        super(Heritage.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Heritage entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Heritage entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Heritage find(@PathParam("id") Integer id) {
        return super.find(id);
        /*Heritagegroup contactPerson = em.find(Heritagegroup.class, id);
        System.out.println("Size of my list is: "+contactPerson.getHeritageCollection().size());
        em.refresh(contactPerson);
        //return (List<Heritage>) contactPerson.getHeritageCollection();
         return Response.status(200)
          .header("Access-Control-Allow-Origin", "*")
          .header("Access-Control-Allow-Credentials", "true")
          .header("Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization")
          .header("Access-Control-Allow-Methods", 
            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
          .entity(contactPerson.getHeritageCollection())
          .build();    */    
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Heritage> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("/search/{groupId}/{archId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response searchHeritage(@PathParam("groupId") Integer groupId, @PathParam("archId") Integer archId){
        Heritagegroup heritageGroup = em.find(Heritagegroup.class, groupId);
        Architecturalstyle architecturalstyle= em.find(Architecturalstyle.class,archId);
        
        heritageGroup.getHeritageCollection().size();
        em.refresh(heritageGroup);
        List<Heritage> heritages1 = (List<Heritage>) heritageGroup.getHeritageCollection();
        
        architecturalstyle.getHeritageCollection().size();
        em.refresh(architecturalstyle);
        List<Heritage> heritages2 = (List<Heritage>) architecturalstyle.getHeritageCollection();
        List<Heritage> newHeritage = new ArrayList<>();
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
        }
        else
        {
            for (Heritage heritage : heritages2)
            {
                if(heritages1.contains(heritage)){
                    newHeritage.add(heritage);
                }
            }     
        }        
        //em.refresh(heritageGroup);
         return Response.status(200)
          .header("Access-Control-Allow-Origin", "*")
          .header("Access-Control-Allow-Credentials", "true")
          .header("Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization")
          .header("Access-Control-Allow-Methods", 
            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
          .entity(newHeritage)
          .build();
    }
    
    @GET
    @Path("/fetchAllHeritages")
    @Produces({MediaType.APPLICATION_JSON})
    public Response test() {
        List<Heritage> heritageList = this.findAll(); 
        
        return Response.status(200)
          .header("Access-Control-Allow-Origin", "*")
          .header("Access-Control-Allow-Credentials", "true")
          .header("Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization")
          .header("Access-Control-Allow-Methods", 
            "GET, POST, PUT, DELETE, OPTIONS, HEAD")
          .entity(heritageList)
          .build();
    }    

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Heritage> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
