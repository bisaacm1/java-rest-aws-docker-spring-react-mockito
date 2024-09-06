package br.com.isaac.javarestawsdockerspringreactmockito.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.isaac.javarestawsdockerspringreactmockito.dtos.PersonDTO;
import br.com.isaac.javarestawsdockerspringreactmockito.mocks.MockData;
import br.com.isaac.javarestawsdockerspringreactmockito.models.Person;

public class CustomModelMapperTest {

    MockData mockData;

    @BeforeEach
    public void setUp() {
        mockData = new MockData();
    }

    @Test
    public void parseEntityToVOTest() {
        Person person = mockData.createPersonEntity(0); // Ajustado para usar o método correto
        PersonDTO output = CustomModelMapper.parseObject(person, PersonDTO.class);
        assertEquals(Long.valueOf(0L), output.getKey());
        assertEquals("First Name Test 0", output.getFirstName()); // Ajustado para refletir o método atual
        assertEquals("Last Name Test 0", output.getLastName()); // Ajustado para refletir o método atual
        assertEquals("Address Test 0", output.getAddress()); // Corrigido de "Addres" para "Address"
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<Person> personList = mockData.createPersonEntityList(15); // Ajustado para usar o método correto
        List<PersonDTO> outputList = CustomModelMapper.parseListObjects(personList, PersonDTO.class);

        PersonDTO outputZero = outputList.get(0);
        assertEquals(Long.valueOf(0L), outputZero.getKey());
        assertEquals("First Name Test 0", outputZero.getFirstName()); // Ajustado para refletir o método atual
        assertEquals("Last Name Test 0", outputZero.getLastName()); // Ajustado para refletir o método atual
        assertEquals("Address Test 0", outputZero.getAddress()); // Corrigido de "Addres" para "Address"
        assertEquals("Male", outputZero.getGender());

        PersonDTO outputSeven = outputList.get(7);
        assertEquals(Long.valueOf(7L), outputSeven.getKey());
        assertEquals("First Name Test 7", outputSeven.getFirstName()); // Ajustado para refletir o método atual
        assertEquals("Last Name Test 7", outputSeven.getLastName()); // Ajustado para refletir o método atual
        assertEquals("Address Test 7", outputSeven.getAddress()); // Corrigido de "Addres" para "Address"
        assertEquals("Female", outputSeven.getGender());

        PersonDTO outputTwelve = outputList.get(12);
        assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        assertEquals("First Name Test 12", outputTwelve.getFirstName()); // Ajustado para refletir o método atual
        assertEquals("Last Name Test 12", outputTwelve.getLastName()); // Ajustado para refletir o método atual
        assertEquals("Address Test 12", outputTwelve.getAddress()); // Corrigido de "Addres" para "Address"
        assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parseVOToEntityTest() {
        PersonDTO personDTO = mockData.createPersonDTO(0); // Ajustado para usar o método correto
        Person output = CustomModelMapper.parseObject(personDTO, Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test 0", output.getFirstName()); // Ajustado para refletir o método atual
        assertEquals("Last Name Test 0", output.getLastName()); // Ajustado para refletir o método atual
        assertEquals("Address Test 0", output.getAddress()); // Corrigido de "Addres" para "Address"
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<PersonDTO> personDTOList = mockData.createPersonDTOList(15); // Ajustado para usar o método correto
        List<Person> outputList = CustomModelMapper.parseListObjects(personDTOList, Person.class);

        Person outputZero = outputList.get(0);
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test 0", outputZero.getFirstName()); // Ajustado para refletir o método atual
        assertEquals("Last Name Test 0", outputZero.getLastName()); // Ajustado para refletir o método atual
        assertEquals("Address Test 0", outputZero.getAddress()); // Corrigido de "Addres" para "Address"
        assertEquals("Male", outputZero.getGender());

        Person outputSeven = outputList.get(7);
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test 7", outputSeven.getFirstName()); // Ajustado para refletir o método atual
        assertEquals("Last Name Test 7", outputSeven.getLastName()); // Ajustado para refletir o método atual
        assertEquals("Address Test 7", outputSeven.getAddress()); // Corrigido de "Addres" para "Address"
        assertEquals("Female", outputSeven.getGender());

        Person outputTwelve = outputList.get(12);
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test 12", outputTwelve.getFirstName()); // Ajustado para refletir o método atual
        assertEquals("Last Name Test 12", outputTwelve.getLastName()); // Ajustado para refletir o método atual
        assertEquals("Address Test 12", outputTwelve.getAddress()); // Corrigido de "Addres" para "Address"
        assertEquals("Male", outputTwelve.getGender());
    }
}
