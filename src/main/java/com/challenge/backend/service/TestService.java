package com.challenge.backend.service;

import com.challenge.backend.entity.Test;
import com.challenge.backend.repository.TestRepository;
import com.challenge.backend.service.interfaces.ITest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Clase que implementa los metodos de logica de negocio de la interface de ITest
 *
 * @version 1.0.0 2022-12-01
 * @author Edison Restrepo - edisonestival@gmail.com
 * @since 1.0.0
 */

@Service
public class TestService implements ITest {

    /**
     * Repositorio de Test
     */
    @Autowired
    private TestRepository testRepository;

    /**
     * Metodo que permite consultar un listado de tests
     *
     * @return listado de tests
     *
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public List<Test> getList() {
        return (List<Test>) testRepository.findAll();
    }

    /**
     * Metodo que permite consultar un test por id
     *
     * @param id
     * @return un test por id
     *
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public Optional<Test> getById(Integer id) {
        Optional<Test> test = this.testRepository.findById(id);
        return test;
    }

    /**
     * Metodo que permite crear un test
     *
     * @param test
     * @return test creado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public Test post(Test test) {
        return this.testRepository.save(test);
    }

    /**
     * Metodo que permite actualizar datos de un test
     *
     * @param test
     * @return test actualizado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public Test put(Test test) {
        return this.testRepository.save(test);
    }

    /**
     * Metodo que permite eliminar un test por id
     *
     * @param id
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @Override
    public void deleteById(Integer id) {
        this.testRepository.deleteById(id);
    }
}
