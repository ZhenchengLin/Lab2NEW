# **Lab Two**

## Part One  
### Code for [**StringServer**](StringServer.java) 
```
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> s = new ArrayList<>();
    

    public String handleRequest(URI url) 
    {
        if (url.getPath().equals("/")) 
        {
            String words = "";
            if(s.size() == 0)
            {
                return String.format("Nothing added yet.");
            }
            for(String word : s)
            {
                words += "\n" + word ;
            }
            return String.format(words);
        } 
        else if (url.getPath().equals("/add")) 
        {
            if (url.getQuery().contains("s")) 
            {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s"))
                 {
                    s.add(parameters[1]);
                    return "Added.";
                }
            }
            return "add?";
        }
        else if (url.getPath().equals("/search")) 
        {
            String words = "Added words are listed below: \n";
            if(s.size() != 0)
            {
                for(String word : s)
                {
                    words += "\n" + word ;
                }
                return String.format(words);
            }
            return "Not added anything yet";
        }
        else if (url.getPath().equals("/add-message")) 
        {
            if (url.getQuery().contains("s")) 
            {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s"))
                 {
                    s.add(parameters[1]);
                    return "Added.";
                }
            }
            return "Error! did not add";
        }
         else 
        {
            return "404 Not Found!";
        }
    }
}


public class StringServer 
{
    public static void main(String[] args) throws IOException {
    if(args.length == 0){
        System.out.println("Missing port number! Try any number between 1024 to 49151");
        return;
    }

    int port = Integer.parseInt(args[0]);

    Server.start(port, new Handler());
    }
}
```
#### *Using the /add-message*
-> The following two screenshot is calling the method in StringServer.java class.  
Inside that class I have lots of different If statment that use to read the URL.  
Then one of the if statement is use to check did we type add-message in URL then  
the method take in the variable and store in the array list.  
- <img width="743" alt="image" src="https://github.com/ZhenchengLin/Lab2NEW/assets/130115215/b25562ed-7778-48e6-b26c-b8c5d54baad5">  

- <img width="743" alt="image" src="https://github.com/ZhenchengLin/Lab2NEW/assets/130115215/692a5a13-137c-4279-8b37-23d271ba710c">

*Which is this part of the code*  
- <img width="461" alt="image" src="https://github.com/ZhenchengLin/Lab2NEW/assets/130115215/0730c9ac-8b35-49ee-8528-46c9420e5036">

->Reading above code: In the `else if` we use `url.getPath().equals()` to check if the path is the path that we want to use.  
Then I use another if statment to check if the Query is starting with `s` and there are a `=` after it.  
Using the following method: `url.getQuery().contains("s")` which `s` is what we want.  
**Warning** we will not be using `equals()` to check because we juse want to make sure it has a s starting  
Later we split the Query with method `split()` then added to the array list `s`.  
This code will return `"Error! did not add"` if we didn't have s in Query.

**If we use equal when we checking `s` form the Query**.  
<img width="461" alt="image" src="https://github.com/ZhenchengLin/Lab2NEW/assets/130115215/38b51ebb-64d0-4644-abdf-ae2e9f6464b0">
<img width="519" alt="image" src="https://github.com/ZhenchengLin/Lab2NEW/assets/130115215/52b40532-b0ed-4ccc-a7f0-9c1f49e55cbd">  

#### *After Added All The Message*
In our main page of the websit we will have the messages we added.  
<img width="519" alt="image" src="https://github.com/ZhenchengLin/Lab2NEW/assets/130115215/fa110fd2-c525-4737-8155-87598a86975e">
Which is matching the following code:
<img width="515" alt="image" src="https://github.com/ZhenchengLin/Lab2NEW/assets/130115215/c82a0861-239f-40ae-848f-add1ac062545">  
I use the same Idea of checking the path; which is checking see if the path have anything in it.  
When we checked we are in the main page, we start checking if we added any message or words yet.  
If we checked that we have something in the arrayList that we use to added message in, then  
we use a loop to print out all the words thats in the ArrayList which call `s`.  


