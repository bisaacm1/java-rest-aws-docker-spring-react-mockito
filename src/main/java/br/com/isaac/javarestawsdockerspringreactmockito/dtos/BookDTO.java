package br.com.isaac.javarestawsdockerspringreactmockito.dtos;

import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({ "key", "author", "launchDate", "price", "title" })
public class BookDTO extends RepresentationModel<BookDTO> implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long key;

	@JsonProperty("author")
	private String author;

	@JsonProperty("launch_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date launchDate;

	@JsonProperty("price")
	private Double price;

	@JsonProperty("title")
	private String title;
}
