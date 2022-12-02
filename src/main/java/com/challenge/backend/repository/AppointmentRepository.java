package com.challenge.backend.repository;

import com.challenge.backend.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface que contiene el CRUD con Spring JPA para la tabla de appointments.
 *
 * @author Edison Restrepo - edisonestival@gmail.com
 * @version 1.0.0 2022-12-01
 * @since 1.0.0
 */
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
}
