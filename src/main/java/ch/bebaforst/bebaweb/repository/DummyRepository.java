package ch.bebaforst.bebaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.bebaforst.bebaweb.model.Dummy;

public interface DummyRepository extends JpaRepository<Dummy, Long> {
}
