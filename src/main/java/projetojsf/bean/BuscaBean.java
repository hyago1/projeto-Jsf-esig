package projetojsf.bean;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;

import projetojsf.dao.TarefaDAO;
import projetojsf.model.tarefaModel;

@ManagedBean(name = "buscaBean")
public class BuscaBean {
	

	private String titulo;
	private String descricao;
	private String responsavel;
	private String prioridade;
	private Date data;
	private String concluida;

	private List<tarefaModel> tarefas;

	
	private TarefaDAO dao = new TarefaDAO();
	
	
	public String buscarTarefa() throws SQLException{
		dao.buscarTarefas();

		
		return null;
		
		
		
		
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
	

}
