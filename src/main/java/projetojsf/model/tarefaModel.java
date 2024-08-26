package projetojsf.model;

public class tarefaModel {
    private int numero;
    private String titulo;
    private String responsavel;
    private String descricao;
    private String data;
    private int prioridade;
    private String concluida;

    // Construtores, Getters e Setters
    public tarefaModel(int numero, String titulo,String responsavel, String descricao, String concluida) {
        this.numero = numero;
        this.titulo = titulo;
        this.responsavel = responsavel;
        this.descricao = descricao;
        this.concluida = concluida;
        
      
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getConcluida() {
		return concluida;
	}

	public void setConcluida(String concluida) {
		this.concluida = concluida;
	}
}