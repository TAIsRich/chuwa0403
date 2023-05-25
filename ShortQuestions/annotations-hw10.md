@EnableWebSecurity: Enables the Spring Security configuration for web applications.

@Secured: Applies method-level security to restrict access to annotated methods based on roles or permissions.

@PreAuthorize: Specifies pre-authorization expressions to secure methods, allowing access based on roles, permissions, or other conditions.

@PostAuthorize: Specifies post-authorization expressions to secure methods, allowing access based on roles, permissions, or other conditions after the method execution.

@RolesAllowed: Restricts access to annotated methods based on the specified roles.

@EnableGlobalMethodSecurity: Enables global method-level security configuration.

@AuthenticationPrincipal: Provides access to the currently authenticated principal (user) in Spring MVC controller methods.

@EnableOAuth2Sso: Enables OAuth 2.0 Single Sign-On (SSO) for securing web applications.

@EnableResourceServer: Configures the application as an OAuth 2.0 resource server to validate access tokens and secure resources.

@PreFilter and @PostFilter: Enable method-level filtering of collection parameters based on specific criteria, allowing fine-grained control over input and output data.