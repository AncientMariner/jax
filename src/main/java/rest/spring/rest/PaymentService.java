package rest.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.spring.transaction.TransactionBo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Component
@Path("/payment")
public class PaymentService {
    @Autowired
    TransactionBo transactionBo;

    @GET
    @Path("/save")
    public Response savePayment() {
        String result = transactionBo.save();
        return Response.status(200).entity(result).build();
    }
}
