package com.example.tags;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortNumbersTag extends TagSupport {
    private String numbers;
    private String order;

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            // Convert input numbers to a list
            List<Integer> numberList = Arrays.stream(numbers.split(","))
                                             .map(String::trim)
                                             .map(Integer::parseInt)
                                             .collect(Collectors.toList());

            // Sort in specified order
            if ("desc".equalsIgnoreCase(order)) {
                Collections.sort(numberList, Collections.reverseOrder());
            } else {
                Collections.sort(numberList);
            }

            // Output sorted numbers
            out.print("<h3>Sorted Numbers (" + order.toUpperCase() + "): " + numberList + "</h3>");

        } catch (IOException | NumberFormatException e) {
            throw new JspException("Error processing numbers", e);
        }
        return SKIP_BODY;
    }
}
