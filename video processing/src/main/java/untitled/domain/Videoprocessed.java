package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Videoprocessed extends AbstractEvent {

    private Long id;
    private String fileId;

    public Videoprocessed() {
        super();
    }
}
