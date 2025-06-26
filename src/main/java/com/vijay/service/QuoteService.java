package com.vijay.service;

import java.util.List;

import com.vijay.dto.QuoteRequestDto;
import com.vijay.payload.PageResponse;

public interface QuoteService {
	
	
    QuoteRequestDto saveQuote(QuoteRequestDto dto);
    
    PageResponse<QuoteRequestDto> getAllQuotesPaged(int page, int size, String sortBy, String sortDir);

    void deleteQuote(Long id);

    
}
