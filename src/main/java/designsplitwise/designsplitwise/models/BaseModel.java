package designsplitwise.designsplitwise.models;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) //listener will listen to the changes
public class BaseModel {
    @Id
    private long id;
    @CreatedDate
    private Date createdAt; //createdAt and updatedAt should be populated with changes
    @UpdateTimestamp
    private Date updatedAt;
}
