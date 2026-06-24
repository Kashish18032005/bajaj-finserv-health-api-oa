package com.chitkara.bfhl;

import com.chitkara.bfhl.dto.BfhlRequest;
import com.chitkara.bfhl.dto.BfhlResponse;
import com.chitkara.bfhl.service.BfhlServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BfhlControllerTest {

    private final BfhlServiceImpl bfhlService = new BfhlServiceImpl();

    @Test
    public void testExampleA() {
        BfhlRequest request = new BfhlRequest();
        request.setData(Arrays.asList("a", "1", "334", "4", "R", "$"));

        BfhlResponse response = bfhlService.processData(request);

        assertTrue(response.isSuccess());
        assertEquals(Arrays.asList("1"), response.getOddNumbers());
        assertEquals(Arrays.asList("334", "4"), response.getEvenNumbers());
        assertEquals(Arrays.asList("A", "R"), response.getAlphabets());
        assertEquals(Arrays.asList("$"), response.getSpecialCharacters());
        assertEquals("339", response.getSum());
        assertEquals("Ra", response.getConcatString());
    }

    @Test
    public void testExampleB() {
        BfhlRequest request = new BfhlRequest();
        request.setData(Arrays.asList("2", "a", "y", "4", "&", "-", "*", "5", "92", "b"));

        BfhlResponse response = bfhlService.processData(request);

        assertTrue(response.isSuccess());
        assertEquals(Arrays.asList("5"), response.getOddNumbers());
        assertEquals(Arrays.asList("2", "4", "92"), response.getEvenNumbers());
        assertEquals("103", response.getSum());
        assertEquals("ByA", response.getConcatString());
    }

    @Test
    public void testExampleC() {
        BfhlRequest request = new BfhlRequest();
        request.setData(Arrays.asList("A", "ABCD", "DOE"));

        BfhlResponse response = bfhlService.processData(request);

        assertTrue(response.isSuccess());
        assertTrue(response.getOddNumbers().isEmpty());
        assertTrue(response.getEvenNumbers().isEmpty());
        assertEquals("0", response.getSum());
        assertEquals("EoDdCbAa", response.getConcatString());
    }
}
