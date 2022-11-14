package io.github.wemersonwalcley.CadastroDeUsuarios.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Getter
@Setter
@ToString
@Table(name="tb_account")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotEmpty(message = "Campo usuário é obrigatório.")
    private String username;

    @Column
    @NotEmpty(message = "Campo senha é obrigatório.")
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Account account = (Account) o;
        return getId() != null && Objects.equals(getId(), account.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
