# 1. What is the authentication?

Authentication is the process of verifying the identity of a user, device, or system. It usually involves validating
their identity against some sort of credentials, like a username and password. Two-factor authentication, which involves
a second step such as sending a code to a registered mobile number or email, is a common method used to increase
security. Biometric systems, such as fingerprint or facial recognition, are other examples of authentication techniques.

# 2. What is the authorization?

Authorization, on the other hand, is the process of giving an authenticated user permission to access specific resources
or perform certain actions. After a user is authenticated, the system checks what permissions that user has – for
example, whether they can access a particular web page, file, or other resources. This ensures that users only have
access to the resources they need and are authorized to use.

# 3. What is the difference between authentication and authorization?

* Authentication is about verifying who a user is, or in other words, confirming their identity. It is the first step in
  any access control system and is required before authorization can take place.

* Authorization is about verifying what a user has access to. After a user has been authenticated, the authorization
  process determines which resources the user should be allowed to access or manipulate.

# 4. What is HTTP Session?

An HTTP session is a sequence of network request-response transactions. When a user visits a web application, a session
is started. The server knows that a user is the same user throughout a session. HTTP, by design, is stateless - each
request is processed independently, without any knowledge of the requests that came before it. Session tracking is a way
to maintain state (memory) between client and server, which otherwise wouldn't remember any past requests or responses.
This is particularly useful for things like shopping carts, user logins, and any other actions that need the server to
remember actions taken by the user.

# 5. What is Cookie?

A cookie is a small piece of data that a server sends to the user's web browser. The browser may store it and send it
back with later requests to the same server. Typically, it's used to tell if two requests came from the same browser —
keeping a user logged-in, for example. Cookies are also used to remember information about the user, such as their
preferred language and other settings.

# 6. What is the difference between Session and Cookie?

* Storage Location: Sessions are usually stored on the server, while Cookies are stored on the user's browsers.

* Expiration: By default, session data is deleted when the user closes the specific browser or after a designated time
  period. On the other hand, a cookie persists even when the browser is closed and will be used in all future client
  requests until deleted or expired.

* Security: As cookies are stored in the client's browser, they are potentially exposed to greater security risks than
  session data, which resides on the server. Sensitive data should generally be stored in a session, not in a cookie.

* Capacity: Cookies are limited in size as they are sent in HTTP headers. If you have a large amount of data to store,
  it's generally better to use a session.

# 7. How do we use session and cookie to keep user information across the application?

* User logs in: When a user submits their login credentials, the server checks them against the stored values (e.g., in
  a database). If the credentials are valid, the server starts a new session for the user.

* Creating a session: The server generates a unique session ID for this session and stores it, along with any other
  necessary data (like user ID, username, etc.), in server-side storage. This could be in-memory, in a database, on
  disk, or elsewhere depending on the specific setup. This session ID serves as a key to access user-specific data for
  subsequent requests.

* Storing the session ID in a cookie: The server then sends a response back to the client with the session ID set in a
  cookie. This cookie will be included with every subsequent request from the client to the server, allowing the server
  to identify the session.

* Subsequent requests: For any subsequent requests, the server reads the session ID from the cookie, looks up the
  session data associated with this ID, and can thereby 'remember' the client and its state. For instance, it knows that
  the user is logged in and can use the stored data to personalize responses.

* Logout and expiration: When the user logs out, or after some time of inactivity (session timeout), the server
  invalidates the session, and the client deletes the session cookie.

