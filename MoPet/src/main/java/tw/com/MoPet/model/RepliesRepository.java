package tw.com.MoPet.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepliesRepository extends JpaRepository<Replies,Integer>{



	public Replies findFirstByOrderByCreateondateDesc();
	
	@Query(value="select count(*) from Replies where fk_c_id=:id",nativeQuery=true)
	public Integer countMessage(Integer id);


	


}
