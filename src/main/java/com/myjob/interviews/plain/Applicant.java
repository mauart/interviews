package com.myjob.interviews.plain;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;


@XmlRootElement
public class Applicant 
{
	private int id;
	private String name;
	private int age;
	private String email="mauricio@itmorelia.edu.mx";
	private String phone;
	private String country;
	private String address;
	
	private String[] pleasures;
	private String[] addictions;
	
	private String expertice;
	private int domain;
	private int english;
	private int attitude;
	private String details;
	private String location;
	
	private List<Link> links=new ArrayList<>();
	
	public Applicant(){}

	public Applicant(int id,String name, int age, String email, String phone, String country, String address,
			String[] pleasures, String[] addictions, String expertice, int domain, int english, int attitude,
			String details, String location) {
		super();
		this.id=id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.country = country;
		this.address = address;
		this.pleasures = pleasures;
		this.addictions = addictions;
		this.expertice = expertice;
		this.domain = domain;
		this.english = english;
		this.attitude = attitude;
		this.details = details;
		this.location = location;
	}
	
	public Applicant(int id, String name, int age, String expertice, int domain, int english) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.expertice = expertice;
		this.domain = domain;
		this.english = english;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String[] getPleasures() {
		return pleasures;
	}

	public void setPleasures(String[] pleasures) {
		this.pleasures = pleasures;
	}

	public String[] getAddictions() {
		return addictions;
	}

	public void setAddictions(String[] addictions) {
		this.addictions = addictions;
	}

	public String getExpertice() {
		return expertice;
	}

	public void setExpertice(String expertice) {
		this.expertice = expertice;
	}

	public int getDomain() {
		return domain;
	}

	public void setDomain(int domain) {
		this.domain = domain;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getAttitude() {
		return attitude;
	}

	public void setAttitude(int attitude) {
		this.attitude = attitude;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "Applicant [name=" + name + ", age=" + age + ", expertice=" + expertice + ", english=" + english
				+ ", location=" + location + "]"+"URL"+links;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public void addLink(String url,String rel)
	{
		Link link=new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
		System.out.println("\n\n\n\n"+link.getLink()+"\n\n\n\n"+link.getRel());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Applicant other = (Applicant) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
