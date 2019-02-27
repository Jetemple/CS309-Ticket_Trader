package io.pp1.users;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	//Give the netid of someone, it will look it up in database and return password
	@Query(value = "SELECT password FROM user u WHERE u.net_id = ?1", nativeQuery=true)
	String getPassByNetID(String netid);
}
