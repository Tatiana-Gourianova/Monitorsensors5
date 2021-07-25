package com.gourianova.binocularvision;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "User")
@Table(
        name ="users",
        uniqueConstraints ={
@UniqueConstraint(name = "users_email_unique", columnNames = "email")
        }
)

public class User{
    @Id
    @SequenceGenerator(
            name ="users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
@GeneratedValue(
        strategy = SEQUENCE,
        generator ="users_sequence"
)
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String login;
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )

    private String password;
    //private String firstName;
    //private String lastName;

    @Column(
            name = "role_id"
    )

    private int roleId;

/*private User user;
    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Role>  roles = new ArrayList<>();
*/
    public User(int id, String login, String password,
                //String firstName,
                //String lastName,
                int roleId) {
        this.id = id;
      //  this.firstName = firstName;
      //  this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

/*    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
*/
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() &&
//                Objects.equals(getFirstName(), user.getFirstName()) &&
 //               Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                getRoleId() == user.getRoleId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),
                //getFirstName(), getLastName(),
                getLogin(), getPassword(), getRoleId());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                //", firstName='" + firstName + '\'' +
                //", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                "} " + super.toString();
    }
}
