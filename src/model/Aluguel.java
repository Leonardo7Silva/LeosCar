package model;

import java.util.Date;

public class Aluguel {
    String id;
    Pessoa cliente;
    Veiculo veiculo;
    Date dataInicio;
    Date dataEntrega;
    String status;
    Double valorTotal;

    Aluguel(Pessoa cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = new Date();
        this.status = "ABERTO";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente +
                ", veiculo=" + veiculo +
                ", dataInicio=" + dataInicio +
                ", dataEntrega=" + dataEntrega +
                ", status='" + status + '\'' +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
