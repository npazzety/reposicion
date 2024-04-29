package hn.lenguajes.reposicion.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "posiciones")
public class Posiciones {

    @Id
    @Column(name = "idposiciones")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPosiciones;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "codigoequipo", referencedColumnName = "codigoequipo")
    private Equipos codigoEquipo;
    
    private int empates;

    private int ganados;

    private int perdidos;

    @Column(name="golesfavor")
    private int golesFavor;

    @Column(name="golescontra")
    private int golesContra;

    private int puntos;
}
