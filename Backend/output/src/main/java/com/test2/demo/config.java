package com.test2.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class config {
@RequestMapping("/hello")
public String hello()
{
	return "IT WORKED, forgot to add @RestController.... sigh";
}

}

