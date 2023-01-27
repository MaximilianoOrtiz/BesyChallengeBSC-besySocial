package com.bczchallenge.socialbesy.domain.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.awt.*;
import java.lang.annotation.Repeatable;

@Entity
@Table(name = "COMPRADOR")
@PrimaryKeyJoinColumn(name = "vendedor_id")
public class Comprador extends Usuario{

    List<> venderores;

}
