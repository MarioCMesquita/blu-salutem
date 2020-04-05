package beans;

public class ConsultaBean {

	//Atributos
	private int idConsulta, idSegmentoMedico, idMedico, idPaciente;
	private String descricaoConsulta, dataConsulta;
	
	//Set e Get
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public int getIdSegmentoMedico() {
		return idSegmentoMedico;
	}
	public void setIdSegmentoMedico(int idSegmentoMedico) {
		this.idSegmentoMedico = idSegmentoMedico;
	}
	public int getIdMedico() {
		return idMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getDescricaoConsulta() {
		return descricaoConsulta;
	}
	public void setDescricaoConsulta(String descricaoConsulta) {
		this.descricaoConsulta = descricaoConsulta;
	}
	public String getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(String data) {
		this.dataConsulta = data;
	}
	
}
