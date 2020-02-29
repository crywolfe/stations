INSTRUCTIONS

Code is found here on http://github.com/crywolfe/stations

DEMO

Navigate to the following url for the demo app:
https://stations.herokuapp.com

In this demo you can access the services and see the results in a very simple UI.


If no parameters are entered for username or first letter, then the app will send you to an error page.
Otherwise, it will default to 'foobar' and '100' if getting all users.

NOTES

I added caching to the service calls. Without caching the service calls are 200 to 2000 ms. With caching the call is ~20 ms.

I added unit tests and used both JUnit Mockito and SpringJunit test libraries.

DOCUMENTATION AND ACCESSING ENDPOINTS

The documentation can be found here.
https://stations.herokuapp.com/swagger-ui.html#/

That will give you access to endpoint documentation and provide instructions for the endpoint requests.

CONCLUSION

Thank you for the opportunity to code up this mid layer api demo.
