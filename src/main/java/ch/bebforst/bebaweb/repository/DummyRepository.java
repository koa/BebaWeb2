package ch.bebforst.bebaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.bebforst.bebaweb.model.Dummy;

public interface DummyRepository extends JpaRepository<Dummy, Long> {
}
