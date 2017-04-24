package com.myjob.interviews.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.myjob.interviews.plain.Login;

import com.myjob.interviews.plain.Applicant;
public class DatabaseClass {
	private static Map<Integer,Applicant> applicants=new ConcurrentHashMap<>();
	private static Map<Integer, Login> loginUsers=new ConcurrentHashMap<>();
	
	private static String url="http://PC02TV4D:8081/interviews/webapi/aplicants/";
	
	private static String namesArray[]={"Juan","Pedro","Mauricio","Victor","Ulises","Jorge",
					"Jesus","Oswaldo","Perla","Ivette","Paola","Barbara","Erika",
					"Maria","Carlos","Marco","Manuel","Francisco","Heiran","Yuri","Liliana",
					"Susana","Giovana","mayra","Luis","Raul","Alonso","Eduardo","Lorena","Ingrid","Jaqueline",
					"Yennifer","Julio","Diego","Gamaliel","Miguel","Alfonso","Cristian","Tatiana","Omar"
					};
	
	private static String lastNamesArray[]={ "Arteaga","Chavez","Fajardo","Salgado","Hernandez","Reyes","Palomo","Quintana",
								"Tangay","Briones","Calderon","Cortes","Garcia","Uribe","Lara","Acevedo","Lopez","Perez",
								"Diaz","Espinoza","Paz","Samudio","Gonzalez","Rodriguez","Tapia","Vega","Duran","Zavala","Ochoa",
								"Gallardo","Montes","Soto","Ortiz","Torres","Ibarra","Cruz","Fernandez","Huerta",
								"Nieves","Comparan","Carillo","Contreras","Urieta","Madrigal"
			
							};
	
	
	private static String proffesionsArray[]={"Java Developer","Tester","ETL Developer"};
	
	
	private static List<String> names=new ArrayList<>(Arrays.asList(namesArray));
	private static List<String> lastNames=new ArrayList<>(Arrays.asList(lastNamesArray));
	
	private static List<String> proffesions= new ArrayList<>(Arrays.asList(proffesionsArray));
	
	static
	{
		for(int i=1;i<101;i++)
		{
			int randomAge=(int) ((Math.random()*70));
			int randomName=(int) (Math.random()*names.size());
			int randomLastName=(int) (Math.random()*lastNames.size());
			int randomProffesion=(int)(Math.random()*proffesions.size());
			Applicant applicant=new Applicant(i,names.get(randomName)+" "+lastNames.get(randomLastName),randomAge,proffesions.get(randomProffesion),
												(int)(Math.random()*100),(int)(Math.random()*100));
			applicant.addLink(url+i,"self");
			applicants.put(i,applicant);
		}
		Login login=new Login(1,"admin","admin");
		login.setId(1);
		loginUsers.put(1,login);
	}
	public static Map<Integer,Applicant> getAllApplicants()
	{
		return applicants;
	}
	public static Map<Integer,Login> getAllLoginUsers()
	{
		return loginUsers;
	}
	public static void main(String[] arg)
	{
		System.out.println(Math.random());
		System.out.println(applicants.values());
	}
	public static String getURL()
	{
		return url;
	}
}
