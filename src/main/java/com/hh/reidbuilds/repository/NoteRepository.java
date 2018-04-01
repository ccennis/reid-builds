package com.hh.reidbuilds.repository;

/**
 * Created by cennis on 3/25/18.
 */
import com.hh.reidbuilds.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
