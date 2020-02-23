package com.rissandimo.studentcms.exceptions;

public class CourseNotFoundException extends RuntimeException
{
    public CourseNotFoundException(String message)
    {
        super(message);
    }
}
