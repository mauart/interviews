package com.myjob.interviews.service;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.myjob.interviews.plain.Applicant;
import com.myjob.interviews.database.DatabaseClass;

public class ApplicantService {
	Map<Integer,Applicant> applicants=DatabaseClass.getAllApplicants();
	
	public List<Applicant> getAllApplicants()
	{
		return new ArrayList<Applicant>(applicants.values());
	}
	
	public Applicant addApplicant(Applicant applicant)
	{
		Set<Integer> keys=applicants.keySet();
		System.out.println(keys);
		int id=Collections.max(keys)+1;
		
		applicant.setId(id);
		applicant.addLink(DatabaseClass.getURL()+id,"self");
		applicants.put(id,applicant);
		return applicant;
	}
	
	public Applicant getApplicant(int id)
	{
		return applicants.get(id);
	}
	
	public Applicant updateApplicant(int id,Applicant applicant)
	{
		applicant.setId(id);
		applicant.addLink(DatabaseClass.getURL()+id, "self");
		applicants.put(id,applicant);
		return applicant;		
	}
	public Applicant deleteApplicant(int id)
	{
		System.out.println(id);
		System.out.println(applicants.get(id));
		Applicant applicant=applicants.remove(id);
		System.out.println(applicants.size());

		return applicant;
	}
	public int getSize()
	{
		return applicants.size();
	}
}
