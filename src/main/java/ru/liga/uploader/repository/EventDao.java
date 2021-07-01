package ru.liga.uploader.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.liga.uploader.entity.Event;

import java.util.List;

public interface EventDao extends JpaRepository<Event, Long> {

    @Query(value = "Select *\n" +
            "FROM si.events e\n " +
            "WHERE e.request_subtype_id = 96\n" +
            "  AND (e.event_id >= 115554512 AND e.event_id <= 115584206)\n" +
            "  AND e.rejected_flag is null\n" +
            "  AND e.status = 'PROCESSED'", nativeQuery = true)
    List<Event> findAllByParams ();

}
