package beans;

public class MedicoBean {

	//Atributos
	private int idMedico, idEstado, idSegmentoMedico, idCentroAtendimento;
	private String nomeMedico, rgMedico, cpfMedico, crmMedico, emailMedico, telefoneMedico, enderecoMedico, senhaMedico;
	
	//Set e Get
	public int getIdMedico() {
		return idMedico;
	}
	public String getRgMedico() {
		return rgMedico;
	}
	public void setRgMedico(String rgMedico) {
		this.rgMedico = rgMedico;
	}
	public String getCpfMedico() {
		return cpfMedico;
	}
	public void setCpfMedico(String cpfMedico) {
		this.cpfMedico = cpfMedico;
	}
	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public int getIdSegmentoMedico() {
		return idSegmentoMedico;
	}
	public void setIdSegmentoMedico(int idSegmentoMedico) {
		this.idSegmentoMedico = idSegmentoMedico;
	}
	public int getIdCentroAtendimento() {
		return idCentroAtendimento;
	}
	public void setIdCentroAtendimento(int idCentroAtendimento) {
		this.idCentroAtendimento = idCentroAtendimento;
	}
	public String getNomeMedico() {
		return nomeMedico;
	}
	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}
	public String getCrmMedico() {
		return crmMedico;
	}
	public void setCrmMedico(String crmMedico) {
		this.crmMedico = crmMedico;
	}
	public String getEmailMedico() {
		return emailMedico;
	}
	public void setEmailMedico(String emailMedico) {
		this.emailMedico = emailMedico;
	}
	public String getTelefoneMedico() {
		return telefoneMedico;
	}
	public void setTelefoneMedico(String telefoneMedico) {
		this.telefoneMedico = telefoneMedico;
	}
	public String getEnderecoMedico() {
		return enderecoMedico;
	}
	public void setEnderecoMedico(String enderecoMedico) {
		this.enderecoMedico = enderecoMedico;
	}
	public String getSenhaMedico() {
		return senhaMedico;
	}
	public void setSenhaMedico(String senhaMedico) {
		this.senhaMedico = senhaMedico;
	}
	
}
