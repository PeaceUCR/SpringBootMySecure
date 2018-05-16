# SpringBoo Security In Memory Authtication

Add the spring-boot-starter-security in pom.xml

in application.properties, add spring.mvc.view.suffix=.html to render html when the view controller return the view name

Add ViewController to return /login and /home html file


Add Security Configuration security/SecureConfig.java

BCryptPasswordEncoder to encrypt the password, no this process, it will report some error,

configure(HttpSecurity httpSecurity) to configure the app http access control, login and logout url
<form class="form sign-in" action="/login" method="post">
<form action="/logout" method="post">

configureGlobal(AuthenticationManagerBuilder auth), set inMem auth with name and password and role


/****/
in the login html, we must keep the name attribute in form to submit to /login as post method, otherwise will not be reconginzed
<input type="text" name="username" />
<input type="password" name="password"/>
