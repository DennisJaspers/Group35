package be.ucll.unit.model.UserTest;

public class User {
    private String name;
    private int age;
    private String email;
    private String password;

    public User(String name, int age, String email, String password) {
        setName(name);
        setAge(age);
        setEmail(email);
        setPassword(password);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

        public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
