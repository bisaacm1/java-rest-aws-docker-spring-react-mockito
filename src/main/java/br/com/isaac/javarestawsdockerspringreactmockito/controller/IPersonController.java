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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "People", description = "Endpoints for managing people")
public interface IPersonController {

        @GetMapping(value = "/{id}", produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                        Constants.APPLICATION_YML })
        @Operation(summary = "Finds a Person", description = "Finds a Person by ID", tags = { "People" }, responses = {
                        @ApiResponse(description = Constants.SUCCESS, responseCode = Constants.RESPONSE_CODE_OK, content = @Content(schema = @Schema(implementation = PersonVO.class))),
                        @ApiResponse(description = Constants.NO_CONTENT, responseCode = Constants.RESPONSE_CODE_NO_CONTENT, content = @Content),
                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content(schema = @Schema(implementation = PersonVO.class))),
                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content(schema = @Schema(implementation = PersonVO.class))),
                        @ApiResponse(description = Constants.NOT_FOUND, responseCode = Constants.RESPONSE_CODE_NOT_FOUND, content = @Content(schema = @Schema(implementation = PersonVO.class))),
                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content(schema = @Schema(implementation = PersonVO.class)))
        })
        ResponseEntity<PersonVO> findById(@PathVariable Long id);

        @GetMapping(value = "/", produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                        Constants.APPLICATION_YML })
        @Operation(summary = "Finds all People", description = "Finds all People", tags = { "People" }, responses = {
                        @ApiResponse(description = Constants.SUCCESS, responseCode = Constants.RESPONSE_CODE_OK, content = @Content(array = @ArraySchema(schema = @Schema(implementation = PersonVO.class)))),
                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content(array = @ArraySchema(schema = @Schema(implementation = PersonVO.class)))),
                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content(array = @ArraySchema(schema = @Schema(implementation = PersonVO.class)))),
                        @ApiResponse(description = Constants.NOT_FOUND, responseCode = Constants.RESPONSE_CODE_NOT_FOUND, content = @Content(array = @ArraySchema(schema = @Schema(implementation = PersonVO.class)))),
                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content(array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))))
        })
        ResponseEntity<List<PersonVO>> findAll();

        @PostMapping(value = "/create", produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                        Constants.APPLICATION_YML }, consumes = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                                        Constants.APPLICATION_YML })
        @Operation(summary = "Adds a new Person", description = "Adds a new Person by passing in a JSON, XML, or YML representation of the person", tags = {
                        "People" }, responses = {
                                        @ApiResponse(description = Constants.SUCCESS, responseCode = Constants.RESPONSE_CODE_OK, content = @Content(schema = @Schema(implementation = PersonVO.class))),
                                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content(schema = @Schema(implementation = PersonVO.class))),
                                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content(schema = @Schema(implementation = PersonVO.class))),
                                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content(schema = @Schema(implementation = PersonVO.class)))
                        })
        ResponseEntity<PersonVO> create(@RequestBody PersonVO person);

        @PutMapping(value = "/update", produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                        Constants.APPLICATION_YML }, consumes = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                                        Constants.APPLICATION_YML })
        @Operation(summary = "Updates a Person", description = "Updates a Person by passing in a JSON, XML, or YML representation of the person", tags = {
                        "People" }, responses = {
                                        @ApiResponse(description = Constants.SUCCESS, responseCode = Constants.RESPONSE_CODE_OK, content = @Content(schema = @Schema(implementation = PersonVO.class))),
                                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content(schema = @Schema(implementation = PersonVO.class))),
                                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content(schema = @Schema(implementation = PersonVO.class))),
                                        @ApiResponse(description = Constants.NOT_FOUND, responseCode = Constants.RESPONSE_CODE_NOT_FOUND, content = @Content(schema = @Schema(implementation = PersonVO.class))),
                                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content(schema = @Schema(implementation = PersonVO.class)))
                        })
        ResponseEntity<PersonVO> update(@RequestBody PersonVO person);

        @DeleteMapping(value = "/{id}")
        @Operation(summary = "Deletes a Person", description = "Deletes a Person by ID", tags = {
                        "People" }, responses = {
                                        @ApiResponse(description = Constants.NO_CONTENT, responseCode = Constants.RESPONSE_CODE_OK, content = @Content),
                                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content),
                                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content),
                                        @ApiResponse(description = Constants.NOT_FOUND, responseCode = Constants.RESPONSE_CODE_NOT_FOUND, content = @Content),
                                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content)
                        })
        ResponseEntity<?> delete(@PathVariable Long id);
}
