package app.controllers;

import app.dataSources.TransactionsData;
import app.dto.Transaction;
import app.services.TransactionsService;
import io.jooby.StatusCode;
import io.jooby.annotations.GET;
import io.jooby.annotations.PUT;
import io.jooby.annotations.Path;
import io.jooby.annotations.PathParam;
import io.jooby.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.jooby.StatusCode.OK_CODE;


@Path("/transactions")
public class TransactionsController {
  private TransactionsService transactionsService;

  public TransactionsController(TransactionsService transactionsService) {
    this.transactionsService = transactionsService;
  }

  @GET
  @Path("/types/{type}")
  public List<Long> getTransaction(@PathParam String type) {
     List<Long> idsTransactions = transactionsService.getTransactionByType(type);
     return idsTransactions;
  }

  @GET
  @Path("/sum/{parentId}")
  public Map<String, Double>  getTransaction(@PathParam Long parentId) {
    Map<String, Double> response = new HashMap<>();
    Double sum = transactionsService.getTransactionSumByParentId(parentId);
    response.put("sum", sum);
    return response;
  }

  @PUT
  @Path("/{id}")
  public void addTransaction(@PathParam Long id, Context context) {
    Transaction transaction = context.body(Transaction.class);
    transactionsService.saveTransaction(id,transaction);
  }

}
