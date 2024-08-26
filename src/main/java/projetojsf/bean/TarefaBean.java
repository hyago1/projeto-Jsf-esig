package projetojsf.bean;

import projetojsf.dao.TarefaDAO;
import projetojsf.model.tarefaModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import java.util.Date;

@ManagedBean(name = "tarefaBean")
@RequestScoped
public class TarefaBean {

	private String titulo;
	private Integer numero = null;
	private String descricao;
	private String responsavel;
	private String prioridade;
	private Date data;
	private String concluida;
	
	 private List<tarefaModel> tarefasFiltradas; 
	private TarefaDAO dao = new TarefaDAO();

	private List<tarefaModel> tarefas;


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

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getConcluida() {
		return concluida;
	}

	public void setConcluida(String concluida) {
		this.concluida = concluida;
	}
	
	
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String buscar() throws SQLException, IOException {
        tarefasFiltradas = tarefas.stream()
            .filter(tarefa -> (numero == null || tarefa.getNumero() == numero))
            .filter(tarefa -> (titulo == null || tarefa.getTitulo().contains(titulo) 
                                || tarefa.getTitulo().contains(titulo)))
            .filter(tarefa -> (concluida == null || tarefa.getConcluida().equals(concluida)))
            .filter(tarefa -> (responsavel == null || tarefa.getResponsavel().contains(responsavel)))
            .collect(Collectors.toList());
        
        tarefas = tarefasFiltradas;
        
      
		
		return null;
    }
	
	
	
//PegarTarefas	   
	public List<tarefaModel> getTarefas() throws SQLException, IOException {
		if (tarefas == null) {
			tarefas = dao.getTarefas();

		}
		return tarefas;
	}
//Excluir
	public String excluirTarefa(String numero) throws SQLException, IOException {
		int numeroTarefa = Integer.parseInt(numero);
		dao.excluir(numeroTarefa);

		FacesContext.getCurrentInstance().getExternalContext().redirect("cadastrarTarefa.jsf");
		return null;
	}
	
//Concluir	
	public String concluirTarefa(String numero) throws SQLException, IOException {
		int numeroTarefa = Integer.parseInt(numero);
		dao.concluir(numeroTarefa);

		FacesContext.getCurrentInstance().getExternalContext().redirect("cadastrarTarefa.jsf");
		return null;
	}
//Cadastrar/Salvar Tarefas
	public String salvar() throws SQLException, IOException {
		dao.salvar(titulo, descricao, responsavel, prioridade, data);

		FacesContext.getCurrentInstance().getExternalContext().redirect("cadastrarTarefa.jsf");

		return null;
	}

	
	

}