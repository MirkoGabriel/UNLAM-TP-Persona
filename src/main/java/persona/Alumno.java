/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author g.guzman
 */
public class Alumno extends Persona {

    public static final String DELIM = "\t";
    private MiCalendario fecIng;
    
    private int cantMatAprob;
    
    private double promedio;
    
    private boolean activo = true;
    
    public static final int MAX_CANT_MAT_APROB = 50;

    public Alumno() {
        super();
    }

    public Alumno(MiCalendario fecIng, int cantMatAprob, double promedio, char sexo, int dni,
            String nombre, String apellido, MiCalendario fecNac) 
            throws PersonaNombreException, AlumnoException, PersonaDniException {
        super(dni, nombre, apellido, fecNac, sexo);
        this.fecIng = fecIng;
        setCantMatAprob(cantMatAprob);
        setPromedio(promedio);
    }
    
    

    public MiCalendario getFecIng() {
        return fecIng;
    }

    public void setFecIng(MiCalendario fecIng) {
        this.fecIng = fecIng;
    }

    public int getCantMatAprob() {
        return cantMatAprob;
    }

    public void setCantMatAprob(int cantMatAprob) throws AlumnoException {
        if (cantMatAprob < 0 || cantMatAprob > MAX_CANT_MAT_APROB) {
            throw new AlumnoException("La cant. de materias aprobadas es incorrecta");
        }
        this.cantMatAprob = cantMatAprob;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) throws AlumnoException {
        if(promedio < 0 || promedio > 10|| String.valueOf(promedio).length() > 5) {
            throw new AlumnoException("Subjects averge its wrong");
        }
        this.promedio = promedio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return super.toString() +
                fecIng + DELIM +
                StringUtils.leftPad(String.valueOf(cantMatAprob), 2,'0') + DELIM +
                StringUtils.center(String.valueOf(promedio),5,'0') + DELIM +
                (activo ? 'A' : 'B');
    }
}
