package com.challenge.backend.service.interfaces;

import com.challenge.backend.entity.Affiliate;

import java.util.List;
import java.util.Optional;

/**
 * Interface que contiene los metodos de logica de negocio para los affiliates
 *
 * @author Edison Restrepo - edisonestival@gmail.com
 * @version 1.0.0 2022-11-29
 * @since 1.0.0
 */

public interface IAffiliate {

    /**
     * Metodo que permite consultar un listado de affiliates
     *
     * @return listado de affiliates
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public List<Affiliate> getList();

    /**
     * Metodo que permite consultar un affiliate por id
     *
     * @param id
     * @return un affiliate por id
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public Optional<Affiliate> getById(Integer id);

    /**
     * Metodo que permite crear un affiliate
     *
     * @param affiliate
     * @return affiliate creado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public Affiliate post(Affiliate affiliate);

    /**
     * Metodo que permite actualizar datos de un affiliate
     *
     * @param affiliate
     * @return affiliate actualizado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public Optional<Affiliate> put(Affiliate affiliate);

    /**
     * Metodo que permite eliminar un affiliate por id
     *
     * @param id
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    public void deleteById(Integer id);
}