## Part two
### Failure inducing input JUnit test  
**Code**  
```
@Test
  public void testForAverageLength()
  {
    double[] input1 = { 2.0 , 2.0 , 4.0};
    assertEquals(3.0, ArrayExamples.averageWithoutLowest(input1), 0.0001);
  }
  ```  
  **Failure**
  ```
(base) zhenchenglin@ZhenchengdeMacBook-Pro lab3 % javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
(base) zhenchenglin@ZhenchengdeMacBook-Pro lab3 % java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore ArrayTests
JUnit version 4.13.2
.....E
Time: 0.006
There was 1 failure:
1) testForAverageLength(ArrayTests)
java.lang.AssertionError: expected:<3.0> but was:<2.0>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:555)
        at org.junit.Assert.assertEquals(Assert.java:685)
        at ArrayTests.testForAverageLength(ArrayTests.java:39)

FAILURES!!!
Tests run: 5,  Failures: 1
```  
### Input that does not induce failure JUnit test  
**Code**  
```
 @Test
  public void testForAverageLength2()
  {
    double[] input1 = { 2.0 , 3.0 , 4.0};
    assertEquals(3.5, ArrayExamples.averageWithoutLowest(input1), 0.0001);
  }
  ```
**Passed** Which it does not fail
```
(base) zhenchenglin@ZhenchengdeMacBook-Pro lab3 % javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java                              
(base) zhenchenglin@ZhenchengdeMacBook-Pro lab3 % java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore ArrayTests
JUnit version 4.13.2
......E
Time: 0.007
There was 1 failure:
1) testForAverageLength(ArrayTests)
java.lang.AssertionError: expected:<3.0> but was:<2.0>
        at org.junit.Assert.fail(Assert.java:89)
        at org.junit.Assert.failNotEquals(Assert.java:835)
        at org.junit.Assert.assertEquals(Assert.java:555)
        at org.junit.Assert.assertEquals(Assert.java:685)
        at ArrayTests.testForAverageLength(ArrayTests.java:39)

FAILURES!!!
Tests run: 6,  Failures: 1
```  
### Here is a picture of running both test
<img width="1049" alt="image" src="https://github.com/ZhenchengLin/Lab2NEW/assets/130115215/1fd9d6cb-13d5-4b91-b57a-d97838227d2b">  

### This is the code before fix
```
  static double averageWithoutLowest(double[] arr) {
    if(arr.length < 2) { return 0.0; }
    double lowest = arr[0];
    for(double num: arr) {
      if(num < lowest) { lowest = num; }
    }
    double sum = 0;
    for(double num: arr) {
      if(num != lowest) { sum += num; }
    }
    return sum / (arr.length - 1);
  }

```

### This is a fixed code
```
  static double averageWithoutLowest(double[] arr) {
    if(arr.length < 2) { return 0.0; }
    double lowest = arr[0];
    for(double num: arr) {
      if(num < lowest) { lowest = num; }
    }
    double sum = 0;
    boolean checkLow = false;
    for(double num: arr) {
      if(num == lowest && checkLow == false) 
      { 
        checkLow = true;
      }
      else{
        sum += num;
      }
    }
    return sum / (arr.length - 1);
  }
```
**Just want to make it clear to see**  
```
if(num == lowest && checkLow == false) 
      { 
        checkLow = true;
      }
```
I added this in the middle of the code.  

**Before the code was fixed it has a wrong behavir that will not add all the smallest number.**  
**Which it should not happen, therefore I added a checker in the second loop for making sure that the will only kick out the smallest number once in the loop**  

## Part Three
I have learn using assertEquals in cse 12 but I have learn many new stuff!!  
One importent thing I think it is extramly important is the use of Git hub.  
Another stuff that I think is also important is the skills of making webs.  
