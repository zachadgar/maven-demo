package com.student.demo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class AppTest {
@Test
public void testGreet() {
assertEquals("Hello, Student! Welcome to Jenkins CI.", App.greet("Student"));
}
}
