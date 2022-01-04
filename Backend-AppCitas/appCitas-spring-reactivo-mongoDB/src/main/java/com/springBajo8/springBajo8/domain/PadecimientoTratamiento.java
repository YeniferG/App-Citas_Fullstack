package com.springBajo8.springBajo8.domain;

public class PadecimientoTratamiento {
    private  String padecimiento;
    private  String Tratamiento;

    public PadecimientoTratamiento(String padecimiento, String tratamiento) {
        this.padecimiento = padecimiento;
        Tratamiento = tratamiento;
    }

    public PadecimientoTratamiento() {
    }

    public String getPadecimiento() {
        return padecimiento;
    }

    public void setPadecimiento(String padecimiento) {
        this.padecimiento = padecimiento;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        Tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "padecimiento = '" + padecimiento + '\'' +
                ", Tratamiento = '" + Tratamiento + '\'';
    }
}
