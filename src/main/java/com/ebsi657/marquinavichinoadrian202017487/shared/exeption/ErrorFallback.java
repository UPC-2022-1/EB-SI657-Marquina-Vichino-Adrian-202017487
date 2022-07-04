package com.ebsi657.marquinavichinoadrian202017487.shared.exeption;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorFallback implements ErrorController {
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			if (Integer.parseInt(status.toString()) == HttpStatus.NOT_FOUND.value()) {
				return "error-404";
			}
		}
		return "error";
	}
}