* Remembering users across sessions: To 'remember' users across different sessions (for example, when a user checks a '
  remember me' box), you can use persistent cookies. These cookies are not deleted when the user closes the browser, but
  have a specific expiry date. They could, for instance, contain a token that can be used to re-authenticate the user in
  a new session.

# 8. What is JWT?

JWT stands for JSON Web Token. It is an open standard (RFC 7519) that defines a compact and self-contained way for
securely transmitting information between parties as a JSON object. This information can be verified and trusted because
it is digitally signed.

* Header: The header typically consists of two parts: the type of the token, which is JWT, and the signing algorithm
  being used, such as HMAC SHA256 or RSA.

* Payload: The second part of the token is the payload, which contains the claims. Claims are statements about an
  entity (typically, the user) and additional data. There are three types of claims: registered, public, and private
  claims.

* Signature: To create the signature part, you have to take the encoded header, the encoded payload, a secret, and the
  algorithm specified in the header, and sign that.

# 9. What is the spring security filter?

A filter is a specific type of Servlet Filter that is used to implement security features. The Spring Security Filter
chain is a list of filters that are applied on every HTTP requests and responses. Each filter in the chain has a
specific task, for example, authentication, authorization, logging, etc.

The central concept in Spring Security is the **SecurityFilterChain**, which is essentially a composed Filter. When a
request is made to a server, the filter chain is responsible for processing this request. The chain is made up of a
number of different filters that each handle a specific task. They are arranged in a particular order, and after the
request passes through the filters in the chain, the appropriate controller that handles the request is then executed.

# 10. Describe how do JWT work(slides 里有图， 26页)

* User Authentication: When a user successfully logs in using their credentials, an authentication server generates a
  JWT that includes the user's details and other claims. This JWT is then signed by the server using a secret key or a
  public/private key pair.

* Token Generation: The JWT consists of three parts: a header, a payload, and a signature. The header defines the type
  of the token and the algorithm used for signing. The payload contains the claims or the pieces of information being
  passed about the user and any additional data. The signature is computed by base64url encoding the header and payload
  and then concatenating them with a period separator, and finally applying the signing algorithm specified in the
  header, using the secret key.

* Token Issuance: Once the JWT is generated, it's sent back to the user. The client application then stores the JWT,
  often in local storage or a cookie, for future use.

* Token Usage: Whenever the client makes subsequent requests to the server, it includes the JWT in the HTTP
  Authorization header. The server then verifies the JWT.

* Token Verification: To verify the token, the server checks the signature of the JWT using its secret key or public
  key. If the signature is valid, the server extracts the payload of the JWT to identify the user and processes the
  request accordingly. If the signature is not valid, the server rejects the request.

* Token Expiry: JWTs are stateless; they do not require the server to keep track of the issued tokens in memory.
  Instead, they rely on an expiration mechanism. The server sets an expiration time on the JWT payload when it issues
  the token. On every request with a token, the server checks if the token is expired. If it is, the server responds
  with an 'unauthorized' status, and the client must then obtain a new token (often this involves prompting the user to
  log in again).

# 11. Do you use any Encoder to encode Password?

`PasswordEncoder` is an interface provided by Spring Security that you can use to securely manage user passwords.

```java
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("plaintextPassword");

        System.out.println(hashedPassword);
    }
}
```

# 12. What is UserDetailService? AuthenticationProvider? AuthenticationManager? AuthenticationFilter?(把这几个名字看熟悉也行)

**UserDetailsService**: This is an interface for core user information. The primary purpose of this interface is to load
user-specific data to perform authentication. It has one method loadUserByUsername(String username) that locates the
user based on the username. The returned UserDetails object can then be used to build an Authentication or for Spring
Security to perform various checks, such as validation of credentials, checking account status (enabled, account
non-expired, credentials non-expired, account non-locked), and so on.

```java

@Service
public class MyUserDetailsService implements UserDetailsService {

    // For simplicity, the user data is hard-coded here. In a real-world application, 
    // you would load user data from a database or other persistent storage.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return User.withUsername("user")
                .password("password")
                .roles("USER")
                .build();
    }
}
```

**AuthenticationProvider**: This is an interface for a class that is capable of authenticating an authentication
request. It includes a single method authenticate(Authentication authentication), which authenticates a particular
Authentication object, returning a fully populated Authentication object (including granted authorities) if successful.
An AuthenticationProvider must support a specific type of Authentication, and it's often used to perform the
authentication against a specific user store (like a database or an LDAP server).

```java
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Here, you would use the authentication request to perform the actual authentication.
        // For example, you might load a user's details from the database and compare the 
        // provided password with the stored password.

        // For simplicity, this example assumes that any authentication request is valid.
        return new UsernamePasswordAuthenticationToken(
                authentication.getName(),
                authentication.getCredentials(),
                new ArrayList<>()
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

```

**AuthenticationManager**: This is an interface that's responsible for passing requests through a chain of
AuthenticationProvider instances. An AuthenticationManager has one method: authenticate(Authentication authentication).
It can be thought of as being a AuthenticationProvider which delegates to a chain of other AuthenticationProvider
instances.

**AuthenticationFilter**: This isn't a specific interface or class within Spring Security, but rather a general term for
any filter that performs authentication. There are many specific filter classes in Spring Security, each intended for a
different authentication mechanism. For example, UsernamePasswordAuthenticationFilter is used for form login
authentication, BasicAuthenticationFilter is used for HTTP Basic authentication, and JwtAuthenticationFilter could be
used for JWT-based authentication.

# 13. What is the disadvantage of Session? how to overcome the disadvantage?

* Scalability: The more active users your application has, the more session data you need to store, which can become a
  problem if you have many users. To overcome this, you can use a distributed session management system that stores
  session data across multiple servers. Examples include external databases, in-memory databases like Redis, or
  distributed caching systems.
* Performance: Storing a lot of data in the session can lead to performance issues, as every time the session is loaded
  and saved it consumes resources. To overcome this, try to minimize the amount of data stored in a session.
* Reliability: If the server crashes or restarts, all current session data stored in memory will be lost. This can be
  mitigated by persisting sessions in an external store, like a database or a distributed cache, that can survive a
  server restart.
* Security: If a session ID is compromised (for instance, via session sniffing or session hijacking), an attacker can
  impersonate a user. To mitigate this, you can implement various security measures, like regenerating the session ID
  after login, encrypting session IDs when they are stored and transmitted, and implementing timeouts for inactive
  sessions.
* Cross-Server Sessions: If your application is deployed across multiple servers for load balancing, a user's session
  might not be available if their requests are routed to different servers. This is known as session affinity or "sticky
  sessions", and it can limit your ability to scale your application dynamically. To overcome this, you could use a
  shared session storage that all instances of your application can access, or synchronize sessions between your
  servers.
* Memory Consumption: Session objects remain in memory until they're explicitly invalidated or timed out, which can lead
  to increased memory consumption. This can be mitigated by configuring an appropriate session timeout or implementing a
  policy to regularly clean up old sessions.

# 14. How to get value from application.properties?

```java

@Component
public class MyComponent {

    @Value("${my.property}")
    private String myProperty;

    // ...
}
```

# 15. What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?

configure(HttpSecurity http): This method is used for configuring web-based security at a resource level, based on a
selection match strategy (expressed through the HttpSecurity object). In this method, you can set up rules to specify
which URL paths should be secured, which should be publicly accessible, what kind of authentication is required (
form-based, HTTP Basic, etc.), CSRF protection, session management, and much more. Essentially, the HttpSecurity object
allows configuring web-based security for specific http requests.

configure(AuthenticationManagerBuilder auth): This method is used for establishing an authentication mechanism by
building an AuthenticationManager, which is the main Spring Security interface for authenticating a user.

# 16. What is Spring security authentication and authorization?

Authentication: This is the process of establishing a known identity for the principal (a user or a system). In other
words, it's the process of answering the question: "Who is the user?"

Authorization: This is the process of deciding whether a principal is allowed to perform an action within your
application. In other words, it's the process of answering the question: "Is the user allowed to do this?"

# 17. Assuming that the Redbook UI supports dark mode and multiple languages
Done