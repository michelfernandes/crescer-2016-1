
package br.com.crescer.aula4.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "AMIGO")
public class Amigo implements Serializable{
    
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_AMIGO")
    @SequenceGenerator(name = "SEQ_AMIGO", sequenceName = "SEQ_AMIGO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_AMIGO")
    private Long idAmigo;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_USUARIO_AMIGO")
    private Usuario usuarioAmigo;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA")
    private Date dataDataAmizade; 
    
}
