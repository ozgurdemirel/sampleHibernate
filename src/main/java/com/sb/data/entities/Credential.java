package com.sb.data.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Data
@EqualsAndHashCode
@ToString
@Table(name = "CREDENTIAL")
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CREDENTIAL_ID")
    private Long credentialId;

    @OneToOne(cascade = CascadeType.ALL)//when we persist a credential we olsa want to persist a user.
    @JoinColumn(name="USER_ID")
    public User user;

    @Column(name="USERNAME")
    private String username;

    @Column(name="PASSWORD")
    private String password;

}
