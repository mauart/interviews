package com.myjob.interviews.resource;

import javax.xml.bind.DatatypeConverter;

import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;

import com.myjob.interviews.plain.Applicant;
import com.myjob.interviews.plain.Login;
import com.myjob.interviews.service.ApplicantService;

import java.util.List;
import com.myjob.interviews.service.LoginService;

@Path("/aplicants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApplicantResource 
{
	private ApplicantService appService=new ApplicantService();
	private LoginService loginService=new LoginService();
	
	@GET
	public Response getAllApplicants()
	{
		System.out.println("Somebody has gotten elements");
		GenericEntity<List<Applicant>> g=new GenericEntity<List<Applicant>>(appService.getAllApplicants()){};
		return Response.status(Status.OK).entity(g).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getApplicant(@PathParam("id") int id,@Context UriInfo info)
	{
		Applicant applicant=appService.getApplicant(id);
		System.out.println(applicant);
		
		return Response.status(Status.OK).entity(applicant).build();
	}
	
	@POST
	public Response addAplicant(Applicant applicant)
	{
		System.out.println("primero:\n"+applicant);
		Applicant applicant2 =appService.addApplicant(applicant);
		System.out.println("despues: \n"+applicant2);
		System.out.println("en HashTable:\n"+ appService.getApplicant(applicant2.getId()));
		
		return Response.status(Status.OK).entity(applicant2).build();
	}
	@DELETE
	@Path("/{id}")
	public Response deleteAplicant(@PathParam("id")int id)
	{
		Applicant applicant=appService.deleteApplicant(id);
		
		return Response.status(Status.OK).entity(applicant).build();
	}
	@PUT
	@Path("/{id}")
	public Response updateAplicant(@PathParam("id")int id,Applicant applicant)
	{
		return Response.status(Status.OK).entity(appService.updateApplicant(id, applicant)).build();
	}
	
	@POST
	@Path("/login")
	public Response doLogin(Login login)
	{
		System.out.println("\n\nDoLogin\n"+login);
		List<Login> list=loginService.getAllUsersLogin();
		for(Login log:list)
		{
			if(log.equals(login))
				return Response.status(Status.OK).build();
		}
		return Response.status(Status.FORBIDDEN).build();
	}
	@POST
	@Path("/addLogin")
	public Response addLogin(Login login)
	{
		System.out.println("\n\n addLogin"+login);
		return Response.status(Status.OK).entity(loginService.addLoginUser(login)).build();
	}
	@DELETE
	@Path("/login/{id}")
	public Response deleteLogin(@PathParam("{id}")int id)
	{
		System.out.println("\n\n deleteLogin\n"+id);
		return Response.status(Status.OK).entity(loginService.deleteLoginUser(id)).build();
	}
	@GET
	@Path("/login/{id}")
	public Response getLogin(@PathParam("id") int id)
	{
		return Response.status(Status.OK).entity(loginService.getUserLogin(id)).build();
	}
	@PUT
	@Path("/login/{id}")
	public Response updateLogin(@PathParam("id") int id,Login login)
	{
		System.out.println("\n updateLogin\n\n"+login);
		return Response.status(Status.OK).entity(loginService.updateLoginUser(id, login)).build();
	}
}
