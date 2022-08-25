package com.Veggies.Register.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Vegetable not found")
public class Usernotfound extends Exception{
}
