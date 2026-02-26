package com.ayoub.Telephone.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Telephone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtel ;
	private String nomTel ;
	private Double prixTel ;
	private Date dateCreation ;
  
	public Telephone() {
		super();

	}
	public Telephone( String nomTel, String desTel, Double prixTel, Date dateCreation, String emailtel) {
		super();
		
		this.nomTel = nomTel;

		this.prixTel = prixTel;
		this.dateCreation = dateCreation;

	}

    public Long getIdtel() {
        return idtel;
    }

    public void setIdtel(long idtel) {
        this.idtel = idtel;
    }

    public String getNomTel() {
        return nomTel;
    }

    public void setNomTel(String nomTel) {
        this.nomTel = nomTel;
    }

    public Double getPrixTel() {
        return prixTel;
    }

    public void setPrixTel(Double prixTel) {
        this.prixTel = prixTel;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

  

    @Override
	public String toString() {
		return "Tel [idtel=" + idtel + ", nomTel=" + nomTel + ",  prixTel=" + prixTel
				+ ", dateCreation=" + dateCreation + " ]";
	}

}










