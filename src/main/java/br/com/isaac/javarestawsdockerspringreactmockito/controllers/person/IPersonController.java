package br.com.isaac.javarestawsdockerspringreactmockito.controllers.person;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.isaac.javarestawsdockerspringreactmockito.dtos.PersonDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.shared.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "People", description = "Endpoints for managing people")
public interface IPersonController {

        @CrossOrigin(origins = { Constants.ORIGIN_LOCALHOST_8080, Constants.ORIGIN_ISAAC })
        @GetMapping(value = "/{id}", produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                        Constants.APPLICATION_YML })
        @Operation(summary = "Finds a Person", description = "Retrieves a Person by their ID.", tags = {
                        "People" }, responses = {
                                        @ApiResponse(description = Constants.SUCCESS, responseCode = Constants.RESPONSE_CODE_OK, content = @Content(schema = @Schema(implementation = PersonDTO.class))),
                                        @ApiResponse(description = Constants.NO_CONTENT, responseCode = Constants.RESPONSE_CODE_NO_CONTENT, content = @Content),
                                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content),
                                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content),
                                        @ApiResponse(description = Constants.NOT_FOUND, responseCode = Constants.RESPONSE_CODE_NOT_FOUND, content = @Content),
                                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content)
                        })
        ResponseEntity<PersonDTO> findById(@PathVariable Long id);

        @GetMapping(produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML, Constants.APPLICATION_YML })
        @Operation(summary = "Finds all People", description = "Retrieves a list of all People.", tags = {
                        "People" }, responses = {
                                        @ApiResponse(description = Constants.SUCCESS, responseCode = Constants.RESPONSE_CODE_OK, content = @Content(array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class)))),
                                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content),
                                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content),
                                        @ApiResponse(description = Constants.NOT_FOUND, responseCode = Constants.RESPONSE_CODE_NOT_FOUND, content = @Content),
                                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content)
                        })
        ResponseEntity<List<PersonDTO>> findAll();

        @PostMapping(consumes = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                        Constants.APPLICATION_YML }, produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                                        Constants.APPLICATION_YML })
        @Operation(summary = "Adds a new Person", description = "Creates a new Person with the provided data.", tags = {
                        "People" }, responses = {
                                        @ApiResponse(description = Constants.CREATED, responseCode = Constants.RESPONSE_CODE_CREATED, content = @Content(schema = @Schema(implementation = PersonDTO.class))),
                                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content),
                                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content),
                                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content)
                        })
        ResponseEntity<PersonDTO> create(@RequestBody PersonDTO person);

        @PutMapping(consumes = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                        Constants.APPLICATION_YML }, produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                                        Constants.APPLICATION_YML })
        @Operation(summary = "Updates an existing Person", description = "Updates the Person with the specified ID using the provided data.", tags = {
                        "People" }, responses = {
                                        @ApiResponse(description = Constants.SUCCESS, responseCode = Constants.RESPONSE_CODE_OK, content = @Content(schema = @Schema(implementation = PersonDTO.class))),
                                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content),
                                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content),
                                        @ApiResponse(description = Constants.NOT_FOUND, responseCode = Constants.RESPONSE_CODE_NOT_FOUND, content = @Content),
                                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content)
                        })
        ResponseEntity<PersonDTO> update(@RequestBody PersonDTO person);

        @DeleteMapping(value = "/{id}")
        @Operation(summary = "Deletes a Person", description = "Deletes the Person with the specified ID.", tags = {
                        "People" }, responses = {
                                        @ApiResponse(description = Constants.NO_CONTENT, responseCode = Constants.RESPONSE_CODE_NO_CONTENT, content = @Content),
                                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content),
                                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content),
                                        @ApiResponse(description = Constants.NOT_FOUND, responseCode = Constants.RESPONSE_CODE_NOT_FOUND, content = @Content),
                                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content)
                        })
        ResponseEntity<Void> delete(@PathVariable Long id);
}
