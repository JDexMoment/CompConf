package Repository;

import Model.Complect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComplectRepository  extends JpaRepository<Complect,Long> {

}
