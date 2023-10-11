package com.example.agenda.enums;

public enum Especialidades {

        ClinicoGeral("Clinico Geral"),
        Pediatra("Pediatra");

        private String especialidade="";

    Especialidades(String especialidade){
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }
}
