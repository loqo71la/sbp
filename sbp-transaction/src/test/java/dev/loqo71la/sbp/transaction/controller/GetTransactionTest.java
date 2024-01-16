package dev.loqo71la.sbp.transaction.controller;

import dev.loqo71la.sbp.transaction.model.Transaction;
import dev.loqo71la.sbp.transaction.repository.TransactionRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GetTransactionTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionRepository repository;

    @Mock
    private Page<Transaction> transactionPage;

    @ParameterizedTest
    @CsvSource({"'','',0", "'5','10',4", "'0','0',0", "'-5','-10',0"})
    public void Get_WithoutTransactions_ReturnsAnEmptyPagination(String page,
                                                                 String limit,
                                                                 int expectedPage) throws Exception {
        // Arrange
        when(transactionPage.getNumber()).thenReturn(expectedPage);
        when(transactionPage.getContent()).thenReturn(List.of());
        when(transactionPage.getTotalElements()).thenReturn(0L);
        when(transactionPage.getTotalPages()).thenReturn(1);
        when(repository.findAll(any(Pageable.class))).thenReturn(transactionPage);

        // Act
        ResultActions result = mockMvc.perform(get("/api/transactions")
                .param("page", page)
                .param("limit", limit));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(4)))
                .andExpect(jsonPath("$.totalItems", is(0)))
                .andExpect(jsonPath("$.totalPages", is(1)))
                .andExpect(jsonPath("$.currentPage", is(expectedPage + 1)))
                .andExpect(jsonPath("$.items.*", hasSize(0)));

        verify(repository).findAll(any(Pageable.class));
    }
}
