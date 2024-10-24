package fiap.checkpoint.service;

import fiap.checkpoint.DTO.OrderServiceDTO;
import fiap.checkpoint.model.OrderServiceModel;
import fiap.checkpoint.model.ReservationRoom;
import fiap.checkpoint.model.ServiceModel;
import fiap.checkpoint.repository.OrderServiceRepository;
import fiap.checkpoint.repository.ReservationRoomRepository;
import fiap.checkpoint.repository.ServiceRepository;
import jakarta.persistence.EntityNotFoundException;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class OrderServiceService {

    private OrderServiceRepository orderServiceRepository;

    private ReservationRoomRepository reservationRoomRepository;

    private ServiceRepository serviceRepository;

    public OrderServiceService(OrderServiceRepository orderServiceRepository, ReservationRoomRepository reservationRoomRepository, ServiceRepository serviceRepository) {
        this.orderServiceRepository = orderServiceRepository;
        this.reservationRoomRepository = reservationRoomRepository;
        this.serviceRepository = serviceRepository;
    }

    public OrderServiceDTO createOrderService(LocalDate date, Long reservationRoomId, List<Long> serviceIds) {
        ReservationRoom reservationRoom = reservationRoomRepository.findById(reservationRoomId).orElseThrow(()-> new EntityNotFoundException("ReservationRoom not found"));

        List<ServiceModel> serviceModelList = new ArrayList<>();
        serviceIds.forEach(serviceId -> {
            ServiceModel serviceModelFounded  = serviceRepository.findById(serviceId)
                    .orElseThrow(()-> new EntityNotFoundException("Service not found"));

            serviceModelList.add(serviceModelFounded);
        });

        OrderServiceModel orderServiceToBeSaved = new OrderServiceModel(date, reservationRoom, serviceModelList);

        return convertToDTO(orderServiceRepository.save(orderServiceToBeSaved));
    }

    public OrderServiceDTO convertToDTO(OrderServiceModel orderServiceModel){
        return new OrderServiceDTO(orderServiceModel.getId(),
                orderServiceModel.getDate(),
                orderServiceModel.getReservationRoom().getId(),
                orderServiceModel.getService().stream().map(ServiceModel::getId).toList());
    }
}
