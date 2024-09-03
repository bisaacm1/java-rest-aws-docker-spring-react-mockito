package br.com.isaac.javarestawsdockerspringreactmockito.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.isaac.javarestawsdockerspringreactmockito.utils.Constants;
import br.com.isaac.javarestawsdockerspringreactmockito.vo.PersonVO;

public interface IPersonController {

        @GetMapping(value = "/{id}", produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                        Constants.APPLICATION_YML })
        public ResponseEntity<PersonVO> findById(@PathVariable Long id);

        @GetMapping(value = "/", produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                        Constants.APPLICATION_YML })
        public ResponseEntity<List<PersonVO>> findAll();

        @PostMapping(value = "/create", produces = { Constants.APPLICATION_JSON,
                        Constants.APPLICATION_XML, Constants.APPLICATION_YML }, consumes = { Constants.APPLICATION_JSON,
                                        Constants.APPLICATION_XML, Constants.APPLICATION_YML })
        public ResponseEntity<PersonVO> create(@RequestBody PersonVO person);

        @PutMapping(value = "/update", produces = { Constants.APPLICATION_JSON,
                        Constants.APPLICATION_XML, Constants.APPLICATION_YML }, consumes = { Constants.APPLICATION_JSON,
                                        Constants.APPLICATION_XML, Constants.APPLICATION_YML })
        public ResponseEntity<PersonVO> update(@RequestBody PersonVO person);

        @DeleteMapping(value = "/{id}")
        public ResponseEntity<?> delete(@PathVariable Long id);
}