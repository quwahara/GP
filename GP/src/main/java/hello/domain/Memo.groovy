package hello.domain

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Memo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(nullable = false, unique = true, updatable = false)
    Long id

    @Column(nullable = false)
    String text

    @Column(nullable = false)
    Date creationDate

}
