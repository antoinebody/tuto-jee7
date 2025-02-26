package fr.dawan.projet1.ws.beans;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import fr.dawan.projet1.ws.validator.custom.CaseMode;
import fr.dawan.projet1.ws.validator.custom.CheckCase;
import fr.dawan.projet1.ws.validator.custom.Severity;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@CheckCase(caseMode=CaseMode.LOWER,payload=Severity.Info.class,message="{my.custom.error}")
public class CompagnieAerienne implements Serializable {

	@XmlElement
	@Min(0)
	private long id;
	
	@XmlElement
	@Pattern(regexp="[a-zA-Z]+")
	@Size(min=3, message="au moins 3 caractères max")
	@NotNull(message="{compagnie.aerienne.null}")
	private String nom;

	public CompagnieAerienne(long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public CompagnieAerienne() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		CompagnieAerienne other = (CompagnieAerienne) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompagnieAerienne [id=" + id + ", nom=" + nom + "]";
	}

}
