# user-Authentication-for-sso

1. Run the spring boot application. It will start tomcat on localhost port 8080

2. From postman fire the POST URL(localhost:8080/auth) with json body as below 
{
"username" : "admin",
"password" : "admin"
}
In request you will receive token valid for 5 minutes.

3. From postman firth the GET URL(localhost:8080/test) with Authorization type as "Bearer token"
If request fired within 5 minutes of token expiration you will get response as "Welcome to the Java World..!!"
else message will be displayed "Not a valid token or token expired"

4. User can generate token any number of times, if generated within expiry of previous token then after generation of new token earlier token will be marked as invalid.
