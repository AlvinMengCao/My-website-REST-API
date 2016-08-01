##Synopsis
Build a remote deploied restful API service with dropwizard. I use this seperate service to serve my personal website: www.alvinmc.com. By doing so, I can totally divide my web project into front-end (with jQuery and AngularJS) and back-end (mainly Java). Contians 4 resources, which need different fields. Use remote MySQL database with Hibernate framework and 3cp0 connection pool. 

##Code Example
If you have a restful clint test tool, open it, and just simply send a request to `alvin-api.herokuapp.com/application/blogcomments`
You may need to wait a few seconds since the whole hibernate framework need to be initilized.
Since you can directly use these api to manipulate my database, so I strongly recommend you just send GET request!
And you will get all of website comment data in remote database;

##Motivation
Self training and interest. Without this, my website could only be a static one. I also want to make my website as a personal community, which contains my status, blogs, my daily life, church life, work experience and job related things. ANd if this can bring me a good offer, it couldn't be better!

##Installation
Actually you don't need to install it. Just like how the code example above works, it is already a live service. If you want to download it and make it your own version, just clone it, and go to the hibernate configuration file to change the url, database driver, dial0g, password and username. 

##API Reference

Recentlly I changed some of my API.

####Base domain: 
alvin-api.herokuapp.com/application
####Resources: 
BlogResource(title, url): /blogs
SkillResource(title, content> :/skills
StatusResource(content): /status 
CommentResource(email, comment): /comments
####RESTful pattern:
###### GET:  /{id}
###### Get all :/
###### POST: /{id}
###### PUT: /{id}
###### DELETE:/{id}
###### DELETE last:/

##Tests
Use TDD to build DAO part of this project, and it already contians Unit test cases for all DAO. And I also manually test all types of request. Gonna add mock test for API and DOA.

##Contributors
Since I am not that skillful in deploying to server side, if you guys can help me re-edit the `app.yml` file, which is under java/resource, and put database information and other possible configuration varibles in it, I would be really appreciate.

##License
License? No, I don't have that. What is that for? How to get that? Should I pay money? Not sure. 

##Current task
Fufill most of functions.
