package beans;

public class Cliente {
	private String usuario;
	private String password;
	private String email;
	private int tfno;	

	public Cliente(String usuario, String password, String email, int tfno) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		this.tfno = tfno;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getTfno() {
		return tfno;
	}

	public void setTfno(int tfno) {
		this.tfno = tfno;
	}

	

}
