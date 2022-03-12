package app.services;

import app.dataSources.TransactionsData;
import app.dto.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionsServiceTest {

    TransactionsService transactionsService;

    @BeforeEach
    public void setUp() {
        transactionsService = new TransactionsService(initializeTransactionData());
    }

    @Test
    public void whenGetTransactionByTypeThenReturnTransactions() {
        List<Long> result = transactionsService.getTransactionByType("auto");
        assertEquals(3, result.size());
    }

    @Test
    public void whenGetTransactionByTypeAndThereIsntThenReturnTransactionsEmpty() {
        List<Long> result = transactionsService.getTransactionByType("tele");
        assertEquals(0, result.size());
    }

    @Test
    public void whenGetTransactionSumByParentIdThenReturnSum() {
        Double result = transactionsService.getTransactionSumByParentId(2L);
        assertEquals(3000D, result);
    }

    @Test
    public void whenGetTransactionSumByParentIdTAndThereIsntParentThenReturnSumZero() {
        Double result = transactionsService.getTransactionSumByParentId(3L);
        assertEquals(0D, result);
    }

    @Test
    public void whenSaveTransactionThenInsertInTransactionData() {
        Transaction t = new Transaction();
        t.setAmount(4000D);
        t.setParentId(2L);
        t.setType("prueba");
        transactionsService.saveTransaction(10L,t );
        assertEquals(6, getTransactionData().getTransactions().size());
    }

    private TransactionsData initializeTransactionData(){
        TransactionsData td = new TransactionsData();
        for (long i = 0 ; i < 3 ; i++){
            Transaction t = new Transaction();
            t.setId(i);
            t.setAmount(1000D);
            t.setParentId(2L);
            t.setType("auto");
            td.getTransactions().add(t);
        }

        for (long i = 0 ; i < 2 ; i++){
            Transaction t = new Transaction();
            t.setId(i);
            t.setAmount(2000D);
            t.setParentId(1L);
            t.setType("casa");
            td.getTransactions().add(t);
        }

        return td;
    }

    private TransactionsData getTransactionData(){
        return transactionsService.getTransactionsData();
    }
}
