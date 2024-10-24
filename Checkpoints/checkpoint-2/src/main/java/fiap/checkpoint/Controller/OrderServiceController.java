package fiap.checkpoint.Controller;

import fiap.checkpoint.DTO.AddOrderServiceDTO;
import fiap.checkpoint.DTO.OrderServiceDTO;
import fiap.checkpoint.service.OrderServiceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service")
public class OrderServiceController {

    private OrderServiceService orderServiceService;

    public OrderServiceController(OrderServiceService orderServiceService) {
        this.orderServiceService = orderServiceService;
    }

    @PostMapping
    public ResponseEntity<OrderServiceDTO> createOrderService(@RequestBody @Valid AddOrderServiceDTO request){
        OrderServiceDTO response =  orderServiceService.createOrderService(request.date(),
                request.reservationRoomId(),
                request.serviceId());
        return ResponseEntity.ok(response);
    }


}
