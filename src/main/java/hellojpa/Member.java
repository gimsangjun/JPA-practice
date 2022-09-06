package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date cereatedDate;

    private LocalDate lastModifiedDate;

    @Lob
    private String description;

    @Transient
    private int tmp_number;


}
