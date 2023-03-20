package untitled.domain;

import java.util.*;
import lombok.*;
import untitled.domain.*;
import untitled.infra.AbstractEvent;

@Data
@ToString
public class Fileindexed extends AbstractEvent {

    private Long id;

    public Fileindexed(Index aggregate) {
        super(aggregate);
    }

    public Fileindexed() {
        super();
    }
}
