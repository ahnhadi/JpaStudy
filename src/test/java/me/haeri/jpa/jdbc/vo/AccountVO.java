package me.haeri.jpa.jdbc.vo;

public class AccountVO {

    private Integer Id;

    private String username;

    private String password;

    // 기본생성자
    public AccountVO() {
    }

    // setter
    public void setId(Integer id) {
        Id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 생성자
    public AccountVO(String username, String password) {
        this.username =username;
        this.password =password;
    }


    // getter
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
