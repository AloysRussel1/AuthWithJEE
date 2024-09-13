package Model;

public class Users {
    private int id;
    private String username;
    private String email;
    private String password;
    private String recoveryWord;

    public Users() {}

    public Users(int id, String username, String email, String password, String recoveryWord) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.recoveryWord = recoveryWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getRecoveryWord() {
		return recoveryWord;
	}

	public void setRecoveryWord(String recoveryWord) {
		this.recoveryWord = recoveryWord;
	}
}
