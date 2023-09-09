package model;

import java.util.Objects;

public class Veiculo {
    private String modelo;
    private String placa;
    private String tipo;
    private String status;

    public Veiculo(String modelo, String placa, String tipo) {
        this.modelo = modelo;
        this.placa = placa;
        this.tipo = tipo;
        this.status = "DISPONÍVEL";
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                "modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", tipo='" + tipo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
