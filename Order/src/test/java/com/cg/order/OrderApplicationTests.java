package com.cg.order;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.order.exception.InvalidOrderId;
import com.cg.order.model.Orders;
import com.cg.order.repo.OrderRepo;
import com.cg.order.service.OrderService;
import com.cg.order.service.OrderServiceImpl;

@SpringBootTest
class OrderApplicationTests {

	@Test
	void contextLoads() {
	}

    @Mock private OrderRepo repo;
    @InjectMocks private OrderService services = new OrderServiceImpl();

    @Test
    void testToGetOrders() throws InvalidOrderId {
        int OrdersId = 232;
        Orders orders = new Orders(2,"ls",9,9);	
        
        when(repo.findById(OrdersId)).thenReturn(Optional.of(orders));
        
        assertEquals("ls", services.getById(OrdersId).getCustomerName());
   
    }

}
	
	
	

