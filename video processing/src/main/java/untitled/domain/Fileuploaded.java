package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Fileuploaded extends AbstractEvent {

    private Long id;
    private String name;
    private String path;
    private String type;
}
