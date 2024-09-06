package br.com.isaac.javarestawsdockerspringreactmockito.controllers.book;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.isaac.javarestawsdockerspringreactmockito.dtos.BookDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.shared.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book", description = "Endpoints for managing books")
public interface IBookController {

        @GetMapping(produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML, Constants.APPLICATION_YML })
        @Operation(summary = "Finds all Books", description = "Retrieves a list of all books", tags = {
                        "Book" }, responses = {
                                        @ApiResponse(description = Constants.SUCCESS, responseCode = Constants.RESPONSE_CODE_OK, content = @Content(array = @ArraySchema(schema = @Schema(implementation = BookDTO.class)))),
                                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content),
                                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content),
                                        @ApiResponse(description = Constants.NOT_FOUND, responseCode = Constants.RESPONSE_CODE_NOT_FOUND, content = @Content),
                                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content)
                        })
        ResponseEntity<List<BookDTO>> findAll();

        @GetMapping(value = "/{id}", produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                        Constants.APPLICATION_YML })
        @Operation(summary = "Finds a Book by ID", description = "Retrieves a book by its ID", tags = {
                        "Book" }, responses = {
                                        @ApiResponse(description = Constants.SUCCESS, responseCode = Constants.RESPONSE_CODE_OK, content = @Content(schema = @Schema(implementation = BookDTO.class))),
                                        @ApiResponse(description = Constants.NO_CONTENT, responseCode = Constants.RESPONSE_CODE_NO_CONTENT, content = @Content),
                                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content),
                                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content),
                                        @ApiResponse(description = Constants.NOT_FOUND, responseCode = Constants.RESPONSE_CODE_NOT_FOUND, content = @Content),
                                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content)
                        })
        ResponseEntity<BookDTO> findById(@PathVariable Long id);

        @PostMapping(consumes = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                        Constants.APPLICATION_YML }, produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                                        Constants.APPLICATION_YML })
        @Operation(summary = "Adds a new Book", description = "Creates a new book with the provided information", tags = {
                        "Book" }, responses = {
                                        @ApiResponse(description = Constants.CREATED, responseCode = Constants.RESPONSE_CODE_CREATED, content = @Content(schema = @Schema(implementation = BookDTO.class))),
                                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content),
                                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content),
                                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content)
                        })
        ResponseEntity<BookDTO> create(@RequestBody BookDTO book);

        @PutMapping(consumes = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                        Constants.APPLICATION_YML }, produces = { Constants.APPLICATION_JSON, Constants.APPLICATION_XML,
                                        Constants.APPLICATION_YML })
        @Operation(summary = "Updates an existing Book", description = "Updates an existing book with the provided information", tags = {
                        "Book" }, responses = {
                                        @ApiResponse(description = Constants.SUCCESS, responseCode = Constants.RESPONSE_CODE_OK, content = @Content(schema = @Schema(implementation = BookDTO.class))),
                                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content),
                                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content),
                                        @ApiResponse(description = Constants.NOT_FOUND, responseCode = Constants.RESPONSE_CODE_NOT_FOUND, content = @Content),
                                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content)
                        })
        ResponseEntity<BookDTO> update(@RequestBody BookDTO book);

        @DeleteMapping(value = "/{id}")
        @Operation(summary = "Deletes a Book", description = "Deletes a book by its ID", tags = {
                        "Book" }, responses = {
                                        @ApiResponse(description = Constants.NO_CONTENT, responseCode = Constants.RESPONSE_CODE_NO_CONTENT, content = @Content),
                                        @ApiResponse(description = Constants.BAD_REQUEST, responseCode = Constants.RESPONSE_CODE_BAD_REQUEST, content = @Content),
                                        @ApiResponse(description = Constants.UNAUTHORIZED, responseCode = Constants.RESPONSE_CODE_UNAUTHORIZED, content = @Content),
                                        @ApiResponse(description = Constants.NOT_FOUND, responseCode = Constants.RESPONSE_CODE_NOT_FOUND, content = @Content),
                                        @ApiResponse(description = Constants.INTERNAL_ERROR, responseCode = Constants.RESPONSE_CODE_INTERNAL_ERROR, content = @Content)
                        })
        ResponseEntity<?> delete(@PathVariable Long id);
}
