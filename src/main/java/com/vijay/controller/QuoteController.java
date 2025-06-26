package com.vijay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.dto.QuoteRequestDto;
import com.vijay.payload.ApiResponse;
import com.vijay.payload.PageResponse;
import com.vijay.payload.QuoteApiResponse;
import com.vijay.service.QuoteService;

@RestController
@RequestMapping("/user/quote")

public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    // create a new quote
    @PostMapping
    public ResponseEntity<ApiResponse<QuoteRequestDto>> submitQuote(@RequestBody QuoteRequestDto dto) {
    	
    	QuoteRequestDto qrt=   quoteService.saveQuote(dto);
        
        return ResponseEntity.ok(
            new ApiResponse<>(true, "Quote submitted successfully!",qrt)
        );
    }
    
    
    //  get all quote
    @GetMapping("/all")
    public ResponseEntity<QuoteApiResponse<PageResponse<QuoteRequestDto>>> getAllQuotes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        PageResponse<QuoteRequestDto> response = quoteService.getAllQuotesPaged(page, size, sortBy, sortDir);
        return ResponseEntity.ok(new QuoteApiResponse<>(true, "Quotes fetched successfully!", response));
    }

    // delete quote by id
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteQuote(@PathVariable Long id) {
        quoteService.deleteQuote(id);
        return ResponseEntity.ok(new ApiResponse<>(true, "Quote deleted successfully!", null));
    }

}
