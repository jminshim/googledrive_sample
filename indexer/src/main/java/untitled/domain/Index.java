package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import untitled.IndexerApplication;
import untitled.domain.Fileindexed;

@Entity
@Table(name = "Index_table")
@Data
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileId;

    private String keywords;

    @PostPersist
    public void onPostPersist() {
        Fileindexed fileindexed = new Fileindexed(this);
        fileindexed.publishAfterCommit();
    }

    public static IndexRepository repository() {
        IndexRepository indexRepository = IndexerApplication.applicationContext.getBean(
            IndexRepository.class
        );
        return indexRepository;
    }

    public static void indexFile(Fileuploaded fileuploaded) {
        /** Example 1:  new item 
        Index index = new Index();
        repository().save(index);

        Fileindexed fileindexed = new Fileindexed(index);
        fileindexed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileuploaded.get???()).ifPresent(index->{
            
            index // do something
            repository().save(index);

            Fileindexed fileindexed = new Fileindexed(index);
            fileindexed.publishAfterCommit();

         });
        */

    }
}
