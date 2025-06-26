package com.vijay.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vijay.dto.QuoteRequestDto;
import com.vijay.entity.Quote;
import com.vijay.payload.PageResponse;
import com.vijay.repository.QuoteRepository;


@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository quoteRepository;

    @Override
    public QuoteRequestDto saveQuote(QuoteRequestDto dto) {
        Quote quote =new Quote();
            quote.setId(dto.getId());
            quote.setName(dto.getName());
            quote.setEmail(dto.getEmail());
            quote.setPhone(dto.getPhone());
            quote.setService(dto.getService());
            quote.setMessage(dto.getMessage());
        		
               

            Quote q=  quoteRepository.save(quote);
            QuoteRequestDto qrt=new QuoteRequestDto();
            qrt.setId(q.getId());
            qrt.setName(q.getName());
            qrt.setEmail(q.getEmail());
            qrt.setPhone(q.getPhone());
            qrt.setService(q.getService());
            qrt.setMessage(q.getMessage());
            
            return qrt;
            
    }
    
    public PageResponse<QuoteRequestDto> getAllQuotesPaged(int page, int size, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Quote> quotePage = quoteRepository.findAll(pageable);

        List<QuoteRequestDto> content = quotePage.getContent().stream()
                .map(quote -> new QuoteRequestDto(
                		quote.getId(),
                        quote.getName(),
                        quote.getEmail(),
                        quote.getPhone(),
                        quote.getService(),
                        quote.getMessage()
                )).toList();

        return new PageResponse<>(
                content,
                quotePage.getNumber(),
                quotePage.getSize(),
                quotePage.getTotalElements(),
                quotePage.getTotalPages(),
                quotePage.isLast()
        );
    }
    
    @Override
    public void deleteQuote(Long id) {
        quoteRepository.findById(id).orElseThrow(() ->
            new RuntimeException("Quote not found with ID: " + id)
        );
        quoteRepository.deleteById(id);
    }


    
    
}

