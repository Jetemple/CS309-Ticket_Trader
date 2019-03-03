package io.pp1.logos;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LogoRepository extends JpaRepository<Logo, String> {

}
