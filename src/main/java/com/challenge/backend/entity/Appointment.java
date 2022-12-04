package com.challenge.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase que representa entidades de Appoiment
 *
 * @author Edison Restrepo - edisonestival@gmail.com
 * @version 1.0.0 2022-12-01
 * @since 1.0.0
 */

@Data
@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
public class Appointment implements Serializable {

    /**
     * Variable usada para manejar el tema del identificador de la tupla (consecutivo)
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador de la tupla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * Fecha del appointment
     */
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date", nullable = false)
    private LocalDate date;

    /**
     * Hora del appointments
     */
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm")
    @Column(name = "hour", nullable = false)
    private LocalTime hour;

    /**
     * id del test
     */
    @ManyToOne
    @JoinColumn(name = "id_test", nullable = false)
    private Tests idTest;

    /**
     * id del affiliate
     */
    @ManyToOne
    @JoinColumn(name = "id_affiliate", nullable = false)
    private Affiliate idAffiliate;
}
