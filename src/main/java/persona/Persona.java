/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

/**
 * @author g.guzman
 */
public abstract class Persona {

    private static final String DELIM = "\t";
    private static final int MAX_NAME_LENGTH = 15;

    private int dni;

    private String nombre;

    private String apellido;

    private MiCalendario fecNac; // 40/04/2023 ==> 10/05/2023

    private char sexo;


    public Persona() {
    }

    public Persona(int dni) throws PersonaDniException {
        setDni(dni);
    }

    public Persona(int dni, String nombre, String apellido, MiCalendario fecNac, char sexo)
            throws PersonaNombreException, PersonaDniException {
        setDni(dni);
        setNombre(nombre);
        setApellido(apellido);
        this.fecNac = fecNac;
        setSexo(sexo);
    }

    public int getDni() {
        return dni;
    }

    public void setDni(final int dni) throws PersonaDniException {
        if (dni <= 0 || String.valueOf(dni).length() > 8) {
            throw new PersonaDniException("DNI (" + dni + ") should be positive and the long should be less that 8");
        }
        this.dni = dni;
    }

    public String getNombre() {
        return nombre == null ? null : nombre.trim();
    }

    public void setNombre(String nombre) throws PersonaNombreException {
        if (StringUtils.isBlank(nombre)) {
            throw new PersonaNombreException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws PersonaNombreException {
        if (StringUtils.isBlank(nombre)) {
            throw new PersonaNombreException("Surname connot be empty");
        }
        this.apellido = apellido.trim();
    }

    public MiCalendario getFecNac() {
        return fecNac;
    }

    public void setFecNac(MiCalendario fecNac) {
        this.fecNac = fecNac;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) throws PersonaNombreException {
        if (sexo != 'M' && sexo != 'F') {
            throw new PersonaNombreException("Gender value its wrong");
        }
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        String nombreTrunc = this.nombre.length() > MAX_NAME_LENGTH ?
                this.nombre.substring(0, MAX_NAME_LENGTH) :
                this.nombre;

        String apellidoTrunc = this.apellido.length() > MAX_NAME_LENGTH ?
                this.apellido.substring(0, MAX_NAME_LENGTH) :
                this.apellido;

        return StringUtils.leftPad(String.valueOf(dni), 8, '0') + DELIM +
                StringUtils.rightPad(nombreTrunc, 15, StringUtils.SPACE) + DELIM +
                StringUtils.rightPad(apellidoTrunc, 15, StringUtils.SPACE) + DELIM +
                sexo + DELIM +
                fecNac + DELIM;
    }


}
