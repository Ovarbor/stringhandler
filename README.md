## String Handler
Backend service for handling strings.


### Functional:
String Handler accept a string in JSON format as request, like:

{
"string": "Hello"
}

and gives as a response which letters and in what quantity are included in the string in descending order of number
of occurrences, as JSON format also, like:

{
"l": 2,
"H": 1,
"e": 1,
"o": 1
}

### Request Requirements

You can use only small and capital letters of the English alphabet, also the length of string should be more than five 
and less than twenty-five, no characters or spaces are allowed.

### System requirements:
JDK 11 amazon corretto  
IntellijIdea

### Startup instructions:
1. Download zip-file
2. Unpack zip-file
3. Open app in IntellijIdea
4. mvn clean package
5. test app in IntellijIdea from test package
6. run app from main class
7. run postman-client, import test file from postman package to postman-client
8. test app with postman tests