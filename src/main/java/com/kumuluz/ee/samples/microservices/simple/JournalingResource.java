package com.kumuluz.ee.samples.microservices.simple;

import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import com.kumuluz.ee.logs.cdi.Log;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import com.kumuluz.ee.samples.microservices.simple.Models.Entry;


@Path("/journal")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Log
public class JournalingResource {

    @PersistenceContext
    private EntityManager em;

    private static final Logger LOG = LogManager.getLogger(JournalingResource.class.getName());



    @GET
    public Response showJournal() {

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/insertJournal")
    public Response insertJournal(Entry entry) {

        try{
            em.getTransaction().begin();
            entry.setId(null);
            em.persist(entry);

            em.getTransaction().commit();
            LOG.trace("New journal entry created!");
            return Response.status(Response.Status.CREATED).entity(entry).build();

        }catch(Exception ex){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

        }
    }
}
