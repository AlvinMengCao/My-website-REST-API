##Synopsis
Build a remote deploied restful API service with dropwizard. I use this seperate service to serve my personal website: www.alvinmc.com. By doing so, I can totally divide my web project into front-end (with jQuery and AngularJS) and back-end( Java). Contians 4 resources, which need different fields. Use remote MySQL database with Hibernate framework and 3cp0 connection pool. 

####Base domain: alvin-api.herokuapp.com/application
####Resources: 
###### BlogResource(title, url): /blogs
###### SkillResource(title, content> :/skills
###### StatusResource(content): /status 
###### WebSiteResource(email, comment): /website-resources

###RESTful pattern:
###### GET:  /{id}
###### Get all :/
###### POST: /{id}
###### PUT: /{id}
###### DELETE:/{id}
###### DELETE last:/
