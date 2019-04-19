package fr.inti.formation.entity;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.schema.JsonSerializableSchema;

//Mappe une classe sur un élément XML.
@XmlRootElement


//Détermine si les champs ou les propriétés Javabean sont sérialisés par défaut.
@XmlAccessorType(XmlAccessType.FIELD)


public class Car  {

	private Integer cid;
	private String cname;
	private String color;
	private Integer speed;
	private String mfdctry;

	public Car() {
	}

	public Car(Integer cid, String cname, String color, Integer speed,
			String mfdctry) {
		this.cid = cid;
		this.cname = cname;
		this.color = color;
		this.speed = speed;
		this.mfdctry = mfdctry;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public String getMfdctry() {
		return mfdctry;
	}

	public void setMfdctry(String mfdctry) {
		this.mfdctry = mfdctry;
	}

}
