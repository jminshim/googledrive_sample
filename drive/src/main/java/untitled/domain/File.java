package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.DriveApplication;
import untitled.domain.Fileuploaded;

@Entity
@Table(name = "File_table")
@Data
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String pathh;

    private String type;

    private Integer size;

    @PostPersist
    public void onPostPersist() {
        Fileuploaded fileuploaded = new Fileuploaded(this);
        fileuploaded.publishAfterCommit();
    }

    public static FileRepository repository() {
        FileRepository fileRepository = DriveApplication.applicationContext.getBean(
            FileRepository.class
        );
        return fileRepository;
    }
}
