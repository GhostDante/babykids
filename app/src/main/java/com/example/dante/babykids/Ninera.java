package com.example.dante.babykids;

public class Ninera
{
    //nombre de niñera
    private String nombre;
    //dias de trabajo
    private String dias;
    //horario
    private String horas;
    //edad de niñera y telefono
    private String edad, telefono;

    //Constructor
    public Ninera(String nombre, String dias, String horas, String edad, String telefono) {
        this.nombre = nombre;
        this.dias = dias;
        this.horas = horas;
        this.edad = edad;
        this.telefono = telefono;
    }

    //Retorna el nombre de niñera
    public String getNombre() {
        return nombre;
    }

    //Agrega el nombre de niñera
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Retorna los dias
    public String getDias() {
        return dias;
    }

    //Agrega el dia de trabajo
    public void setDias(String dias) {
        this.dias = dias;
    }

    //retorna la hora de trabajo
    public String getHoras() {
        return horas;
    }


    //Agrega la hora de trabajo
    public void setHoras(String horas) {
        this.horas = horas;
    }

    //Retorna la edad de niñera
    public String getEdad() {
        return edad;
    }

    //agrega la edad de niñera
    public void setEdad(String edad) {
        this.edad = edad;
    }

    //retorna el telefono de niñera
    public String getTelefono() {
        return telefono;
    }

    //agrega la edad de niñera
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
