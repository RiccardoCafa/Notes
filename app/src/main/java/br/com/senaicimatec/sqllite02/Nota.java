package br.com.senaicimatec.sqllite02;

public class Nota {
    private Integer Id;
    private String Descricao;

    public Integer getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}
