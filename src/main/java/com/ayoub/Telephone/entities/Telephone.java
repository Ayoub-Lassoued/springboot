package com.ayoub.Telephone.entities;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Telephone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idtel ;
    @Setter
    @NotNull
    @Size (min = 4,max = 15)
	private String nomTel ;
    @Setter
    @Min(value = 10)
    @Max(value = 10000)
    private Double prixTel ;
    @Setter
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateCreation ;
    @Setter

    @ManyToOne
    private Statut statut;
  
	public Telephone() {
		super();

	}
	public Telephone( String nomTel, Double prixTel, Date dateCreation) {
		super();
		
		this.nomTel = nomTel;

		this.prixTel = prixTel;


	}

    public Statut getStatut() {
        return statut;
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

    public Double getPrixTel() {
        return prixTel;
    }

    public Date getDateCreation() {
        return dateCreation;
    }


    @Override
	public String toString() {
		return "Tel [idtel=" + idtel + ", nomTel=" + nomTel + ",  prixTel=" + prixTel
				+ ", dateCreation=" + dateCreation + " ]";
	}

}










