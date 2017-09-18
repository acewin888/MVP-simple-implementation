# MVP-simple-implementation
simple MVP example

this app shows a simple log in page to display the structure of MVP pattern. 

I have two examples to show the difference of using MVP and not using MVP pattern.

This servers as only a simple example to help you understand the MVP pattern.

without using MVP, a lot of the logic is tied to the activity. as shown in this app, only two button logic.

so in the case of activity needs to perform many actions, the activity will be packed. it will be difficult to understand, and hard to maintain



In the MVP pattern. View(activity) does not directly talk with model(data). Instead, We create pass in the instance of activity and data in the presenter(a stage model and view interact).

Two advantages of implementating presenter: 
1: reduce the logic of activity( logic will be performed in the presenter, it will reduce lines of code in the activity)

2: data and view only interact with each other in the presenter. it will formalized the way to change logic if any changes occur.

