you want to combine JWT-based authentication with form login (Spring Security). That means:

Users log in with username/password via a form.

If login succeeds → you issue a JWT token instead of maintaining a session.

For subsequent requests → users send the token (usually in the Authorization: Bearer <token> header).

The server validates JWT on each request (stateless).


STEPS

User goes to /login (form login page).

Submits username & password.

If credentials are valid → backend returns JWT token.

User stores JWT in browser (localStorage or cookie).

For next requests → client sends Authorization: Bearer <token>.

JwtAuthFilter validates the token and sets authentication context.


JSP login flow so that:

On successful login, your backend generates the JWT

Stores it in a secure HttpOnly cookie

Redirects user to /home (or dashboard)

From then on, your JWT filter will extract it from cookies automatically