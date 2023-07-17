package dev.loqo71la.bp.mapper;

import dev.loqo71la.bp.dto.TransactionDto;
import dev.loqo71la.bp.model.Transaction;
import dev.loqo71la.bp.model.TransactionType;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class TransactionMapper implements Mapper<TransactionDto, Transaction> {

    @Override
    public TransactionDto toDto(Transaction model) {
        return new TransactionDto(
                model.getId(),
                model.getAccount().getId(),
                model.getType().getLabel(),
                model.getValue()
        );
    }

    @Override
    public Transaction toModel(TransactionDto dto) {
        var model = new Transaction();
        model.setValue(dto.value());
        model.setType(TransactionType.valueOfLabel(dto.type()));
        model.setDate(Date.valueOf(LocalDate.now()));
        return model;
    }
}
