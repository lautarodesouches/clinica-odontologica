package com.company.desoucheslautaro.service.impl;

import com.company.desoucheslautaro.dto.OdontologoDTO;
import com.company.desoucheslautaro.exception.BadRequestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    private static Long ODONTOLOGO_1_ID = 1L;
    private static final String ODONTOLOGO_1_NOMBRE = "Juan";
    private static final String ODONTOLOGO_1_APELLIDO = "Gomez";
    private static final Long ODONTOLOGO_1_MATRICULA = 111L;

    public OdontologoDTO crearOdontologoDTO(){

        OdontologoDTO odontologoDTO = new OdontologoDTO();

        odontologoDTO.setNombre(ODONTOLOGO_1_NOMBRE);
        odontologoDTO.setApellido(ODONTOLOGO_1_APELLIDO);
        odontologoDTO.setMatricula(ODONTOLOGO_1_MATRICULA);

        return odontologoDTO;
    }

    @BeforeEach
    public void setUp() throws BadRequestException {

        OdontologoDTO odontologoDTOCreado = odontologoService.guardar(crearOdontologoDTO());

        ODONTOLOGO_1_ID = odontologoDTOCreado.getId();

        for (OdontologoDTO o: odontologoService.buscarTodos()) {
            System.out.println("\n ------------- \n" + o.toString() + "\n ------------- \n");
        }

    }

    @AfterEach
    public void close() throws BadRequestException {
        if (odontologoService.buscarPorId(ODONTOLOGO_1_ID) != null){
            odontologoService.eliminarPorId(ODONTOLOGO_1_ID);
        }
    }

    @Test
    void buscarPorId() throws BadRequestException {

        OdontologoDTO odontologoDtoEcontrado = odontologoService.buscarPorId(ODONTOLOGO_1_ID);

        Long actual = odontologoDtoEcontrado.getMatricula();

        assertEquals(ODONTOLOGO_1_MATRICULA, actual);

    }

    @Test
    void guardar() throws BadRequestException {

        OdontologoDTO odontologoDTOEncontrado = odontologoService.buscarPorMatricula(ODONTOLOGO_1_MATRICULA);

        assertNotNull(odontologoDTOEncontrado);

    }

    @Test
    void buscarTodos() {
        assertTrue(odontologoService.buscarTodos().size() > 0);
    }

    @Test
    void buscarPorMatricula() throws BadRequestException {
        OdontologoDTO odontologoDTO = odontologoService.buscarPorMatricula(ODONTOLOGO_1_MATRICULA);
        assertEquals(ODONTOLOGO_1_APELLIDO, odontologoDTO.getApellido());
    }
/*
    @Test
    void eliminarPorId() {

        odontologoService.eliminarPorId(ODONTOLOGO_1_ID);

        Exception exception = assertThrows(BadRequestException.class, () -> {
            odontologoService.buscarPorId(ODONTOLOGO_1_ID);
        });

        String expectedMessage = "No se encontro un odontologo con el id 1";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
*/
    @Test
    void actualizar() throws BadRequestException {

        OdontologoDTO odontologoDTO = crearOdontologoDTO();

        odontologoDTO.setId(ODONTOLOGO_1_ID);

        String nuevoNombre = "Jose";
        odontologoDTO.setNombre(nuevoNombre);

        System.out.println(odontologoService.actualizar(odontologoDTO));

        OdontologoDTO odontologoDTOEncontrado = odontologoService.buscarPorMatricula(ODONTOLOGO_1_MATRICULA);

        String actual = odontologoDTOEncontrado.getNombre();

        assertEquals(nuevoNombre, actual);

    }

}