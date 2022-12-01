package com.challenge.backend.controller;

import com.challenge.backend.entity.Test;
import com.challenge.backend.service.interfaces.ITest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador que manipula el flujo de los servicios rest del microservicio de tests
 *
 * @author Edison Restrepo - edisonestival@gmail.com
 * @version 1.0.0 2022-12-01
 * @since 1.0.0
 */

@RestController
@RequestMapping("/api/controller")
public class TestController {

    /**
     * Servicio para el manejo de tests
     */
    @Autowired
    private ITest testService;

    /**
     * Metodo que permite consultar un listado de tests
     *
     * @return Objeto Response en formato JSON
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @GetMapping("tests")
    public ResponseEntity<?> getList() {

        List<Test> testList = this.testService.getList();
        if (testList.isEmpty()) {
            return new ResponseEntity<>("No content", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(testList, HttpStatus.OK);
        }
    }

    /**
     * Metodo que permite consultar un test por id
     *
     * @param id
     * @return un test por id
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @GetMapping("tests/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Optional<Test> test = this.testService.getById(id);
        if (test.isEmpty()) {
            return new ResponseEntity<>("No found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(test, HttpStatus.OK);
        }
    }

    /**
     * Metodo que permite crear un test
     *
     * @param test
     * @return test creado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @PostMapping("tests")
    public ResponseEntity<?> post(@RequestBody Test test) {
        try {
            Test testSave = this.testService.post(test);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Metodo que permite actualizar datos de un test
     *
     * @param test
     * @return test actualizado
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @PutMapping("tests")
    public ResponseEntity<?> put(@RequestBody Test test) {
        return post(test);
    }


    /**
     * Metodo que permite eliminar un test por id
     *
     * @param id
     * @author Edison Restrepo - edisonestival@gmail.com
     * @since 1.0.0
     */
    @DeleteMapping("tests/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            this.testService.deleteById(id);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
