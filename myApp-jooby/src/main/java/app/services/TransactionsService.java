package app.services;

import app.dataSources.TransactionsData;
import app.dto.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionsService {

    private TransactionsData transactionsData;

    public TransactionsService(TransactionsData transactionsData) {
        this.transactionsData = transactionsData;
    }

    public List<Long> getTransactionByType(String type){
        List<Long> idsTransactions = new ArrayList<>();

        for (Transaction transaction : transactionsData.getTransactions()){
            if (type.equalsIgnoreCase(transaction.getType())){
                idsTransactions.add(transaction.getId());
            }
        }

        return idsTransactions;
    }

    public Double getTransactionSumByParentId(Long parentId){
        Double sumAmount = 0D;

        for (Transaction transaction : transactionsData.getTransactions()){
            if (parentId.equals(transaction.getParentId())){
                sumAmount = sumAmount + transaction.getAmount();
            }
        }

        return sumAmount;
    }


    public TransactionsData saveTransaction(Long id, Transaction transaction){
        transaction.setId(id);
        transactionsData.getTransactions().add(transaction);
        return transactionsData;
    }

    public TransactionsData getTransactionsData() {
        return transactionsData;
    }
}
