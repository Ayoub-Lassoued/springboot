package com.ayoub.Telephone.entities;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Telephone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtel ;
	private String nomTel ;
	private Double prixTel ;
	private Date dateCreation ;
    @ManyToOne
    private Statut statut;
  
	public Telephone() {
		super();

	}
	public Telephone( String nomTel, String desTel, Double prixTel, Date dateCreation, String emailtel) {
		super();
		
		this.nomTel = nomTel;

		this.prixTel = prixTel;
		this.dateCreation = dateCreation;

	}

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
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










