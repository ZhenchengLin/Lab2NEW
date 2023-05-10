# **Lab Two**

## Part One  
### Code for [**StringServer**](StringServer.java)  
#### Using the /add-message
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
Using the following method: `url.getQuery().contains("s")` **Warning** we will not be using `equals()` to check because we juse want to make sure it has a s starting  
Later we split the Query with method `split()` then added to the array list `s`.  
This code will return `"Error! did not add"` if we didn't have s in Query.

**If we use equal when we checking `s` form the Query**.  


## Part two
In week 3 lab, we have been woking on fixing bugs and learning how to use eclipse. 

One of the bug that we have to fix is below..  
![Image](2LabC.png)  
Reading the implementation, I notice that this code will not add all numbers thats equals to the lowest number which is buggy. Later I added a checker to clear the bug.

## Part Three
I have learn using assertEquals in cse 12 but I have learn many new stuff!!  
One importent thing I think it is extramly important is the use of Git hub.  
Another stuff that I think is also important is the skills of making webs.  
