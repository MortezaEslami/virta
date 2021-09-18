package com.devolon.virta.service.iservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPublicService<I, ID, C, U> {

    I get(ID id);

    Page<I> list(Pageable pageable);

    I create(C request);

    I update(ID id, U request);

    void delete(ID id);
}
