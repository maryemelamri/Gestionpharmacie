package mon.projet.pharmacy.Gestionpharmacie.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
public class User {

	protected User() {
	}

	public User(String email, String pwd, String role, Collection<Role> roles, List<Pharmacie> pharmacie) {
		this.email = email;
		this.pwd = pwd;
		this.role = role;
		this.roles = roles;
		this.pharmacie = pharmacie;
	}
	public User(String email, String pwd, Collection<Role> roles) {
		this.email = email;
		this.pwd = pwd;
		this.role = role;
		this.roles = roles;
		this.pharmacie = pharmacie;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	private String email;
	private String pwd;
	private String role;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "user_id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "role_id"))
	private Collection <Role> roles;

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public List<Pharmacie> getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(List<Pharmacie> pharmacie) {
		this.pharmacie = pharmacie;
	}

	@OneToMany(mappedBy = "user")
	private List<Pharmacie> pharmacie;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
