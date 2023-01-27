package com.bczchallenge.socialbesy.domain.models;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity()
@Table(name = "VENDEDOR")
@PrimaryKeyJoinColumn(name = "vendedo_id")
public class Vendedor extends Usuario{

}
