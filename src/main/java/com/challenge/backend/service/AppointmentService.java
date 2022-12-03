package com.challenge.backend.service;


import com.challenge.backend.entity.Affiliate;
import com.challenge.backend.entity.Appointment;
import com.challenge.backend.entity.Test;
import com.challenge.backend.repository.AffiliateRepository;
import com.challenge.backend.repository.AppointmentRepository;
import com.challenge.backend.repository.TestRepository;
import com.challenge.backend.service.interfaces.IAppointment;
import org.hibernate.query.internal.AbstractProducedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase que implementa los metodos de logica de negocio de la interface de IAppointment
 *
 * @version 1.0.0 2022-12-02
 * @author Edison Restrepo - edisonestival@gmail.com
 * @since 1.0.0
 */

@Service
public class AppointmentService implements IAppointment {

    /**
     * Repositorio de Appointment
     */
    @Autowired
    private AppointmentRepository appointmentRepository;

    /**
     * Repositorio de Affiliate
     */
    @Autowired
    private AffiliateRepository affiliateRepository;

    /**
     * Repositorio de Test
     */
    @Autowired
    private TestRepository testRepository;

    /**
     * Metodo que permite consultar un listado de appointments
     *
     * @return listado de appointments
     *
     *  @author Edison Restrepo - edisonestival@gmail.com
     *  @since 1.0.0
     */
    @Override
    public List<Appointment> getList() {
        return (List<Appointment>) appointmentRepository.findAll();
    }

    /**
     * Metodo que permite consultar un appointment por id
     *
     * @param id
     * @return un appointment por id
     *
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public Optional<Appointment> getById(Integer id) {
        Optional<Appointment> appointment = this.appointmentRepository.findById(id);
        return appointment;
    }

    /**
     * Metodo que permite crear un appointment
     *
     * @param appointment
     * @return appointment creado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public Appointment post(Appointment appointment) {
        Optional<Affiliate> affiliate = affiliateRepository.findById(appointment.getIdAffiliate().getId());
        Optional<Test> test = testRepository.findById(appointment.getIdTest().getId());

        if(affiliate.isPresent() && test.isPresent()) {
            try{
                return appointmentRepository.save(appointment);
            } catch (Exception exception) {
                return null;
            }
        }else {
            return null;
        }
    }

    /**
     * Metodo que permite actualizar datos de un appointment
     *
     * @param appointment
     * @return appointment actualizado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public Optional<Appointment> put(Appointment appointment) {
        Optional<Affiliate> affiliate = affiliateRepository.findById(appointment.getIdAffiliate().getId());
        Optional<Test> test = testRepository.findById(appointment.getIdTest().getId());
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointment.getId());

        if(affiliate.isPresent() && test.isPresent() && optionalAppointment.isPresent()) {
            try{
                Appointment updatedAppointment = optionalAppointment.get();

                updatedAppointment.setIdAffiliate(affiliate.get());
                updatedAppointment.setIdTest(test.get());
                updatedAppointment.setDate(appointment.getDate());
                updatedAppointment.setHour(appointment.getHour());

                appointmentRepository.save(updatedAppointment);

                return Optional.ofNullable(updatedAppointment);
            } catch (Exception exception) {
                return Optional.empty();
            }
        }else {
            return Optional.empty();
        }
    }

    /**
     * Metodo que permite eliminar un appointment por id
     *
     * @param id
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public void deleteById(Integer id) {
        this.appointmentRepository.deleteById(id);
    }
}