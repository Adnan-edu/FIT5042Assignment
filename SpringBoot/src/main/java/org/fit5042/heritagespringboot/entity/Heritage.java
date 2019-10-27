package org.fit5042.heritagespringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Heritage implements Serializable {
    private int heritageId;
    private String authority;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
