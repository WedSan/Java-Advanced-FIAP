package fiap.checkpoint.repository;

import fiap.checkpoint.model.OrderServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderServiceModel, Long> {
}
