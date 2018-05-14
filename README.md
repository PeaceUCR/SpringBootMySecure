# SpringBootMySecure

WorkFlow for the Spring Security 
https://stackoverflow.com/questions/23088004/spring-security-workflow

some graph form https://blog.csdn.net/code__code/article/details/53885510

Add Role.java in User(will be used in UserDetails)


SecureConfig.java

For Custom auth,AuthenticationManagerBuilder auth need a userDetailsService

So we need to implement userDetail and userDetailsService(will be call when user login)


in userDetailImpl get password should return user.getEncryptedPassword(); because the database will not store the real password

in form, we still need to set the username instead of email in the form input name
 <!-- userdetails secure will get form username from html request, even you load email in userserviceIMPL -->
 
 Spring Security Arch https://spring.io/guides/topicals/spring-security-architecture/
