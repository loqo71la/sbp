package dev.loqo71la.bp.transaction.controller;

import dev.loqo71la.bp.transaction.model.Transaction;
import dev.loqo71la.bp.transaction.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static dev.loqo71la.bp.transaction.util.TransactionUtil.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@AutoConfigureMockMvc
public class GetTransactionTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionRepository repository;

    private Page<Transaction> buildPage(Pageable pageable, int total, Transaction... transactions) {
        return new PageImpl<>(List.of(transactions), pageable, total);
    }

//    @ParameterizedTest
//    @CsvSource({"'',0", "'',2"})
    public void Get_WithoutParamsAndTransactions_ReturnsEmptyPage(String param, int total) throws Exception {
        // Arrange
        var pageable = PageRequest.of(0, 50);
        var transactions = new Transaction[total];
        Arrays.fill(transactions, empty());
        var page = buildPage(pageable, total, transactions);
        when(repository.findAll(pageable)).thenReturn(page);

        // Act
        var url = new StringBuilder("/api/transaction");
        if (param != null) url.append(param);
        ResultActions result = mockMvc.perform(get(url.toString()));

        // Assert
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(4)))
                .andExpect(jsonPath("$.totalItem", is(total)))
                .andExpect(jsonPath("$.totalPage", is(1)))
                .andExpect(jsonPath("$.currentPage", is(1)))
                .andExpect(jsonPath("$.items.*", is(0)));

        verify(repository).findAll(pageable);
    }

//    @Test
    public void Get_WithoutFilters_ReturnsTransactionPage() throws Exception {
        // Arrange
        var pageable = PageRequest.of(0, 50);
        var page = buildPage(pageable, 2, empty(), empty());
        when(repository.findAll(pageable)).thenReturn(page);

        // Act
        ResultActions result = mockMvc.perform(get("/api/transaction"));

        // Assert
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(4)))
                .andExpect(jsonPath("$.totalItem", is(2)))
                .andExpect(jsonPath("$.totalPage", is(1)))
                .andExpect(jsonPath("$.currentPage", is(1)))
                .andExpect(jsonPath("$.items.*", is(2)));

        verify(repository).findAll(pageable);
    }
}
