# **Lab Two**

## Part One  
### Code for [**StringServer**](StringServer.java)  
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


## Part Three
I have learn using assertEquals in cse 12 but I have learn many new stuff!!  
One importent thing I think it is extramly important is the use of Git hub.  
Another stuff that I think is also important is the skills of making webs.  
