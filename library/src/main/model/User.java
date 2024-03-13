package be.ucll.model.unit.UserTest;
public class User {
    private String name;
    private String password;
    private String email;
    private int age;

    public User(String name, String email, int age, String password) {
        setName(name);
        setEmail(email);
        setAge(age);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new DomainException("Name is required.");
        }
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 8) {
            throw new DomainException("Password must be at least 8 characters long.");
        }
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new DomainException("E-mail must be a valid email format.");
        }
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 101) {
            throw new DomainException("Age must be a positive integer between 0 and 101.");
        }
        this.age = age;
    }
}
