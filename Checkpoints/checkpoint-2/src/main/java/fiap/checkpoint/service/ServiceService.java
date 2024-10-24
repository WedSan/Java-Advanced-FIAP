package fiap.checkpoint.service;

import fiap.checkpoint.DTO.ServiceDTO;
import fiap.checkpoint.model.ServiceModel;
import fiap.checkpoint.repository.OrderServiceRepository;
import fiap.checkpoint.repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ServiceService {

    private ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ServiceDTO createService(String description, BigDecimal price) {
        ServiceModel service = new ServiceModel(description, price);
        return convertToDTO(serviceRepository.save(service));
    }

    public ServiceDTO convertToDTO(ServiceModel service){
        return new ServiceDTO(service.getId(), service.getDescription(), service.getPrice());
    }


}
